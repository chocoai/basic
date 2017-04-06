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
public class SurveyDetailList extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String building_address=ra.getParameter("building_address");
		String use_desgin=ra.getParameter("use_desgin");
		String building_date=ra.getParameter("building_date");
		String build_struct=ra.getParameter("build_struct");
		String manage_type=ra.getParameter("manage_type");
		String building_properties=ra.getParameter("building_properties");
		String building_safecondition=ra.getParameter("building_safecondition");
		String info_state=ra.getParameter("info_state");
		String building_region=ra.getParameter("building_region");
		String last_editor=ra.getParameter("last_editor");
		String survey_date=ra.getParameter("survey_date");
		/**组织查询条件对象*/
		TBuildingSurvey tBuildingSurvey=new TBuildingSurvey();
		if(null!=building_address&&!"".equals(building_address)){
			tBuildingSurvey.setBuilding_address(building_address);
		}
		if(null!=use_desgin&&!"".equals(use_desgin)){
			tBuildingSurvey.setUse_desgin(use_desgin);
		}
		if(null!=building_date&&!"".equals(building_date)){
			tBuildingSurvey.setBuilding_date(Integer.parseInt(building_date));
		}
		if(null!=build_struct&&!"".equals(build_struct)){
			tBuildingSurvey.setBuild_struct(build_struct);
		}
		if(null!=manage_type&&!"".equals(manage_type)){
			tBuildingSurvey.setManage_type(manage_type);
		}
		if(null!=building_properties&&!"".equals(building_properties)){
			tBuildingSurvey.setBuilding_properties(building_properties);
		}
		if(null!=building_safecondition&&!"".equals(building_safecondition)){
			tBuildingSurvey.setBuilding_safecondition(building_safecondition);
		}
		if(null!=info_state&&!"".equals(info_state)){
			tBuildingSurvey.setInfo_state(info_state);
		}
		if(null!=building_region&&!"".equals(building_region)){
			tBuildingSurvey.setBuilding_region(building_region);
		}
		if(null!=last_editor&&!"".equals(last_editor)){
			tBuildingSurvey.setLast_editor(last_editor);
		}
		if(null!=survey_date&&!"".equals(survey_date)){
			tBuildingSurvey.setSurvey_date(sdf.parse(survey_date));
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
		List<TBuildingSurvey> resultList=(List<TBuildingSurvey>)sc.queryForList("Safecheck.getSurveyDetailList", param);
		Map resultMap=new HashMap();
		String current_time=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		resultMap.put("current_time", current_time);
		resultMap.put("resultList", resultList);
		return new DataAndView(resultMap,"block");
	}

}
