package com.originsys.safemanage.warning.action;

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
 auth:zhanglf 2014-7-24
   描述：突发事件删除
 */
public class DisasterWarnDelete extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		/**楼幢编号*/
		String disaster_id="";
		if(ra.getParameter("disaster_id")!=null && !"".equals(ra.getParameter("disaster_id"))){
			disaster_id=ra.getParameter("disaster_id");
		}
		
		int success=0;
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		try{
			sc.delete("Safecheck.deleteDisasterWarn",disaster_id);
			//修改日志
			ra.operate.setOperateModule("删除突发事件信息：突发事件编号"+disaster_id);
			ra.operate.setOperateContent("");
			ra.operate.setOperateType("删除");			
			success=1;
		}catch (Exception e) {
			success=0;
			throw e;
		}finally{
		}
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":"+success+"}");
	}

}
