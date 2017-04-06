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
 auth:zhanglf 2014-5-30
   描述：楼幢普查审核
 */
public class SurveyCheck extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		/**楼幢编号*/
		String building_id="";
		if(ra.getParameter("building_id")!=null && !"".equals(ra.getParameter("building_id"))){
			building_id=ra.getParameter("building_id");
		}
		String survey_id="";
		if(ra.getParameter("survey_id")!=null && !"".equals(ra.getParameter("survey_id"))){
			survey_id=ra.getParameter("survey_id");
		}		
		/**楼幢普查结果信息*/
		TBuildingSurvey tBuildingSurvey=new TBuildingSurvey();
		tBuildingSurvey.setBuilding_id(ra.getParameter("building_id"));//Integer:楼幢编号-图斑编号
		tBuildingSurvey.setSurvey_id(survey_id);
		tBuildingSurvey.setCheck_date(new java.util.Date());
		tBuildingSurvey.setCheck_message(ra.getParameter("building_check_log"));
		tBuildingSurvey.setCheck_userid(ra.getUser().getMem_id());
		tBuildingSurvey.setInfo_state(ra.getParameter("building_isOpen"));//String:暂存 0   未审核1    审核驳回2     审核通过8
		TBuilding tbuilding=new TBuilding();
		tbuilding.setBuilding_id(building_id);
		
		StringBuffer opcontent=new StringBuffer();
		opcontent.append("楼幢编号："+building_id+";楼幢坐落："+ra.getParameter("building_address")+";");
		opcontent.append("审核状态："+ra.getParameter("building_isOpen")+";审核意见："+ra.getParameter("building_check_log")+";");
		
		int success=0;
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		
		try{
			TBuilding building=(TBuilding)sc.queryForObject("Safecheck.getTBuilding",building_id);
			if(null==building.getBuilding_address()||"".equals(building.getBuilding_address())){
				tbuilding.setBuilding_address(ra.getParameter("building_address"));
			}
			if(null==building.getBuiliding_region()||"".equals(building.getBuiliding_region())){
				tbuilding.setBuiliding_region(ra.getParameter("builiding_region"));
			}
			
			sc.startTransaction();
			sc.update("Safecheck.updateTBuildingSurvey",tBuildingSurvey);
			//修改日志
			ra.operate.setOperateModule("审核普查信息：楼幢编号"+building_id);
			ra.operate.setOperateContent(opcontent.toString());
			ra.operate.setOperateType("审核");
			
			if("8".equals(ra.getParameter("building_isOpen"))){
				if(ra.getParameter("builiding_region")!=null&&!"".equals(ra.getParameter("builiding_region"))
						&&ra.getParameter("building_address")!=null&&!"".equals(ra.getParameter("building_address")))
					sc.update("Safecheck.updateTBuilding",tbuilding);
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
				NameValuePair  op= new NameValuePair("op", "14年老楼危楼安全排查");
				NameValuePair  opdate= new NameValuePair("opdate", ra.getParameter("survey_date"));
				NameValuePair  opresult= new NameValuePair("opresult", ra.getParameter("safelevel"));
				String annex_image=ra.getParameter("annex_image");
//				if(annex_image!=null&&!"".equals(annex_image))
//					annex_image=ra.getParameter("annex_image").replace("../", FilePath.getServerUrl()+"/");
				NameValuePair  annex_image1= new NameValuePair("annex_image", annex_image);
				String annex_file=ra.getParameter("annex_file");
//				if(annex_file!=null&&!"".equals(annex_file))
//					annex_file=FilePath.getServerUrl()+annex_file;
				NameValuePair  annex_file1= new NameValuePair("annex_file", annex_file);
				String bsafe=ra.getParameter("safelevel");
				NameValuePair optype=null;
				if(bsafe.equals("1")){
					optype= new NameValuePair("optype", "无危险点房屋");
				}else if (bsafe.equals("2")){
					optype= new NameValuePair("optype", "存在危险点房屋");
				}else if (bsafe.equals("3")){
					optype= new NameValuePair("optype", "局部危险房屋");
				}else if (bsafe.equals("4")){
					optype= new NameValuePair("optype", "整幢危险房屋");
				}else{
					optype= new NameValuePair("optype", "");
				}
				NameValuePair [] pair = new NameValuePair[]{bid,op,opdate,opresult,optype,annex_image1,annex_file1};
				post0.setRequestBody(pair);
				int status = client.executeMethod(post0);
				post0.releaseConnection();
				
				/**调用12的接口写入到空间库中*/
				PostMethod post1 = new PostMethod(hbase_url+"/portal/realtygis.updatesafedate");
				/**设置编码格式*/
				post1.getParams().setContentCharset("utf-8");
				/**组织传入的参数*/
				NameValuePair  safegrade= new NameValuePair("safegrade", ra.getParameter("safelevel"));//安全普查的等级
				NameValuePair  checkstate= new NameValuePair("checkstate", "1");//检查的状态，是否检查
				NameValuePair [] pair1 = new NameValuePair[]{bid,safegrade,checkstate};
				post1.setRequestBody(pair1);
				int status1 = client.executeMethod(post1);
				post1.releaseConnection();
				
			}
			sc.commitTransaction();			
			success=1;
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
