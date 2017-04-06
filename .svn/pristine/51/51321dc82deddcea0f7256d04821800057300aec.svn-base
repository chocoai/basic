package com.originsys.safemanage.authenticate.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.eap.util.UUIDshort;
import com.originsys.safemanage.domain.TAppraisalReport;

/**
 auth:boy 2014-6-4
   描述：鉴定报告修改
 */
public class ReportUpdate  extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		StringBuffer opcontent=new StringBuffer();
		opcontent.append("楼幢编号："+ra.getParameter("building_id")+";楼幢坐落："+ra.getParameter("building_address")+";");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		TAppraisalReport tAppraisalReport=new TAppraisalReport();
		tAppraisalReport.setJdinfo_id(ra.getParameter("jdinfo_id"));//String:鉴定信息编号主键
		tAppraisalReport.setBuilding_address(ra.getParameter("building_address"));//String:楼幢地址
		tAppraisalReport.setBuilding_region(ra.getParameter("building_region"));//String:所属区域
		tAppraisalReport.setEntrust_user(ra.getParameter("entrust_user"));//String:委托人或单位
		tAppraisalReport.setLinkman(ra.getParameter("linkman"));//String:联系人
		tAppraisalReport.setLinktel(ra.getParameter("linktel"));//String:联系电话
		tAppraisalReport.setJz_overview(ra.getParameter("jz_overview"));//String:房屋概况
		tAppraisalReport.setIdentify_conclusion(ra.getParameter("identify_conclusion"));//String:鉴定结论
		tAppraisalReport.setDangerous_level(ra.getParameter("dangerous_level"));//String:危险等级@1-a级&2-b级&3-c级&4-d级
		opcontent.append("危险等级："+ra.getParameter("dangerous_level")+";");
		tAppraisalReport.setIdentify_content(ra.getParameter("identify_content"));//String:鉴定内容
		tAppraisalReport.setStruct_aging(ra.getParameter("struct_aging"));//String:房屋结构老化程度@1-强&2-弱&3-差
		tAppraisalReport.setIs_transform(ra.getParameter("is_transform"));//String:是否有改造@1-是&2-否
		tAppraisalReport.setFacility_aging(ra.getParameter("facility_aging"));//String:设施老化程度@1-强&2-弱&3-差
		tAppraisalReport.setIs_kzperfect(ra.getParameter("is_kzperfect"));//String:抗震结构是否完善@1-强&2-弱&3-差
		tAppraisalReport.setIs_transform_seriousness(ra.getParameter("is_transform_seriousness"));//String:拆改结构是否严重@1-强&2-弱&3-差
		if(ra.getParameter("jd_date")!=null && !"".equals(ra.getParameter("jd_date"))){
			tAppraisalReport.setJd_date(sdf.parse(ra.getParameter("jd_date")));//Date:鉴定时间
			opcontent.append("鉴定时间："+ra.getParameter("jd_date")+";");
		}
		tAppraisalReport.setJdmember(ra.getParameter("jdmember"));//String:鉴定人
		opcontent.append("鉴定人："+ra.getParameter("jdmember")+";");
		tAppraisalReport.setJd_report(ra.getParameter("jd_report"));//String:鉴定报告
		tAppraisalReport.setJd_image(ra.getParameter("jd_image"));//String:相关图片
		if("zc".equals(ra.getParameter("op")))
			tAppraisalReport.setInfo_state("0");//String:鉴定信息状态0暂存1待审核2审核驳回8审核通过
		else
			tAppraisalReport.setInfo_state("1");//String:鉴定信息状态0暂存1待审核2审核驳回8审核通过
		tAppraisalReport.setJd_result(ra.getParameter("jd_result"));//String:鉴定结果
		opcontent.append("鉴定结果："+ra.getParameter("jd_result")+";");
		int success=0;
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		try{
			sc.insert("safeauth.updateTAppraisalReport",tAppraisalReport);
			//修改日志
			ra.operate.setOperateModule("修改鉴定报告信息：楼幢编号"+ra.getParameter("building_id"));
			ra.operate.setOperateContent(opcontent.toString());
			ra.operate.setOperateType("修改");
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
