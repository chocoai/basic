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
   描述:安全鉴定明细
 */
public class AuthMx extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String building_region=ra.getParameter("building_region");
		String health_grade_jd=ra.getParameter("health_grade_jd");
		/**组织查询条件对象*/
		TBuilding tBuilding=new TBuilding();
		if(null!=building_region&&!"".equals(building_region)){
			tBuilding.setBuiliding_region(building_region);
		}
		if(null!=health_grade_jd&&!"".equals(health_grade_jd)){
			tBuilding.setHealth_grade_jd(health_grade_jd);
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
		List<TBuilding> resultList=resultList=(List<TBuilding>)sc.queryForList("Safecheck.getAuthMx", param);
		
		Map resultMap=new HashMap();
		String current_time=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		resultMap.put("current_time", current_time);
		resultMap.put("resultList", resultList);
		return new DataAndView(resultMap,"block");
	}

}
