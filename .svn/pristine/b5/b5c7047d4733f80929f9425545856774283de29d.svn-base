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
import com.originsys.safemanage.domain.TBuildingRepair;

/**
 auth:zhanglf 2014-11-13
   描述：楼幢维修修改
 */
public class TBuildingRepairUpdate extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		TBuildingRepair tBuildingRepair = new TBuildingRepair();
		
		tBuildingRepair.setRepair_id(ra.getParameter("repair_id"));

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
				
		SqlMapClient sc = DataSource.getSqlMapInstance();
		String success="0";
		try{
			sc.update("Safecheck.updateTBuildingRepair", tBuildingRepair);
			success="1";
		}catch (Exception e) {
			sc.getCurrentConnection().rollback();
			log().error("楼幢维修修改error："+e.getMessage());
		}
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":\""+success+"\"}");
	}

}
