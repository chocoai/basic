package com.originsys.safemanage.safecheck.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.Member;
import com.originsys.eap.domain.MemberRole;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.service.DepartmentService;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.GetMD5;
import com.originsys.eap.util.RequestAction;
import com.originsys.eap.util.UUIDshort;
import com.originsys.safemanage.domain.TSafeAssessors;

/**
 auth:zhanglf 2014-5-22
   描述：安全鉴定员增加，
   1：增加用户信息
   2：增加用户和角色对应信息
   3：增加安全鉴定员属性信息
 */
public class SafeAssessorsUserInsert extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		String mem_id=UUIDshort.get();//用户id
		/**用户对象*/
		Member mem=new Member();
		/**用户对应角色对象*/
		MemberRole memRole=new MemberRole();
		String birthday=ra.getParameter("birthday");
		mem.setMem_id(mem_id);
		mem.setFamily_name(ra.getParameter("familyname"));
		String password=GetMD5.getMd5("666666");
        mem.setMem_pass(password);
        mem.setMem_sex(ra.getParameter("mem_sex"));
		Date theDate=null;
		SimpleDateFormat   sdf   =   new   SimpleDateFormat( "yyyy-MM-dd");
		try{
			if(null!=birthday&&!"".equals(birthday)){
				theDate=sdf.parse(birthday);
			}
		}catch (Exception e) {
			this.log().info("SafeAssessorsUserInsert类日期转换错误:"+e);
		}
		mem.setMem_born(theDate);
		mem.setMem_mail(ra.getParameter("mem_mail"));
		mem.setRegister_time(new Date());
		mem.setIsenable("1");
		mem.setFirstname(ra.getParameter("firstname"));
		mem.setFullname(ra.getParameter("familyname")+ra.getParameter("firstname"));
		mem.setMem_name(ra.getParameter("username"));
		mem.setMem_mphone(ra.getParameter("mem_mphone"));
		memRole.setMem_id(mem.getMem_id());
		memRole.setRole_state("1");
		memRole.setConfirmed_time(new Date());
		memRole.setRole_id(ra.getParameter("role_id"));
		/**安全鉴定员信息*/
		TSafeAssessors tSafeAssessors=new TSafeAssessors();
		tSafeAssessors.setMem_id(mem_id);//String:用户id
		tSafeAssessors.setCertificate_number(ra.getParameter("certificate_number"));//String:从业资格证书编号
		if(ra.getParameter("certificate_date")!=null && !"".equals(ra.getParameter("certificate_date"))){
			tSafeAssessors.setCertificate_date(sdf.parse(ra.getParameter("certificate_date")));//Date:证书取得时间
		}
		tSafeAssessors.setCertificate(ra.getParameter("certificate"));//String:从业资格证书复印件
		tSafeAssessors.setProfessional_titles(ra.getParameter("professional_titles"));//String:专业技术职称
		if(ra.getParameter("work_years")!=null && !"".equals(ra.getParameter("work_years"))){
			tSafeAssessors.setWork_years(Integer.parseInt(ra.getParameter("work_years")));//Integer:工作经验年限
		}
		tSafeAssessors.setProfessional(ra.getParameter("professional"));//String:从事专业
		tSafeAssessors.setSignature(ra.getParameter("signature"));
		String success="0";
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		try{
			sc.startTransaction();
			sc.insert("User.admin_insert", mem);
			sc.insert("User.admin_RoleInsert",memRole);
			//增加用户和部门的对应
			String department_id=ra.getParameter("department_id");
			if(department_id!=null&&!"".equals(department_id)){
				DepartmentService.getInstance().addDepartmentMember(mem_id, department_id);
			}
			sc.insert("Safecheck.addTSafeAssessors",tSafeAssessors);
			sc.commitTransaction();
			success="1";
		}catch (Exception e) {
			success="0";
			sc.getCurrentConnection().rollback();
			throw e;
		}finally{
			sc.endTransaction();
		}
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":\""+success+"\",\"key\":\""+mem_id+"\"}");
	}

}
