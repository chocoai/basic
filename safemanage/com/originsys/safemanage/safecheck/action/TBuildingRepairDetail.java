package com.originsys.safemanage.safecheck.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.TBuildingRepair;

/**
 auth:zhanglf 2014-11-13
   描述：楼幢维修详细信息
 */
public class TBuildingRepairDetail extends BaseAction implements  IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		String  repair_id = ra.getParameter("repair_id");
		SqlMapClient sc=DataSource.getSqlMapInstance();
		
		TBuildingRepair buildingrepair=(TBuildingRepair)sc.queryForObject("Safecheck.getTBuildingRepair",repair_id);
		
		return new DataAndView(buildingrepair,"block");
	}

}
