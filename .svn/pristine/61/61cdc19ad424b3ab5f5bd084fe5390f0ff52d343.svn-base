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
import com.originsys.safemanage.domain.DisasterWarn;
import com.originsys.safemanage.domain.TBuilding;
import com.originsys.safemanage.domain.TBuildingSafe;
import com.originsys.safemanage.domain.TInvmBase;
import com.originsys.safemanage.domain.TInvmField;

/**
 auth:zhanglf 2014-7-24
   描述：突发事件审核
 */
public class DisasterWarnCheck extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		StringBuffer opcontent=new StringBuffer();
		DisasterWarn dWarn=new DisasterWarn();
		opcontent.append("突发事件编号："+ra.getParameter("disaster_id")+";");
		dWarn.setDisaster_id(ra.getParameter("disaster_id"));
		dWarn.setInfo_state(ra.getParameter("info_state"));//预警状态@0-未审核&1-审核通过&2-审核驳回&3-已取消
		opcontent.append("突发事件审核状态："+ra.getParameter("info_state")+";");
		dWarn.setCheck_log(ra.getParameter("check_log"));//审核意见
		opcontent.append("突发事件审核意见："+ra.getParameter("check_log")+";");
		
		int success=0;
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		try{
			sc.update("Safecheck.updateDisasterWarn", dWarn);
			//修改日志
			ra.operate.setOperateModule("审核突发事件：突发事件编号"+ra.getParameter("disaster_id"));
			ra.operate.setOperateContent(opcontent.toString());
			ra.operate.setOperateType("审核");			
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
