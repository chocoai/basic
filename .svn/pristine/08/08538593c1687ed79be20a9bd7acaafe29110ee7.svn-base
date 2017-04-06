package com.originsys.realtygis.action;

import java.util.HashMap;
import java.util.Map;

import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.RequestAction;

public class BuildingMapIdenty  extends BaseAction implements IGet{
	/**
	 * 类说明：地图定位类
	 * @创建时间：2014-3-31
	 * @作者：洛佳明
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	public DataAndView<Map> execute(RequestAction ra)
			throws Exception {
		Map<String, String> map=new HashMap<String, String>();
		if(!"".equals(ra.getParameter("building_mapid"))&&ra.getParameter("building_mapid")!=null){
			String building_mapid = ra.getParameter("building_mapid");
			map.put("building_mapid", building_mapid);
			}
		return new DataAndView<Map>(map, "map");
	}
	

}
