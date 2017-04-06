package com.originsys.auth.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import com.originsys.auth.Service.OrgComService;
import com.originsys.auth.domain.Orgcom;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.control.Constants;
import com.originsys.eap.domain.User;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2013-7-11
   描述：设置当前登录身份企业
 */
public class SetCurrentOrgcom extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		int success=0;
		User user=(User) ra.getSession().getAttribute(Constants.User);
		if(user!=null){
			user.setOrgcom_id(ra.getParameter("organ_id"));
			user.setOrgcom_name(ra.getParameter("organ_name"));
			Orgcom orgcom=OrgComService.getInstance().getOrgcomByID(ra.getParameter("organ_id"));
			if(orgcom!=null)
				user.setOrgcom_code(orgcom.getOrgan_code());
			else
				user.setOrgcom_code("");
			ra.getSession().setAttribute(Constants.User,user);
			success=1;
		}
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":"+success+"}");
	}

}
