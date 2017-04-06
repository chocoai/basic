package com.originsys.safemanage.hiddendanger.action;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.eap.iservice.IData;
import javax.servlet.http.HttpServletResponse;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.originsys.eap.util.UUIDshort;
import com.originsys.safemanage.domain.THdangerBuilding;

import java.io.PrintWriter;
/**
 * @author   Email: 
 * @version 1.0 创建时间： 
 * 类说明： 隐患楼幢上报增加
 */
public class THdangerBuildingAdd extends BaseAction implements IData {

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		//获取值
		THdangerBuilding tHdangerBuilding=new THdangerBuilding();
		String key=UUIDshort.get();
		tHdangerBuilding.setInfo_id(key);//String:信息编号
		tHdangerBuilding.setBuilding_address(ra.getParameter("building_address"));//String:楼幢坐落
		tHdangerBuilding.setBuilding_region(ra.getParameter("building_region"));//String:所属区域
		if(ra.getParameter("house_count")!=null && !"".equals(ra.getParameter("house_count"))){
			tHdangerBuilding.setHouse_count(Integer.parseInt(ra.getParameter("house_count")));//Integer:户数
		}
		if(ra.getParameter("floor_count")!=null && !"".equals(ra.getParameter("floor_count"))){
			tHdangerBuilding.setFloor_count(Integer.parseInt(ra.getParameter("floor_count")));//Integer:层数
		}
		tHdangerBuilding.setDangerous_desc(ra.getParameter("dangerous_desc"));//String:隐患说明
		tHdangerBuilding.setAnnex_file(ra.getParameter("annex_file"));//String:附件
		tHdangerBuilding.setAnnex_image(ra.getParameter("annex_image"));//String:图片
		tHdangerBuilding.setLink_man(ra.getParameter("link_man"));//String:联系人
		tHdangerBuilding.setLink_tel(ra.getParameter("link_tel"));//String:联系方式
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		tHdangerBuilding.setEntry_time(sdf.parse(sdf.format(new Date())));//Date:录入时间
		tHdangerBuilding.setInfo_state("0");//String:
		
		String success="0";
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		try{
			sc.insert("Safecheck.addTHdangerBuilding",tHdangerBuilding);
			success="1";
		}catch (Exception e) {
			success="0";
			throw e;
		}
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":\""+success+"\",\"key\":\""+key+"\"}");
	}
}