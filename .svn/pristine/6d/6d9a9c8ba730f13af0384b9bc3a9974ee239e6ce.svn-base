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
import com.originsys.realtygis.domain.Building;
import com.originsys.realtygis.domain.House;


public class BuildingFromSurvey  extends BaseAction implements IGet{
	/**
	 * 类说明：楼栋表查询类
	 * @创建时间：2013-11-27
	 * @作者：洛佳明
	 */
	private static final long serialVersionUID = 1L;

	public DataAndView execute(RequestAction ra)
			throws Exception {
		String control=ra.getParameter("method");
		if("houseQue".equals(control)){
			//System.out.println("@@@@@@@@@"+control);
			SqlMapClient sc=DataSource.getSqlMapInstance();
			Map<String,Object> map=new HashMap<String,Object>();
			String building_id=ra.getParameter("building_id");
			Map<String,Object> term=new HashMap();
			if(!"".equals(building_id)||building_id!=null){
				term.put("building_id",building_id);
			}	
			//获得单元查询条件
			if(!"".equals(ra.getParameter("unit_number"))&&ra.getParameter("unit_number")!=null){
				term.put("unit_number",ra.getParameter("unit_number"));
			}
			//获得楼层查询条件
			if(!"".equals(ra.getParameter("lay_start"))&&ra.getParameter("lay_start")!=null){
				term.put("lay_start",ra.getParameter("lay_start"));
			}
			if(!"".equals(ra.getParameter("lay_end"))&&ra.getParameter("lay_end")!=null){
				term.put("lay_end",ra.getParameter("lay_end"));
			}
			//获得单元及单元含有的最大套数的list
			List<Map> all_unitlist=sc.queryForList("Realtygis.getALLUnitNumberList", building_id);
			List<Map> unitlist=sc.queryForList("Realtygis.getUnitNumberList", term);
			List<House> laylist=sc.queryForList("Realtygis.laylist", term);
			List<House> houselist=sc.queryForList("Realtygis.houselist", term);
			map.put("laylist", laylist);
			map.put("houselist", houselist);
			map.put("unitlist", unitlist);
			map.put("all_unitlist", all_unitlist);
			map.put("term", term);
			unitlist=null;
			houselist=null;
			laylist=null;
			return new DataAndView(map, "map");
		}
		else{
			
		SqlMapClient sc=DataSource.getSqlMapInstance();
		Map map=new HashMap();
		Building eo=new Building();
		
		String building_mapid = ra.getParameter("id");
		eo.setBuilding_mapid(building_mapid);
		if(!"".equals(building_mapid)||building_mapid!=null){
			map.put("id",building_mapid);
		}	
		List<Building>  list=(List<Building>)sc.queryForList("Realtygis.buildinglist", eo);
		map.put("list", list);
		map.put("building", eo);
		return new DataAndView(map, "map");
			
		}
	}
	
	

}
