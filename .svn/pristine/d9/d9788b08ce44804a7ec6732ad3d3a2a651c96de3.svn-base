package com.originsys.safemanage.safecheck.action;

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
import com.originsys.safemanage.domain.TBuilding;
import com.originsys.safemanage.domain.TBuildingSafe;
import com.originsys.safemanage.domain.TBuildingSurvey;
import com.originsys.safemanage.domain.TInvmBase;
import com.originsys.safemanage.domain.TInvmField;

/**
 auth:zhanglf 2014-6-6
   描述：楼幢检查审核
   1：修改数据的审核状态
   2：如果审核通过则，修改主表中的检查的等级及面积
   3：如果审核通过则，记录到大数据中
 */
public class BuildingSafeCheck extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
				
		/**楼幢检查结果信息*/
		TBuildingSafe tBuildingSafe=new TBuildingSafe();
		tBuildingSafe.setInfo_id(ra.getParameter("info_id"));//主键
		tBuildingSafe.setVerify_time(new java.util.Date());
		tBuildingSafe.setVerify_comment(ra.getParameter("building_check_log"));
		tBuildingSafe.setVerify_userid(ra.getUser().getMem_id());
		tBuildingSafe.setInfo_state(ra.getParameter("building_isOpen"));//String:暂存 0   未审核1    审核驳回2     审核通过8
		
		StringBuffer opcontent=new StringBuffer();
		opcontent.append("信息编号："+ra.getParameter("info_id")+";");
		opcontent.append("楼幢编号："+ra.getParameter("building_id")+";楼幢坐落："+ra.getParameter("building_address")+";");
		opcontent.append("审核状态："+ra.getParameter("building_isOpen")+";审核意见："+ra.getParameter("building_check_log")+";");
		
		int success=0;
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try{
			sc.startTransaction();
			sc.update("Safecheck.updateTBuildingSafe",tBuildingSafe);
			//修改日志
			ra.operate.setOperateModule("审核检查信息：信息编号"+ra.getParameter("info_id"));
			ra.operate.setOperateContent(opcontent.toString());
			ra.operate.setOperateType("审核");
			if("8".equals(ra.getParameter("building_isOpen"))){		
				String building_id=ra.getParameter("building_id");
				/**楼幢基本信息*/
				TBuilding tBuilding=new TBuilding();
				tBuilding.setBuilding_id(building_id);//Integer:楼幢编号图斑编号sm_id
				if(ra.getParameter("build_area")!=null && !"".equals(ra.getParameter("build_area"))){
					tBuilding.setBuild_area(Float.parseFloat(ra.getParameter("build_area")));//Float:建筑面积
				}
				tBuilding.setHealth_grade_pc(ra.getParameter("health_savegrade"));//String:健康等级-普查@1-a级&2-b级&3-c级&4-d级
				sc.update("Safecheck.updateTBuilding",tBuilding);
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
					NameValuePair  bid= new NameValuePair("building_id", building_id);
					NameValuePair  op= new NameValuePair("op", "安全检查");
					NameValuePair  opdate= new NameValuePair("opdate", sdf.format(new Date()));
					NameValuePair  opresult= new NameValuePair("opresult", ra.getParameter("health_savegrade"));
					NameValuePair  optype= new NameValuePair("optype", "整栋");
					String annex_image="";//201-8-19图片改成可以上传多张的了，这里暂时去掉，否则qd的结果图片显示错误
//					String annex_image=ra.getParameter("annex_image");
//					if(annex_image!=null&&!"".equals(annex_image))
//						annex_image=ra.getParameter("annex_image").replace("../", FilePath.getServerUrl()+"/");
					NameValuePair  annex_image1= new NameValuePair("annex_image", annex_image);
					String annex_file=ra.getParameter("annex_file");
//					if(annex_file!=null&&!"".equals(annex_file))
//						annex_file=FilePath.getServerUrl()+annex_file;
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
					NameValuePair  checkgrade= new NameValuePair("checkgrade", ra.getParameter("health_savegrade"));//安全检查等级
					NameValuePair  checkstate= new NameValuePair("checkstate2", "1");//检查的状态，是否检查
					NameValuePair [] pair1 = new NameValuePair[]{bid,checkstate,checkgrade};
					post1.setRequestBody(pair1);
					int status1 = client.executeMethod(post1);
					post1.releaseConnection();
			}
			sc.commitTransaction();			
			success=1;
		}catch (Exception e) {
			success=0;
			sc.getCurrentConnection().rollback();
			throw e;
		}finally{
			sc.endTransaction();
		}
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":"+success+"}");
	}

}
