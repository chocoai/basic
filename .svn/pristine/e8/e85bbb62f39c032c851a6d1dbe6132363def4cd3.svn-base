package com.originsys.safemanage.safecheck.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.eap.util.UUIDshort;
import com.originsys.safemanage.domain.TBuilding;
import com.originsys.safemanage.domain.TBuildingCtrack;

/**
 auth:boy 2014-5-13
   描述：隐患楼幢安全检查录入
 */
public class BuildingCtrackInsert_delete  extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		/**楼幢编号*/
		String building_id="";
		if(ra.getParameter("building_id")!=null && !"".equals(ra.getParameter("building_id"))){
			building_id=ra.getParameter("building_id");
		}
		/**楼幢基本信息*/
		TBuilding tBuilding=new TBuilding();
		tBuilding.setBuilding_id(building_id);//Integer:楼幢编号图斑编号sm_id
		/**楼幢普查结果信息*/
		TBuildingCtrack tBuildingSafe=new TBuildingCtrack();
		tBuildingSafe.setInfo_id(UUIDshort.get());
		tBuildingSafe.setBuilding_id(building_id);//Integer:楼幢编号-图斑编号
		tBuildingSafe.setDt_tdesc(ra.getParameter("dt_tdesc"));//String:电梯、楼梯备注
		tBuildingSafe.setStruct_desc(ra.getParameter("struct_desc"));//String:装饰装修备注
		tBuildingSafe.setBz_desc(ra.getParameter("bz_desc"));//String:基本信息备注
		tBuildingSafe.setDere_desc(ra.getParameter("dere_desc"));//String:上下部结构形式备注
		if(ra.getParameter("check_time")!=null && !"".equals(ra.getParameter("check_time"))){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			tBuildingSafe.setCheck_time(sdf.parse(ra.getParameter("check_time")));//Date:检查时间
		}
		tBuildingSafe.setCheck_user(ra.getParameter("check_user"));//String:检查人姓名可能多个
		tBuildingSafe.setCheck_userid(ra.getUser().getMem_id());//String:信息填写人
		if("zc".equals(ra.getParameter("op")))
			tBuildingSafe.setInfo_state("0");//String:暂存 0 提交待审核1 审核通过8 审核驳回7
		else{
			tBuilding.setHealth_grade_pc(ra.getParameter("health_savegrade"));//String:健康等级-普查@1-a级&2-b级&3-c级&4-d级
			tBuildingSafe.setInfo_state("8");//String:暂存 0 提交待审核1 审核通过8 审核驳回7
		}
		tBuildingSafe.setStructure_grade(ra.getParameter("structure_grade"));//String:健康结构健康等级@1-a级&2-b级&3-c级&4-d级
		tBuildingSafe.setUsed_grade(ra.getParameter("used_grade"));//String:健康使用健康等级@1-a级&2-b级&3-c级&4-d级
		tBuildingSafe.setKz_grade(ra.getParameter("kz_grade"));//String:健康抗震能力@1-强&2-弱&3-差
		tBuildingSafe.setFl_grade(ra.getParameter("fl_grade"));//String:健康防雷能力@1-强&2-弱&3-差
		tBuildingSafe.setXf_grade(ra.getParameter("xf_grade"));//String:健康消防能力@1-强&2-弱&3-差
		tBuildingSafe.setOther_grade(ra.getParameter("other_grade"));//String:健康其他防灾能力@1-强&2-弱&3-差
		tBuildingSafe.setAll_grade(ra.getParameter("all_grade"));//String:健康总健康等级@1-ⅰ级（健康）&2-ⅱ级（亚健康）&3-ⅲ级（病态）&4-ⅳ（病危）
		tBuildingSafe.setHealth_savegrade(ra.getParameter("health_savegrade"));//String:健康安全等级@1-a级&2-b级&3-c级&4-d级
		tBuildingSafe.setClresult(ra.getParameter("clresult"));//String:健康处理意见@1-正常使用&2-常规维护&3-适当维修&4-采取措施&5-停止使用
		tBuildingSafe.setHealth_gradetdesc(ra.getParameter("health_gradetdesc"));//String:健康备注
		tBuildingSafe.setLose_grade(ra.getParameter("lose_grade"));//String:健康完损等级@1-完好房屋&2-基本完好&3-一般破损&4-严重破损
		tBuildingSafe.setUsefunction(ra.getParameter("usefunction"));//String:使用功能@1-住宅&2-综合楼&3-办公&4-商业&5-学校用房&6-医院用房&7-工业用房&8-其它
		tBuildingSafe.setWq_type(ra.getParameter("wq_type"));//String:外墙饰面@1-玻璃&2-石材&3-面砖&4-马赛克&5-砂浆&6-涂料&7-清水墙&8-其它
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		int success=0;
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		try{
			sc.startTransaction();
			sc.insert("Safecheck.addTBuildingCtrack",tBuildingSafe);
			if(!"zc".equals(ra.getParameter("op"))){
				sc.update("Safecheck.updateTBuilding",tBuilding);
				/**将安全结果录入到大数据中*/
				/**调用api获取数据*/
				HttpClient client = new HttpClient();
				/**设置api的地址*/
				PostMethod post0 = new PostMethod("http://192.168.0.12:8080/portal/datacenter.buildingsafeapi");
				/**设置编码格式*/
				post0.getParams().setContentCharset("utf-8");
				/**组织传入的参数*/
				NameValuePair  bid= new NameValuePair("building_id", building_id);
				NameValuePair  op= new NameValuePair("op", "跟踪检查");
				NameValuePair  opdate= new NameValuePair("opdate", sdf.format(new Date()));
				NameValuePair  opresult= new NameValuePair("opresult", ra.getParameter("health_savegrade"));
				NameValuePair  optype= new NameValuePair("optype", "整栋");
				NameValuePair [] pair = new NameValuePair[]{bid,op,opdate,opresult,optype};
				post0.setRequestBody(pair);
				int status = client.executeMethod(post0);
				post0.releaseConnection();
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
