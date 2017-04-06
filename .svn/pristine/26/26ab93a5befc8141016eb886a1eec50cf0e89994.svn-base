package com.originsys.auth.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.Orgcom;
import com.originsys.auth.domain.UserRegister;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.GetMD5;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2013-7-18
   描述：修改单位登录密码
 */
public class ChangeOrganPassword extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		String organ_id=ra.getUser().getOrgcom_id();
		String old_pass=ra.getParameter("old_password");
		String old_pass_1= GetMD5.getMd5(old_pass);
		/**根据用户id去数据库中查询看输入的旧密码是否正确，如果正确可以修改，不正确不能修改*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		Orgcom orgcom=(Orgcom)sc.queryForObject("Auth.getOrgcom",organ_id);
		String success="0";
		if(orgcom!=null){
			if(old_pass_1.equals(orgcom.getOrgan_pass())){
				String new_pass=ra.getParameter("password");
				orgcom.setOrgan_pass(GetMD5.getMd5(new_pass));
				sc.update("Auth.updateOrganPass",orgcom);
				success="1";
			}else{
				//输入的旧密码不正确
				success="2";
			}
		}
				
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":\""+success+"\"}");
	}

}
