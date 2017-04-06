package com.originsys.auth.action;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.AccessApp;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-7-24
   描述：应用详细
 */
public class AppDetail extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		AccessApp app=(AccessApp)sc.queryForObject("Auth.getAccessAppByCID", ra.getParameter("client_id"));
		return new DataAndView(app,"block");
	}

}
