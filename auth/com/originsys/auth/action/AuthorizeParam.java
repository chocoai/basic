package com.originsys.auth.action;

import java.util.HashMap;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.AccessApp;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-7-21
   描述：授权认证传递参数
 */
public class AuthorizeParam extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		String client_id=ra.getParameter("client_id");
		SqlMapClient sc=DataSource.getSqlMapInstance();
		AccessApp app=(AccessApp)sc.queryForObject("Auth.getAccessAppByCID",client_id);
		Map<String,Object> remap=new HashMap<String,Object>();
		remap.put("client_id", client_id);
		remap.put("app", app);
		remap.put("client_secret", ra.getParameter("client_secret"));
		return new DataAndView(remap,"block");
	}

}
