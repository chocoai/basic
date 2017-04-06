package com.originsys.datacenter.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-3-13
   描述：删除服务
 */
public class ServiceDelete  extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		String key=ra.getParameter("service_id");
		String success="0";
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		try{
			sc.startTransaction();	
			sc.delete("datacenter.deleteServiceParam", key);
			sc.delete("datacenter.deleteService", key);
			sc.commitTransaction();
			success="1";
		}catch (Exception e) {
			success="0";
			throw e;
		}finally{
			sc.getCurrentConnection().rollback();
			sc.endTransaction();
		}
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":\""+success+"\",\"key\":\""+key+"\"}");
	}


}
