package com.originsys.safemanage.warning.action;

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
import com.originsys.safemanage.domain.TBuilding;

/**
 auth:zhanglf 2014-7-4
   描述:房屋使用超限预警列表
 */
public class UseWarnList extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String building_address=ra.getParameter("building_address");
		String builiding_region=ra.getParameter("builiding_region");
		String building_date=ra.getParameter("building_date");
		String health_grade_pc=ra.getParameter("health_grade_pc");
		String build_right=ra.getParameter("build_right");
		String warn_grade=ra.getParameter("warn_grade");
		/**组织查询条件对象*/
		TBuilding tBuilding=new TBuilding();
		if(null!=building_address&&!"".equals(building_address)){
			tBuilding.setBuilding_address(building_address);
		}
		if(null!=builiding_region&&!"".equals(builiding_region)){
			tBuilding.setBuiliding_region(builiding_region);
		}
		if(null!=building_date&&!"".equals(building_date)){
			tBuilding.setBuilding_date(Integer.parseInt(building_date));
		}
		if(null!=build_right&&!"".equals(build_right)){
			tBuilding.setBuild_right(build_right);
		}
		if(null!=health_grade_pc&&!"".equals(health_grade_pc)){
			tBuilding.setHealth_grade_pc(health_grade_pc);
		}
		if(null!=warn_grade&&!"".equals(warn_grade)){
			tBuilding.setWarn_grade(warn_grade);
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
		int totalnum=(Integer)sc.queryForObject("Safecheck.getUseWarnCount", tBuilding);
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
					sortname="building_id";
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
		param.put("tBuilding", tBuilding);	  
		//查询结果
		List<TBuilding> resultList=(List<TBuilding>)sc.queryForList("Safecheck.getUseWarnList", param);
		Page page=new Page(totalpage,currentNum,totalnum);
		Map resultMap=new HashMap();
		resultMap.put("page", page);
		resultMap.put("resultList", resultList);
		return new DataAndView(resultMap,"block");
	}

}
