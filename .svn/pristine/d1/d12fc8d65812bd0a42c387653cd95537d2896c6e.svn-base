package com.originsys.authclient.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.MemberRole;
import com.originsys.eap.domain.Role;
import com.originsys.eap.domain.User;
import com.originsys.eap.domain.UserType;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.iservice.IUserType;
import com.originsys.eap.service.RoleService;
import com.originsys.eap.util.BeanFactory;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 * @author boy Email:wangbaoaiboy@163.com
 * @version 1.0 创建时间：2010-6-8
 * 类说明：增加角色用户的对应关系
 */
public class MemberRoleInsert extends BaseAction implements IData {

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		String success="0";
		String typeaction="";
		//获得角色编号
		String role_id=ra.getParameter("role_id");
		//获得用户编号
		String mem_id=ra.getParameter("mem_id");
		if(role_id!=null&&!"".equals(role_id)&&mem_id!=null&&!"".equals(mem_id)){
			MemberRole mr=new MemberRole();
			mr.setRole_id(role_id);
			mr.setMem_id(mem_id);
			//获取角色是否需要申请,根据是否需要申请设置用户状态 管理员添加的直接设置为1（正常）
			SqlMapClient sc=DataSource.getSqlMapInstance();
			/**查看数据库中是否存在角色和用户的对应关系，存在则不再增加直接返回*/
			int num=(Integer)sc.queryForObject("Role.getMemberRole1", mr);
			if(num>0){
				
			}else{
				Role role=RoleService.getInstance().getRoleByRoleId(role_id);
				String is_check=role.getIscheck();
				if("1".equals(is_check))
					mr.setRole_state("0");
				else
					mr.setRole_state("1");
				//申请记录
				String admin_name=ra.getUser().getMem_id();
				SimpleDateFormat   sdf  =  new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
				String date=sdf.format(new Date());
				String record="授予角色-管理员:"+admin_name+"-"+date;
				mr.setApplication_record(record);
				mr.setApplication_datetime(new Date());
				String user_type="";
				UserType userType=null;
				try{
					sc.startTransaction();
					sc.insert("Role.insertMemberRole",mr);
					user_type=role.getUser_type();
					log().debug(user_type);
					if(null!=user_type&&!"".equals(user_type)){
						userType=BeanFactory.userTypeMap.get(user_type);
						log().debug(userType.getSettingAction());
						IUserType iUserType=(IUserType)BeanFactory.getBean(userType.getImplementClass());
						User user=new User();
						user.setMem_id(mem_id);
						iUserType.init(user);
						typeaction=userType.getSettingAction()+"?mem_id="+mem_id+"&user_name="+ra.getParameter("user_name");
					}
					sc.commitTransaction();
					success="1";
				}catch(Exception ex){
					success="0";
					log().error(ex.getMessage());
				}finally{
					sc.endTransaction();
				}
			}						
		}else{
			throw new Exception("The parameters \"mem_id\" is empty, we must select a record");
		}
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":\""+success+"\",\"typeaction\":\""+typeaction+"\"}");
	}

}
