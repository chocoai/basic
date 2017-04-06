package com.originsys.authclient.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

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
import com.originsys.eap.util.UtilString;


/**
 * @author boy Email:wangbaoaiboy@163.com
 * @version 1.0 创建时间：2010-6-8
 * 类说明：用户角色对应关系删除
 */
public class MemberRoleDelete extends BaseAction implements IData {

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		String success="0";
		//获得角色编号
		String role_id=ra.getParameter("role_id");
		//获得用户编号
		String mem_id=ra.getParameter("mem_id");		
		if(role_id!=null&&!"".equals(role_id)&&mem_id!=null&&!"".equals(mem_id)){			
			SqlMapClient sc=DataSource.getSqlMapInstance();
			try{
				sc.startTransaction();
				sc.startBatch();
				String[] memids=UtilString.split(mem_id,"|");
				Role role=null;
				String user_type="";
				Map<String,Object> map=new HashMap<String, Object>();
				map.put("mem_id", mem_id);
				UserType userType=null;
				IUserType iUserType=null;
				User user=new User();
				user.setMem_id(mem_id);
				for(int i=0;i<memids.length;i++){
					MemberRole mr=new MemberRole();
					mr.setRole_id(role_id);
					mr.setMem_id(memids[i]);
					role=RoleService.getInstance().getRoleByRoleId(role_id);
					user_type=role.getUser_type();
					if(null!=user_type&&!"".equals(user_type)){
						map.put("role_id", role_id);
						map.put("user_type", user_type);
						int count=(Integer) sc.queryForObject("Role.getCountByMUId",map);
						if(count==0){
							userType=BeanFactory.userTypeMap.get(user_type);
							iUserType=(IUserType)BeanFactory.getBean(userType.getImplementClass());
							iUserType.destory(user);
						}
					}
					//删除用户角色对应关系
					sc.delete("Role.deleteMemberRole",mr);
				}
				sc.executeBatch();
				sc.commitTransaction();
				success="1";
			}catch(Exception e){
				success="0";
				throw e;
			}finally{
				sc.endTransaction();
			}
		}
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":\""+success+"\"}");
	}

}
