package com.originsys.safemanage.usertype.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.TSafeManager;

/**
 auth:zhanglf 2014-5-20
   描述：安全管理员信息修改
   1：修改用户基本信息
   2：修改用户和机构的对应关系
   3：修改管理员基本信息
 */
public class SafeManagerUserUpdate extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		SqlMapClient sc = DataSource.getSqlMapInstance();
		String mem_id=ra.getParameter("mem_id");
		
		/**安全管理员信息*/
		TSafeManager tSafeManager=new TSafeManager();
		tSafeManager.setMem_id(mem_id);//String:用户id
		tSafeManager.setRegion(ra.getParameter("region"));//所属地区
		String success="0";
		try{
			sc.startTransaction();
			sc.update("Safecheck.updateTSafeManager",tSafeManager);
			sc.commitTransaction();
			success="1";
		}catch (Exception e) {
			success="0";
			sc.getCurrentConnection().rollback();
			throw e;
		}finally{
			sc.endTransaction();
		}
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":\""+success+"\",\"key\":\""+mem_id+"\"}");
	}

}
