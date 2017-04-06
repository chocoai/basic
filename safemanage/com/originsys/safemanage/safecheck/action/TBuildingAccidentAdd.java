package com.originsys.safemanage.safecheck.action;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.TBuildingAccident;
import com.originsys.eap.iservice.IData;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import com.originsys.eap.util.UUIDshort;
import java.io.PrintWriter;

/**
 * @author zhanglf 2014年11月13日
 * @version 1.0 创建时间： 类说明： 楼幢事故记录增加
 */
public class TBuildingAccidentAdd extends BaseAction implements IData {

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		// 获取值
		TBuildingAccident tBuildingAccident = new TBuildingAccident();

		String key = UUIDshort.get();
		tBuildingAccident.setAccident_id(key);// String:事故记录编号
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

		String success = "0";
		/** 获取ibatis执行 */
		SqlMapClient sc = DataSource.getSqlMapInstance();
		try {
			sc.startTransaction();
			sc.insert("Safecheck.addTBuildingAccident", tBuildingAccident);
			sc.commitTransaction();
			success = "1";
		} catch (Exception e) {
			success = "0";
			throw e;
		} finally {
			sc.getCurrentConnection().rollback();
			sc.endTransaction();
		}
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.print("{\"success\":\"" + success + "\",\"key\":\"" + key + "\"}");
	}
}