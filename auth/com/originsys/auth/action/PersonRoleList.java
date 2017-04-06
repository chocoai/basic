package com.originsys.auth.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.RoleRegister;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-7-16
   描述：个人角色列表
   1：服务站的本地角色列表
   2：企业角色列表
 */
public class PersonRoleList extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		String mem_id=ra.getUser().getMem_id();
		SqlMapClient sc=DataSource.getSqlMapInstance();
		List<RoleRegister> rolelist=sc.queryForList("Auth.getMyRoleList", mem_id);
		Map<String,Object> remap=new HashMap<String,Object>();
		remap.put("rolelist",rolelist);
		
		return new DataAndView(remap,"block");
	}

}
