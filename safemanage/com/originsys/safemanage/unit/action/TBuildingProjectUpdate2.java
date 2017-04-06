package com.originsys.safemanage.unit.action;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.TBuildingProject;
import com.originsys.eap.iservice.IData;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author boy Email:
 * @version 1.0 创建时间： 类说明： 管理项目小区修改包含楼幢
 */
public class TBuildingProjectUpdate2 extends BaseAction implements IData {

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		// 获取值
		TBuildingProject tBuildingProject = new TBuildingProject();
		tBuildingProject.setProject_id(ra.getParameter("project_id"));// String:管理项目编号
		tBuildingProject.setProject_buildingids(ra
				.getParameter("project_buildingids"));// String:包含楼幢
		int success = 0;
		/** 获取ibatis执行 */
		SqlMapClient sc = DataSource.getSqlMapInstance();
		try {
			sc.startTransaction();
			sc.update("Safecheck.updateTBuildingProject", tBuildingProject);
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
