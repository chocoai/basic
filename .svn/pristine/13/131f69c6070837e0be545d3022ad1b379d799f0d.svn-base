package com.originsys.safemanage.statistics.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
 auth:zhanglf 2014-6-16
   描述:安全检查明细
 */
public class BuildingMx extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String building_region=ra.getParameter("building_region");
		String health_grade_pc=ra.getParameter("health_grade_pc");
		
		String use_desgin=ra.getParameter("use_desgin");
		String build_struct=ra.getParameter("build_struct");
		String usefunction=ra.getParameter("usefunction");
		String right_type=ra.getParameter("right_type");
		
		/**组织查询条件对象*/
		TBuilding tBuilding=new TBuilding();
		if(null!=building_region&&!"".equals(building_region)){
			tBuilding.setBuiliding_region(building_region);
		}
		if(null!=health_grade_pc&&!"".equals(health_grade_pc)){
			tBuilding.setHealth_grade_pc(health_grade_pc);
		}
		if(null!=use_desgin&&!"".equals(use_desgin)){
			tBuilding.setUse_desgin(use_desgin);
		}
		if(null!=build_struct&&!"".equals(build_struct)){
			tBuilding.setBuild_struct(build_struct);
		}
		if(null!=usefunction&&!"".equals(usefunction)){
			tBuilding.setUsefunction(usefunction);
		}
		if(null!=right_type&&!"".equals(right_type)){
			tBuilding.setRight_type(right_type);
		}
		
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
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
		param.put("_sortname", sortname);
		param.put("_sortorder", sortorder);
		param.put("tBuilding", tBuilding);	  
		//查询结果
		List<TBuilding> resultList=resultList=(List<TBuilding>)sc.queryForList("Safecheck.getBuildingMx", param);
		
		Map resultMap=new HashMap();
		String current_time=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		resultMap.put("current_time", current_time);
		resultMap.put("resultList", resultList);
		return new DataAndView(resultMap,"block");
	}

}
