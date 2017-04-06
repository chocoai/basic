package com.originsys.authclient.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.originsys.auth.domain.OrgcomType;
import com.originsys.authclient.util.ApiUtil;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.OrgContextHolder;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-6-27
   描述：预角色增加，获取当前企业站点下的用户类型
 */
public class ForRoleInsert extends BaseAction implements IGet{

	public DataAndView execute(RequestAction arg0) throws Exception {
		/**取本站点的企业类型*/
		String site_id=OrgContextHolder.getVendorType();
		List<OrgcomType> orgcomtype_list=ApiUtil.getService().getOrgcomTypeList(site_id);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("orgcomtype_list", orgcomtype_list);
		return new DataAndView(map,"block");
	}

}
