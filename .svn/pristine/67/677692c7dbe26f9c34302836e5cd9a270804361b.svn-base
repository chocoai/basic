package com.originsys.auth.action;


import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.util.CacheUtil;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.eap.iservice.IData;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
/**
 * @author   Email: 
 * @version 1.0 创建时间： 
 * 类说明： 删除企业类型属性
 * 删除公司信息
 */
public class OrgcomDelete extends BaseAction implements IData {

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
				String organ_id = ra.getParameter("organ_id");	
				//获取ibatis执行
				SqlMapClient sc=DataSource.getSqlMapInstance();
				//获取值
				int success=0;
				try{
					sc.startTransaction();
					//删除用户和公司的对应
					sc.delete("Auth.deleteQyOrgcomMemberByOrganid",organ_id);
					//删除公司和公司类型的对应
					sc.delete("Auth.deleteOrgcomtypeOrgcom",organ_id);
					//删除公司的信息
					sc.delete("Auth.deleteOrgcom",organ_id);
					//清除缓存
					CacheUtil.dataCache().remove("orgcom_"+organ_id);
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