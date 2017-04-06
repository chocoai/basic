package com.originsys.safemanage.dangeroushouse.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.eap.util.UUIDshort;
import com.originsys.safemanage.domain.TDangerousLog;

/**
 auth:boy 2014-6-9
   描述：危房处置增加
 */
public class DangerousLogInsert extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
				//获取值
				TDangerousLog dlog=new TDangerousLog();
				String key=UUIDshort.get();
				dlog.setInfo_id(key);//String:信息编号
				dlog.setBuilding_id(ra.getParameter("building_id"));//String:楼幢编号
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				dlog.setOp_date(sdf.parse(sdf.format(new Date())));//Date:通知时间
				dlog.setOp_content(ra.getParameter("op_content"));
				dlog.setBuilding_state(ra.getParameter("building_state"));
				StringBuffer opcontent=new StringBuffer();
				opcontent.append("楼幢编号："+ra.getParameter("building_id")+";通知时间："+sdf.parse(sdf.format(new Date()))+";");
				String success="0";
				/**获取ibatis执行*/
				SqlMapClient sc=DataSource.getSqlMapInstance();
				try{
					sc.startTransaction();
					/**增加处置信息*/
					sc.insert("safeauth.addTDangerousLog",dlog);
					/**修改主表的状态*/
					sc.update("safeauth.changeBuildingState",dlog);
					//修改日志
					ra.operate.setOperateModule("增加危房处置通知：楼幢编号"+ra.getParameter("building_id"));
					ra.operate.setOperateContent(opcontent.toString());
					ra.operate.setOperateType("增加");
					sc.commitTransaction();
					success="1";
				}catch (Exception e) {
					success="0";
					throw e;
				}finally{
					sc.endTransaction();
				}
				response.setContentType("text/plain");
				PrintWriter out=response.getWriter();
				out.print("{\"success\":\""+success+"\",\"key\":\""+key+"\"}");
	}

}
