package com.originsys.auth.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.YcEadminProperty;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-7-1
   描述：企业管理员属性修改
 */
public class EadminPropertyUpdate extends BaseAction implements IData {

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		String mem_id=ra.getParameter("mem_id");
		String current_organ=ra.getParameter("current_organ");
		if(current_organ==null)current_organ="";
		String[] organids=ra.getParameterValues("organ_id");
		String organ_id="";
		if(organids!=null){
			for(String oid:organids){
				organ_id+=" "+oid+",";
			}
		}
		YcEadminProperty eadmin=new YcEadminProperty();
		eadmin.setMem_id(mem_id);
		eadmin.setCurrent_organ(current_organ);
		eadmin.setOrgan_id(organ_id);
		String success="0";
		if(!"".equals(organ_id)){
			try{
				//修改用户的当前可管理企业的信息
				sc.update("Auth.updateEadmin",eadmin);
				success="1";
			}catch (Exception e) {
				success="0";
				throw e;
			}
		}
		
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":\""+success+"\"}");
	}

}
