package com.originsys.authclient.util;

import java.util.ResourceBundle;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import com.caucho.hessian.client.HessianProxyFactory;
import com.originsys.auth.hessian.BasicService;
import com.originsys.eap.util.FileReaderUtil;

/**
 auth:boy 2014-7-14
   描述：
 */
public class ApiUtil {
	
	/**获取hession接口调用地址*/
	public static BasicService getService() throws Exception{
		ResourceBundle rb=FileReaderUtil.getInstance().getResourceBundle("authclient");
		String authurl=rb.getString("authurl");
		HessianProxyFactory factory = new HessianProxyFactory();
	    BasicService basicService = (BasicService)factory.create(BasicService.class, authurl);
	    return basicService;
	}
	
	/**根据code返回token对象*/
	public static JSONObject getAccessTokenByCode(String code) throws Exception{
		ResourceBundle rb=FileReaderUtil.getInstance().getResourceBundle("authclient");
		String token_url=rb.getString("accessTokenURL");
		String client_id=rb.getString("client_ID");
		/**为了安全，在获取授权码的时候传递回调地址，判断是否一致*/
		String redirect_URI=rb.getString("redirect_URI");
		
		HttpClient client = new HttpClient();
		PostMethod post0 = new PostMethod(token_url);
		/**设置编码格式*/
		post0.getParams().setContentCharset("utf-8");
		/**组织传入的参数*/
		NameValuePair  bid= new NameValuePair("grant_type", "authorization_code");
		NameValuePair  op= new NameValuePair("client_id", client_id);
		NameValuePair  opdate= new NameValuePair("code", code);
		NameValuePair  reurl= new NameValuePair("redirect_URI", redirect_URI);
		NameValuePair [] pair = new NameValuePair[]{bid,op,opdate,reurl};
		post0.setRequestBody(pair);
		int status = client.executeMethod(post0);
		String restr=post0.getResponseBodyAsString();
		JSONObject a = JSONObject.fromObject(restr);
		post0.releaseConnection();
		return a;
	}
	
	/**根据refresh_token返回token对象*/
	public static JSONObject getAccessTokenByRefreshToken(String refresh_token) throws Exception{
		ResourceBundle rb=FileReaderUtil.getInstance().getResourceBundle("authclient");
		String token_url=rb.getString("accessTokenURL");
		String client_id=rb.getString("client_ID");
		/**为了安全，在获取授权码的时候传递回调地址，判断是否一致*/
		String redirect_URI=rb.getString("redirect_URI");
		/**用refreshtoken获得token*/
		HttpClient client = new HttpClient();
		PostMethod post0 = new PostMethod(token_url);
		/**设置编码格式*/
		post0.getParams().setContentCharset("utf-8");
		/**组织传入的参数*/
		NameValuePair  bid= new NameValuePair("grant_type", "refresh_token");
		NameValuePair  op= new NameValuePair("client_id", client_id);
		NameValuePair  opdate= new NameValuePair("refresh_token", refresh_token);
		NameValuePair  reurl= new NameValuePair("redirect_URI", redirect_URI);
		NameValuePair [] pair = new NameValuePair[]{bid,op,opdate,reurl};
		post0.setRequestBody(pair);
		int status = client.executeMethod(post0);
		String restr=post0.getResponseBodyAsString();
		JSONObject a = JSONObject.fromObject(restr);
		post0.releaseConnection();
		return a;
	}
}
