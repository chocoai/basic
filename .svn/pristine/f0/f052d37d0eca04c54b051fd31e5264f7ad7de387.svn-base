package com.originsys.auth.action;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.MemberRole;
import com.originsys.eap.domain.Role;
import com.originsys.eap.service.RoleService;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.GetMD5;
import com.originsys.eap.util.RequestAction;
import com.originsys.eap.util.UUIDshort;
import com.originsys.auth.domain.Orgcom;
import com.originsys.auth.domain.OrgcomMember;
import com.originsys.auth.domain.OrgcomtypeOrgcom;
import com.originsys.auth.domain.UserInfo;
import com.originsys.auth.domain.UserRegister;
import com.originsys.auth.domain.UserRole;
import com.originsys.eap.iservice.IData;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Email:
 * @version 1.0 创建时间： 类说明： 列表页,增加后直接转向到修改页面，维护其它字段内容
 */
public class OrgcomAdd extends BaseAction implements IData {

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		// 获取值
		Orgcom orgcom = new Orgcom();

		String key = ra.getParameter("organ_id");
		orgcom.setOrgan_id(key);// String:组织id

		orgcom.setToken_id(ra.getParameter("token_id"));
		orgcom.setOrgan_name(ra.getParameter("organ_name"));// String:名称

		orgcom.setOrgan_region(ra.getParameter("organ_region"));// String:行政区

		orgcom.setOrgan_address(ra.getParameter("organ_address"));// String:地址

		orgcom.setOrgan_linkman(ra.getParameter("organ_linkman"));// String:联系人

		orgcom.setOrgan_phone(ra.getParameter("organ_phone"));// String:电话

		orgcom.setOrgan_postcode(ra.getParameter("organ_postcode"));// String:邮码

		orgcom.setOrgan_domainname(ra.getParameter("organ_domainname"));// String:域名｜ip

		orgcom.setOrgan_trade(ra.getParameter("organ_trade"));// String:行业

		orgcom.setCom_type(ra.getParameter("com_type"));// String:企业类型

		orgcom.setOrgan_desc(ra.getParameter("organ_desc"));// String:组织简介

		orgcom.setOrgan_type(ra.getParameter("organ_type"));// String:组织类型

		orgcom.setOrgan_staff_number(ra.getParameter("organ_staff_number"));// String:员工人数

		String organ_code1 = ra.getParameter("organ_code1");
		String organ_code2 = ra.getParameter("organ_code2");
		orgcom.setOrgan_code(organ_code1 + "-" + organ_code2);// String:组织机构代码证号

		orgcom.setOrgan_cred_type(ra.getParameter("organ_cred_type"));// String:组织证件类型

		orgcom.setOrgan_cred_code(ra.getParameter("organ_cred_code"));// String:组织证件号码

		orgcom.setAuthentication_state("0");// String:认证状态//此出默认状态为未认证，
		orgcom.setUse_token(ra.getParameter("use_token"));
		orgcom.setReg_date(new Date());
		orgcom.setOrgan_domainname2(ra.getParameter("organ_domainname2"));// String:
		orgcom.setOrgan_code_image(ra.getParameter("organ_code_image"));
		orgcom.setBusiness_license_image(ra.getParameter("business_license_image"));
		orgcom.setTax_reg_certificate(ra.getParameter("tax_reg_certificate"));
		String password = ra.getParameter("organ_pass");
		password = GetMD5.getMd5(password);
		orgcom.setOrgan_pass(password);

