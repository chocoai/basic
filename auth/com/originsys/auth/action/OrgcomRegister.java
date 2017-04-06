package com.originsys.auth.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.Orgcom;
import com.originsys.auth.domain.OrgcomMember;
import com.originsys.auth.domain.OrgcomtypeOrgcom;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.PostDataAndView;
import com.originsys.eap.domain.SwitchType;
import com.originsys.eap.iservice.IPost;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.GetMD5;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2013-7-9
   描述：公司机构注册
   增加公司的基本信息
   增加公司用户的对应
   是否把公司类型对应的所有角色都分给这个用户作为公司的管理员呢？不然的话怎么判断哪个是管理员角色？
   还是定义一个公共的角色作为企业的管理员，嗯这样吧，这样比较妥当，不过还是应该把企业类型对应的角色都分给这个用户，因为这关系到企业站点的权限问题
   注册完成，跳转到企业管理面板
   
 */
public class OrgcomRegister extends BaseAction implements IPost {

	public PostDataAndView execute(RequestAction ra) throws Exception {
		String newAction;
		SwitchType st;
		//组织企业机构信息
		Orgcom orgcom=new Orgcom();
		String key=ra.getParameter("organ_id");
		orgcom.setOrgan_id(key);//String:组织id
		orgcom.setOrgan_name(ra.getParameter("organ_name"));//String:名称
		orgcom.setOrgan_region(ra.getParameter("organ_region"));//String:行政区
		orgcom.setOrgan_address(ra.getParameter("organ_address"));//String:地址
		orgcom.setOrgan_linkman(ra.getParameter("organ_linkman"));//String:联系人
		orgcom.setOrgan_phone(ra.getParameter("organ_phone"));//String:电话
		orgcom.setOrgan_postcode(ra.getParameter("organ_postcode"));//String:邮码
		orgcom.setOrgan_domainname(ra.getParameter("organ_domainname"));//String:域名｜ip
		orgcom.setOrgan_trade(ra.getParameter("organ_trade"));//String:行业
		orgcom.setCom_type(ra.getParameter("com_type"));//String:企业类型
		orgcom.setOrgan_desc(ra.getParameter("organ_desc"));//String:组织简介
		orgcom.setOrgan_type(ra.getParameter("organ_type"));//String:组织类型
		orgcom.setOrgan_staff_number(ra.getParameter("organ_staff_number"));//String:员工人数
		orgcom.setOrgan_code(ra.getParameter("organ_code1")+"-"+ra.getParameter("organ_code2"));//String:组织机构代码证号
		orgcom.setOrgan_cred_type(ra.getParameter("organ_cred_type"));//String:组织证件类型
		orgcom.setOrgan_cred_code(ra.getParameter("organ_cred_code"));//String:组织证件号码
		orgcom.setAuthentication_state("0");//String:认证状态
		orgcom.setOrgan_domainname2(ra.getParameter("organ_domainname2"));//String:
		orgcom.setToken_id(ra.getParameter("token_id"));
		orgcom.setOrgan_code_image(ra.getParameter("organ_code_image"));
		orgcom.setBusiness_license_image(ra.getParameter("business_license_image"));
		orgcom.setTax_reg_certificate(ra.getParameter("tax_reg_certificate"));
		orgcom.setUse_token(ra.getParameter("use_token"));
		orgcom.setReg_date(new Date());
		String password = ra.getParameter("organ_pass");
		password = GetMD5.getMd5(password);
		orgcom.setOrgan_pass(password);
		Map<String,String> temp=new HashMap<String,String>();
		temp.put("organ_code1", ra.getParameter("organ_code1"));
		temp.put("organ_code2", ra.getParameter("organ_code2"));
		temp.put("organ_region_name", ra.getParameter("organ_region_name"));
		
		//组织用户机构对应信息
		OrgcomMember orgcomMember=new OrgcomMember();
		String mem_id=ra.getUser().getMem_id();//=====================================用户id的获取方式
		orgcomMember.setMem_id(mem_id);//String:用户id
		orgcomMember.setOrgan_id(key);//String:企业id
		if(ra.getParameter("join_in_time")!=null && !"".equals(ra.getParameter("join_in_time"))){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			orgcomMember.setJoin_in_time(sdf.parse(ra.getParameter("join_in_time")));//Date:入职时间
		}
		orgcomMember.setNote(ra.getParameter("note"));//String:备注
		orgcomMember.setState("1");//String:状态
		orgcomMember.setIs_manager("1");//String:是否管理员
		//增加企业和企业类型的对应表
		OrgcomtypeOrgcom orgcomtypeOrgcom=new OrgcomtypeOrgcom();
		orgcomtypeOrgcom.setOrgan_id(key);
		orgcomtypeOrgcom.setOrgan_type_state("0");	
		
		//组织用户和角色对应，默认给用户增加企业管理员的角色，这个角色是注册站的角色，有注册站的权限
		//==============================角色id固定的
//		UserRole userRole=new UserRole();
//		//增加用户和企业类型关联的角色对应?????? qyadmin 企业管理员 ==本地角色，保存用户对应角色表中
//		userRole.setRoleid("qyadmin");//String:角色id
//		userRole.setSite_id("eap2");//String:站点
//		userRole.setMem_id(mem_id);//String:用户id
//		userRole.setMem_state("1");//String:用户状态
//		userRole.setCom_id(key);//String:该角色所属的企业
//		userRole.setRole_register_id("5");//String:角色注册id		
//		MemberRole mr=new MemberRole();
//		mr.setRole_id("qyadmin");
//		mr.setMem_id(mem_id);
//		mr.setRole_state("1");
//		mr.setApplication_record("");
//		mr.setApplication_datetime(new Date());
		
		SqlMapClient sc=DataSource.getSqlMapInstance();
		int num=(Integer)sc.queryForObject("Auth.selectOrganid_numCount",key);
		if(num==0){
			try{
				sc.startTransaction();
				sc.insert("Auth.addOrgcom",orgcom);
				sc.insert("Auth.addOrgcomMember",orgcomMember);	
				/**增加企业和类型的对应表*/
				String[] org_types=ra.getParameterValues("com_type");
				if(org_types!=null){
					for(String organ_type_id:org_types){
						orgcomtypeOrgcom.setOrgan_type_id(organ_type_id);
						sc.insert("Auth.addOrgcomtypeOrgcom",orgcomtypeOrgcom);
					}
				}
	//			User user=new User();
	//			user.setMem_id(mem_id);
	//			Role role=new Role();
	//			role.setRole_id("qyadmin");
	//			MemberRole mrole=UserService.getInstance().getMemberRole(user, role);
	//			if(mrole==null)
	//				sc.insert("Role.insertMemberRole",mr);
	//			sc.insert("Auth.addUserRole",userRole);
				sc.commitTransaction();
				newAction = "auth.orgcomregister.after";
				st = SwitchType.REDIRECT;
				ra.getSession().removeAttribute("orgcom");
				ra.getSession().removeAttribute("organcomparam");
				ra.getSession().removeAttribute("regcom_error");
				ra.getSession().removeAttribute("temp_map");
			}catch (Exception e) {
				log().info(e.getMessage());
				log().info(e.getStackTrace());
				e.printStackTrace();
				newAction = "auth.orgcomregister";
				st = SwitchType.REDIRECT;
				ra.getSession().setAttribute("orgcom", orgcom);
				ra.getSession().setAttribute("regcom_error", "2");
				ra.getSession().setAttribute("temp_map", temp);
			}finally{
				sc.endTransaction();
			}
		}else{
			newAction = "auth.orgcomregister";
			st = SwitchType.REDIRECT;
			ra.getSession().setAttribute("orgcom", orgcom);
			ra.getSession().setAttribute("regcom_error", "1");
			ra.getSession().setAttribute("temp_map", temp);
		}
		return new PostDataAndView(null, "block", newAction, st);
	}

}
