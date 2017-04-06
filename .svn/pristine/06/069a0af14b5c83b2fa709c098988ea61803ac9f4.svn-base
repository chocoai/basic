package com.originsys.safemanage.safecheck.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-4-30
   描述：用户的启用和禁用，0是禁用，其余是启用
 */
public class EnableUser extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		String success="0";
		try{
			if("0".equals(ra.getParameter("state")))
				sc.update("User.updateOff", ra.getParameter("mem_id"));
			else
				sc.update("User.updateOn", ra.getParameter("mem_id"));
			success="1";
		}catch (Exception e) {
			success="0";
		}
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":\""+success+"\"}");
	}

}
