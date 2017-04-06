package com.originsys.safemanage.authenticate.action;

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
import com.originsys.safemanage.domain.TDangerousNotice;

/**
 auth:boy 2014-6-5
   描述：增加危房通知书
   同时修改鉴定报告表中的通知书发送状态
 */
public class NoticeAdd extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		StringBuffer opcontent=new StringBuffer();
		//获取值
		TDangerousNotice tDangerousNotice=new TDangerousNotice();
		String key=UUIDshort.get();
		tDangerousNotice.setInfo_id(key);//String:信息编号
		tDangerousNotice.setBuilding_id(ra.getParameter("building_id"));//String:楼幢编号
		opcontent.append("楼幢编号："+ra.getParameter("building_id")+";");
		tDangerousNotice.setJdinfo_id(ra.getParameter("jdinfo_id"));//String:鉴定编号
		opcontent.append("鉴定编号："+ra.getParameter("jdinfo_id")+";");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		if(ra.getParameter("notice_date")!=null&&!"".equals(ra.getParameter("notice_date"))){
			tDangerousNotice.setNotice_date(sdf.parse(ra.getParameter("notice_date")));//Date:通知时间
			opcontent.append("通知时间："+ra.getParameter("notice_date")+";");
		}
		tDangerousNotice.setNotice_title(ra.getParameter("notice_title"));//通知标题
		opcontent.append("通知标题："+ra.getParameter("notice_title")+";");
		tDangerousNotice.setNotice_content(ra.getParameter("notice_content"));//String:通知内容
		tDangerousNotice.setSender_mem_id(ra.getUser().getFullname());//String:发送人
		opcontent.append("发送人："+ra.getUser().getFullname()+";");
		tDangerousNotice.setSender_department(ra.getUser().getOrgan_name());//发送单位
		opcontent.append("发送单位："+ra.getUser().getOrgan_name()+";");
		tDangerousNotice.setNotice_file(ra.getParameter("notice_file"));//String:通知附件
		String success="0";
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		try{
			sc.startTransaction();
			sc.insert("safeauth.addTDangerousNotice",tDangerousNotice);
			sc.update("safeauth.updateTBuildingNoticeState",ra.getParameter("building_id"));
			//修改日志
			ra.operate.setOperateModule("增加危房通知书：楼幢编号"+ra.getParameter("building_id"));
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
