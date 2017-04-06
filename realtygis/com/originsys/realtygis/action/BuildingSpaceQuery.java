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
import com.originsys.realtygis.domain.Stridrgn;


public class BuildingSpaceQuery extends BaseAction implements IGet{
	/**
	 * 类说明：带tab页的空间表查询楼栋类
	 * @创建时间：2014-6-23
	 * @作者：洛佳明
	 */
	private static final long serialVersionUID = 1L;
	public DataAndView<Map<String, List>> execute(RequestAction ra)
			throws Exception {	
		SqlMapClient sc=DataSource.getSqlMapInstance();
		Map<String, List> map=new HashMap<String, List>();
		Stridrgn eo=new Stridrgn();
		String building_id=ra.getParameter("building_id");
	    eo.setBuilding_id(building_id);
		@SuppressWarnings("unchecked")
		List  list=(List)sc.queryForList("Realtygis.getstridrgndata", eo);
		map.put("list", list);
		
		return new DataAndView<Map<String, List>>(map, "map");
		
	}

}