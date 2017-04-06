package com.originsys.auth.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.UserRegister;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2013-7-19
   描述：重置密码安全问题
 */
public class PersonUserPassSecuritySave  extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		int success=0;
		UserRegister userRegister=new UserRegister();
		userRegister.setMem_id(ra.getUser().getMem_id());
		userRegister.setMem_question(ra.getParameter("mem_question"));//String:密码问题
		userRegister.setMem_answer(ra.getParameter("mem_answer"));//String:密码答案
		SqlMapClient sc=DataSource.getSqlMapInstance();
		sc.update("Auth.updatePassAnswer", userRegister);
		success=1;

		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":"+success+"}");
	}

}
