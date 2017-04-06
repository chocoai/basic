package com.originsys.authclient.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import com.originsys.auth.domain.UserInfo;
import com.originsys.auth.domain.UserRegister;
import com.originsys.authclient.util.ApiUtil;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.GetMD5;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2013-8-7
   描述：企业管理员重置密码，修改注册站的数据
 */
public class Reset_Pass extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		String mem_id=ra.getParameter("mem_id");
		String password=ra.getParameter("mem_pass");
        password=GetMD5.getMd5(password);
        UserRegister reg=new UserRegister();
        reg.setMem_id(mem_id);
        reg.setMem_pass(password);
        UserInfo info=new UserInfo();
        info.setMem_id(mem_id);
        info.setSecret(ra.getParameter("mem_pass"));
        
        int success=ApiUtil.getService().resetQyUserPass(reg, info);
        
        response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":"+success+"}");
	}

}
