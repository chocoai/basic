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
import com.originsys.safemanage.domain.TBuildingAccident;

/**
 auth:zhanglf 2014-11-13
   描述：楼幢事故详细信息
 */
public class TBuildingAccidentDetail extends BaseAction implements  IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		String  accident_id = ra.getParameter("accident_id");
		SqlMapClient sc=DataSource.getSqlMapInstance();
		TBuildingAccident buildingsurvey=(TBuildingAccident)sc.queryForObject("Safecheck.getTBuildingAccident",accident_id);
		
		return new DataAndView(buildingsurvey,"block");
	}

}
