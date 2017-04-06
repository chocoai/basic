package com.originsys.auth.action;

import java.util.HashMap;
import java.util.Map;

import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-7-4
   描述：登录传递参数
 */
public class LoginBlock extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		String callback=ra.getParameter("callback");
		String reurl=ra.getParameter("reurl");
		String client_id=ra.getParameter("client_id");
		Map<String,String> remap=new HashMap<String,String>();
		remap.put("callback",callback);
		remap.put("reurl",reurl);
		remap.put("client_id",client_id);
		return new DataAndView(remap,"block");
	}

}
