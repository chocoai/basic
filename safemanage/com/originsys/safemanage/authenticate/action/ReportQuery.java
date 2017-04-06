package com.originsys.safemanage.authenticate.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.domain.Page;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.TAppraisalReport;
import com.originsys.safemanage.domain.TBuilding;

/**
 auth:zhanglf 2014-6-19
  描述：鉴定报告查询  按楼幢地址完全匹配
 */
public class ReportQuery extends BaseAction implements  IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		List<TAppraisalReport> resultList=new ArrayList();
		String building_address=ra.getParameter("building_address");
		
		if(null!=building_address && !"".equals(building_address)){
			//查询结果
			resultList=(List<TAppraisalReport>)sc.queryForList("safeauth.getTAppraisalReportListByAddress", building_address);
		}
	
		Map resultMap=new HashMap();
		resultMap.put("resultList", resultList);
		return new DataAndView(resultMap,"block");
	}

}
