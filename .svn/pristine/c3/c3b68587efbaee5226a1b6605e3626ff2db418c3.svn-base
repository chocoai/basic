package com.originsys.auth.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.AccessApp;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-7-25
   描述：应用审核
 */
public class AppCheck extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		AccessApp app=new AccessApp();
		app.setClient_id(ra.getParameter("client_id"));
		app.setApp_state(ra.getParameter("app_state"));
		SqlMapClient sc=DataSource.getSqlMapInstance();
		int success=0;
		try{
			sc.update("Auth.checkApp",app);
			success=1;	
		}catch(Exception e){
			success=0;
			throw e;
		}	
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":"+success+"}");		
	}

}
