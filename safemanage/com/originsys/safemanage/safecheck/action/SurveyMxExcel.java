package com.originsys.safemanage.safecheck.action;

import java.text.SimpleDateFormat;
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
import com.originsys.safemanage.domain.TBuildingSurvey;

/**
 auth:zhanglf 2014-6-5
   描述:楼幢普查明细表
 */
public class SurveyMxExcel extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String use_desgin=ra.getParameter("use_desgin");
		String floor=ra.getParameter("floor_count");
		String build_struct=ra.getParameter("build_struct");
		String building_properties=ra.getParameter("building_properties");
		String building_safecondition=ra.getParameter("building_safecondition");
		String building_region=ra.getParameter("building_region");
		/**组织查询条件对象*/
		TBuildingSurvey tBuildingSurvey=new TBuildingSurvey();
		if(null!=use_desgin&&!"".equals(use_desgin)){
			tBuildingSurvey.setUse_desgin(use_desgin);
		}
		if("1".equals(floor)){//平房（1层）
			tBuildingSurvey.setFloordown_count(1);
			tBuildingSurvey.setFloorup_count(1);
		}else if("2".equals(floor)){//低层（2-3层）
			tBuildingSurvey.setFloordown_count(2);
			tBuildingSurvey.setFloorup_count(3);
		}else if("3".equals(floor)){//多层（4-7层）
			tBuildingSurvey.setFloordown_count(4);
			tBuildingSurvey.setFloorup_count(7);
		}else if("4".equals(floor)){//小高层（8-12层）
			tBuildingSurvey.setFloordown_count(8);
			tBuildingSurvey.setFloorup_count(12);
		}else if("5".equals(floor)){//高层（12层以上）
			tBuildingSurvey.setFloordown_count(12);
			tBuildingSurvey.setFloorup_count(9999);
		}
		if(null!=build_struct&&!"".equals(build_struct)){
			tBuildingSurvey.setBuild_struct(build_struct);
		}
		if(null!=building_properties&&!"".equals(building_properties)){
			tBuildingSurvey.setBuilding_properties(building_properties);
		}
		if(null!=building_safecondition&&!"".equals(building_safecondition)){
			tBuildingSurvey.setBuilding_safecondition(building_safecondition);
		}
		if(null!=building_region&&!"".equals(building_region)){
			tBuildingSurvey.setBuilding_region(building_region);
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
		param.put("tBuildingSurvey", tBuildingSurvey);	  
		
		//查询结果
		List<TBuildingSurvey> resultList=(List<TBuildingSurvey>)sc.queryForList("Safecheck.getSurveyMxExcel", param);
		Map resultMap=new HashMap();
		String current_time=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		resultMap.put("current_time", current_time);
		resultMap.put("resultList", resultList);
		return new DataAndView(resultMap,"block");
	}

}
