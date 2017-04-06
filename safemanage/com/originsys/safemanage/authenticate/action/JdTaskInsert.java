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
import com.originsys.eap.util.FileReaderUtil;
import com.originsys.eap.util.RequestAction;
import com.originsys.eap.util.UUIDshort;
import com.originsys.safemanage.domain.TAppraisalTask;
import com.originsys.safemanage.domain.TBuilding;
import com.originsys.safemanage.domain.TBuildingSafe;

/**
 auth:zhanglf 2014-8-8
   描述：检查结果生成鉴定任务单
 */
public class JdTaskInsert  extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		StringBuffer opcontent=new StringBuffer();
		opcontent.append("楼幢编号："+ra.getParameter("building_id")+";楼幢坐落："+ra.getParameter("building_address")+";");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String  building_id = ra.getParameter("building_id");
		String info_id=ra.getParameter("info_id");
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		int num = (Integer)sc.queryForObject("safeauth.getTAppraisalTaskCount1", building_id);
		int success=0;
		if(num>0){
			success=2;//存在，已经生成任务单
		}else{
			/**楼幢基本信息*/
			TBuilding building=(TBuilding)sc.queryForObject("Safecheck.getTBuilding",building_id);
			/**检查结果信息*/
			TBuildingSafe buildingsafe=(TBuildingSafe)sc.queryForObject("Safecheck.getTBuildingSafe",info_id);
			TAppraisalTask tAppraisalTask=new TAppraisalTask();
			String key=UUIDshort.get();
			tAppraisalTask.setJdtask_id(key);//String:鉴定任务编号主键
			tAppraisalTask.setBuilding_id(ra.getParameter("building_id"));//String:楼幢编号
			tAppraisalTask.setBuilding_address(building.getBuilding_address());//String:楼幢地址
			tAppraisalTask.setBuilding_newaddress(building.getCheck_address());//String:楼幢新地址
			tAppraisalTask.setBuilding_region(building.getBuiliding_region());//String:所属区域
			tAppraisalTask.setManagement_unit(building.getManagement_unit());//String:经营单位
			tAppraisalTask.setOwner(building.getOwner());//String:产权单位
			tAppraisalTask.setBuilding_date(building.getBuilding_date());//String:联系电话
			if("check".equals(ra.getParameter("op"))){
				tAppraisalTask.setData_origin("安全检查");//String:数据来源
				opcontent.append("数据来源：安全检查;");
			}
			
			tAppraisalTask.setSafe_grade(building.getHealth_grade_pc());//String:安全情况@1-a级&2-b级&3-c级&4-d级
			opcontent.append("安全情况："+building.getHealth_grade_pc()+";");
			tAppraisalTask.setAgent(buildingsafe.getCheck_user());//String:经办人、委托人
			tAppraisalTask.setAdd_time(new Date());//新增时间
			tAppraisalTask.setInfo_state("8");
			try{
				sc.insert("safeauth.addTAppraisalTask",tAppraisalTask);
				//修改日志
				ra.operate.setOperateModule("增加鉴定任务信息：楼幢编号"+ra.getParameter("building_id"));
				ra.operate.setOperateContent(opcontent.toString());
				ra.operate.setOperateType("增加");
				success=1;
			}catch (Exception e) {
				success=0;
				throw e;
			}
		}
		
		
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":"+success+"}");
	}

}
