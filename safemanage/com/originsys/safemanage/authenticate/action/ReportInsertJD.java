package com.originsys.safemanage.authenticate.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;


import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.eap.util.UUIDshort;
import com.originsys.safemanage.domain.TAppraisalReport;

/**
 auth:boy 2014-6-4
   描述：鉴定报告保存
  还需要暂存吗？在预增加页面上暂存或是提交之后页面都关闭或是跳转，
  因为这个地方就是增加，不包括修改，如果在这里修改不知道鉴定报告的编号，没法修改
 */
public class ReportInsertJD  extends BaseAction implements IData{
	private String state;
	private String optType;
	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		StringBuffer opcontent=new StringBuffer();
		optType = ra.getParameter("optType");
		System.out.println("optType "+optType+"  新增记录");
		
		opcontent.append("楼幢编号："+ra.getParameter("building_id")+";楼幢坐落："+ra.getParameter("building_address")+";");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		TAppraisalReport tAppraisalReport=new TAppraisalReport();
		String key=UUIDshort.get();
		tAppraisalReport.setJdinfo_id(key);//String:鉴定信息编号主键
		tAppraisalReport.setBuilding_id(ra.getParameter("building_id"));//String:楼幢编号
		tAppraisalReport.setBuilding_address(ra.getParameter("building_address"));//String:楼幢地址
		tAppraisalReport.setBuilding_region(ra.getParameter("building_region"));//String:所属区域
		tAppraisalReport.setEntrust_user(ra.getParameter("entrust_user"));//String:委托人或单位
		tAppraisalReport.setIs_transform(ra.getParameter("is_transform"));//String:是否有改造@1-是&2-否
		if(ra.getParameter("jd_date")!=null && !"".equals(ra.getParameter("jd_date"))){
			tAppraisalReport.setJd_date(sdf.parse(ra.getParameter("jd_date")));//Date:鉴定时间
			opcontent.append("鉴定时间："+ra.getParameter("jd_date")+";");
		}
		tAppraisalReport.setJd_department_id(ra.getParameter("jd_department_id"));//String:鉴定单位
		tAppraisalReport.setJd_department(ra.getParameter("jd_department"));//String:鉴定单位
		tAppraisalReport.setJdmember(ra.getParameter("jdmember"));//String:鉴定人
		tAppraisalReport.setJd_image(ra.getParameter("jd_image"));//String:相关图片
		if("zc".equals(ra.getParameter("op")))
			tAppraisalReport.setInfo_state("0");//String:鉴定信息状态0暂存1待审核2审核驳回8审核通过
		else
			tAppraisalReport.setInfo_state("1");//String:鉴定信息状态0暂存1待审核2审核驳回8审核通过
		tAppraisalReport.setEntry_mem_id(ra.getUser().getMem_id());//String:录入人
		tAppraisalReport.setEntry_date(sdf.parse(sdf.format(new Date())));//Date:录入时间
		tAppraisalReport.setNotice_state("0");
		int success=0;
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		try{
			sc.startTransaction();
			if(optType != null && !optType.equals("") && optType.equals("MODIFY")){
				sc.insert("safeauth.updateTAppraisalReport",tAppraisalReport);
				//修改日志
				ra.operate.setOperateModule("修改鉴定报告信息：楼幢编号"+ra.getParameter("building_id"));
				ra.operate.setOperateContent(opcontent.toString());
				ra.operate.setOperateType("修改");
			}else{
				sc.insert("safeauth.addTAppraisalReport",tAppraisalReport);
				//修改日志
				ra.operate.setOperateModule("增加鉴定报告信息：楼幢编号"+ra.getParameter("building_id"));
				ra.operate.setOperateContent(opcontent.toString());
				ra.operate.setOperateType("增加");
			}
			
			/**调用接口，修改普查状态*/
//			HttpClient client = new HttpClient();
//			//读取属性文件 
//			ResourceBundle rb=FileReaderUtil.getInstance().getResourceBundle("safecheck");
//			String hbase_url=rb.getString("hbase_url");
//			PostMethod post0 = new PostMethod(hbase_url+"/portal/realtygis.updatesafedate");
//			/**设置编码格式*/
//			post0.getParams().setContentCharset("utf-8");
//			/**组织传入的参数*/
//			NameValuePair  bid= new NameValuePair("building_id", ra.getParameter("building_id"));
//			NameValuePair  checkstate= new NameValuePair("checkstate3", "1");//鉴定的状态，是否鉴定
//			NameValuePair [] pair = new NameValuePair[]{bid,checkstate};
//			post0.setRequestBody(pair);
//			int status = client.executeMethod(post0);
//			post0.releaseConnection();
//			success=1;
			sc.commitTransaction();
			state="SUCC";
		}catch (Exception e) {
			state="FAIL";
			throw e;
		}finally{
			sc.endTransaction();
		}
		response.setContentType("text/html; charset=GBK");
		// 输出json对象
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("result" , state);
		String result = jsonObj.toString();
		// 输出响应
		response.getWriter().println(result);
	}

}
