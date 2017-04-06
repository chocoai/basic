package com.originsys.authclient.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.authclient.util.ApiUtil;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.Role;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.service.RoleService;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.OrgContextHolder;
import com.originsys.eap.util.RequestAction;
import com.originsys.manager.domain.SiteManagerService;

public class RoleUpdate extends BaseAction implements IData {

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		String success="0";
		/**
		 * 获取ibatis_SqlMapClient对象
		 */
		SqlMapClient sc = DataSource.getSqlMapInstance();
		Role role=new Role();
		role.setRole_id(ra.getParameter("role_id"));
		String site_id="";
		if(SiteManagerService.getInstance().getCurrentSite(ra)!=null)
			site_id=SiteManagerService.getInstance().getCurrentSite(ra).getSite_id();
		role.setSite_id(site_id);
		role.setRole_description(ra.getParameter("role_description"));
		role.setRole_name(ra.getParameter("role_name"));
		role.setIsrequest(ra.getParameter("isrequest"));
		role.setIssys(ra.getParameter("issys"));
		role.setIscheck(ra.getParameter("ischeck"));
		role.setRole_code(ra.getParameter("role_code"));
		role.setPrepositive_role(ra.getParameter("prepositive_role"));
		role.setIs_register_request(ra.getParameter("is_register_request"));
		role.setUser_type(ra.getParameter("user_type"));
		role.setSecurity_auth(ra.getParameter("security_auth"));
		String organ_type_id=ra.getParameter("organ_type_id");
		
		try{
			sc.startTransaction();
			if(organ_type_id!=null&&!"".equals(organ_type_id)){
				role.setOrgan_type_id(organ_type_id);
				ApiUtil.getService().addRole(role, OrgContextHolder.getVendorType());
			}
			sc.update("Role.roleupdate",role);
			sc.commitTransaction();
			success="1";
		}catch(Exception e){
			success="0";
			throw e;
		}finally{
			sc.endTransaction();
		}
		RoleService.getInstance().clearCache(role.getRole_id());
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":\""+success+"\"}");
	}

}
