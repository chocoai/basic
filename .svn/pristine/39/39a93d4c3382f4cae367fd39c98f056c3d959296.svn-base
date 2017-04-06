package com.originsys.auth.action;

import java.util.Random;

import javax.servlet.http.HttpSession;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.Service.AccessTokenService;
import com.originsys.auth.Service.AuthUserService;
import com.originsys.auth.domain.AccessApp;
import com.originsys.auth.domain.AccessToken;
import com.originsys.auth.domain.UserInfo;
import com.originsys.auth.domain.UserRegister;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.control.Constants;
import com.originsys.eap.domain.PostDataAndView;
import com.originsys.eap.domain.SwitchType;
import com.originsys.eap.domain.User;
import com.originsys.eap.iservice.IPost;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.GetMD5;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2013-7-10
   描述：注册站用户登录
 */
public class Login extends BaseAction implements IPost{

	public PostDataAndView execute(RequestAction ra) throws Exception {
		SqlMapClient sc = DataSource.getSqlMapInstance();
		String newAction="auth.loginblock";
		if(ra.getHeader("referer")!=null)
			newAction=ra.getHeader("referer");
		SwitchType st=SwitchType.REDIRECT;
		String success="0";
		String username = ra.getParameter("mem_name");
		String password = ra.getParameter("mem_pass");
		//记录操作日志
		ra.operate.setOperateModule("用户登录");
		ra.operate.setOperateContent("用户:"+username+"登录");
		HttpSession session = ra.getSession();
		String code=(String) session.getAttribute("validateCode");
		String validatecode="";
		if(code==null){
			code="";
		}else
			validatecode=ra.getParameter("validatecode");
		session.setAttribute("empusername", username);
		session.setAttribute("emppassword", password);
		if(!"1".equals(ra.getParameter("jump_flag"))){
			
		}else{
			code="";
			validatecode="";
		}
		password = GetMD5.getMd5(password);
		boolean flag=false;
		String login_flag=ra.getParameter("login_flag");
		UserRegister userreg=(UserRegister)sc.queryForObject("Auth.getUserRegister",username);
		//验证码登录
			if(code.equals(validatecode)){
				if(null!=userreg){
					if(password.equals(userreg.getMem_pass())){
						flag=true;
					}else{
						//密码不正确
						success="3";
					}
				}else{
					//用户不存在
					success="2";
				}
			}else{
				//验证码不正确
				success="6";
			}
		
		if(flag){
			if(password.equals(userreg.getMem_pass())){
				//登录名和密码都正确
				/**获取用户的基本信息，看看用户是否激活过了，未激活的用户不能正常登录*/
				UserInfo info=(UserInfo)sc.queryForObject("Auth.getUserInfo", userreg.getMem_id());
				if(null!=info){
					if("1".equals(info.getMem_state())){
						//可以登录了
						success="1";
						//调用服务类，返回用户的所有信息，用户对应的所有企业信息，用户对应的角色信息
						User user=AuthUserService.getInstance().getUser(info.getMem_id());
						session.setAttribute(Constants.User, user);
						ra.getUser().setMem_id(user.getMem_id());
						if(ra.getParameter("client_id")!=null&&!"".equals(ra.getParameter("client_id"))){
							String client_id=ra.getParameter("client_id");
//							newAction="auth.forauthorize?client_id="+ra.getParameter("client_id");
							/**去数据库查询应用对象*/
							AccessApp app=(AccessApp)sc.queryForObject("Auth.getAccessAppByCID",client_id);
							if(app!=null){
								newAction=app.getRedirect_uri()+"?reurl="+app.getApp_url();
							}							
						}
					}else{
						//未激活
						success="5";
					}
				}else{
					//用户基本信息不正确
					success="4";
				}
			}else{
				//密码不正确
				success="3";
			}
		}
		
		session.setAttribute("error", success);
		return new PostDataAndView(null, "map", newAction, st);
	}

}
