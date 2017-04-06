package com.originsys.authclient.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.domain.MemberRole;
import com.originsys.eap.domain.Role;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.service.RoleService;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 * @author boy Email:wangbaoaiboy@163.com
 * @version 1.0 创建时间：2011-9-13
 * 类说明：角色对应用户列表条件传递页
 */
public class ForMemberListByRoleId extends BaseAction implements IGet{

	public DataAndView<Map> execute(RequestAction ra) throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		String role_id=ra.getParameter("role_id");
		String role_name=ra.getParameter("role_name");
		Map<String,String> remap=new HashMap<String,String>();
		remap.put("role_id", role_id);
		remap.put("role_name", role_name);
		//取该角色的对应用户
		MemberRole mr=new MemberRole();
		mr.setRole_id(role_id);
		List<String> memidlist=(List<String>)sc.queryForList("Role.getMemIDListByRoleId", mr);
		if(memidlist==null)
			memidlist=new ArrayList<String>();
		String havenames="#";
		for(String mem_id:memidlist){
			havenames+=mem_id+"#";
		}
		Role role=RoleService.getInstance().getRoleByRoleId(role_id);
		String type=role.getOrgan_type_id();
		remap.put("organ_type_id", type);
		remap.put("havenames", havenames);
		return new DataAndView<Map>(remap,"block");
	}

}
