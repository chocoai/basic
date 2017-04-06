package com.originsys.safemanage.authenticate.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.eap.util.UUIDshort;
import com.originsys.safemanage.domain.TAppraisalTask;
import com.originsys.safemanage.domain.TBuildingSurvey;

/**
 auth:boy 2014-9-19
   描述：普查结果生成鉴定任务单
 */
public class JdTaskInsertSurvey  extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		StringBuffer opcontent=new StringBuffer();
		opcontent.append("楼幢编号："+ra.getParameter("building_id")+";楼幢坐落："+ra.getParameter("building_address")+";");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		/**楼幢编号，普查的表中这个就是主键*/
		String  building_id = ra.getParameter("building_id");
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		int num = (Integer)sc.queryForObject("safeauth.getTAppraisalTaskCount1", building_id);
		int success=0;
		if(num>0){
			success=2;//存在，已经生成任务单
		}else{
			/**获取楼幢普查信息*/
			TBuildingSurvey building=(TBuildingSurvey)sc.queryForObject("Safecheck.getTBuildingSurvey",building_id);
			TAppraisalTask tAppraisalTask=new TAppraisalTask();
			String key=UUIDshort.get();
			tAppraisalTask.setJdtask_id(key);//String:鉴定任务编号主键
			tAppraisalTask.setBuilding_id(ra.getParameter("building_id"));//String:楼幢编号
			tAppraisalTask.setBuilding_address(building.getBuilding_address());//String:楼幢地址
			tAppraisalTask.setBuilding_newaddress(building.getBuilding_newaddress());//String:楼幢新地址
			tAppraisalTask.setBuilding_region(building.getBuilding_region());//String:所属区域
			tAppraisalTask.setManagement_unit(building.getBuilding_manager_name());//String:经营单位
			tAppraisalTask.setOwner("");//String:产权单位
			tAppraisalTask.setBuilding_date(building.getBuilding_date());//String:联系电话
			tAppraisalTask.setData_origin("安全普查");//String:数据来源
			opcontent.append("数据来源：安全普查;");
			
			tAppraisalTask.setSafe_grade(building.getBuilding_safecondition());//String:安全情况@1-a级&2-b级&3-c级&4-d级
			opcontent.append("安全情况："+building.getBuilding_safecondition()+";");
			tAppraisalTask.setAgent(building.getManager_name());//String:经办人、委托人
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
