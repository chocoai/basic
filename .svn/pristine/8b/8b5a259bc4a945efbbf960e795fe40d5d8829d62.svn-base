package com.originsys.auth.action;

import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.PostDataAndView;
import com.originsys.eap.domain.SwitchType;
import com.originsys.eap.iservice.IPost;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2013-7-19
   描述：用户注销
 */
public class LoginOut extends BaseAction implements IPost {

	public PostDataAndView execute(RequestAction ra)
			throws Exception {
		//修改日志
		ra.operate.setOperateModule("用户注销");
		ra.operate.setOperateContent("用户:"+ra.getUser().getMem_name()+"注销");
		ra.getSession().invalidate();

		this.log().debug(ra.getSession().getId());		
		String newAction;
		if(ra.getHeader("referer")!=null){
			log().debug(ra.getHeader("referer"));
			newAction=ra.getHeader("referer");
		}else{

			newAction="auth.loginblock";
		}
		return new PostDataAndView(null,"",newAction,SwitchType.REDIRECT);
	}

}
