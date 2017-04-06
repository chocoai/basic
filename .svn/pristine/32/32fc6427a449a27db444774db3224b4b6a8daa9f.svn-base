package com.originsys.datacenter.action;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.datacenter.domain.YcDatacenterServiceRegister;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-3-13
   描述：服务修改状态
 */
public class ServiceChangeState extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		/**服务编号*/
		String service_id=ra.getParameter("service_id");
		/**服务状态*/
		String service_state=ra.getParameter("service_state");
		YcDatacenterServiceRegister reg=new YcDatacenterServiceRegister();
		reg.setService_id(service_id);
		reg.setService_state(service_state);
		reg.setCheckor(ra.getUser().getMem_id());
		reg.setCheck_date(new Date());
		SqlMapClient sc=DataSource.getSqlMapInstance();
		String success="0";
		try{
			sc.update("datacenter.changeServiceState", reg);
			success="1";
		}catch(Exception e){
			success="0";
			throw e;
		}
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":\""+success+"\"}");
	}

}
