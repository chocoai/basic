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
import com.originsys.safemanage.domain.BuildingSurvey;


public class BuildingCommonSurvey  extends BaseAction implements IGet{
	/**
	 * 类说明：房屋普查表查询类
	 * @创建时间：2014-6-5
	 * @作者：洛佳明
	 */
	private static final long serialVersionUID = 1L;

	public DataAndView execute(RequestAction ra)
			throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		Map map=new HashMap();
		BuildingSurvey eo=new BuildingSurvey();
		if(ra.getParameter("id")==""||ra.getParameter("id")==null){
			eo.setBuilding_id(null);
		}
		else{
			String building_id = ra.getParameter("id");
			eo.setBuilding_id(building_id);
		}
		
		
		List<BuildingSurvey>  list=(List<BuildingSurvey>)sc.queryForList("Safecheck.buildingcommonlist", eo);
		map.put("list", list);
		return new DataAndView(map, "map");
			
		
	}
	
	

}
