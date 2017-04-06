package com.originsys.datacenter.api.action;

import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.RequestAction;



/**
 auth:boy 2014-3-26
   描述：调用示例
 */
public class CallExample1 extends BaseAction implements IData{
	
	public void execute(RequestAction arg0, HttpServletResponse arg1) throws Exception {
		HttpClient client = new HttpClient();
		/**设置api的地址*/
		PostMethod post0 = new PostMethod("http://localhost:8080/portal/datacenter.houseapi");
		/**设置编码格式*/
		post0.getParams().setContentCharset("utf-8");
		/**组织传入的参数*/
		NameValuePair E = new NameValuePair("building_id", "406601");
		NameValuePair M = new NameValuePair("house_id", "6112434");
		NameValuePair [] pair = new NameValuePair[]{E,M};
		post0.setRequestBody(pair);
		int status = client.executeMethod(post0);
		/**获得返回值*/
		JSONObject house=JSONObject.fromObject(post0.getResponseBodyAsString());
		/**获得自己需要的属性*/
		String building_id=house.getString("building_id");
		String fw_address=house.getString("fw_address");
		System.out.println(status+"楼幢编号:"+building_id+"房屋地址："+fw_address);
		post0.releaseConnection();
		
	}
}
