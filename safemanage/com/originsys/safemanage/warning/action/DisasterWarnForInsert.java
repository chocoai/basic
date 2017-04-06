package com.originsys.safemanage.warning.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.TBuilding;

/**
 auth:zhanglf 2014-7-23
   描述：突发事件预警新增
 */
public class DisasterWarnForInsert  extends BaseAction implements  IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		String sbid=ra.getParameter("smuserid");
		String smx=ra.getParameter("smx");
		String smy=ra.getParameter("smy");
		Map<String,Object> remap=new HashMap<String,Object>();
		remap.put("sbid", sbid);
		remap.put("smx", smx);
		remap.put("smy", smy);

		return new DataAndView(remap,"block");
	}

}
