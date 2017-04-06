package com.originsys.realtygis.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

public class MapVersionDelete extends BaseAction implements IData{
	/**
	 * 类说明：删除地图版本类
	 * @创建时间：2014-1-7
	 * @作者：洛佳明
	 */
	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		int success=0;
		SqlMapClient sc = DataSource.getSqlMapInstance();
		try{
			sc.startTransaction();
			sc.delete("Realtygis.deleteMapVersion",Long.parseLong(ra.getParameter("version_number")));
			sc.commitTransaction();
			success=1;
		}catch (Exception e) {
			e.printStackTrace();
			success=0;
		}finally{
			sc.endTransaction();
		}
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":"+success+"}");
	}
}
