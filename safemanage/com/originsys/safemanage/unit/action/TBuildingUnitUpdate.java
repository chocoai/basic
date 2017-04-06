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
 * @version 1.0 创建时间： 类说明： 安全责任单位修改
 */
public class TBuildingUnitUpdate extends BaseAction implements IData {

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		// 获取值
		TBuildingUnit tBuildingUnit = new TBuildingUnit();
		tBuildingUnit.setUnit_id(ra.getParameter("unit_id"));// String:安全责任单位编号
		tBuildingUnit.setUnit_name(ra.getParameter("unit_name"));// String:安全责任单位名称
		tBuildingUnit.setUnit_type(ra.getParameter("unit_type"));// String:安全责任单位类型
		tBuildingUnit.setLink_man(ra.getParameter("link_man"));// String:负责人
		tBuildingUnit.setLink_phone(ra.getParameter("link_phone"));// String:负责人电话
		tBuildingUnit.setUnit_desc(ra.getParameter("unit_desc"));// String:备注
		tBuildingUnit.setCity_district(ra.getParameter("city_district"));// String:所属区域
		tBuildingUnit.setReview_state("0");// String:审核状态
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
