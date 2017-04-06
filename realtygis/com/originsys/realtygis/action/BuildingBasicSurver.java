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
import com.originsys.realtygis.domain.BasicSurver;


public class BuildingBasicSurver extends BaseAction implements IGet{
	/**
	 * 类说明：基础测绘成果查询类
	 * @创建时间：2014-3-4
	 * @作者：洛佳明
	 */
	private static final long serialVersionUID = 1L;
	public DataAndView<Map<String, List<BasicSurver>>> execute(RequestAction ra)
			throws Exception {	
		SqlMapClient sc=DataSource.getSqlMapInstance();
		Map<String, List> map=new HashMap<String, List>();
		BasicSurver bs = new BasicSurver();
		String building_id = ra.getParameter("building_id");
		bs.setBuilding_id(building_id);
		List<BasicSurver>  list = sc.queryForList("Realtygis.buildingbasicsurver",bs);
		map.put("list", list);
		return new DataAndView(map, "map");
	}
}
