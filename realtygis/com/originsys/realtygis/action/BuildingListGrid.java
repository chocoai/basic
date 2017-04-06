package com.originsys.realtygis.action;

import java.util.HashMap;
import java.util.Map;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.RequestAction;


public class BuildingListGrid  extends BaseAction implements IGet{
	/**
	 * 类说明：房屋面积查询结果jqGrid列表类
	 * @创建时间：2013-12-17
	 * @作者：洛佳明
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	public DataAndView<Map> execute(RequestAction ra)
			throws Exception {	
		Map<String, String> map=new HashMap<String, String>();
		if(ra.getParameter("min")==""||ra.getParameter("min")==null){
			String min="0.0";
			map.put("min", min);
		}
		else{
			String min=ra.getParameter("min");
			map.put("min", min);
		}
		if(ra.getParameter("max")==""||ra.getParameter("max")==null){
			String max="0.0";
			map.put("max", max);
		}
		else{
			String max=ra.getParameter("max");
			map.put("max", max);
		}
		if(ra.getParameter("buildingdate")==""||ra.getParameter("buildingdate")==null){
			String buildingdate="0";
			map.put("buildingdate",buildingdate);
		}
		else{
			String buildingdate=ra.getParameter("buildingdate");
			map.put("buildingdate",buildingdate);
		}
		if(ra.getParameter("buildingdate2")==""||ra.getParameter("buildingdate2")==null){
			String buildingdate2="0";
			map.put("buildingdate2",buildingdate2);
		}
		else{
			String buildingdate2=ra.getParameter("buildingdate2");
			map.put("buildingdate2",buildingdate2);
		}
		if(ra.getParameter("floormin")==""||ra.getParameter("floormin")==null){
			String floormin="0";
			map.put("floormin",floormin);
		}
		else{
			String floormin=ra.getParameter("floormin");
			map.put("floormin",floormin);
		}
		if(ra.getParameter("floormax")==""||ra.getParameter("floormax")==null){
			String floormax="0";
			map.put("floormax",floormax);
		}
		else{
			String floormax=ra.getParameter("floormax");
			map.put("floormax",floormax);
		}
		return new DataAndView<Map>(map, "map");
		
	}
}
