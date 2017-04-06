package com.originsys.safemanage.warning.action;

import java.io.PrintWriter;
import java.math.BigDecimal;
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
import com.originsys.eap.util.UUIDshort;
import com.originsys.safemanage.domain.DisasterWarn;
import com.originsys.safemanage.domain.TBuilding;
import com.originsys.safemanage.domain.TBuildingSurvey;

/**
 auth:zhanglf 2014-7-23
   描述：突发事件录入
 */
public class DisasterWarnInsert extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		StringBuffer opcontent=new StringBuffer();
		DisasterWarn dWarn=new DisasterWarn();
		String id=UUIDshort.get();
		opcontent.append("突发事件编号："+id+";");
		dWarn.setDisaster_id(id);
		dWarn.setSmuserid(ra.getParameter("smuserid"));
		if(null!=ra.getParameter("smx")&&!"".equals(ra.getParameter("smx"))){
			BigDecimal smx=new BigDecimal(ra.getParameter("smx"));
			dWarn.setSmx(smx);
		}
		if(null!=ra.getParameter("smy")&&!"".equals(ra.getParameter("smy"))){
			BigDecimal smy=new BigDecimal(ra.getParameter("smy"));
			dWarn.setSmy(smy);
		}
		dWarn.setDisaster_name(ra.getParameter("disaster_name"));
		opcontent.append("灾害简称："+ra.getParameter("disaster_name")+";");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		if(null!=ra.getParameter("disaster_date")&&!"".equals(ra.getParameter("disaster_date"))){
			dWarn.setDisaster_date(sdf.parse(ra.getParameter("disaster_date")));
			opcontent.append("灾害发生时间："+ra.getParameter("disaster_date")+";");
		}
		dWarn.setDisaster_discription(ra.getParameter("disaster_discription"));
		dWarn.setDisaster_grade(ra.getParameter("disaster_grade"));
		opcontent.append("灾害等级："+ra.getParameter("disaster_grade")+";");
		dWarn.setDisaster_region(ra.getParameter("disaster_region"));
		dWarn.setDisaster_type(ra.getParameter("disaster_type"));
		opcontent.append("灾害类型："+ra.getParameter("disaster_type")+";");
		dWarn.setAdd_time(new Date());
		dWarn.setInfo_state("0");//预警状态@0-未审核&1-审核通过&2-审核驳回&3-已取消
		
		int success=0;
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		
		try{
			sc.startTransaction();
			
			sc.insert("Safecheck.addDisasterWarn", dWarn);
			//修改日志
			ra.operate.setOperateModule("增加突发事件：突发事件编号"+id);
			ra.operate.setOperateContent(opcontent.toString());
			ra.operate.setOperateType("增加");
			
			sc.commitTransaction();			
			success=1;
		}catch (Exception e) {
			success=0;
			sc.getCurrentConnection().rollback();
			throw e;
		}finally{
			sc.endTransaction();
		}
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":"+success+"}");
	}

}
