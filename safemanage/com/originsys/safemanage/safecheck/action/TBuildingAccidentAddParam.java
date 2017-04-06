package com.originsys.safemanage.safecheck.action;

import java.util.HashMap;
import java.util.Map;

import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.RequestAction;

/**
 auth:zhanglf 2014-11-13
   描述：楼幢事故记录增加传递楼幢编号参数
 */
public class TBuildingAccidentAddParam extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		String building_id=ra.getParameter("building_id");
		Map<String,String> remap=new HashMap<String,String>();
		remap.put("building_id",building_id);
		return new DataAndView(remap,"block");
	}

}
