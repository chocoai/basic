package com.originsys.authclient.action;

import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.Role;
import com.originsys.eap.domain.User;
import com.originsys.eap.domain.UserType;
import com.originsys.eap.service.RoleService;
import com.originsys.eap.util.BeanFactory;
import com.originsys.eap.util.RequestAction;
import com.originsys.authclient.util.ApiUtil;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.iservice.IUserType;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author boy Email:
 * @version 1.0 创建时间： 
 * 类说明： 企业管理员删除用户和角色的对应关系
 */
public class QyUserRoleDelete extends BaseAction implements IData {

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		String role_reg_id=ra.getParameter("roleid");
		String mem_id=ra.getParameter("mem_id");
		int success=ApiUtil.getService().delQyUserRole(mem_id, role_reg_id);
		
		UserType userType=null;
		IUserType iUserType=null;
		User user=new User();
		user.setMem_id(mem_id);
		Role role=RoleService.getInstance().getRoleByRoleId(role_reg_id);
		String user_type=role.getUser_type();
		if(null!=user_type&&!"".equals(user_type)){
			userType=BeanFactory.userTypeMap.get(user_type);
			iUserType=(IUserType)BeanFactory.getBean(userType.getImplementClass());
			iUserType.destory(user);
		}
		
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.print("{\"success\":" + success + "}");
	}
}