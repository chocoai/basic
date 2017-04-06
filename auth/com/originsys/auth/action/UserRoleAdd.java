package com.originsys.auth.action;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.auth.Service.AuthRoleService;
import com.originsys.auth.domain.RoleRegister;
import com.originsys.auth.domain.UserRole;
import com.originsys.eap.iservice.IData;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
/**
 * @author   Email: 
 * @version 1.0 创建时间： 
 * 类说明： 列表页,增加后直接转向到修改页面，维护其它字段内容
 */
public class UserRoleAdd extends BaseAction implements IData {

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		String reg_id=ra.getParameter("role_reg_id");
		RoleRegister rolereg=AuthRoleService.getInstance().getRoleRegister(reg_id);
		String success="0";
		if(rolereg!=null){
			//获取值
			UserRole userRole=new UserRole();
			userRole.setRoleid(rolereg.getRole_id());//String:角色id
			userRole.setSite_id(rolereg.getSite_id());//String:站点
			userRole.setMem_id(ra.getParameter("mem_id"));//String:用户id
			if("1".equals(rolereg.getIscheck()))
				userRole.setMem_state("0");//String:用户状态
			else
				userRole.setMem_state("1");//String:用户状态
			userRole.setCom_id(ra.getUser().getOrgcom_id());//String:该角色所属的企业
			userRole.setRole_register_id(reg_id);//String:角色注册id
			
			/**获取ibatis执行*/
			SqlMapClient sc=DataSource.getSqlMapInstance();
			try{
				sc.startTransaction();
				sc.insert("Auth.addUserRole",userRole);
				sc.commitTransaction();
				success="1";
			}catch (Exception e) {
				success="0";
				log().info(e.getMessage());
				log().info(e.getStackTrace());
				throw e;
			}finally{
				sc.getCurrentConnection().rollback();
				sc.endTransaction();
			}
		}
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":\""+success+"\"}");
	}
}