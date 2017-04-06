package com.originsys.auth.action;

import java.io.PrintWriter;
import java.security.MessageDigest;

import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.Orgcom;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.GetMD5;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2013-8-22
   描述：
 */
public class ResetOrganPass extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		String organ_id=ra.getParameter("organ_id");
		MessageDigest md5=MessageDigest.getInstance("MD5"); 
        BASE64Encoder base64en = new BASE64Encoder(); 
        String password=GetMD5.getMd5(ra.getParameter("organ_pass"));
        Orgcom orgcom =new  Orgcom();
        orgcom.setOrgan_id(organ_id);
        orgcom.setOrgan_pass(password);
        int success=0;
        try{
        	sc.update("Auth.updateOrganPass",orgcom);
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
