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
import com.originsys.realtygis.domain.Building;
import com.originsys.realtygis.domain.House;
import com.originsys.realtygis.domain.Invmprj;


public class BuildingSafetySurvey  extends BaseAction implements IGet{
	/**
	 * 类说明：安全楼栋表查询类
	 * @创建时间：2014-4-26
	 * @作者：洛佳明
	 */
	private static final long serialVersionUID = 1L;

	public DataAndView execute(RequestAction ra)
			throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		Map map=new HashMap();
		Invmprj eo=new Invmprj();
		
		Integer build_id = Integer.parseInt(ra.getParameter("id"));
		eo.setBuild_id(build_id);
		
		List<Building>  list=(List<Building>)sc.queryForList("Realtygis.safetybuildinglist", eo);
		map.put("list", list);
		return new DataAndView(map, "map");
			
		
	}
	
	

}
