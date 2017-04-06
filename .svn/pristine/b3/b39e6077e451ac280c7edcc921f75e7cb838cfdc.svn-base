package com.originsys.datacenter.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-3-12
   描述：服务左侧菜单，统计各种服务的数量
 */
public class ServiceMenu extends BaseAction implements IGet{

	public DataAndView execute(RequestAction arg0) throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		List<HashMap> resultlist=sc.queryForList("datacenter.getServicemenu");
		Map<String,Object> remap=new HashMap<String,Object>();
		remap.put("s0", 0);
		remap.put("s1", 0);
		remap.put("s2", 0);
		remap.put("s7", 0);
		remap.put("s8", 0);
		if(resultlist!=null){
			for(HashMap temp:resultlist){
				String key=(String)temp.get("SERVICE_STATE");
				Object value=temp.get("NUM");
				remap.put("s"+key, value);
			}
		}
		return new DataAndView(remap,"block");
	}

}
