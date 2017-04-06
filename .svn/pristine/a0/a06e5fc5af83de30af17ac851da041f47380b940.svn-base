package com.originsys.realtygis.action;

import java.util.Arrays;
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

public class TabDialog extends BaseAction implements IGet{
	/**
	 * 类说明：带tab页的弹出窗口查询楼栋类
	 * @创建时间：2014-3-6
	 * @作者：洛佳明
	 */
	private static final long serialVersionUID = 1L;
	public DataAndView<Map<String, List<Building>>> execute(RequestAction ra)
			throws Exception {	
		SqlMapClient sc=DataSource.getSqlMapInstance();
		Map<String, List<Building>> map=new HashMap<String, List<Building>>();
		Building eo=new Building();
		String building_id=ra.getParameter("building_id");
	    eo.setBuilding_id(building_id);
		@SuppressWarnings("unchecked")
		List<Building>  list=(List<Building>)sc.queryForList("Realtygis.tabbuildingquery", eo);
		map.put("list", list);
		
		return new DataAndView<Map<String, List<Building>>>(map, "map");
		
	}

}