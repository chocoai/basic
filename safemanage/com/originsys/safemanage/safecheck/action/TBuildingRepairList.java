package com.originsys.safemanage.safecheck.action;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.domain.Page;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.TBuildingRepair;

/**
 auth:zhanglf 2014-11-13
   描述:楼幢维修列表
 */
public class TBuildingRepairList extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String repair_content=ra.getParameter("repair_content");
		String complete_date=ra.getParameter("complete_date");
		String repair_manager=ra.getParameter("repair_manager");
		/**组织查询条件对象*/
		TBuildingRepair tBuildingRepair=new TBuildingRepair();
		if(null!=repair_content&&!"".equals(repair_content)){
			tBuildingRepair.setRepair_content(repair_content);
		}
		if(null!=complete_date&&!"".equals(complete_date)){
			tBuildingRepair.setComplete_date(sdf.parse(complete_date));
		}
		if (repair_manager != null&& !"".equals(repair_manager)) {
			tBuildingRepair.setRepair_manager(repair_manager);
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
		int totalnum=(Integer)sc.queryForObject("Safecheck.getTBuildingRepairCount", tBuildingRepair);
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
					sortname="accident_id";
		}
		String sortorder= ra.getParameter("sord");
		if(sortorder==null||"".equals(sortorder)){
			sortorder="asc";
		}
		//定义参数
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("_page_start", start);
		param.put("_page_nums", pageNum);//该参数是为MySQL数据库准备的
		param.put("_page_end", end);//该参数是为Oracle数据库准备的
		param.put("_sortname", sortname);
		param.put("_sortorder", sortorder);
		param.put("tBuildingRepair", tBuildingRepair);	  
		//查询结果
		List<TBuildingRepair> resultList=(List<TBuildingRepair>)sc.queryForList("Safecheck.getTBuildingRepairList", param);
		Page page=new Page(totalpage,currentNum,totalnum);
		Map resultMap=new HashMap();
		resultMap.put("page", page);
		resultMap.put("resultList", resultList);
		return new DataAndView(resultMap,"block");
	}

}
