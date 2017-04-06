package com.originsys.auth.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2013-7-17
   描述：管理员删除用户
   删除所有用户的关联信息
 */
public class AdminUserDelete  extends BaseAction implements IData {

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		String mem_id=ra.getParameter("mem_id");
		int success=0;
		try{
			sc.startTransaction();
			//删除用户企业的对应关系
			sc.delete("Auth.deleteOrgcomMemberByMemid",mem_id);
			//删除注册站用户角色的对应关系，企业站的用户角色对应关系怎么删除？？？？？？？？？？？？？？
			sc.delete("Auth.deleteUserRoleByMemid",mem_id);
			//=============删除企业站用户对应角色关系？？？？？？？？？？？？
			sc.delete("User.deleteuserrole",mem_id);
			//=============删除企业站用户和部门的对应关系？？？？？？？？？？
			sc.delete("organ.deleteDepartmentMemberByMID", mem_id);
			//删除用户信息 
			sc.delete("Auth.deleteUserByMemid",mem_id);
			sc.delete("Auth.deleteUserRegByMemid",mem_id);
			sc.commitTransaction();
			success=1;
		}catch (Exception e) {
			success=0;
			log().info(e.getMessage());
			log().info(e.getStackTrace());
			throw e;
		}finally{
			sc.getCurrentConnection().rollback();
			sc.endTransaction();
		}
				response.setContentType("text/plain");
				PrintWriter out=response.getWriter();
				out.print("{\"success\":"+success+"}");
	}
}
