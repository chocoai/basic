package com.originsys.realtygis.action;

import java.util.HashMap;
import java.util.Map;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.RequestAction;



public class BuildingFromMap extends BaseAction implements IGet{
	/**
	 * 类说明：楼栋查询结果列表类
	 * @创建时间：2014-4-4
	 * @作者：洛佳明
	 */
	private static final long serialVersionUID = 1L;
	public DataAndView<Map<String, String>> execute(RequestAction ra)
			throws Exception {	
		Map<String, String> map=new HashMap<String, String>();
		String fea=ra.getParameter("fea");
		map.put("fea", fea);
		
		return new DataAndView<Map<String, String>>(map, "map");
		
	}

}
