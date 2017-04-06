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

/**
 auth:boy 2014-5-13
   描述：隐患房屋楼幢跟踪检查
 */
public class BuildingCtrackForInsert extends BaseAction implements  IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		String sbid=ra.getParameter("smuserid");
		Map<String,Object> remap=new HashMap<String,Object>();
		SqlMapClient sc=DataSource.getSqlMapInstance();
		/**楼幢基本信息*/
		TBuilding building=(TBuilding)sc.queryForObject("Safecheck.getTBuilding",sbid);
		remap.put("building", building);
		return new DataAndView(remap,"block");
	}

}
