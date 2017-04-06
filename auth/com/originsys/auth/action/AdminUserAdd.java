package com.originsys.auth.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.OrgcomMember;
import com.originsys.auth.domain.UserInfo;
import com.originsys.auth.domain.UserRegister;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.GetMD5;
import com.originsys.eap.util.RequestAction;
import com.originsys.eap.util.UUIDshort;

/**
 auth:boy 2013-7-17
   描述：管理员增加用户
 */
public class AdminUserAdd  extends BaseAction implements IData {

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		UserRegister userRegister=new UserRegister();
		String key=UUIDshort.get();
		userRegister.setMem_id(key);//String:用户id
		userRegister.setMem_name(ra.getParameter("mem_name"));//String:登录名
		String password="666666";
//		String password = ra.getParameter("mem_pass");
		password = GetMD5.getMd5(password);
		userRegister.setMem_pass(password);//String:密码
		userRegister.setMem_question("");//String:密码问题
		userRegister.setMem_answer("");//String:密码答案
		userRegister.setToken_id(ra.getParameter("token_id"));
		UserInfo userInfo=new UserInfo();
		userInfo.setMem_id(key);
		userInfo.setFamily_name(ra.getParameter("family_name"));//String:姓
		userInfo.setFirst_name(ra.getParameter("first_name"));//String:名
		userInfo.setMem_sex(ra.getParameter("mem_sex"));//String:性别
		if(ra.getParameter("mem_born")!=null && !"".equals(ra.getParameter("mem_born"))){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			userInfo.setMem_born(sdf.parse(ra.getParameter("mem_born")));//Date:生日
		}
		userInfo.setMem_mail(ra.getParameter("mem_mail"));//String:邮址
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		userInfo.setRegister_time(new Date());//Date:注册时间
		userInfo.setMem_integrality(ra.getParameter("mem_integrality"));//String:用户信息完整性
		userInfo.setMem_mphone(ra.getParameter("mem_mphone"));//String:手机
		userInfo.setMem_region(ra.getParameter("mem_region"));//String:居住区域
		userInfo.setMem_addr(ra.getParameter("mem_addr"));//String:地址
		userInfo.setSecure_image(ra.getParameter("secure_image"));//String:安全认证图片
		userInfo.setReg_source(ra.getParameter("reg_source"));//String:注册来源网站
		userInfo.setMem_image(ra.getParameter("mem_image"));//String:头像
		userInfo.setNote_info(ra.getParameter("note_info"));//String:备注信息
		userInfo.setMem_name(ra.getParameter("mem_name"));
		userInfo.setMem_state("1");
		userInfo.setID_num(ra.getParameter("ID_num"));
		userInfo.setSecret(ra.getParameter("mem_pass"));
		SqlMapClient sc=DataSource.getSqlMapInstance();
		int success=0;
		try{
			sc.startTransaction();
			int num=(Integer)sc.queryForObject("Auth.selectMemNameCount",ra.getParameter("mem_name"));
			if(num==0){
				//增加用户注册信息
				sc.insert("Auth.addUserRegister",userRegister);
				//增加用户基本信息
				sc.insert("Auth.addUserInfoadmin",userInfo);
				success=1;
			}else{
				success=2;
			}
			sc.commitTransaction();			
		}catch(Exception e){
			success=0;
			throw e;
		}finally{
			sc.endTransaction();
		}	
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":"+success+"}");
	}

}
