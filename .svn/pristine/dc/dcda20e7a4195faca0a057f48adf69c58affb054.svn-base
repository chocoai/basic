package com.originsys.auth.action;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.domain.Page;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.service.RegionService;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.auth.domain.Orgcom;
/**
 * @author   Email: 
 * @version 1.0 创建时间： 
 * 类说明： 列表页
 */
public class OrgcomList  extends BaseAction implements IGet{

	public DataAndView<Map> execute(RequestAction ra)throws Exception {
		/**组织查询条件对象*/
		Orgcom orgcom=new Orgcom();
		orgcom.setOrgan_name(ra.getParameter("organ_name"));//String:名称
		orgcom.setOrgan_code(ra.getParameter("organ_code"));//String:组织机构代码证号
		orgcom.setAuthentication_state(ra.getParameter("authentication_state"));//认证状态
		if(ra.getParameter("reg_date")!=null&&!"".equals(ra.getParameter("reg_date"))){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			orgcom.setReg_date(sdf.parse(ra.getParameter("reg_date")));
		}
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		//获得起始条数
		int start=0;
		//获得每页显示的条数
		int pageNum=10;
		if(ra.getParameter("rows")!=null){
			pageNum=Integer.parseInt(ra.getParameter("rows"));
		}
		else{
			pageNum=10;
		}
		pageNum=(pageNum==0)?10:pageNum;
		//获取总条数
		int totalnum=(Integer)sc.queryForObject("Auth.getOrgcomCount", orgcom);
		//获得总页数
		int totalpage=totalnum%pageNum==0?totalnum/pageNum:(totalnum/pageNum+1);		
		//获得当前页
		String currentPage=ra.getParameter("page");
		int currentNum=1;
		if(currentPage!=null && !"".equals(currentPage)){
			currentNum=Integer.parseInt(currentPage);
		}
		//重新设置起始条数
		start=(currentNum-1)*pageNum;
		int end = currentNum*pageNum;
		//排序字段+排序方式
//		String sortname=ra.getParameter("sidx");
//		if(sortname==null||"".equals(sortname)){
		String sortname="reg_date";
//		}
//		String sortorder= ra.getParameter("sord");
//		if(sortorder==null||"".equals(sortorder)){
		String sortorder="desc";
//		}
		//定义参数
		Map param=new HashMap();
		param.put("_page_start", start);
		param.put("_page_nums", pageNum);//该参数是为MySQL数据库准备的
		param.put("_page_end", end);//该参数是为Oracle数据库准备的
		param.put("_sortname", sortname);
		param.put("_sortorder", sortorder);
		param.put("orgcom", orgcom);	  
		//查询结果
		List<Orgcom> resultList=(List<Orgcom>)sc.queryForList("Auth.getOrgcomList", param);
		for(Orgcom temp:resultList){
			temp.setOrgan_region_name(RegionService.getInstance().getRegionFullName(temp.getOrgan_region()));
			temp.setOrgcomtype_list(sc.queryForList("Auth.getOrgTypeListByOrgID1", temp.getOrgan_id()));
		}
		Page page=new Page(totalpage,currentNum,totalnum);
		Map resultMap=new HashMap();
		resultMap.put("page", page);
		resultMap.put("resultList", resultList);
		resultMap.put("orgcom", orgcom);
		return new DataAndView(resultMap,"block");
	}
}