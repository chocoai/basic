package com.originsys.auth.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2013-10-14
   描述：
 */
public class FindMemName  extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		String ID_num=ra.getParameter("ID_num");
		SqlMapClient sc=DataSource.getSqlMapInstance();
		String mem_name=(String)sc.queryForObject("Auth.findMemName", ID_num);
		if(mem_name==null)mem_name="";
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"mem_name\":\""+mem_name+"\"}");
	}

}
