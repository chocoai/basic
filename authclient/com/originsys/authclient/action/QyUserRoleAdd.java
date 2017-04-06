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
 * @author boy   Email: 
 * @version 1.0 创建时间： 
 * 类说明： 企业管理员增加用户和角色对应关系
 */
public class QyUserRoleAdd extends BaseAction implements IData {

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {

	    String role_reg_id=ra.getParameter("role_reg_id");
		String mem_id=ra.getParameter("mem_id");
		String organ_id=ra.getUser().getOrgcom_id();
		String success=ApiUtil.getService().addQyUserRole(mem_id, organ_id, role_reg_id);
		
		/**查看角色是否有用户类型，如果有返回修改地址*/
		Role role=RoleService.getInstance().getRoleByRoleId(ra.getParameter("role_id"));
		String typeaction="";
		String user_type=role.getUser_type();
		UserType userType=null;
		if(null!=user_type&&!"".equals(user_type)){
			userType=BeanFactory.userTypeMap.get(user_type);
			IUserType iUserType=(IUserType)BeanFactory.getBean(userType.getImplementClass());
			User user=new User();
			user.setMem_id(mem_id);
			iUserType.init(user);
			typeaction=userType.getSettingAction()+"?mem_id="+mem_id+"&user_name="+ra.getParameter("user_name");
		}
		
		
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":\""+success+"\",\"typeaction\":\""+typeaction+"\"}");
	}
}