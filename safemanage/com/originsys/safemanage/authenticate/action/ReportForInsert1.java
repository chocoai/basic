package com.originsys.safemanage.authenticate.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.TBuilding;

/**
 auth:zhanglf 2014-6-10
   描述：鉴定报告预增加,初始化t_building表
 */
public class ReportForInsert1 extends BaseAction implements  IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		String sbid=ra.getParameter("smuserid");
		String address=ra.getParameter("address");
		Map<String,Object> remap=new HashMap<String,Object>();
		remap.put("sbid", sbid);
		remap.put("building_address", address);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String currentdate=sdf.format(new Date());
		remap.put("currentdate", currentdate);	
		SqlMapClient sc=DataSource.getSqlMapInstance();
		/**楼幢基本信息*/
		TBuilding tBuilding=new TBuilding();
		tBuilding.setBuilding_id(sbid);//Integer:楼幢编号图斑编号sm_id
		tBuilding.setBuilding_address(address);//坐落地址
		
		int num = (Integer)sc.queryForObject("Safecheck.getTBuildingCount", sbid);
		if(num==0){
			//初始化到t_building表
			sc.insert("Safecheck.addTBuilding", tBuilding);
		}
		return new DataAndView(remap,"block");
	}

}
