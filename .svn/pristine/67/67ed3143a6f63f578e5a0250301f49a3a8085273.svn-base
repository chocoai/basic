package com.originsys.safemanage.safecheck.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.TAppraisalReport;

public class BuildingTestSurvey  extends BaseAction implements IGet{
	/**
	 * 类说明：房屋鉴定表查询类
	 * @创建时间：2014-6-25
	 * @作者：洛佳明
	 */
	private static final long serialVersionUID = 1L;

	public DataAndView execute(RequestAction ra)
			throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		Map map=new HashMap();
		TAppraisalReport eo=new TAppraisalReport();
		if(ra.getParameter("id")==""||ra.getParameter("id")==null){
			eo.setBuilding_id(null);
		}
		else{
			String building_id = ra.getParameter("id");
			eo.setBuilding_id(building_id);
		}
		
		
		List<TAppraisalReport>  list=(List<TAppraisalReport>)sc.queryForList("Safecheck.buildingtestlist", eo);
		map.put("list", list);
		return new DataAndView(map, "map");
			
		
	}
	
	

}