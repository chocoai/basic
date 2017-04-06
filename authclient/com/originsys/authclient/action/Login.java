package com.originsys.authclient.action;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONObject;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.authclient.util.ApiUtil;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.common.domain.Department;
import com.originsys.eap.common.domain.DepartmentMember;
import com.originsys.eap.control.Constants;
import com.originsys.eap.domain.PostDataAndView;
import com.originsys.eap.domain.SwitchType;
import com.originsys.eap.domain.User;
import com.originsys.eap.iservice.IPost;
import com.originsys.eap.service.DepartmentService;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.FileReaderUtil;
import com.originsys.eap.util.OnlineUtil;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.safecheck.action.SafeCensorService;
import com.originsys.safemanage.safecheck.action.SafeManagerService;

/**
 auth:boy 2014-7-2
   描述：登录
   从注册站登录之后，返回用户的mem_id,在这边调用服务器获取用户信息，
   再追加上本站的角色，站点，机构等信息
 */
public class Login extends BaseAction implements IPost{

	public PostDataAndView execute(RequestAction ra) throws Exception {
		HttpSession session = ra.getSession();
		ResourceBundle rb=FileReaderUtil.getInstance().getResourceBundle("authclient");
		String access_token=(String)session.getAttribute("access_token");
		if(access_token==null||"".equals(access_token))
			access_token=ra.getParameter("token");
		String refresh_token=ra.getParameter("refresh_token");
		/**判断token是否存在，如果存在直接取用户信息，如果不存在则重新获取token*/
		if(access_token==null||"".equals(access_token)){						
			String client_id=rb.getString("client_ID");
			String client_secret=rb.getString("client_secret");
			/**为了安全，在获取授权码的时候传递回调地址，判断是否一致*/
			if(refresh_token==null||"".equals(refresh_token)){
				/**刷新的token为空，用code获取token*/
				String code=ra.getParameter("code");	
				/**如果code为空，则跳转到注册站的登录页，重新获取
				 * 追加client__secret参数，为了验证这个请求的发出方确实 第三方应用。
					相当于作为第三方的身份证。这样是为了保证被人不会冒充你过过来向平台发请求*/
				if(code==null||"".equals(code)){
					String newAction=rb.getString("authlogin")+"?client_id="+client_id+"&client_secret="+client_secret;
					return new PostDataAndView(null, "map", newAction, SwitchType.REDIRECT);
				}
				/**用code获取token*/		
				JSONObject a = ApiUtil.getAccessTokenByCode(code);
				access_token=a.getString("access_token");
				/**放到缓存中*/
				session.setAttribute("access_token", a.getString("access_token"));
				session.setAttribute("refresh_token", a.getString("refresh_token"));
			}else{
				/**用refreshtoken获得token*/
				JSONObject a = ApiUtil.getAccessTokenByRefreshToken(refresh_token);
				access_token=a.getString("access_token");
				/**放到缓存中*/
				session.setAttribute("access_token", a.getString("access_token"));
				session.setAttribute("refresh_token", a.getString("refresh_token"));
			}			
		}
		
		/**用token获取用户信息，在注册端的程序中应该判断token是否过期，如果过期跳转到授权页面*/
		User user=ApiUtil.getService().getUserByToken(access_token);
//		User user=ApiUtil.getService().getUserByMemid(mem_id);
	    String mem_id=user.getMem_id();
	    SqlMapClient sc = DataSource.getSqlMapInstance();
	    /**获取本站用户角色列表,作为用户属性roleList*/
		List<String> roleList = (List) sc.queryForList("User.getRoleList1", mem_id);
		if (roleList == null) {
			roleList = new ArrayList();
		}
		List<String> roleList1=user.getRoleList();
		roleList1.addAll(roleList);
		user.setRoleList(roleList1);
		/***获取用户的相关部门信息存放起来*/
		DepartmentMember temp=(DepartmentMember)sc.queryForObject("organ.getDepartmentMemberByMemid", mem_id);
		List department_list=new ArrayList<Object>();
		if(temp!=null&&!"".equals(temp.getDepartment_id()))
			department_list.add(temp);
		user.setDepartmentList(department_list);	
		doLogin(ra,user,sc,session);
		
		String newAction=rb.getString("app_URL");
		if(ra.getParameter("reurl")!=null&&!"".equals(ra.getParameter("reurl")))
			newAction=ra.getParameter("reurl");
	
		return new PostDataAndView(null, "map", newAction, SwitchType.REDIRECT);
	}
	
	private void doLogin(RequestAction ra,User user,SqlMapClient sc,HttpSession session) throws Exception{
		/** 修改用户的最后登录时间 */
//		user.setLast_time(new Date());
//		sc.update("User.updateuserlasttime", user);
		
		OnlineUtil.addOnlie(ra,user.getMem_id());
		if(ra.getParameter("loginsave")!=null){
			log().debug("保存登录状态");
			Cookie eap_userid = new Cookie("eap_userid",user.getMem_id());
			eap_userid.setMaxAge(60*60*24*365);
			eap_userid.setPath("/");
			ra.addCookie(eap_userid);
		
		}else{
			Cookie eap_userid = new Cookie("eap_userid","");
			log().debug("取消登录状态");
			eap_userid.setMaxAge(0);
			eap_userid.setPath("/");
			ra.addCookie(eap_userid);
		}
		String organ="";
		List departlist=user.getDepartmentList();
		if(departlist!=null){
			if(departlist.size()>0){					
				organ=((DepartmentMember)departlist.get(0)).getDepartment_id();
			}
		}
		user.setOrgan(organ);
		if (!"".equals(organ.trim())) {
			Department depart=DepartmentService.getInstance().getDepartmentById(organ);
			user.setOrgan_name(depart.getDepartment_name());
			user.setRegion_id(depart.getRegion_id());
		}
		
		/**安全管理系统需要根据安全检查员和安全管理员的管理区域，区分地图的显示，
		 * 所以把扩展信息表中的地区信息放到用户的region_id里*/
		String region="";//记录登录的用户管辖的区域
		if(SafeCensorService.getInstance().getTSafeCensor(user.getMem_id())!=null)
			region=SafeCensorService.getInstance().getTSafeCensor(user.getMem_id()).getRegion();
		if(SafeManagerService.getInstance().getTSafeManager(user.getMem_id())!=null)
			region=SafeManagerService.getInstance().getTSafeManager(user.getMem_id()).getRegion();
		if(region==null)region="";
		user.setRegion_id(region);
		
//		HttpSession session = ra.getSession();
		session.setAttribute(Constants.User, user);
		ra.getUser().setMem_id(user.getMem_id());
		//修改日志
		
		//VisitLogService.getInstance().updateOperateParam(ra, "用户登录", "登录", "登录");
		//String log_id=(String)ra.getRequest().getSession().getAttribute("log_id");
		//String sql="update yc_log set mem_name='"+user.getFullName()+"' where log_id='"+log_id+"'";
		//sc.update("Common.updateDynamicTable", sql);
		String id=user.getMem_id();
		if(id.contains("@")){
			id=user.getMem_name();
		}
		Cookie login_cookie=new Cookie(id+"_login",user.getMem_id());
		login_cookie.setMaxAge(60*60*24*365);
		login_cookie.setPath("/");
		ra.addCookie(login_cookie);
	}

}
