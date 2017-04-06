package com.originsys.auth.action;

import javax.servlet.http.HttpServletRequest;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.auth.domain.UserRole;
import com.originsys.eap.iservice.IData;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
/**
 * @author   Email: 
 * @version 1.0 创建时间： 
 * 类说明： 列表页
 */
public class UserRoleDelete extends BaseAction implements IData {

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
				//获取主键String  roleid = ra.getParameter("roleid");
				//设置参数对象
				UserRole userRole=new UserRole();
				userRole.setRoleid(ra.getParameter("roleid"));//String
				userRole.setMem_id(ra.getParameter("mem_id"));
				//获取ibatis执行
				SqlMapClient sc=DataSource.getSqlMapInstance();
				//获取值
				int success=0;
				try{
					sc.delete("Auth.deleteUserRole",userRole);
					success=1;
				}catch (Exception e) {
					success=0;
					log().info(e.getMessage());
					log().info(e.getStackTrace());
					throw e;
				}
				response.setContentType("text/plain");
				PrintWriter out=response.getWriter();
				out.print("{\"success\":"+success+"}");
	}
}