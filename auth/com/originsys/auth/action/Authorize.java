package com.originsys.auth.action;

import java.util.Random;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.AccessApp;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.PostDataAndView;
import com.originsys.eap.domain.SwitchType;
import com.originsys.eap.iservice.IPost;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-7-17
   描述：用户授权认证，返回code
名称  是否必需 描述 
response_type Y  此处为web应用，此值固定为code 
client_id  Y  即创建应用时的Appkey 
redirect_uri  Y  登录后的回调地址，（注意：此地址必须要与注册应用时的回调地址相匹配，匹配规则是：注域名完全匹配 
state  N  该参数由应用定义，用户授权后，授权服务器会原封不动将此参数返回。 
注: 应用可通过可选参数state来记录用户当前所处的页面位置信息，方便用户登录授权后，页面回调到用户之前所处的位置。 
    https://oauth.taobao.com/authorize?response_type=code&client_id=12251541&redirect_uri=http://www.xx.org&state=1 
 用户登陆后，显示用户授权页面： 
此时，用户可以选择“授权”或者“取消”（即不同意授权）。 
如果用户同意授权，则跳转到应用的回调地址(redirect_uri)，同时，应用获得授权码code 
如果用户取消授权或者访问出错 
 */
public class Authorize extends BaseAction implements IPost{

	public PostDataAndView execute(RequestAction ra) throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		String client_id=ra.getParameter("client_id");
		//去数据库中查询回调地址和应用的首页
		AccessApp app=(AccessApp)sc.queryForObject("Auth.getAccessAppByCID",client_id);
		String newAction="auth.loginblock";
		if(app!=null){
			if(app.getClient_secret().equals(ra.getParameter("client_secret"))){
				Random r=new Random();
				String code= client_id+"_"+ra.getUser().getMem_id()+"_"+Integer.toString(r.nextInt()); 
				newAction=app.getRedirect_uri()+"?reurl="+app.getApp_url()+"&code="+code;
			}else{
				log().error("====================client_id 对应的应用的密钥和传递的密钥参数不一致");
			}
		}
		return new PostDataAndView(null, "map", newAction, SwitchType.REDIRECT);
	}

}
