package com.originsys.safemanage.safecheck.action;

import java.util.HashMap;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.TBuilding;
import com.originsys.safemanage.domain.TBuildingCtrack;
import com.originsys.safemanage.domain.TBuildingSafe;
import com.originsys.safemanage.domain.TInvmBase;
import com.originsys.safemanage.domain.TInvmField;

/**
 auth:zhanglf 2014-5-16
   描述：楼隐患楼幢跟踪详细信息
 */
public class BuildingCtrackDetail extends BaseAction implements  IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		String  building_id = ra.getParameter("building_id");
		String info_id = ra.getParameter("info_id");
		
		SqlMapClient sc=DataSource.getSqlMapInstance();
		/**楼幢基本信息*/
		TBuilding building=(TBuilding)sc.queryForObject("Safecheck.getTBuilding",building_id);
		/**隐患房屋跟踪信息*/
		TBuildingCtrack buildingctrack=(TBuildingCtrack)sc.queryForObject("Safecheck.getTBuildingCtrack",info_id);
		
		/**组织返回的对象*/
		Map<String,Object> remap=new HashMap<String,Object>();
		remap.put("building", building);
		remap.put("buildingctrack", buildingctrack);
		return new DataAndView(remap,"block");
	}

}
