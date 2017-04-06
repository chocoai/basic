package com.originsys.authclient.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.originsys.auth.domain.RoleRegister;
import com.originsys.authclient.util.ApiUtil;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.domain.Page;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.OrgContextHolder;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2013-7-12
   描述：注册站用户增加角色对应窗口
   列出属于当前站点的企业管理员当前企业的所有角色列表
 */
public class QyUserRoleDialog extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		
	    String organ_id=ra.getUser().getOrgcom_id();
	    String site_id=OrgContextHolder.getVendorType();
		List<RoleRegister> resultList=ApiUtil.getService().getAllQyRoleList(organ_id, site_id);
		Page page=new Page(1,1,resultList.size());
		Map<String,Object> resultMap=new HashMap<String,Object>();
		resultMap.put("page", page);
		resultMap.put("resultList", resultList);
		return new DataAndView(resultMap,"block");
	}

}
