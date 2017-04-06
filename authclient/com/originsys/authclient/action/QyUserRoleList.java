package com.originsys.authclient.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.domain.Page;
import com.originsys.eap.domain.Role;
import com.originsys.eap.domain.UserType;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.service.RoleService;
import com.originsys.eap.util.BeanFactory;
import com.originsys.eap.util.OrgContextHolder;
import com.originsys.eap.util.RequestAction;
import com.originsys.auth.domain.RoleRegister;
import com.originsys.authclient.util.ApiUtil;
/**
 * @author   Email: 
 * @version 1.0 创建时间： 
 * 类说明： 列表页
 * 查询用户在当前管理员的当前组织中的对应角色列表
 */
public class QyUserRoleList  extends BaseAction implements IGet{

	public DataAndView<Map> execute(RequestAction ra)throws Exception {
		String organ_id=ra.getUser().getOrgcom_id();
	    String site_id=OrgContextHolder.getVendorType();
		List<RoleRegister> resultList=ApiUtil.getService().getQyRoleListByMemid(organ_id,site_id,ra.getParameter("mem_id"));
		List<RoleRegister> relist=new ArrayList<RoleRegister>();
		/**循环角色列表，看看本地是否绑定用户类型*/
		for(int i=0;i<resultList.size();i++){
			RoleRegister temp=resultList.get(i);
			String role_id=temp.getRole_id();
			Role role=RoleService.getInstance().getRoleByRoleId(role_id);
			String typeaction="";
			String user_type=role.getUser_type();
			UserType userType=null;
			if(null!=user_type&&!"".equals(user_type)){
				userType=BeanFactory.userTypeMap.get(user_type);
				typeaction=userType.getSettingAction()+"?mem_id="+ra.getParameter("mem_id")+"&user_name="+ra.getParameter("user_name");
			}
			temp.set_internal_state(typeaction);
			relist.add(temp);
			temp=null;
		}
		resultList=null;
		Page page=new Page(1,1,relist.size());
		Map<String,Object> resultMap=new HashMap<String,Object>();
		resultMap.put("page", page);
		resultMap.put("resultList", relist);
		return new DataAndView(resultMap,"block");
	}
}