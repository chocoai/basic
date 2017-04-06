package com.originsys.auth.action;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.AccessApp;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.eap.util.UUIDshort;

/**
 auth:boy 2014-7-24
   描述：应用注册保存
 */
public class AppInsert extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		AccessApp app=new AccessApp();
		app.setClient_id(UUIDshort.get());
		app.setClient_secret(UUIDshort.get());
		app.setApp_name(ra.getParameter("app_name"));
		app.setApp_icon(ra.getParameter("app_icon"));
		app.setApp_desc(ra.getParameter("app_desc"));
		app.setApp_state("0");//0待审核 1审核通过 2审核驳回
		app.setMem_id(ra.getUser().getMem_id());
		app.setReg_date(new Date());
		app.setApp_url(ra.getParameter("app_url"));
		app.setRedirect_uri(ra.getParameter("redirect_uri"));
		
		
		SqlMapClient sc=DataSource.getSqlMapInstance();
		int success=0;
		try{
			sc.insert("Auth.addApp",app);
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
