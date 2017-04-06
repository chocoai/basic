package com.originsys.safemanage.safecheck.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.FileReaderUtil;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.TBuilding;
import com.originsys.safemanage.domain.TBuildingAccident;
import com.originsys.safemanage.domain.TBuildingRepair;

public class SafeRecordDetail extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		Map<String,Object> remap=new HashMap<String,Object>();//返回值
		/**根据楼幢编号查询详细信息*/
		String building_id=ra.getParameter("building_id");
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		List<TBuilding> safeList=(List<TBuilding>)sc.queryForList("Safecheck.getBuildingSafeManageList1",building_id);
		List<TBuildingAccident> accidentList=(List<TBuildingAccident>)sc.queryForList("Safecheck.getTBuildingAccidentList1",building_id);
		List<TBuildingRepair> repairList=(List<TBuildingRepair>)sc.queryForList("Safecheck.getTBuildingRepairList1",building_id);
		
		//增加返回对象
		remap.put("safeList", safeList);//楼幢日常检查
		remap.put("accidentList", accidentList);//事故记录
		remap.put("repairList", repairList);//维修记录
		
		
		return new DataAndView(remap,"block");
	}

}
