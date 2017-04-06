package com.originsys.safemanage.safecheck.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.FileReaderUtil;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-4-29
   描述：获取前台传入的区号，楼幢号，分副分丘号，builing_mapid ，
   组织成标准标号，调用hbase Api 获取基本数据
 */
public class BuildingSafeForInsert  extends BaseAction implements  IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		String sbid=ra.getParameter("smuserid");
		Map<String,Object> remap=new HashMap<String,Object>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String currentdate=sdf.format(new Date());
		remap.put("currentdate", currentdate);
		/**调用api获取数据*/
		HttpClient client = new HttpClient();
		/**设置api的地址*/
		ResourceBundle rb=FileReaderUtil.getInstance().getResourceBundle("safecheck");
		String hbase_url=rb.getString("hbase_url");
		PostMethod post0 = new PostMethod(hbase_url+"/portal/datacenter.buildingapi");
		/**设置编码格式*/
		post0.getParams().setContentCharset("utf-8");
		/**组织传入的参数*/
		NameValuePair E = new NameValuePair("building_id", sbid);
		NameValuePair [] pair = new NameValuePair[]{E};
		post0.setRequestBody(pair);
		int status = client.executeMethod(post0);
		if (status == HttpStatus.SC_OK) {
			/**获得返回值*/
			JSONObject building=JSONObject.fromObject(post0.getResponseBodyAsString());
			remap.put("sbid", sbid);
			remap.put("region", building.getString("city_district"));
			remap.put("ws_zb", building.getString("ws_zb"));
			remap.put("building_address", building.getString("building_address"));
			remap.put("building_number", building.getString("building_number"));
			remap.put("build_struct", building.getString("build_struct"));
			remap.put("floorup_count", building.getString("floorup_count"));
			remap.put("floordown_count", building.getString("floordown_count"));
			remap.put("house_count", building.getString("house_count"));
			remap.put("floor_count", building.getString("floor_count"));
			remap.put("building_date", building.getString("building_date"));
			remap.put("use_desgin", building.getString("use_desgin"));
			remap.put("real_type", building.getString("real_type"));
			remap.put("tn_area", building.getString("tn_area"));
			remap.put("build_area", building.getString("build_area"));
		}
		post0.releaseConnection();
//		remap.put("sbid", sbid);
//		remap.put("building_address", ra.getParameter("address"));
		return new DataAndView(remap,"block");
	}

}
