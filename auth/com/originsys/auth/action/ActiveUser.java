package com.originsys.auth.action;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.UserInfo;
import com.originsys.auth.domain.UserRegister;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.PostDataAndView;
import com.originsys.eap.domain.SwitchType;
import com.originsys.eap.iservice.IPost;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2013-7-8
   描述：用户激活
 */
public class ActiveUser extends BaseAction implements IPost{

	public PostDataAndView execute(RequestAction ra) throws Exception {
		UserInfo info=new UserInfo();
		String mem_id=ra.getParameter("mem_id");
		info.setMem_id(mem_id);
		info.setMem_state("1");
		SqlMapClient sc=DataSource.getSqlMapInstance();
		sc.update("Auth.updateUserInfo", info);
		info=(UserInfo)sc.queryForObject("Auth.getUserInfo", mem_id);
		UserRegister reg=(UserRegister)sc.queryForObject("Auth.getUserRegister1", ra.getParameter("mem_id"));
		String newAction = "auth.login?mem_name="+reg.getMem_name()+"&mem_pass="+reg.getMem_pass()+"&jump_flag=1";
		SwitchType st = SwitchType.REDIRECT;
		return new PostDataAndView(info,"result",newAction,st);
	}

}
