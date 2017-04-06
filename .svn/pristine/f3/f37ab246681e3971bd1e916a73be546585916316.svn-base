package com.originsys.safemanage.hiddendanger.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.domain.Page;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.THdangerBuilding;

import java.text.SimpleDateFormat;
/**
 * @author   Email: 
 * @version 1.0 创建时间： 
 * 类说明： 隐患房屋上报列表页
 */
public class THdangerBuildingList  extends BaseAction implements IGet{

	public DataAndView<Map> execute(RequestAction ra)throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		/**组织查询条件对象*/
		THdangerBuilding tHdangerBuilding=new THdangerBuilding();
		tHdangerBuilding.setBuilding_address(ra.getParameter("building_address"));//String:楼幢坐落
		tHdangerBuilding.setBuilding_region(ra.getParameter("building_region"));//String:所属区域
		tHdangerBuilding.setLink_man(ra.getParameter("link_man"));//String:联系人
		if(ra.getParameter("entry_time")!=null && !"".equals(ra.getParameter("entry_time"))){
			tHdangerBuilding.setEntry_time((java.util.Date)new java.sql.Date(sdf.parse(ra.getParameter("entry_time")).getTime()));////Date:录入时间
		}
		tHdangerBuilding.setInfo_state(ra.getParameter("info_state"));//String:
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
		int totalnum=(Integer)sc.queryForObject("Safecheck.getTHdangerBuildingCount", tHdangerBuilding);
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
		String sortname=ra.getParameter("sidx");
		if(sortname==null||"".equals(sortname)){
					sortname="entry_time";
		}
		String sortorder= ra.getParameter("sord");
		if(sortorder==null||"".equals(sortorder)){
			sortorder="desc";
		}
		//定义参数
		Map param=new HashMap();
		param.put("_page_start", start);
		param.put("_page_nums", pageNum);//该参数是为MySQL数据库准备的
		param.put("_page_end", end);//该参数是为Oracle数据库准备的
		param.put("_sortname", sortname);
		param.put("_sortorder", sortorder);
		param.put("tHdangerBuilding", tHdangerBuilding);	  
		//查询结果
		List<THdangerBuilding> resultList=(List<THdangerBuilding>)sc.queryForList("Safecheck.getTHdangerBuildingList", param);
		Page page=new Page(totalpage,currentNum,totalnum);
		Map resultMap=new HashMap();
		resultMap.put("page", page);
		resultMap.put("resultList", resultList);
		return new DataAndView(resultMap,"block");
	}
}