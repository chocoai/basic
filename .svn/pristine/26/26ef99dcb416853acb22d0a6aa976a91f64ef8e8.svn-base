package com.originsys.auth.action;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.UserInfo;
import com.originsys.auth.domain.UserRegister;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.domain.User;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.EmailUtil;
import com.originsys.eap.util.FileReaderUtil;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2013-7-8
   描述：用户注册第二步
 */
public class Register2  extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		UserInfo info=new UserInfo();
		String mem_id=ra.getParameter("mem_id");
		info.setMem_id(mem_id);
		info.setMem_mphone(ra.getParameter("mem_mphone"));
		String mem_mail=ra.getParameter("mem_mail");
		info.setMem_mail(mem_mail);
		SqlMapClient sc=DataSource.getSqlMapInstance();
		String flag="1";
		try{			
			sc.update("Auth.updateUserInfo", info);
			//读取属性文件 
			ResourceBundle rb=FileReaderUtil.getInstance().getResourceBundle("commonservice");
			String smtp=rb.getString("smtp");
			String auth_name=rb.getString("auth_name");
			String auth_pass=rb.getString("auth_pass");
			String viewFile=rb.getString("mailtemplate");
			String title=rb.getString("mail_title");
			User user=new User();
			user.setMem_id(mem_id);
			user.setMem_mail(mem_mail);
			EmailUtil.sendEmail(smtp,auth_name,auth_pass,user,viewFile, title,new HashMap());
		}catch(Exception e){
			flag="0";
			throw e;
		}
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("flag",flag);
		map.put("info", info);
		return new DataAndView(map,"block");
	}

}
