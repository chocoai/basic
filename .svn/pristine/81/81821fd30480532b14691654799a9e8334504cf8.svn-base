package com.originsys.safemanage.authenticate.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.FilePath;
import com.originsys.eap.util.FileReaderUtil;
import com.originsys.eap.util.RequestAction;
import com.originsys.eap.util.UUIDshort;
import com.originsys.safemanage.domain.TAppraisalReport;
import com.originsys.safemanage.domain.TBuilding;
import com.originsys.safemanage.domain.TDangerousLog;

/**
 auth:boy 2014-6-4
   描述：鉴定报告审核
   审核通过的修改主表的楼幢鉴定状态
   如果是危楼的增加危楼跟踪日志
   保存到数据中，什么时间 什么单位鉴定 鉴定结果是什么
 */
public class ReportCheck extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		int success=0;
		StringBuffer opcontent=new StringBuffer();
		opcontent.append("鉴定信息编号："+ra.getParameter("jdinfo_id")+";");
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		TAppraisalReport tAppraisalReport=new TAppraisalReport();
		tAppraisalReport.setJdinfo_id(ra.getParameter("jdinfo_id"));//String:鉴定信息编号主键
		tAppraisalReport.setChecker_memid(ra.getUser().getMem_id());//String:审核人
		opcontent.append("审核人："+ra.getUser().getMem_id()+";");
		tAppraisalReport.setCheck_date(sdf.parse(sdf.format(new Date())));//Date:审核时间
		opcontent.append("审核时间："+sdf.parse(sdf.format(new Date()))+";");
		tAppraisalReport.setInfo_state(ra.getParameter("info_state"));//String:鉴定信息状态0暂存1待审核2审核驳回8审核通过
		tAppraisalReport.setCheck_opinion(ra.getParameter("check_opinion"));//String:审核意见
		opcontent.append("审核意见："+ra.getParameter("check_opinion")+";");
		String dangerous_level=ra.getParameter("dangerous_level");
		TBuilding building=new TBuilding();
		building.setBuilding_id(ra.getParameter("building_id"));
		building.setHealth_grade_jd(dangerous_level);
		opcontent.append("鉴定安全等级："+dangerous_level+";");
		building.setJdinfo_id(ra.getParameter("jdinfo_id"));
		building.setNotice_state("0");
		
		try{
			TBuilding tbuilding=(TBuilding)sc.queryForObject("Safecheck.getTBuilding",ra.getParameter("building_id"));
			if(null==tbuilding.getBuilding_address()||"".equals(tbuilding.getBuilding_address())){
				building.setBuilding_address(ra.getParameter("building_address"));
				opcontent.append("楼幢坐落："+ra.getParameter("building_address")+";");
			}
			if(null==tbuilding.getBuiliding_region()||"".equals(tbuilding.getBuiliding_region())){
				building.setBuiliding_region(ra.getParameter("building_region"));
			}
			
			sc.startTransaction();
			sc.update("safeauth.updateTAppraisalReport",tAppraisalReport);
			
			//修改日志
			ra.operate.setOperateModule("审核鉴定信息：鉴定信息编号"+ra.getParameter("jdinfo_id"));
			ra.operate.setOperateContent(opcontent.toString());
			ra.operate.setOperateType("审核");
			if("8".equals(ra.getParameter("info_state"))){
				/**修改主表的楼幢状态的字段属性*/
				if(ra.getParameter("building_region")!=null&&!"".equals(ra.getParameter("building_region"))
						&&ra.getParameter("building_address")!=null&&!"".equals(ra.getParameter("building_address")))
				sc.update("Safecheck.updateTBuilding",building);
				/**增加信息到危楼处置表*/
				//获取值
				TDangerousLog dlog=new TDangerousLog();
				String key=UUIDshort.get();
				dlog.setInfo_id(key);//String:信息编号
				dlog.setBuilding_id(ra.getParameter("building_id"));//String:楼幢编号
				dlog.setOp_date(sdf.parse(sdf.format(new Date())));//Date:通知时间
				String jdresult="";
				if(dangerous_level.equals("1"))jdresult="A级";
				if(dangerous_level.equals("2"))jdresult="B级";
				if(dangerous_level.equals("3"))jdresult="C级";
				if(dangerous_level.equals("4"))jdresult="D级";
				dlog.setOp_content(ra.getParameter("jd_department")+ra.getParameter("jd_date")+"进行房屋鉴定,鉴定结果是:"+jdresult);
				dlog.setBuilding_state("1");
				sc.insert("safeauth.addTDangerousLog",dlog);
				/**将安全结果录入到大数据中*/
				/**调用api获取数据*/
				HttpClient client = new HttpClient();
				/**设置api的地址*/
				//读取属性文件 
				ResourceBundle rb=FileReaderUtil.getInstance().getResourceBundle("safecheck");
				String hbase_url=rb.getString("hbase_url");
				PostMethod post0 = new PostMethod(hbase_url+"/portal/datacenter.buildingsafeapi");
				/**设置编码格式*/
				post0.getParams().setContentCharset("utf-8");
				/**组织传入的参数*/
				NameValuePair  bid= new NameValuePair("building_id", ra.getParameter("building_id"));
				NameValuePair  op= new NameValuePair("op", "安全鉴定");
				NameValuePair  opdate= new NameValuePair("opdate", ra.getParameter("jd_date"));
				NameValuePair  opresult= new NameValuePair("opresult", dangerous_level);
				NameValuePair  optype= new NameValuePair("optype", "整栋");
				String annex_image=ra.getParameter("annex_image");
//				if(annex_image!=null&&!"".equals(annex_image))
//					annex_image=ra.getParameter("annex_image").replace("../", FilePath.getServerUrl()+"/");
				NameValuePair  annex_image1= new NameValuePair("annex_image", annex_image);
				String annex_file=ra.getParameter("annex_file");
//				if(annex_file!=null&&!"".equals(annex_file))
//					annex_file=FilePath.getServerUrl()+annex_file;
				NameValuePair  annex_file1= new NameValuePair("annex_file", annex_file);
				NameValuePair [] pair = new NameValuePair[]{bid,op,opdate,opresult,optype,annex_image1,annex_file1};
				post0.setRequestBody(pair);
				int status = client.executeMethod(post0);
				post0.releaseConnection();
				
				/**调用12的接口写入到空间库中*/
				PostMethod post1 = new PostMethod(hbase_url+"/portal/realtygis.updatesafedate");
				/**设置编码格式*/
				post1.getParams().setContentCharset("utf-8");
				/**组织传入的参数*/
				NameValuePair  testgrade= new NameValuePair("testgrade", dangerous_level);//鉴定等级
				NameValuePair  checkstate= new NameValuePair("checkstate3", "1");//鉴定的状态，是否鉴定
				NameValuePair [] pair1 = new NameValuePair[]{bid,testgrade,checkstate};
				post1.setRequestBody(pair1);
				int status1 = client.executeMethod(post1);
				post1.releaseConnection();
			}
			success=1;
			sc.commitTransaction();
		}catch (Exception e) {
			success=0;
			throw e;
		}finally{
			sc.endTransaction();
		}
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":"+success+"}");
	}
}
