package com.originsys.safemanage.unit.action;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.TBuildingUnit;
import com.originsys.eap.iservice.IData;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author boy Email:
 * @version 1.0 创建时间： 类说明： 安全责任单位审核
 */
public class TBuildingUnitCheck extends BaseAction implements IData {

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		// 获取值
		TBuildingUnit tBuildingUnit = new TBuildingUnit();
		tBuildingUnit.setUnit_id(ra.getParameter("unit_id"));// String:安全责任单位编号
		tBuildingUnit.setReview_state(ra.getParameter("review_state"));// String:审核状态
		int success = 0;
		/** 获取ibatis执行 */
		SqlMapClient sc = DataSource.getSqlMapInstance();
		try {
			sc.startTransaction();
			sc.update("Safecheck.updateTBuildingUnit", tBuildingUnit);
			sc.commitTransaction();
			success = 1;
		} catch (Exception e) {
			success = 0;
			throw e;
		} finally {
			sc.endTransaction();
		}
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.print("{\"success\":" + success + "}");
	}

}
