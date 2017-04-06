package com.originsys.safemanage.safecheck.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.originsys.safemanage.domain.TBuilding;
import com.originsys.safemanage.domain.TBuildingSafe;
import com.originsys.safemanage.domain.TInvmBase;
import com.originsys.safemanage.domain.TInvmField;

/**
 auth:zhanglf 2014-5-15
   描述：楼幢普查结果删除，删除基本信息表，楼幢普查结果表，地基基础表，现场调查场地环境
 */
public class BuildingSafeDelete extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		String info_id="";
		if(ra.getParameter("info_id")!=null && !"".equals(ra.getParameter("info_id"))){
			info_id=ra.getParameter("info_id");
		}
		
		int success=0;
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		try{
			sc.startTransaction();
			sc.delete("Safecheck.deleteTBuildingSafe",info_id);
			sc.delete("Safecheck.deleteTInvmBase",info_id);
			sc.delete("Safecheck.deleteTInvmField",info_id);
			//修改日志
			ra.operate.setOperateModule("删除检查信息：信息编号"+info_id);
			ra.operate.setOperateContent("");
			ra.operate.setOperateType("删除");
			
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
			NameValuePair  checkgrade= new NameValuePair("checkgrade", "-1");//安全检查等级
			NameValuePair  checkstate= new NameValuePair("checkstate2", "0");//检查的状态，是否检查
			NameValuePair [] pair1 = new NameValuePair[]{bid,checkstate,checkgrade};
			post1.setRequestBody(pair1);
			int status1 = client.executeMethod(post1);
			post1.releaseConnection();
			sc.commitTransaction();			
			success=1;
		}catch (Exception e) {
			success=0;
			throw e;
		}finally{
			sc.endTransaction();
		}
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":"+success+"}");
	}

}
