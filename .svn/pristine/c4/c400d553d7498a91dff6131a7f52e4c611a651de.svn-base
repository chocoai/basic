package com.originsys.authclient.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.originsys.auth.domain.OrgcomMember;
import com.originsys.auth.domain.UserInfo;
import com.originsys.auth.domain.UserRegister;
import com.originsys.authclient.util.ApiUtil;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.GetMD5;
import com.originsys.eap.util.RequestAction;
import com.originsys.eap.util.UUIDshort;

/**
 auth:boy 2014-7-3
   描述：企业用户增加
   增加用户注册信息
   增加用户信息
   增加用户和企业的对应
 */
public class QyUserInsert  extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		UserRegister userRegister=new UserRegister();
		String key=UUIDshort.get();
		userRegister.setMem_id(key);//String:用户id
		userRegister.setMem_name(ra.getParameter("mem_name"));//String:登录名
//		int temp=(int)Math.round(Math.random()*89999999+10000000);//随机生成一个密码存到用户信息表中
//		String pass=temp+"";
		String pass="666666";
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
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("userRegister", userRegister);
		param.put("userInfo", userInfo);
		param.put("orgcomMember", orgcomMember);
		param.put("mem_name", ra.getParameter("mem_name"));
		
		int success=ApiUtil.getService().addQyUser(param);
		
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":"+success+"}");
	}
}
