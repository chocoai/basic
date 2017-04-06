package com.originsys.auth.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.OrgcomMember;
import com.originsys.auth.domain.UserInfo;
import com.originsys.auth.domain.UserRegister;
import com.originsys.auth.domain.UserRole;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.GetMD5;
import com.originsys.eap.util.RequestAction;
import com.originsys.eap.util.UUIDshort;

/**
 auth:boy 2013-8-28
   描述：增加工作人员
 */
public class WorkerAdd extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		UserRegister userRegister=new UserRegister();
		String key=UUIDshort.get();
		userRegister.setMem_id(key);//String:用户id
		userRegister.setMem_name(ra.getParameter("mem_name"));//String:登录名
		int temp=(int)Math.round(Math.random()*89999999+10000000);//随机生成一个密码存到用户信息表中
		String pass=temp+"";
		userRegister.setMem_pass(GetMD5.getMd5(pass));
		userRegister.setMem_question("");//String:密码问题
		userRegister.setMem_answer("");//String:密码答案
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
		userInfo.setSecret(pass);
		/**增加企业用户的对应关系*/
		OrgcomMember orgcomMember=new OrgcomMember();		
		orgcomMember.setMem_id(key);//String:用户id
		orgcomMember.setOrgan_id(ra.getUser().getOrgcom_id());//String:企业id
		orgcomMember.setJoin_in_time(sdf.parse(sdf.format(new Date())));//Date:入职时间
		orgcomMember.setNote("");//String:备注
		orgcomMember.setState("1");//String:状态
		orgcomMember.setIs_manager("0");//String:是否管理员
		/**用户角色信息*/
		UserRole mr=new UserRole();
		mr.setRoleid(ra.getParameter("role_id"));
		mr.setMem_id(key);
		mr.setMem_state("1");
		mr.setCom_id(ra.getUser().getOrgcom_id());
		mr.setRole_register_id(ra.getParameter("role_register_id"));
		mr.setSite_id(ra.getSite().getSite_id());
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
				//增加用户和企业的对应
				sc.insert("Auth.addOrgcomMember",orgcomMember);	
				//增加用户和角色对应
				sc.insert("Auth.addUserRole",mr);
				success=1;
			}else{
				success=2;
			}
			sc.commitTransaction();			
		}catch(Exception e){
			success=0;
			log().info(e.getMessage());
			log().info(e.getStackTrace());
			throw e;
		}finally{
			sc.endTransaction();
		}	
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":"+success+"}");
	}
	
}
