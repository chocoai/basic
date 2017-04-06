package com.originsys.safemanage.safecheck.action;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.FileReaderUtil;
import com.originsys.eap.util.RequestAction;

public class BuildingMapIdenty  extends BaseAction implements IGet{
	/**
	 * 类说明：地图定位类
	 * @创建时间：2014-7-3
	 * @作者：zhanglf
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
		
		//读取属性文件 
		ResourceBundle rb=FileReaderUtil.getInstance().getResourceBundle("safecheck");
		String map_url=rb.getString("map_url");
		map.put("map_url", map_url);
		
		return new DataAndView<Map>(map, "map");
	}
	

}
