package com.originsys.realtygis.action;

import java.util.HashMap;
import java.util.Map;

import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.RequestAction;

public class HouseAreaGrid extends BaseAction implements IGet{
	/**
	 * 类说明：户面积查询结果jqGrid列表类
	 * @创建时间：2013-12-30
	 * @作者：洛佳明
	 */
	private static final long serialVersionUID = 1L;
	public DataAndView<Map> execute(RequestAction ra)
			throws Exception {	
		Map<String, String> map=new HashMap<String, String>();
		String bid=ra.getParameter("id");
		    map.put("bid", bid);
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
		return new DataAndView<Map>(map, "map");
}
}