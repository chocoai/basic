package com.originsys.authclient.action;

import java.util.ResourceBundle;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.PostDataAndView;
import com.originsys.eap.domain.SwitchType;
import com.originsys.eap.iservice.IPost;
import com.originsys.eap.util.FileReaderUtil;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-7-4
   描述：注销
 */
public class LoginOut  extends BaseAction implements IPost {

	public PostDataAndView execute(RequestAction ra)
			throws Exception {
//		//修改日志
//		ra.operate.setOperateModule("用户注销");
//		ra.operate.setOperateContent("用户:"+ra.getUser().getMem_name()+"注销");
		ra.getSession().invalidate();
		ResourceBundle rb=FileReaderUtil.getInstance().getResourceBundle("authclient");
		String loginout=rb.getString("authloginout");
		HttpClient client = new HttpClient();
		PostMethod post0 = new PostMethod(loginout);
		/**设置编码格式*/
		post0.getParams().setContentCharset("utf-8");
		/**组织传入的参数*/
		int status = client.executeMethod(post0);
		post0.releaseConnection();
		
		String newAction;
		if(ra.getHeader("referer")!=null){
			newAction=ra.getHeader("referer");
		}else{
			newAction="authclient.loginblock";
		}
		return new PostDataAndView(null,"",newAction,SwitchType.REDIRECT);
	}

}
