package com.originsys.safemanage.safecheck.action;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.TBuildingRepair;
import com.originsys.eap.iservice.IData;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import com.originsys.eap.util.UUIDshort;
import java.io.PrintWriter;

/**
 * @author boy Email:
 * @version 1.0 创建时间： 类说明： 维修记录增加
 */
public class TBuildingRepairAdd extends BaseAction implements IData {

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		// 获取值
		TBuildingRepair tBuildingRepair = new TBuildingRepair();

		String key = UUIDshort.get();
		tBuildingRepair.setRepair_id(key);// String:维修记录编号

		tBuildingRepair.setBuilding_id(ra.getParameter("building_id"));// String:楼幢编号

		tBuildingRepair.setRepair_content(ra.getParameter("repair_content"));// String:维修内容

		tBuildingRepair.setRepair_cost(ra.getParameter("repair_cost"));// String:维修费用

		tBuildingRepair.setRepair_organ(ra.getParameter("repair_organ"));// String:维修单位

		tBuildingRepair.setRepair_manager(ra.getParameter("repair_manager"));// String:维修负责人

		tBuildingRepair.setManager_tel(ra.getParameter("manager_tel"));// String:维修负责电话

		if (ra.getParameter("complete_date") != null
				&& !"".equals(ra.getParameter("complete_date"))) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			tBuildingRepair.setComplete_date(sdf.parse(ra
					.getParameter("complete_date")));// Date:完成时间
		}

		tBuildingRepair.setRepair_remarks(ra.getParameter("repair_remarks"));// String:备注
		String success = "0";
		/** 获取ibatis执行 */
		SqlMapClient sc = DataSource.getSqlMapInstance();
		try {
			sc.startTransaction();
			sc.insert("Safecheck.addTBuildingRepair", tBuildingRepair);
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