package com.originsys.auth.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.Orgcom;
import com.originsys.auth.domain.UserInfo;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2013-7-9
   描述：预加入企业
   根据条件查询企业列表，如果条件为空则返回空列表
 */
public class ForJoinOrgcom extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		/**查询用户信息返回*/
		String mem_id=ra.getUser().getMem_id();
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();		
		UserInfo userinfo=(UserInfo)sc.queryForObject("Auth.getUserInfo",mem_id);
		if(ra.getParameter("organ_name")!=null&&!"".equals(ra.getParameter("organ_name"))){
			/**组织查询条件对象*/
			Orgcom orgcom=new Orgcom();
			orgcom.setOrgan_name(ra.getParameter("organ_name"));//String:名称
			//查询结果
			List<Orgcom> resultList=(List<Orgcom>)sc.queryForList("Auth.getOrgcomList1", orgcom);
			Map<String,Object> resultMap=new HashMap<String,Object>();
			resultMap.put("resultList", resultList);
			resultMap.put("userinfo", userinfo);
			return new DataAndView(resultMap,"block");
		}else{
			Map<String,Object> resultMap=new HashMap<String,Object>();
			resultMap.put("resultList", new ArrayList());
			resultMap.put("userinfo", userinfo);
			return new DataAndView(resultMap,"block");
		}
	}

}
