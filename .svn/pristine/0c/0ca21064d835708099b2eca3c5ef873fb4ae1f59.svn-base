package com.originsys.safemanage.authenticate.action;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.TDangerousNotice;

/**
 auth:boy 2014-6-7
   描述：通知详细
 */
public class NoticeDetail extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		//获取主键
		String building_id = ra.getParameter("building_id");
		//获取ibatis执行
		SqlMapClient sc=DataSource.getSqlMapInstance();
		//根据主键查询信息
		TDangerousNotice result=(TDangerousNotice)sc.queryForObject("safeauth.getTDangerousNotice",building_id);
		//返回结果
		return new DataAndView(result,"result");
	}

}
