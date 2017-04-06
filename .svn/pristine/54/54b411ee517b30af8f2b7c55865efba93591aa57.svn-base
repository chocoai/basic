package com.originsys.auth.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.service.RegionService;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2013-7-19
   描述：个人信息 组织列表
 */
public class PersonUserOrgcomList extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		String mem_id=ra.getUser().getMem_id();
		SqlMapClient sc=DataSource.getSqlMapInstance();
		//用户企业列表
		List<HashMap> userorgan=sc.queryForList("Auth.getUserOrgan", mem_id);
		if(userorgan==null)userorgan=new ArrayList();
		for(HashMap temp:userorgan){
			temp.put("organ_region_name", RegionService.getInstance().getRegionFullName((String)temp.get("ORGAN_REGION")));
		}
		return new DataAndView(userorgan,"block") ;
	}

}
