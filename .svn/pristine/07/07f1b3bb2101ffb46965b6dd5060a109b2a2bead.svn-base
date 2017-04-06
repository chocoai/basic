package com.originsys.authclient.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.authclient.util.ApiUtil;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.control.Constants;
import com.originsys.eap.domain.User;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.GetMD5;
import com.originsys.eap.util.RequestAction;

public class LoginClientForAndroid extends BaseAction implements IData {

	@Override
	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		System.out.println("LoginClientForAndroid");
		@SuppressWarnings("unused")
		String success="0";
		String string = success;
		String username = ra.getParameter("mem_name");
		String password = ra.getParameter("mem_pass");
		System.out.println("username: "+username+" password:"+password);
		//记录操作日志
		ra.operate.setOperateModule("用户登录");
		ra.operate.setOperateContent("用户:"+username+"登录");
		
		HttpSession session = ra.getSession();
		session.setAttribute("empusername", username);
		session.setAttribute("emppassword", password);
		
		password = GetMD5.getMd5(password);
		/**调用接口返回用户信息和操作标示*/
		Map<String,Object> remap=ApiUtil.getService().doClientLogin(username, password);
		success=(String)remap.get("success");
		if("1".equals((String)remap.get("success"))){
			User user=(User)remap.get("user");
			SqlMapClient sc = DataSource.getSqlMapInstance();
		    /**获取本站用户角色列表,作为用户属性roleList*/
			List<String> roleList = (List) sc.queryForList("User.getRoleList1", user.getMem_id());
			if (roleList == null) {
				roleList = new ArrayList();
			}
			List<String> roleList1=user.getRoleList();
			roleList1.addAll(roleList);
			user.setRoleList(roleList1);
			    
			session.setAttribute(Constants.User, user);
			ra.getUser().setMem_name(user.getMem_name());
			ra.getUser().setMem_id(user.getMem_id());
			System.out.println("mem_name: "+ra.getUser().getMem_name()+" memid:"+ra.getUser().getMem_id());
			
			ArrayList list = new ArrayList<List>();
			list.add(user);
			JSONArray jArray = JSONArray.fromObject(list);
			jArray.toString();
			
			
			// 验证用户登录
			int userId = 5;
			response.setContentType("text/html; charset=GBK");
			// 登录成功
			if (userId > 0)
			{
				//ra.getSession(true).setAttribute("userId" , userId);
			}
			// 把验证的userId封装成JSONObject
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("userId" , userId);
			// 输出响应
			//String result = jsonObj.toString();
			String result = jArray.toString();
			response.getWriter().println(result);
					
		}
		
	}

}
