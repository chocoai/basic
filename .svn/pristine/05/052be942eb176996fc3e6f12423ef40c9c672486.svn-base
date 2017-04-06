package com.originsys.datacenter.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.datacenter.domain.YcDatacenterServiceParams;
import com.originsys.datacenter.domain.YcDatacenterServiceRegister;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-3-7
   描述：服务api详细
 */
public class ServiceApiDetail extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		String service_id=ra.getParameter("service_id");
		Map<String,Object> remap=new HashMap<String,Object>();
		/**获取服务信息对象*/
		YcDatacenterServiceRegister servicereg=
				(YcDatacenterServiceRegister)sc.queryForObject("datacenter.getYcDatacenterServiceRegister",service_id);
		/**获取参数对象列表*/
		List<YcDatacenterServiceParams> resultList=
				(List<YcDatacenterServiceParams>)sc.queryForList("datacenter.getYcDatacenterServiceParamsList", service_id);
		remap.put("servicereg", servicereg);
		remap.put("paramlist", resultList);
		return new DataAndView(remap,"block");
	}

}
