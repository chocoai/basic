package com.originsys.safemanage.statistics.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.yc.eap.util.UtilString;

/**
 auth:boy 2014-6-18
   描述：普查自定义统计
 */
public class SurveyComplexCount extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		/**返回的map*/
		Map<String,Object> remap=new HashMap<String,Object>();
		/**查询条件map*/
		Map<String,String> term=new HashMap<String,String>();
		if(ra.getParameter("region_id")!=null&&!"".equals(ra.getParameter("region_id")))
			term.put("region_id", ra.getParameter("region_id"));
		String col_name=ra.getParameter("col_name");
		term.put("col_name", col_name);
		/**如果col_name中含#号，则是枚举的那种的查询*/
		if(col_name!=null&&!"".equals(col_name)){
			if(col_name.contains("#")){
				String names[]=UtilString.split(col_name, "#");
				term.put("enum_id", names[0]);
				term.put("colum_term", names[1]);
				List<HashMap> list1=sc.queryForList("Safecheck.surveyComplexCountEnum",term);
				HashMap hj_map=(HashMap)sc.queryForObject("Safecheck.surveyComplexCountEnumHJ", term);
				remap.put("resultlist",list1);
				remap.put("hj", hj_map);
			}else{
				if("building_date".equals(col_name)){
					/**建成年份查询那种的,起止日期*/
					if(ra.getParameter("start_date")!=null&&!"".equals(ra.getParameter("start_date"))){
						term.put("start_date", ra.getParameter("start_date"));
					}
					if(ra.getParameter("end_date")!=null&&!"".equals(ra.getParameter("end_date"))){
						term.put("end_date", ra.getParameter("end_date"));
					}
				}
				term.put("colum_term", col_name);
				List<HashMap> list1=sc.queryForList("Safecheck.surveyComplexCount",term);
				HashMap hj_map=(HashMap)sc.queryForObject("Safecheck.surveyComplexCountEnumHJ", term);
				remap.put("resultlist",list1);
				remap.put("hj", hj_map);				
			}
		}
		
		
		remap.put("term", term);
		return new DataAndView(remap,"block");
	}

}
