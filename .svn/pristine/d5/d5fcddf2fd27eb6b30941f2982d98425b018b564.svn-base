package com.originsys.auth.action;

import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2013-7-8
   描述：预注册第二步，传递用户id参数
 */
public class RegisterFor2 extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		String mem_id=ra.getParameter("mem_id");
		return new DataAndView(mem_id,"block");
	}

}
