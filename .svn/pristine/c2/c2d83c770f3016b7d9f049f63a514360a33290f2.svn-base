package com.originsys.authclient.action;

import java.util.HashMap;
import java.util.Map;

import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2013-7-12
   描述：传递参数公共类
 */
public class PassParam  extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		String mem_id=ra.getParameter("mem_id");
		String user_name=ra.getParameter("user_name");
		Map<String,Object> remap=new HashMap<String,Object>();
		remap.put("mem_id", mem_id);
		remap.put("user_name", user_name);
		return new DataAndView(remap,"block");
	}

}
