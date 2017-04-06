package com.originsys.auth.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.UserInfo;
import com.originsys.auth.domain.UserRegister;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.PostDataAndView;
import com.originsys.eap.domain.SwitchType;
import com.originsys.eap.domain.User;
import com.originsys.eap.iservice.IPost;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.EmailUtil;
import com.originsys.eap.util.FileReaderUtil;
import com.originsys.eap.util.GetMD5;
import com.originsys.eap.util.RequestAction;
import com.originsys.eap.util.UUIDshort;

/**
 auth:boy 2013-7-8
   描述：用户注册第一步，保存用户的基本的注册信息，初始化用户信息，
   跳转到用户注册的第二步，然用户填写手机和邮箱，通过邮箱验证用户
 */
public class Register1 extends BaseAction implements IPost{

	public PostDataAndView execute(RequestAction ra) throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		UserRegister userRegister=new UserRegister();
		
		userRegister.setMem_name(ra.getParameter("mem_name"));//String:登录名
		String password = ra.getParameter("mem_pass");
		password = GetMD5.getMd5(password);
		userRegister.setMem_pass(password);//String:密码
		userRegister.setMem_question(ra.getParameter("mem_question"));//String:密码问题
		userRegister.setMem_answer(ra.getParameter("mem_answer"));//String:密码答案
		UserInfo userInfo=new UserInfo();
		
		userInfo.setFamily_name(ra.getParameter("family_name"));//String:姓
		userInfo.setFirst_name(ra.getParameter("first_name"));//String:名
		userInfo.setMem_sex(ra.getParameter("mem_sex"));//String:性别
		if(ra.getParameter("mem_born")!=null && !"".equals(ra.getParameter("mem_born"))){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			userInfo.setMem_born(sdf.parse(ra.getParameter("mem_born")));//Date:生日
		}
		userInfo.setMem_mail(ra.getParameter("mem_mail"));//String:邮址
		userInfo.setRegister_time(new Date());//Date:注册时间
		userInfo.setLast_time(new Date());//Date:最后登录时间
		userInfo.setMem_integrality(ra.getParameter("mem_integrality"));//String:用户信息完整性
		userInfo.setMem_mphone(ra.getParameter("mem_mphone"));//String:手机
		userInfo.setMem_region(ra.getParameter("mem_region"));//String:居住区域
		userInfo.setMem_addr(ra.getParameter("mem_addr"));//String:地址
		userInfo.setSecure_image(ra.getParameter("secure_image"));//String:安全认证图片
		userInfo.setReg_source(ra.getParameter("reg_source"));//String:注册来源网站
		userInfo.setMem_image(ra.getParameter("mem_image"));//String:头像
		userInfo.setNote_info(ra.getParameter("note_info"));//String:备注信息
		userInfo.setMem_name(ra.getParameter("mem_name"));
		userInfo.setID_num(ra.getParameter("ID_num"));
		String error="";
		//读取属性文件 
		ResourceBundle rb=FileReaderUtil.getInstance().getResourceBundle("commonservice");
		String RegEmailVerification=rb.getString("RegEmailVerification");
		if("true".equals(RegEmailVerification)){
			userInfo.setMem_state("0");
		}else{
			userInfo.setMem_state("1");
		}
		String newAction="auth.doregafter";
		SwitchType st;
		String vcode="";
		if(ra.getSession()!=null)
			vcode=(String)ra.getSession().getAttribute("validateCode");
		else
			vcode="";
		if (!vcode.equals(ra.getParameter("validatecode"))) {
			error="0";
			newAction = "auth.rega";
			st = SwitchType.REDIRECT;
			log().debug("register:");
			ra.getSession().setAttribute("userRegister", userRegister);
			ra.getSession().setAttribute("userInfo", userInfo);
			ra.getSession().setAttribute("reg_error", error);
		} else {
			int num=(Integer)sc.queryForObject("Auth.selectMemNameCount",ra.getParameter("mem_name"));
			if(num==0){
				log().debug("continue:");
				String key=UUIDshort.get();
				userRegister.setMem_id(key);//String:用户id
				userInfo.setMem_id(key);//String:用户id
				try{
					sc.startTransaction();
					sc.insert("Auth.addUserRegister",userRegister);
					sc.insert("Auth.addUserInfo1",userInfo);
					sc.commitTransaction();
					
					if("true".equals(RegEmailVerification)){
						newAction = "auth.doregafter";
						st = SwitchType.REDIRECT;
						String smtp=rb.getString("smtp");
						String auth_name=rb.getString("auth_name");
						String auth_pass=rb.getString("auth_pass");
						String viewFile=rb.getString("mailtemplate");
						String title=rb.getString("mail_title");
						User user=new User();
						user.setMem_id(key);
						user.setMem_mail(ra.getParameter("mem_mail"));
						EmailUtil.sendEmail(smtp,auth_name,auth_pass,user,viewFile, title,new HashMap());
					}else{
						newAction = "auth.login?mem_name="+ra.getParameter("mem_name")+"&mem_pass="+password+"&jump_flag=1";
						st = SwitchType.REDIRECT;
					}
					ra.getSession().removeAttribute("userRegister");
					ra.getSession().removeAttribute("userInfo");
					ra.getSession().removeAttribute("reg_error");
				}catch(Exception e){
					error="1";
					newAction = "auth.rega";
					st = SwitchType.REDIRECT;
					ra.getSession().setAttribute("userRegister", userRegister);
					ra.getSession().setAttribute("userInfo", userInfo);
					ra.getSession().setAttribute("reg_error", error);
					throw e;
				}finally{
					sc.endTransaction();
					userInfo=null;
				}	
			}else{
				//此用户已经注册过
				error="2";
				newAction = "auth.rega";
				st = SwitchType.REDIRECT;
				ra.getSession().setAttribute("userRegister", userRegister);
				ra.getSession().setAttribute("userInfo", userInfo);
				ra.getSession().setAttribute("reg_error", error);
			}						
		}
		return new PostDataAndView(null, "block", newAction, st);
	}

}
