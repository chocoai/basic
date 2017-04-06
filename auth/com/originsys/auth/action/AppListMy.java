package com.originsys.auth.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.AccessApp;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-7-24
   描述：我的应用列表
 */
public class AppListMy extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		String mem_id=ra.getUser().getMem_id();
		List<AccessApp> applist=sc.queryForList("Auth.getMyAppList", mem_id);
		
		Map<String,Object> remap=new HashMap<String,Object>();
		remap.put("applist",applist);
		return new DataAndView(remap,"block");
	}

}
