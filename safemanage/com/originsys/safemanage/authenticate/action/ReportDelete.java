package com.originsys.safemanage.authenticate.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.FileReaderUtil;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-6-5
   描述：鉴定报告删除
 */
public class ReportDelete extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		//设置参数对象
		String jdinfo_id=ra.getParameter("jdinfo_id");//String
		//获取ibatis执行
		SqlMapClient sc=DataSource.getSqlMapInstance();
		//获取值
		int success=0;
		try{
			sc.delete("safeauth.deleteTAppraisalReport",jdinfo_id);
			//修改日志
			ra.operate.setOperateModule("删除鉴定信息：鉴定信息编号"+jdinfo_id);
			ra.operate.setOperateContent("");
			ra.operate.setOperateType("删除");
			
			/**查询除了此条鉴定信息之外是否还有其他的鉴定信息，如果没有了则调用接口，如果还有则不调用*/
			Map<String,String> term=new HashMap<String,String>();
			term.put("jdinfo_id", jdinfo_id);
			term.put("building_id", ra.getParameter("building_id"));
			int num=(Integer)sc.queryForObject("safeauth.getJdinfoNum", term);
			if(num==0){			
				//读取属性文件 
				ResourceBundle rb=FileReaderUtil.getInstance().getResourceBundle("safecheck");
				String hbase_url=rb.getString("hbase_url");
				/**调用12的接口写入到空间库中*/
				PostMethod post1 = new PostMethod(hbase_url+"/portal/realtygis.updatesafedate");
				/**设置编码格式*/
				post1.getParams().setContentCharset("utf-8");
				/**调用api获取数据*/
				HttpClient client = new HttpClient();
				/**组织传入的参数*/
				NameValuePair  bid= new NameValuePair("building_id", ra.getParameter("building_id"));
				NameValuePair  testgrade= new NameValuePair("testgrade", "-1");//鉴定等级
				NameValuePair  checkstate= new NameValuePair("checkstate3", "0");//鉴定的状态，是否鉴定
				NameValuePair [] pair1 = new NameValuePair[]{bid,testgrade,checkstate};
				post1.setRequestBody(pair1);
				int status1 = client.executeMethod(post1);
				post1.releaseConnection();
			}
			success=1;
		}catch (Exception e) {
			success=0;
			throw e;
		}
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":"+success+"}");
	}

}
