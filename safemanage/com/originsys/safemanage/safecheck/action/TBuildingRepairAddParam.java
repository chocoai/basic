package com.originsys.safemanage.safecheck.action;

import java.util.HashMap;
import java.util.Map;

import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-10-24
   描述：楼幢维修记录增加传递楼幢编号参数
 */
public class TBuildingRepairAddParam extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		String building_id=ra.getParameter("building_id");
		String builiding_region = ra.getParameter("builiding_region");
		Map<String,String> remap=new HashMap<String,String>();
		remap.put("building_id",building_id);
		remap.put("builiding_region",builiding_region);
		return new DataAndView(remap,"block");
	}

}
