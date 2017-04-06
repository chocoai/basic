package com.originsys.safemanage.authenticate.action;

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
import com.originsys.safemanage.domain.TBuildingAccident;
import com.originsys.safemanage.domain.TBuildingRepair;

/**
 auth:wm 2015-2-6
   描述：鉴定报告列表详细
   可以用作详细和预修改
 */
public class RecordDetail extends BaseAction implements  IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		Map<String,Object> remap=new HashMap<String,Object>();//返回值
		/**根据楼幢编号查询详细信息*/
		String building_id=ra.getParameter("building_id");
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		List<TAppraisalReport> safeList=(List<TAppraisalReport>)sc.queryForList("safeauth.getRecordList",building_id);
		//增加返回对象
		remap.put("safeList", safeList);//楼幢鉴定
		return new DataAndView(remap,"block");
	}
}
