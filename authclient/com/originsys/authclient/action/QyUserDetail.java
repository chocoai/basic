package com.originsys.authclient.action;

import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.service.RegionService;
import com.originsys.eap.util.RequestAction;
import com.originsys.auth.domain.UserInfo;
import com.originsys.authclient.util.ApiUtil;

/**
 * @author   Email: 
 * @version 1.0 创建时间： 
 * 类说明： 列表页
 */
public class QyUserDetail extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		String  mem_id = ra.getParameter("mem_id");
		UserInfo result=ApiUtil.getService().getUserInfoByMemid(mem_id);
		result.setMem_region_name(RegionService.getInstance().getRegionFullName(result.getMem_region()));
		//返回结果
		return new DataAndView(result,"result");
	}
}