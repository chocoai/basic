package com.originsys.realtygis.action;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.realtygis.domain.House;


public class BuildingAreaList extends BaseAction implements IGet{
	/**
	 * 类说明：房屋面积查询结果列表类
	 * @创建时间：2013-12-9
	 * @作者：洛佳明
	 */
	private static final long serialVersionUID = 1L;
	public DataAndView<Map<String, List<House>>> execute(RequestAction ra)
			throws Exception {	
		SqlMapClient sc=DataSource.getSqlMapInstance();
		Map<String, List<House>> map=new HashMap<String, List<House>>();
		House hou=new House();
		if(ra.getParameter("min")==""||ra.getParameter("min")==null){
			hou.setJz_areamin(0.0);
		}
		else{
			Double jz_areamin = Double.parseDouble(ra.getParameter("min"));
			hou.setJz_areamin(jz_areamin);
		}
		if(ra.getParameter("max")==""||ra.getParameter("max")==null){
			hou.setJz_areamax(0.0);
		}
		else{
			Double jz_areamax = Double.parseDouble(ra.getParameter("max"));
			hou.setJz_areamax(jz_areamax);	
		}
		if(ra.getParameter("buildingdate")==""||ra.getParameter("buildingdate")==null){
			hou.setBuilding_date_start(0);
		}
		else{
			Integer building_date_start = Integer.parseInt(ra.getParameter("buildingdate"));
			hou.setBuilding_date_start(building_date_start);
		}
		if(ra.getParameter("buildingdate2")==""||ra.getParameter("buildingdate2")==null){
			hou.setBuilding_date_end(0);
		}
		else{
			Integer building_date_end = Integer.parseInt(ra.getParameter("buildingdate2"));
			hou.setBuilding_date_end(building_date_end);
		}
		if(ra.getParameter("floormin")==""||ra.getParameter("floormin")==null){
			hou.setFloor_countmin(0);
		}
		else{
			Integer floor_countmin = Integer.parseInt(ra.getParameter("floormin"));
			hou.setFloor_countmin(floor_countmin);
		}
		if(ra.getParameter("floormax")==""||ra.getParameter("floormax")==null){
			hou.setFloor_countmax(0);
		}
		else{
			Integer floor_countmax = Integer.parseInt(ra.getParameter("floormax"));
			hou.setFloor_countmax(floor_countmax);
		}	
		@SuppressWarnings("unchecked")
		List<House>  list=(List<House>)sc.queryForList("Realtygis.buildingarealist", hou);
		map.put("list", list);
		return new DataAndView<Map<String, List<House>>>(map, "map");		
	}

}

