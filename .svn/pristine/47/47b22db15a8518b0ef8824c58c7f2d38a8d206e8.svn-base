package com.originsys.authclient.action;

import com.originsys.authclient.util.ApiUtil;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2013-7-15
   描述：判断属性是否存在
 */
public class IsUsed extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		int num=0;
		if(ra.getParameter("mem_name")!=null){
			num=ApiUtil.getService().getMemnameCount(ra.getParameter("mem_name"));
		}
//		if(ra.getParameter("mem_mphone")!=null){
//			num=(Integer)sc.queryForObject("Auth.selectMemPhoneCount",ra.getParameter("mem_mphone"));
//		}	
//		if(ra.getParameter("mem_mail")!=null){
//			num=(Integer)sc.queryForObject("Auth.selectMemMailCount",ra.getParameter("mem_mail"));
//		}
//		if(ra.getParameter("ID_num")!=null){
//			num=(Integer)sc.queryForObject("Auth.selectID_numCount",ra.getParameter("ID_num"));
//		}
//		if(ra.getParameter("organ_id")!=null){
//			num=(Integer)sc.queryForObject("Auth.selectOrganid_numCount",ra.getParameter("organ_id"));
//		}
//		if(ra.getParameter("organ_code")!=null){
//			num=(Integer)sc.queryForObject("Auth.selectOrganCode_numCount",ra.getParameter("organ_code"));
//		}
		return new DataAndView<Integer>(num,"used");
	}

}
