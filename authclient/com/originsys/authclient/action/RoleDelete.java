package com.originsys.authclient.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.authclient.util.ApiUtil;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.OrgContextHolder;
import com.originsys.eap.util.RequestAction;

/**
 * @author boy Email:wangbaoaiboy@163.com
 * @version 1.0 创建时间：2010-6-8
 * 类说明：角色删除
 */
public class RoleDelete extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		String success="0";
		String role_id=ra.getParameter("role_id");
		if(role_id!=null&& !"".equals(role_id)){
			SqlMapClient sc=DataSource.getSqlMapInstance();
			try{
				sc.startTransaction();
				Map<String,String> map=new HashMap<String,String>();
				map.put("role_id", role_id);
				//删除角色的对应权限
				sc.delete("FunctionGroup.deleteAccessByRoleId", role_id);
				//删除用户角色对应关系
				sc.delete("Role.deleteMemberRoleByRoleId",role_id);
				//删除角色
				sc.delete("Role.deleteRoleById",role_id);
				
				ApiUtil.getService().deleteRole(role_id, OrgContextHolder.getVendorType());
				sc.commitTransaction();
				success="1";
			}catch(Exception e){
				success="0";
				throw e;
			}finally{
				sc.endTransaction();
			}
		}
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":\""+success+"\"}");
	}

}
