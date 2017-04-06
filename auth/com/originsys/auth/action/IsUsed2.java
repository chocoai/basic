package com.originsys.auth.action;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.Orgcom;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2013-7-15
   描述：
 */
public class IsUsed2 extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		int num=0;
		if(ra.getParameter("organ_code")!=null){
			Orgcom org=new Orgcom();
			org.setOrgan_code(ra.getParameter("organ_code"));
			org.setOrgan_id(ra.getParameter("organ_id"));
			num=(Integer)sc.queryForObject("Auth.selectOrganCode_numCount1",org);
		}
		return new DataAndView<Integer>(num,"used");
	}

}
