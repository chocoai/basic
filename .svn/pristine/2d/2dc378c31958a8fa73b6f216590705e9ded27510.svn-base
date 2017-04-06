package com.originsys.authclient.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.FileReaderUtil;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-7-9
   描述：预登录，传递注册端的登录地址 
 */
public class LoginBlock extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		ResourceBundle rb=FileReaderUtil.getInstance().getResourceBundle("authclient");
		String authlogin=rb.getString("authlogin");
		String authloginout=rb.getString("authloginout");
		String client_ID=rb.getString("client_ID");
		Map<String,Object> remap=new HashMap<String,Object>();
		remap.put("authlogin", authlogin);//服务端的登录地址
		remap.put("authloginout", authloginout);//服务端的注销地址
		remap.put("client_ID", client_ID);//客户端注册的应用编号
		remap.put("date", new Date());
		return new DataAndView(remap,"block");		
	}

}
