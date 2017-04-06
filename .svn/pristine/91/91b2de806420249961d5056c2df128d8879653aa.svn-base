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
import com.originsys.safemanage.domain.TAppraisalTask;

/**
 auth:boy 2014-9-19
   描述：鉴定任务单受理，状态改成9，不显示在鉴定任务单的列表中
 */
public class JdTaskAccept extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		String info_id=ra.getParameter("info_id");
		int success=0;
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		TAppraisalTask tAppraisalTask=new TAppraisalTask();
		tAppraisalTask.setJdtask_id(info_id);
		tAppraisalTask.setInfo_state("9");
		try{
			sc.update("safeauth.updateTAppraisalTask",tAppraisalTask);
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
