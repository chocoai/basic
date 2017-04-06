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
 * @version 1.0 创建时间： 类说明： 管理项目小区审核
 */
public class TBuildingProjectCheck extends BaseAction implements IData {

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		// 获取值
		TBuildingProject tBuildingProject = new TBuildingProject();
		tBuildingProject.setProject_id(ra.getParameter("project_id"));// String:管理项目编号
		tBuildingProject.setReview_state(ra.getParameter("review_state"));// String:信息状态0未审核;1审核通过;2审核驳回
		int success = 0;
		/** 获取ibatis执行 */
		SqlMapClient sc = DataSource.getSqlMapInstance();
		try {
			sc.startTransaction();
			/**修改信息的审核状态*/
			sc.update("Safecheck.updateTBuildingProject", tBuildingProject);
			if("2".equals(ra.getParameter("review_state"))){
				/**如果审核通过则修改t_building表中的小区字段*/
				String building_ids=ra.getParameter("project_buildingids");
				if(building_ids!=null&&!"".equals(building_ids)){
					building_ids=building_ids.replaceAll(",", "','");
					building_ids="('"+building_ids+"')"; 
					tBuildingProject.setProject_buildingids(building_ids);
					sc.update("Safecheck.updateProjectBuildingids", tBuildingProject);
				}
			}
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
