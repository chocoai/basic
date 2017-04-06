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
import com.originsys.realtygis.domain.House;


public class HouseAreaList extends BaseAction implements IGet{
	/**
	 * 类说明：符合面积条件户列表类
	 * @创建时间：2013-12-12
	 * @作者：洛佳明
	 */
	private static final long serialVersionUID = 1L;
	public DataAndView<Map<String, List<House>>> execute(RequestAction ra)
			throws Exception {	
		SqlMapClient sc=DataSource.getSqlMapInstance();
		Map<String, List<House>> map=new HashMap<String, List<House>>();
		House hou=new House();
		String building_id=ra.getParameter("id");
		hou.setBuilding_id(building_id);
		if(ra.getParameter("min")==""||ra.getParameter("min")==null){
			hou.setJz_areamin(0.0);
		}
		else{
			Double jz_areamin = Double.parseDouble(ra.getParameter("min"));
			hou.setJz_areamin(jz_areamin);
		}
		if(ra.getParameter("max")==""||ra.getParameter("max")==null){
			hou.setJz_areamax(0.0);
		}
		else{
			Double jz_areamax = Double.parseDouble(ra.getParameter("max"));
			hou.setJz_areamax(jz_areamax);	
		}
		@SuppressWarnings("unchecked")
		List<House>  list=(List<House>)sc.queryForList("Realtygis.housearealist", hou);
		map.put("list", list);
		return new DataAndView<Map<String, List<House>>>(map, "map");
		
	}

}

