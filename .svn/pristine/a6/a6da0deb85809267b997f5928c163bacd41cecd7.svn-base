package com.originsys.safemanage.safecheck.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.Member;
import com.originsys.eap.domain.MemberRole;
import com.originsys.eap.domain.UserType;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.iservice.IUserType;
import com.originsys.eap.service.DepartmentService;
import com.originsys.eap.service.RoleService;
import com.originsys.eap.util.BeanFactory;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.GetMD5;
import com.originsys.eap.util.RequestAction;
import com.originsys.eap.util.UUIDshort;
import com.originsys.safemanage.domain.TSafeManager;

/**
 auth:zhanglf 2014-5-20
   描述：安全管理员增加，
   1：增加用户信息
   2：增加用户和角色对应信息
   3：增加安全管理员属性信息
 */
public class SafeManagerUserInsert extends BaseAction implements IData{

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
			this.log().info("SafeManagerUserInsert类日期转换错误:"+e);
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
		//String str=ra.getParameter("sub_role");
		memRole.setRole_id(ra.getParameter("role_id"));
		
		/**安全管理员信息*/
		TSafeManager tSafeManager=new TSafeManager();
		tSafeManager.setMem_id(mem_id);//String:用户id
		tSafeManager.setRegion(ra.getParameter("region"));//所属地区
		UserType userType=null;
		String success="0";
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		try{
			sc.startTransaction();
			sc.insert("User.admin_insert", mem);
			sc.insert("User.admin_RoleInsert",memRole);
//			if(null!=str&&!"".equals(str)){
//				memRole.setRole_id(str);
//				sc.insert("User.admin_RoleInsert",memRole);
//				String type=(RoleService.getInstance().getRoleByRoleId(str)).getUser_type();
//				if(null!=type&&!"".equals(type)){
//					userType=BeanFactory.userTypeMap.get(type);
//					IUserType iUserType=(IUserType)BeanFactory.getBean(userType.getImplementClass());
//					iUserType.init(mem);
//				}
//			}
			//增加用户和部门的对应
			String department_id=ra.getParameter("department_id");
			if(department_id!=null&&!"".equals(department_id)){
				DepartmentService.getInstance().addDepartmentMember(mem_id, department_id);
			}
			sc.insert("Safecheck.addTSafeManager",tSafeManager);
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
