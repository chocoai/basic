package com.originsys.safemanage.dangeroushouse.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.TAppraisalReport;
import com.originsys.safemanage.domain.TBuilding;
import com.originsys.safemanage.domain.TBuildingRepair;
import com.originsys.safemanage.domain.TBuildingSafe;
import com.originsys.safemanage.domain.TDangerousLog;
import com.originsys.safemanage.domain.TWFZZ;

/**
 auth:boy 2014-6-9
   描述：危房详细
   基本信息
   处置信息列表
   鉴定信息列表
   检查信息列表
   维修记录
 */
public class DangerousDetail extends BaseAction implements  IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		String building_id=ra.getParameter("building_id");
		//根据主键查询信息
		TBuilding result=(TBuilding)sc.queryForObject("Safecheck.getTBuilding",building_id);
		/**危房处置信息列表*/
		List<TDangerousLog> logList=(List<TDangerousLog>)sc.queryForList("safeauth.getTDangerousLogList",building_id);
		/**鉴定信息列表*/
		List<TAppraisalReport> reporttList=(List<TAppraisalReport>)sc.queryForList("safeauth.getReportListByBid", building_id);
		/**房屋检查信息*/
		List<TBuildingSafe> safeList=(List<TBuildingSafe>)sc.queryForList("Safecheck.getBSafeList", building_id);
		/**维修记录*/
		//List<TBuildingRepair> repairList=(List<TBuildingRepair>)sc.queryForList("Safecheck.getTBuildingRepairList",building_id);
		
		@SuppressWarnings("unchecked")
		List<TWFZZ> wfzzList = (List<TWFZZ>)sc.queryForList("Safecheck.getWFZZList",building_id);
		
		/**返回结果*/
		Map<String,Object> remap=new HashMap<String,Object>();
		remap.put("building",result);
		remap.put("loglist",logList);
		remap.put("reportlist",reporttList);
		remap.put("safelist", safeList);
		remap.put("wfzzList", wfzzList);
		//remap.put("repairlist", repairList);
		return new DataAndView(remap,"block");
	}

}
