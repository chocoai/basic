package com.originsys.auth.action;

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
 auth:boy 2013-8-28
   描述：导出工作人员
 */
public class WorkerExport extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		String organ_id=ra.getUser().getOrgcom_id();
		SqlMapClient sc=DataSource.getSqlMapInstance();
		Map<String,Object> remap=new HashMap<String,Object>();
		String jury_name="";
		String years="";
		Map<String,Object> term=new HashMap<String,Object>();
		term.put("organ_id", organ_id);
		term.put("role_id", ra.getParameter("role_id"));
		List expertlist=sc.queryForList("Auth.workerExport", term);
		remap.put("mlist", expertlist);
		remap.put("jury_name", jury_name);
		remap.put("years", years);
		remap.put("organ_name", ra.getUser().getOrgcom_name());
		return new DataAndView(remap,"block");
	}

}
