package com.originsys.auth.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.GetMD5;
import com.originsys.eap.util.RequestAction;
import com.originsys.eap.util.UtilString;

/**
 auth:boy 2013-8-27
   描述:重置工作人员密码
 */
public class WorkerResetPass extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		int success=0;
		Map<String,String> temp=new HashMap<String,String>();
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		try{
			sc.startTransaction();
			String role_id=ra.getParameter("role_id");
			if(role_id!=null&&!"".equals(role_id)){
				//修改评委会中所有专家的密码,先查询评委会中的专家的用户id
				Map<String,String> term=new HashMap<String,String>();
				term.put("role_id", role_id);
				term.put("organ_id",ra.getUser().getOrgcom_id());
				List<String> mlist=sc.queryForList("Auth.getWorkerMemids", term);
				if(mlist!=null){
					for(String mem_id:mlist){
						int ipass=(int)Math.round(Math.random()*89999999+10000000);//随机生成一个密码存到用户信息表中
						String pass=ipass+"";
						temp.put("mem_id", mem_id);
						temp.put("mem_pass", GetMD5.getMd5(pass));
						temp.put("secret", pass);
						sc.update("Auth.resetExpertPass1", temp);
						sc.update("Auth.resetExpertPass2",temp);
					}
				}
				
			}else{
				String memid=ra.getParameter("mem_id");
				if(memid!=null){
					//修改指定用户的密码
					String[] mids=UtilString.split(memid, "|");
					for(String mem_id:mids){
						int ipass=(int)Math.round(Math.random()*89999999+10000000);//随机生成一个密码存到用户信息表中
						String pass=ipass+"";
						temp.put("mem_id", mem_id);
						temp.put("mem_pass", GetMD5.getMd5(pass));
						temp.put("secret", pass);
						sc.update("Auth.resetExpertPass1", temp);
						sc.update("Auth.resetExpertPass2",temp);
					}
				}
			}
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