		OrgcomtypeOrgcom orgcomtypeOrgcom = new OrgcomtypeOrgcom();
		orgcomtypeOrgcom.setOrgan_id(key);
		orgcomtypeOrgcom.setOrgan_type_state("0");// 此处默认状态为未认证，
		/** 为企业注册新用户 */
		UserRegister userRegister = new UserRegister();
		String ukey = UUIDshort.get();
		userRegister.setMem_id(ukey);// String:用户id
		userRegister.setMem_name(ra.getParameter("organ_id"));// String:登录名
		String upassword = "666666";
		upassword = GetMD5.getMd5(upassword);
		userRegister.setMem_pass(upassword);// String:密码
		userRegister.setMem_question("");// String:密码问题
		userRegister.setMem_answer("");// String:密码答案
		/** 为企业用户完善用户信息 */
		UserInfo userInfo = new UserInfo();
		userInfo.setMem_id(ukey);
		userInfo.setFamily_name("");// String:姓
		userInfo.setFirst_name(ra.getParameter("organ_name"));// String:名
		userInfo.setMem_sex("");// String:性别
		userInfo.setMem_born(null);// Date:生日
		userInfo.setMem_mail("");// String:邮址
		userInfo.setRegister_time(new Date());// Date:注册时间
		userInfo.setMem_integrality("");// String:用户信息完整性
		userInfo.setMem_mphone(ra.getParameter("organ_phone"));// String:手机
		userInfo.setMem_region(ra.getParameter("organ_region"));// String:居住区域
		userInfo.setMem_addr(ra.getParameter("organ_address"));// String:地址
		userInfo.setSecure_image("");// String:安全认证图片
		userInfo.setReg_source("");// String:注册来源网站
		userInfo.setMem_image("");// String:头像
		userInfo.setNote_info("");// String:备注信息
		userInfo.setMem_name(ra.getParameter("organ_id"));
		userInfo.setMem_state("1");// 用户已激活，可以查看或者更新自己的用户信息
		userInfo.setID_num("");
		userInfo.setSecret("666666");
		/** 增加企业用户的对应关系 */
		OrgcomMember orgcomMember = new OrgcomMember();
		orgcomMember.setMem_id(ukey);// String:用户id
		orgcomMember.setOrgan_id(ra.getParameter("organ_id"));// String:企业id
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		orgcomMember.setJoin_in_time(sdf.parse(sdf.format(new Date())));// Date:入职时间
		orgcomMember.setNote("");// String:备注
		orgcomMember.setState("1");// String:状态//默认初始状态为激活
		orgcomMember.setIs_manager("1");// String:是否管理员
		/** 为企业管理员角色增加对应用户 */
		MemberRole mr=new MemberRole();
		mr.setRole_id("qyadmin");
		mr.setMem_id(ukey);
//		UserRole userRole = new UserRole();
//		userRole.setCom_id(key);
//		userRole.setMem_id(ukey);
//		userRole.setMem_state("0");// 默认用户状态为角色未启用，待企业认证之后修改此状态
//		userRole.setRole_register_id("9ca497f86f774419a80e7e39184d80b0");
//		userRole.setRoleid("qyadmin");
//		userRole.setSite_id("eap2");		
		//申请记录
		String admin_name=ra.getUser().getMem_id();
		SimpleDateFormat   sdff  =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=sdff.format(new Date());
		String record="授予角色-管理员:"+admin_name+"-"+date;
		mr.setApplication_record(record);
		mr.setApplication_datetime(new Date());	
		mr.setRole_state("0");//默认角色状态未启用,在企业认证时需要修改该状态值			
		String success = "0";
		/** 获取ibatis执行 */
		SqlMapClient sc = DataSource.getSqlMapInstance();
		try {
			sc.startTransaction();
			int num = (Integer) sc.queryForObject("Auth.selectMemNameCount",
					key);// 检查用户名是否已经存在
			if (num == 0) {
				sc.insert("Auth.addOrgcom", orgcom);
				/** 增加企业和类型的对应表 */
				String[] org_types = ra.getParameterValues("com_type");
				if (org_types != null) {
					for (String organ_type_id : org_types) {
						orgcomtypeOrgcom.setOrgan_type_id(organ_type_id);
						sc.insert("Auth.addOrgcomtypeOrgcom", orgcomtypeOrgcom);
					}
				}
				// 增加用户注册信息
				sc.insert("Auth.addUserRegister", userRegister);
				// 增加用户基本信息
				sc.insert("Auth.addUserInfoadmin", userInfo);
				// 增加用户和企业的对应
				sc.insert("Auth.addOrgcomMember", orgcomMember);
				// 增加用户-角色对应关系*/
				sc.insert("Role.insertMemberRole",mr);
				//sc.insert("Auth.addUserRole", userRole);
				sc.commitTransaction();
				success = "1";
			} else {
				success = "2"; // 用户名已存在
			}
		} catch (Exception e) {
			success = "0";
			log().info(e.getMessage());
			log().info(e.getStackTrace());
			throw e;
		} finally {
			sc.getCurrentConnection().rollback();
			sc.endTransaction();
		}
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.print("{\"success\":\"" + success + "\",\"key\":\"" + key + "\"}");
	}
}