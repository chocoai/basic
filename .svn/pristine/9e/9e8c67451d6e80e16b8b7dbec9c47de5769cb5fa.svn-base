package com.originsys.safemanage.unit.action;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.TBuildingProject;
import com.originsys.eap.iservice.IData;
import javax.servlet.http.HttpServletResponse;
import com.originsys.eap.util.UUIDshort;
import java.io.PrintWriter;

/**
 * @author boy Email:
 * @version 1.0 创建时间： 类说明：管理项目小区增加
 */
public class TBuildingProjectAdd extends BaseAction implements IData {

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		// 获取值
		TBuildingProject tBuildingProject = new TBuildingProject();

		String key = UUIDshort.get();
		tBuildingProject.setProject_id(key);// String:管理项目编号

		tBuildingProject.setProject_name(ra.getParameter("project_name"));// String:管理项目名称

		tBuildingProject.setProject_address(ra.getParameter("project_address"));// String:管理项目地址
        if(null!=ra.getParameter("city_district"))
		tBuildingProject.setCity_district(ra.getParameter("city_district"));// String:所属区域
        else
        tBuildingProject.setCity_district(ra.getUser().getRegion_id());// String:所属区域	
		tBuildingProject.setProject_desc(ra.getParameter("project_desc"));// String:备注

		tBuildingProject.setProject_buildingids(ra
				.getParameter("project_buildingids"));// String:包含楼幢
		if(null!=ra.getParameter("unit_id"))
		tBuildingProject.setUnit_id(ra.getParameter("unit_id"));// String:责任单位编号
		else
		tBuildingProject.setUnit_id(ra.getUser().getOrgcom_id());
		if(null!=ra.getParameter("unit_name"))
		tBuildingProject.setUnit_name(ra.getParameter("unit_name"));//String:责任单位名称
		else
		tBuildingProject.setUnit_name(ra.getUser().getOrgcom_name());	
		tBuildingProject.setReview_state("0");// String:信息状态0未审核;1审核通过;2审核驳回
		String success = "0";
		/** 获取ibatis执行 */
		SqlMapClient sc = DataSource.getSqlMapInstance();
		try {
			sc.startTransaction();
			sc.insert("Safecheck.addTBuildingProject", tBuildingProject);
			sc.commitTransaction();
			success = "1";
		} catch (Exception e) {
			success = "0";
			throw e;
		} finally {
			sc.endTransaction();
		}
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.print("{\"success\":\"" + success + "\",\"key\":\"" + key + "\"}");
	}
}