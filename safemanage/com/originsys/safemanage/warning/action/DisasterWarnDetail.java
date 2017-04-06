package com.originsys.safemanage.warning.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.DisasterWarn;
import com.originsys.safemanage.domain.TBuilding;
import com.originsys.safemanage.domain.TBuildingSafe;
import com.originsys.safemanage.domain.TBuildingSurvey;
import com.originsys.safemanage.domain.TInvmBase;
import com.originsys.safemanage.domain.TInvmField;

/**
 auth:zhanglf 2014-7-24
   描述：突发事件详细信息
 */
public class DisasterWarnDetail extends BaseAction implements  IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		String  disaster_id = ra.getParameter("disaster_id");
		SqlMapClient sc=DataSource.getSqlMapInstance();
		
		DisasterWarn dWarn=(DisasterWarn)sc.queryForObject("Safecheck.getDisasterWarn",disaster_id);
		/**组织返回的对象*/
		Map<String,Object> remap=new HashMap<String,Object>();
		remap.put("dWarn", dWarn);
		
		return new DataAndView(remap,"block");
	}

}
