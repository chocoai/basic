package com.originsys.safemanage.hiddendanger.action;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.eap.iservice.IData;
import com.originsys.safemanage.domain.THdangerBuilding;

import javax.servlet.http.HttpServletResponse;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.PrintWriter;
/**
 * @author   Email: 
 * @version 1.0 创建时间： 
 * 类说明： 隐患房屋上报受理
 */
public class THdangerBuildingUpdate extends BaseAction implements IData {

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		//获取值
		THdangerBuilding tHdangerBuilding=new THdangerBuilding();
		tHdangerBuilding.setInfo_id(ra.getParameter("info_id"));//String:信息编号
		tHdangerBuilding.setInfo_state("1");//String:
		tHdangerBuilding.setAccept_opinion(ra.getParameter("accept_opinion"));//String:受理意见
		tHdangerBuilding.setAcceptor(ra.getUser().getFullname());//String:受理人中文名称
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		tHdangerBuilding.setAccept_date(sdf.parse(sdf.format(new Date())));//Date:受理时间
		int success=0;
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		try{
			sc.update("Safecheck.updateTHdangerBuilding",tHdangerBuilding);
			success=1;
		}catch (Exception e) {
			success=0;
			throw e;
		}
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":"+success+"}");
	}

}
