package com.originsys.auth.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.OrgcomMember;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2013-7-18
   描述：企业管理员审核用户
 */
public class QYCheckUser extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		int success=0;
		String orgcom_id=ra.getUser().getOrgcom_id();
		String mem_id=ra.getParameter("mem_id");
		String state=ra.getParameter("state");
		OrgcomMember mem=new OrgcomMember();
		mem.setMem_id(mem_id);
		mem.setOrgan_id(orgcom_id);
		mem.setState(state);
		SqlMapClient sc=DataSource.getSqlMapInstance();
		sc.update("Auth.qycheckuser", mem);
		success=1;

		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":"+success+"}");
	}

}
