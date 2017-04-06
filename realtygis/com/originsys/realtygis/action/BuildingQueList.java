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


public class BuildingQueList extends BaseAction implements IGet{
	/**
	 * 类说明：楼栋查询结果列表类
	 * @创建时间：2013-12-3
	 * @作者：洛佳明
	 */
	private static final long serialVersionUID = 1L;
	public DataAndView execute(RequestAction ra)
			throws Exception {	
		SqlMapClient sc=DataSource.getSqlMapInstance();
		Map map=new HashMap();
		Building eo=new Building();
		String fea=ra.getParameter("fea");
		String[] arr=fea.split("\\,");
		List arrlist = Arrays.asList(arr);  
        eo.setArrlist(arrlist);		
		List<Building>  list=(List<Building>)sc.queryForList("Realtygis.buildingquelist", eo);
		map.put("list", list);
		
		return new DataAndView(map, "map");
		
	}

}
