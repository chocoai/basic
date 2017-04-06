package com.originsys.safemanage.authenticate.action;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.TAppraisalReport;

/**
 auth:boy 2014-6-4
   描述：鉴定报告详细
   可以用作详细和预修改
 */
public class ReportDetail extends BaseAction implements  IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		//获取ibatis执行
		SqlMapClient sc=DataSource.getSqlMapInstance();
		//获取主键
		String  jdinfo_id = ra.getParameter("jdinfo_id");
		if(jdinfo_id==null||"".equals(jdinfo_id)){
			String building_id=ra.getParameter("building_id");
			if(building_id!=null&&!"".equals(building_id)){
				/**获取最新的鉴定信息的编号*/
				jdinfo_id=(String)sc.queryForObject("safeauth.getNewJdinfoId",building_id);
			}
		}
		if(jdinfo_id==null)jdinfo_id="";
		//根据主键查询信息
		TAppraisalReport result=(TAppraisalReport)sc.queryForObject("safeauth.getTAppraisalReport",jdinfo_id);
		
		//返回结果
		return new DataAndView(result,"result");
	}

}
