package com.originsys.safemanage.safecheck.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-8-8
   描述：将456条第一次普查的数据导入到大数据中
 */
public class ImportSurverToHbase  extends BaseAction implements IData{

	public void execute(RequestAction arg0, HttpServletResponse response)
			throws Exception {
		String success = "0";
		SqlMapClient sc=DataSource.getSqlMapInstance();
		List<HashMap> relist=sc.queryForList("Common.getDynamicTable","select BUILDING_ID,BUILDING_SAFECONDITION from T_BUILDING_SURVEY");
		
		/**调用api获取数据*/
		HttpClient client = new HttpClient();
		/**设置api的地址*/
		String hbase_url="http://192.168.0.9:8080/";
		PostMethod post0 = new PostMethod(hbase_url+"/portal/datacenter.buildingsafeapi");
		/**设置编码格式*/
		post0.getParams().setContentCharset("utf-8");
		NameValuePair  op= new NameValuePair("op", "14年老楼危楼安全排查");
		NameValuePair  opdate= new NameValuePair("opdate", "2014-07-06");
		NameValuePair  optype= new NameValuePair("optype", "整栋");
		NameValuePair  annex_image1= new NameValuePair("annex_image", "");
		NameValuePair  annex_file1= new NameValuePair("annex_file", "");
		for(int i=0;i<relist.size();i++){
			HashMap temp=relist.get(i);
			System.out.println((String)temp.get("BUILDING_ID")+"=========="+(String)temp.get("BUILDING_SAFECONDITION"));
			NameValuePair  bid= new NameValuePair("building_id", (String)temp.get("BUILDING_ID"));
			NameValuePair  opresult= new NameValuePair("opresult", (String)temp.get("BUILDING_SAFECONDITION"));
			NameValuePair [] pair = new NameValuePair[]{bid,op,opdate,opresult,optype,annex_image1,annex_file1};
			post0.setRequestBody(pair);
			int status = client.executeMethod(post0);
			post0.releaseConnection();
			temp=null;
		}
		success="1";
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":\""+success+"\"}");
	}

}
