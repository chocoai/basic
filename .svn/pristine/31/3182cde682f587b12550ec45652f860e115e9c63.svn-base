package com.originsys.auth.action;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.UserInfo;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.service.RegionService;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2013-7-19
   描述：
 */
public class PersonUserBasicInfo  extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		//获取主键
		String  mem_id = ra.getUser().getMem_id();
		//获取ibatis执行
		SqlMapClient sc=DataSource.getSqlMapInstance();
		//根据主键查询信息
		UserInfo result=(UserInfo)sc.queryForObject("Auth.getUserInfo",mem_id);
		result.setMem_region_name(RegionService.getInstance().getRegionFullName(result.getMem_region()));
		//返回结果
		return new DataAndView(result,"result");
	}
}
