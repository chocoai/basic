package com.originsys.datacenter.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.datacenter.domain.YcDatacenterResources;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-3-13
   描述：修改资源的状态
 */
public class ResourcesChangeState extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		/**服务编号*/
		String resources_id=ra.getParameter("resource_id");
		/**服务状态*/
		String resource_state=ra.getParameter("resource_state");
		YcDatacenterResources resource=new YcDatacenterResources();
		resource.setResources_id(resources_id);
		resource.setResources_state(resource_state);
		SqlMapClient sc=DataSource.getSqlMapInstance();
		String success="0";
		try{
			sc.update("datacenter.changeResourcesState", resource);
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
