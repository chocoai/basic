package com.originsys.safemanage.safecheck.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.User;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.service.DepartmentService;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.GetMD5;
import com.originsys.eap.util.RequestAction;
import com.originsys.eap.util.UUIDshort;
import com.originsys.safemanage.domain.TBuildingAccident;

/**
 auth:zhanglf 2014-11-13
   描述：楼幢事故修改
 */
public class TBuildingAccidentUpdate extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		// 获取值
		TBuildingAccident tBuildingAccident = new TBuildingAccident();

		tBuildingAccident.setAccident_id(ra.getParameter("accident_id"));// String:事故记录编号
		tBuildingAccident.setAccident_name(ra.getParameter("accident_name"));// String:事故标题
		tBuildingAccident.setAccident_type(ra.getParameter("accident_type"));// String:事故类型
		tBuildingAccident.setAccident_description(ra.getParameter("accident_description"));// String:事故描述
		tBuildingAccident.setAccident_reporter(ra.getParameter("accident_reporter"));// String:事故上报人
		tBuildingAccident.setAccident_note(ra.getParameter("accident_note"));// String:事故备注
		tBuildingAccident.setBuilding_id(ra.getParameter("building_id"));// String:楼幢编号

		if (ra.getParameter("accident_date") != null
				&& !"".equals(ra.getParameter("accident_date"))) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			tBuildingAccident.setAccident_date(sdf.parse(ra.getParameter("accident_date")));// String:事故发生时间
		}
				
		SqlMapClient sc = DataSource.getSqlMapInstance();
		String success="0";
		try{
			sc.update("Safecheck.updateTBuildingAccident", tBuildingAccident);
			success="1";
		}catch (Exception e) {
			sc.getCurrentConnection().rollback();
			log().error("楼幢事故修改error："+e.getMessage());
		}
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":\""+success+"\"}");
	}

}
