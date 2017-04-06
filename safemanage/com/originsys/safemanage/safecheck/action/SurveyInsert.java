package com.originsys.safemanage.safecheck.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.FileReaderUtil;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.TBuilding;
import com.originsys.safemanage.domain.TBuildingSurvey;

/**
 auth:zhanglf 2014-5-27
   描述：楼幢普查结果保存，修改基本信息表，修改普查表
 */
public class SurveyInsert extends BaseAction implements IData{

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
		/**楼幢基本信息*/
		TBuilding tBuilding=new TBuilding();
		tBuilding.setBuilding_id(building_id);//Integer:楼幢编号图斑编号sm_id
		tBuilding.setHealth_grade_pc(ra.getParameter("building_safecondition"));//String:健康等级-普查@1-a级&2-b级&3-c级&4-d级
		tBuilding.setDangerous_type_pc(ra.getParameter("building_safecondition"));//String:危房类型-普查 无危险点房屋1 存在危险点2 局部危险3 整幢危险4
		
		StringBuffer opcontent=new StringBuffer();
		opcontent.append("楼幢编号："+building_id+";楼幢坐落："+ra.getParameter("building_address")+";");
		if("1".equals(ra.getParameter("issame")))
			opcontent.append("普查新坐落："+ra.getParameter("building_newaddress")+";");
		
		/**楼幢普查结果信息*/
		TBuildingSurvey tBuildingSurvey=new TBuildingSurvey();
		tBuildingSurvey.setBuilding_id(ra.getParameter("building_id"));//Integer:楼幢编号-图斑编号
		tBuildingSurvey.setSurvey_id(survey_id);
		tBuildingSurvey.setBuilding_holder(ra.getParameter("building_holder"));
		tBuildingSurvey.setBuilding_manager_name(ra.getParameter("building_manager_name"));
		tBuildingSurvey.setBuilding_manager_phone(ra.getParameter("building_manager_phone"));
		tBuildingSurvey.setBuilding_material(ra.getParameter("building_material"));
		tBuildingSurvey.setManage_type(ra.getParameter("manage_type"));
		tBuildingSurvey.setBuild_dept(ra.getParameter("build_dept"));
		tBuildingSurvey.setDesign_dept(ra.getParameter("design_dept"));
		tBuildingSurvey.setConstruct_dept(ra.getParameter("construct_dept"));
		tBuildingSurvey.setBuilding_properties(ra.getParameter("building_properties"));
		tBuildingSurvey.setLocal_survey(ra.getParameter("local_survey"));
		tBuildingSurvey.setBuilding_safecondition(ra.getParameter("building_safecondition"));
		tBuildingSurvey.setManager_name(ra.getParameter("manager_name"));
		tBuildingSurvey.setSurvey_name(ra.getParameter("survey_name"));
		tBuildingSurvey.setLast_editor(ra.getUser().getFullname());//String：最后编辑人
		if(ra.getParameter("survey_date")!=null && !"".equals(ra.getParameter("survey_date"))){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			tBuildingSurvey.setSurvey_date(sdf.parse(ra.getParameter("survey_date")));//排查时间
		}
		if("zc".equals(ra.getParameter("op")))
			tBuildingSurvey.setInfo_state("0");//String:暂存 0   未审核1    审核驳回2     审核通过8 
		else{
			tBuildingSurvey.setInfo_state("1");//String:暂存 0   未审核1    审核驳回2     审核通过8 
		}
		tBuildingSurvey.setBuilding_address(ra.getParameter("building_address"));//String:楼幢坐落
		tBuildingSurvey.setBuilding_region(ra.getParameter("building_region"));//String:所属区域
		if(ra.getParameter("house_count")!=null && !"".equals(ra.getParameter("house_count"))){
			tBuildingSurvey.setHouse_count(Integer.parseInt(ra.getParameter("house_count")));//Integer:户数
			opcontent.append("房屋套数："+ra.getParameter("house_count")+";");
		}
		if(ra.getParameter("floorup_count")!=null && !"".equals(ra.getParameter("floorup_count"))){
			tBuildingSurvey.setFloorup_count(Integer.parseInt(ra.getParameter("floorup_count")));//Integer:地上层数
			opcontent.append("地上层数："+ra.getParameter("floorup_count")+";");
		}
		if(ra.getParameter("floordown_count")!=null && !"".equals(ra.getParameter("floordown_count"))){
			tBuildingSurvey.setFloordown_count(Integer.parseInt(ra.getParameter("floordown_count")));//Integer:地下层数
			opcontent.append("地下层数："+ra.getParameter("floordown_count")+";");
		}
		if(ra.getParameter("build_area")!=null && !"".equals(ra.getParameter("build_area"))){
			tBuildingSurvey.setBuild_area(Float.parseFloat(ra.getParameter("build_area")));//Float:建筑面积
			opcontent.append("建筑面积："+ra.getParameter("build_area")+";");
		}
		tBuildingSurvey.setUse_desgin(ra.getParameter("use_desgin"));//String:设计用途
		if(ra.getParameter("building_date")!=null && !"".equals(ra.getParameter("building_date"))){
			tBuildingSurvey.setBuilding_date(Integer.parseInt(ra.getParameter("building_date")));//Integer:建成时间
		}
		tBuildingSurvey.setBuild_struct(ra.getParameter("build_struct"));//String:结构类型
		tBuildingSurvey.setUpon_type(ra.getParameter("upon_type"));//String:楼盖类型@1-现浇板&2-预制板&3-现浇、预制板混用&4-木楼板&5-其它
		tBuildingSurvey.setWm_type(ra.getParameter("wm_type"));//String:屋面类型@1-预制板平屋面&2-现浇板平屋面&3-现浇板坡屋面&4-有檩系坡屋面&5-其它
		tBuildingSurvey.setAnnex(ra.getParameter("annex"));
		tBuildingSurvey.setAnnex_pic(ra.getParameter("annex_pic"));
		tBuildingSurvey.setBuilding_newaddress(ra.getParameter("building_newaddress"));//普查新地址
		tBuildingSurvey.setIssame(ra.getParameter("issame"));//是否一致@0-否&1-是
		
