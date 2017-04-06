package com.originsys.safemanage.usertype.action;

import java.util.HashMap;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.TSafeCensor;

/**
 auth:boy 2014-4-16
   描述：安全检查员属性信息详细
 */
public class SafeCensorUserDetail  extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		//获取主键
		String  mem_id = ra.getParameter("mem_id");
		//获取ibatis执行
		SqlMapClient sc=DataSource.getSqlMapInstance();
		Map<String,Object> remap=new HashMap<String,Object>();
		//根据主键查询信息
		TSafeCensor safecensor=(TSafeCensor)sc.queryForObject("Safecheck.getTSafeCensor",mem_id);
		remap.put("safecensor", safecensor);
		//返回结果
		return new DataAndView(remap,"block");
	}

}
