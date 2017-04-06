package com.originsys.auth.action;

import java.util.Random;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.Service.AccessTokenService;
import com.originsys.auth.domain.AccessApp;
import com.originsys.auth.domain.AccessToken;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.PostDataAndView;
import com.originsys.eap.domain.SwitchType;
import com.originsys.eap.iservice.IPost;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-7-1
   描述：<!--用户认证的第一个动作，先判断session中是否有用户，
   如果没有，则跳转到登录页面，
   如果有取用户信息返回到callback的页面中-->
   1：判断服务端的用户是否登录，如果登录了，跳转到授权页面，同意授权的返回授权码，服务端要把授权码存到数据库中，
   	如果没有登录，则跳转到登录页面，登录之后跳转到授权页面，同意授权的返回一个授权码。
   2：在客户端，获取到授权码之后，访问服务端的一个地址服务，获取访问的token，客户端放到session中，
   客户端在访问服务端的接口的时候都传递这个token，服务端比对，token一样的，才可以访问，不一样的返回错误？
   在客户端判断如果token为空，则跳转到客户端的登录页面
 */
public class AuthLogin1 extends BaseAction implements IPost{

	public PostDataAndView execute(RequestAction ra) throws Exception {
		if(ra.getUser().getMem_id()!=null){
			//登录了现在直接跳转到回调地址了，应该跳转到授权页
//			String callback=ra.getParameter("callback")+"?mem_id="+ra.getUser().getMem_id()+"&reurl="+ra.getParameter("reurl");
			//跳转到授权页面获取授权码，如果已经授权，且授权码没有过期的，是否直接返回授权码？
//			String callback="auth.forauthorize?client_id="+ra.getParameter("client_id");
//			return new PostDataAndView(null, "map", callback, SwitchType.REDIRECT);
			
			
			SqlMapClient sc=DataSource.getSqlMapInstance();
			String client_id=ra.getParameter("client_id");
			//去数据库中查询回调地址和应用的首页
			AccessApp app=(AccessApp)sc.queryForObject("Auth.getAccessAppByCID",client_id);
			String newAction="auth.loginblock";
			if(app!=null){
				if(app.getClient_secret().equals(ra.getParameter("client_secret"))){
					Random r=new Random();
					newAction=app.getRedirect_uri()+"?reurl="+app.getApp_url();
					//去数据库中查询,根据client_id和mem_id查询token对象，如果有对象且没有过期，则直接返回token，
					//如果过期了，则返回refreshtoken
					AccessToken token=AccessTokenService.getInstance().getTokenBy(client_id, ra.getUser().getMem_id());
					if(token!=null){
						if(!AccessTokenService.getInstance().invaildToken(token))
							newAction=newAction+"&token="+token.getAccess_token();
						else
							newAction=newAction+"&refresh_token="+token.getRefresh_token();
					}else{
						newAction="auth.forauthorize?client_id="+ra.getParameter("client_id")+"&client_secret="+ra.getParameter("client_secret");
					}
				}else{
					log().error("====================client_id 对应的应用的密钥和传递的密钥参数不一致");
				}
			}else{
				log().error("====================client_id 对应的应用为空");
			}
			return new PostDataAndView(null, "map", newAction, SwitchType.REDIRECT);
		}else{
			String newAction="auth.loginblock?client_id="+ra.getParameter("client_id");
			return new PostDataAndView(null, "map", newAction, SwitchType.REDIRECT);
		}
	}
	
}
