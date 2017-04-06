package com.originsys.auth.action;

import java.util.List;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.OrgcomType;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-7-4
   描述：预增加，获取机构类型列表
 */
public class OrgcomForAdd extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		List<OrgcomType> typelist=sc.queryForList("Auth.getOrgcomTypeList");
		
		return new DataAndView(typelist,"block");
	}

}
