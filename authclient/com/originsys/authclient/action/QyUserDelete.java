package com.originsys.authclient.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.authclient.util.ApiUtil;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.Role;
import com.originsys.eap.domain.User;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.iservice.IUserType;
import com.originsys.eap.util.BeanFactory;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-7-3
   描述：企业管理员删除用户
   0：删除本站用户类型属性
   1：删除本站的用户和角色的对应
   2：删除用户和本地机构的对应
   3：删除注册站的用户和企业的对应
   4：删除注册站的用户和本企业角色的对应
 */
public class QyUserDelete  extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {		
	    SqlMapClient sc=DataSource.getSqlMapInstance();
	    int success=0;
	    
	    String mem_id=ra.getParameter("mem_id");
	    try{
	    	User user=new User();
			user.setMem_id(mem_id);
			IUserType iUserType=null;
			List<Role> roles=sc.queryForList("Role.getMemberRoleList",mem_id);//获取用户对应的所有角色
			sc.startTransaction();
			String userType="";
			if(null!=roles&&roles.size()>0){
				for(Role role:roles){
					userType=role.getUser_type();
					if(null!=userType&&!"".equals(userType)){
						iUserType=(IUserType) BeanFactory.getBean((BeanFactory.userTypeMap.get(userType)).getImplementClass());
						iUserType.destory(user);//清除特定用户属性表中的数据
					}
				}
			}
			//删除用户对应角色关系
			sc.delete("User.deleteuserrole",mem_id);
			//删除用户和部门的对应关系
			sc.delete("organ.deleteDepartmentMemberByMID", mem_id);
	    	sc.commitTransaction();
	    	success=ApiUtil.getService().delQyUser(mem_id,ra.getUser().getOrgcom_id());
//	    	success=1;
	    }catch(Exception e){
	    	success=0;
	    	throw e;
	    }finally{
	    	sc.endTransaction();
	    }
	    
	    response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":"+success+"}");
	}

}
