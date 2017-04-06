package com.originsys.safemanage.unit.action;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.eap.iservice.IData;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author boy Email:
 * @version 1.0 创建时间： 类说明：安全责任单位删除
 */
public class TBuildingUnitDelete extends BaseAction implements IData {

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		// 设置参数对象
		String unit_id=ra.getParameter("unit_id");
		// 获取ibatis执行
		SqlMapClient sc = DataSource.getSqlMapInstance();
		// 获取值
		int success = 0;
		try {
			sc.startTransaction();
			sc.delete("Safecheck.deleteTBuildingUnit", unit_id);
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