package com.originsys.auth.Service;

import com.originsys.eap.domain.User;
import com.originsys.auth.domain.UserInfo;

/**
 auth:boy 2013-7-14
   描述：注册站用户信息和企业站用户信息的转换类
 */
public class UserInfoToUser {
	
	public static User toUser(UserInfo info) throws Exception{
		User user=new User();
		user.setMem_id(info.getMem_id());
		user.setMem_name(info.getMem_name());
		user.setFamily_name(info.getFamily_name());
		user.setFirstname(info.getFirst_name());
		StringBuffer fullname=new StringBuffer();
		if(info.getFamily_name()!=null)
			fullname.append(info.getFamily_name().trim());
		if(info.getFirst_name()!=null)
			fullname.append(info.getFirst_name().trim());
		user.setFullname(fullname.toString());
		user.setMem_mail(info.getMem_mail());
		user.setMem_born(info.getMem_born());
		user.setRegister_time(info.getRegister_time());
		user.setLast_time(info.getLast_time());
		user.setIsenable(info.getMem_state());
		user.setMem_mphone(info.getMem_mphone());
		user.setMem_sex(info.getMem_sex());
		user.setID_num(info.getID_num());
		user.set_internal_state(info.getNote_info());
		return user;
	}
}
