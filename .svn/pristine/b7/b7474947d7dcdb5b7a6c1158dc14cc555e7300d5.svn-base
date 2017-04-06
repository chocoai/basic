package com.originsys.auth.action;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.service.RegionService;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.auth.domain.UserInfo;

/**
 * @author   Email: 
 * @version 1.0 创建时间： 
 * 类说明： 列表页
 */
public class UserInfoDetail extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		//获取主键
		String  mem_id = ra.getParameter("mem_id");
		//获取ibatis执行
		SqlMapClient sc=DataSource.getSqlMapInstance();
		//根据主键查询信息
		UserInfo result=(UserInfo)sc.queryForObject("Auth.getUserInfo",mem_id);
		result.setMem_region_name(RegionService.getInstance().getRegionFullName(result.getMem_region()));
		//返回结果
		return new DataAndView(result,"result");
	}
}