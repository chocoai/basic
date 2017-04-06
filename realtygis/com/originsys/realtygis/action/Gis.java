package com.originsys.realtygis.action;

import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.RequestAction;
public class Gis extends BaseAction implements IGet{
	public DataAndView<String> execute(RequestAction arg0) throws Exception {
		// TODO Auto-generated method stub
		return new DataAndView("helloworld","world");
	}
}
