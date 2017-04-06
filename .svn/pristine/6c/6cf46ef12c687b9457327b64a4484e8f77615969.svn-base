package com.originsys.safemanage.authenticate.action;

import java.text.SimpleDateFormat;
import java.util.Date;
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
 auth:boy 2014-6-4
   描述：鉴定报告预增加
 */
public class ReportForInsert extends BaseAction implements  IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		String sbid=ra.getParameter("smuserid");
		String address=ra.getParameter("address");
		Map<String,Object> remap=new HashMap<String,Object>();
		remap.put("sbid", sbid);
		remap.put("building_address", address);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String currentdate=sdf.format(new Date());
		remap.put("currentdate", currentdate);
		return new DataAndView(remap,"block");
	}

}
