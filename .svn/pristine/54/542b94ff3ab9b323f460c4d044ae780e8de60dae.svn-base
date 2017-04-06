package com.originsys.authclient.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.OrgcomType;
import com.originsys.authclient.util.ApiUtil;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.domain.Role;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.BeanFactory;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.OrgContextHolder;
import com.originsys.eap.util.RequestAction;

public class RoleModify extends BaseAction implements IGet {

	public DataAndView execute(RequestAction ra) throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		
		String role_id=ra.getParameter("role_id");
		if(role_id!=null&& !"".equals(role_id)){
			Role role=(Role)sc.queryForObject("Role.selectRoleById",role_id);
			String user_type=role.getUser_type();
			if(null!=user_type&&!"".equals(user_type)){
				role.setList_action(BeanFactory.userTypeMap.get(user_type).getName());
			}
			/**取本站点的企业类型*/
			String site_id=OrgContextHolder.getVendorType();
			List<OrgcomType> orgcomtype_list=ApiUtil.getService().getOrgcomTypeList(site_id);
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("role",role);
			map.put("orgcomtype_list", orgcomtype_list);
			return new DataAndView(map,"block");
		}else{
			throw new Exception("The parameters \"role_id\" is empty, we must select a record");
		}
	}
}
