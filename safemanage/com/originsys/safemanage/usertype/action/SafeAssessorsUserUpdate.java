package com.originsys.safemanage.usertype.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.TSafeAssessors;

/**
 auth:zhanglf 2014-5-22
   描述：安全鉴定员信息修改
   3：修改鉴定员基本信息
 */
public class SafeAssessorsUserUpdate extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		SqlMapClient sc = DataSource.getSqlMapInstance();
		String mem_id=ra.getParameter("mem_id");
		
		SimpleDateFormat   sdf   =   new   SimpleDateFormat( "yyyy-MM-dd");

		/**安全鉴定员信息*/
		TSafeAssessors tSafeAssessors=new TSafeAssessors();
		tSafeAssessors.setMem_id(mem_id);//String:用户id
		tSafeAssessors.setCertificate_number(ra.getParameter("certificate_number"));//String:从业资格证书编号
		if(ra.getParameter("certificate_date")!=null && !"".equals(ra.getParameter("certificate_date"))){
			tSafeAssessors.setCertificate_date(sdf.parse(ra.getParameter("certificate_date")));//Date:证书取得时间
		}
		tSafeAssessors.setCertificate(ra.getParameter("certificate"));//String:从业资格证书复印件
		tSafeAssessors.setProfessional_titles(ra.getParameter("professional_titles"));//String:专业技术职称
		if(ra.getParameter("work_years")!=null && !"".equals(ra.getParameter("work_years"))){
			tSafeAssessors.setWork_years(Integer.parseInt(ra.getParameter("work_years")));//Integer:工作经验年限
		}
		tSafeAssessors.setProfessional(ra.getParameter("professional"));//String:从事专业
		tSafeAssessors.setSignature(ra.getParameter("signature"));
		String success="0";
		try{
			sc.startTransaction();			
			sc.update("Safecheck.updateTSafeAssessors",tSafeAssessors);
			sc.commitTransaction();
			success="1";
		}catch (Exception e) {
			success="0";
			sc.getCurrentConnection().rollback();
			throw e;
		}finally{
			sc.endTransaction();
		}
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":\""+success+"\",\"key\":\""+mem_id+"\"}");
	}

}
