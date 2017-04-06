package com.originsys.auth.action;

import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.UserInfo;
import com.originsys.auth.domain.UserRegister;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2013-7-10
   描述：个人信息面板
 */
public class PersonalInformation extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		String mem_id=ra.getUser().getMem_id();
//		System.out.println("mem_id="+mem_id);
		SqlMapClient sc=DataSource.getSqlMapInstance();
		//用户注册信息
		UserRegister reg=(UserRegister)sc.queryForObject("Auth.getUserRegister",mem_id);
		//用户基本信息
		UserInfo info=(UserInfo)sc.queryForObject("Auth.getUserInfo", mem_id);
		//用户企业列表
		List userorgan=sc.queryForList("Auth.getUserOrgan", mem_id);
		//用户角色信息
		List userrole=sc.queryForList("Auth.getUserRole", mem_id);
		
		return null;
	}

}
