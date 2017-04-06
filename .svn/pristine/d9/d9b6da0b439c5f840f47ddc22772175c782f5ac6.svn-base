package com.originsys.datacenter.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.datacenter.domain.YcDatacenterResources;
import com.originsys.datacenter.domain.YcDatacenterResourcesColumns;
import com.originsys.datacenter.domain.YcDatacenterResourcesIndex;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-3-13
   描述：资源详细
 */
public class ResourcesDetail extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		//获取主键
		String  resources_id = ra.getParameter("resources_id");
		//获取ibatis执行
		SqlMapClient sc=DataSource.getSqlMapInstance();
		//根据主键查询信息
		YcDatacenterResources result=(YcDatacenterResources)sc.queryForObject("datacenter.getYcDatacenterResources",resources_id);
		/**列信息list**/
		List<YcDatacenterResourcesColumns> collist=sc.queryForList("datacenter.getResourcesColsList", resources_id);
		/**索引list*/
		List<YcDatacenterResourcesIndex> indexlist=sc.queryForList("datacenter.getResourceIndexList", resources_id);
		
		/**返回对象*/
		Map<String,Object> remap=new HashMap<String,Object>();
		remap.put("resource", result);
		remap.put("collist", collist);
		remap.put("indexlist", indexlist);
		collist=null;
		indexlist=null;
		result=null;
		return new DataAndView(remap,"block");
	}

}