		int success=0;
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		
		try{
			sc.startTransaction();
			sc.update("Safecheck.updateTBuilding",tBuilding);
		  if(null!=ra.getParameter("survey_id") && !"".equals(ra.getParameter("survey_id"))){
			  //int num = (Integer)sc.queryForObject("Safecheck.getSurveyCount", ra.getParameter("building_id"));
			 // if(num>0){//存在，执行update
				sc.update("Safecheck.updateTBuildingSurvey",tBuildingSurvey);
				//修改日志
				ra.operate.setOperateModule("修改普查信息：普查编号"+survey_id);
				ra.operate.setOperateContent(opcontent.toString());
				ra.operate.setOperateType("修改");
			// }
		   }else{//不存在，执行insert
				tBuildingSurvey.setReport_userid(ra.getUser().getMem_id());//String:信息填写人
				sc.insert("Safecheck.addTBuildingSurvey", tBuildingSurvey);
				//修改日志
				ra.operate.setOperateModule("增加普查信息：楼幢编号"+building_id);
				ra.operate.setOperateContent(opcontent.toString());
				ra.operate.setOperateType("增加");
		   }
			/**调用接口，修改普查状态*/
			HttpClient client = new HttpClient();
			//读取属性文件 
			ResourceBundle rb=FileReaderUtil.getInstance().getResourceBundle("safecheck");
			String hbase_url=rb.getString("hbase_url");
			PostMethod post0 = new PostMethod(hbase_url+"/portal/realtygis.updatesafedate");
			/**设置编码格式*/
			post0.getParams().setContentCharset("utf-8");
			/**组织传入的参数*/
			NameValuePair  bid= new NameValuePair("building_id", ra.getParameter("building_id"));
			NameValuePair  checkstate= new NameValuePair("checkstate", "1");//检查的状态，是否检查
			NameValuePair [] pair = new NameValuePair[]{bid,checkstate};
			post0.setRequestBody(pair);
			int status = client.executeMethod(post0);
			post0.releaseConnection();
			
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
