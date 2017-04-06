package com.originsys.safemanage.safecheck.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.Role;
import com.originsys.eap.domain.User;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.iservice.IUserType;
import com.originsys.eap.util.BeanFactory;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-5-12
   描述：删除安全检查员
   1：删除安全检查员属性信息
   2：删除用户和机构的对应
   3：删除用户和角色的对应关系
   4：删除用户信息
 */
public class SafeCensorUserDelete  extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		String mem_id = ra.getParameter("mem_id");
		SqlMapClient sc = DataSource.getSqlMapInstance();
		String success="0";
		try {	
			sc.startTransaction();
			//删除安全检查员属性信息
			sc.delete("Safecheck.deleteTSafeCensor",mem_id);
			//删除用户和部门的对应关系
			sc.delete("organ.deleteDepartmentMemberByMID", mem_id);
			//删除用户对应角色关系
			sc.delete("User.deleteuserrole",mem_id);
			//删除用户信息
			sc.delete("User.deleteuser",mem_id);
			sc.commitTransaction();
			success="1";
		} catch (Exception e) {
			success="0";
			throw e;
		} finally{
			sc.endTransaction();
		}
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":\""+success+"\",\"key\":\""+mem_id+"\"}");
	}

}
