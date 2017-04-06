package com.originsys.auth.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.UserInfo;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2013-7-17
   描述：管理员用户激活和禁用
 */
public class AdminUserCheck  extends BaseAction implements IData {

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		String mem_id=ra.getParameter("mem_id");
		String state=ra.getParameter("state");
		UserInfo info=new UserInfo();
		info.setMem_id(mem_id);
		info.setMem_state(state);
		int success=0;
		try{
			//删除用户企业的对应关系
			sc.update("Auth.updateUserInfo",info);
			success=1;
		}catch (Exception e) {
			success=0;
			log().info(e.getMessage());
			log().info(e.getStackTrace());
			throw e;
		}
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":"+success+"}");
	}
}
