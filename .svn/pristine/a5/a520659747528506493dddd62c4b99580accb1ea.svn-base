package com.originsys.auth.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

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
   描述：注册第三步，信息完善
 */
public class Register3 extends BaseAction implements IPost{

	public PostDataAndView execute(RequestAction ra) throws Exception {
		String newAction;
		SwitchType st;
		UserInfo userInfo=new UserInfo();
		userInfo.setMem_id(ra.getParameter("mem_id"));//String:用户id
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
		int success=0;
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		try{
			sc.update("Auth.updateUserInfo",userInfo);
			success=1;
			UserRegister reg=(UserRegister)sc.queryForObject("Auth.getUserRegister1", ra.getParameter("mem_id"));
			newAction = "auth.login?mem_name="+reg.getMem_name()+"&mem_pass="+reg.getMem_pass()+"&jump_flag=1";
			st = SwitchType.REDIRECT;
		}catch (Exception e) {
			success=0;
			newAction = "auth.regc?mem_id="+ra.getParameter("mem_id");
			st = SwitchType.FORWARD;
			throw e;
		}
		return new PostDataAndView(null, "map", newAction, SwitchType.REDIRECT);
	}

}
