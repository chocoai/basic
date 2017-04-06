package com.originsys.auth.action;

import java.io.PrintWriter;
import java.security.MessageDigest;

import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.UserInfo;
import com.originsys.auth.domain.UserRegister;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.GetMD5;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2013-8-7
   描述：
 */
public class Reset_Pass extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		String mem_id=ra.getParameter("mem_id");
		String password=ra.getParameter("mem_pass");
		MessageDigest md5=MessageDigest.getInstance("MD5"); 
        BASE64Encoder base64en = new BASE64Encoder(); 
        password=GetMD5.getMd5(password);
        UserRegister reg=new UserRegister();
        reg.setMem_id(mem_id);
        reg.setMem_pass(password);
        UserInfo info=new UserInfo();
        info.setMem_id(mem_id);
        info.setSecret(ra.getParameter("mem_pass"));
        int success=0;
        try{
        	sc.startTransaction();
	        sc.update("Auth.updatePass",reg);
	        sc.update("Auth.updatePass2",info);
	        sc.commitTransaction();
	        success=1;
        }catch(Exception e){
        	success=0;
        	throw e;
        }finally{
        	sc.endTransaction();
        }
        response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":"+success+"}");
	}

}
