package com.originsys.realtygis.action;

import java.util.HashMap;
import java.util.Map;

import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.RequestAction;

public class MapVersionForView  extends BaseAction implements IGet{
	/**
	 * 类说明：地图版本预览类
	 * @创建时间：2014-1-23
	 * @作者：洛佳明
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	public DataAndView<Map> execute(RequestAction ra)
			throws Exception {
		Map<String, String> map=new HashMap<String, String>();
		String mapname = new String(ra.getParameter("mapname").getBytes("ISO8859_1"),"utf-8");
		if(!"".equals(ra.getParameter("default_mapnumber"))&&ra.getParameter("default_mapnumber")!=null){
		String default_mapnumber = new String(ra.getParameter("default_mapnumber").getBytes("ISO8859_1"),"utf-8");
		map.put("default_mapnumber", default_mapnumber);
		}
		map.put("mapname", mapname);
		return new DataAndView<Map>(map, "map");
	}
	

}
