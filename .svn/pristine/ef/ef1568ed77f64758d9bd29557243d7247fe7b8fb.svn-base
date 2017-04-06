package com.originsys.auth.action;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.auth.domain.OrgcomMember;
import com.originsys.eap.iservice.IData;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
/**
 * @author   Email: 
 * @version 1.0 创建时间： 
 * 类说明： 企业管理员删除用户，删除用户和企业的对应关系
 */
public class UserInfoDelete extends BaseAction implements IData {

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		OrgcomMember orgcomMember=new OrgcomMember();
		orgcomMember.setMem_id(ra.getParameter("mem_id"));	
		orgcomMember.setOrgan_id(ra.getUser().getOrgcom_id());
				int success=0;
				try{
					sc.startTransaction();
					sc.delete("Auth.deleteOrgcomMember",orgcomMember);
					sc.commitTransaction();
					success=1;
				}catch (Exception e) {
					success=0;
					log().info(e.getMessage());
					log().info(e.getStackTrace());
					throw e;
				}finally{
					sc.getCurrentConnection().rollback();
					sc.endTransaction();
				}
				response.setContentType("text/plain");
				PrintWriter out=response.getWriter();
				out.print("{\"success\":"+success+"}");
	}
}