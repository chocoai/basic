package com.originsys.authclient.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.MemberRole;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.service.UserService;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.eap.util.UtilString;

/**
 * @author boy Email:wangbaoaiboy@163.com
 * @version 1.0 创建时间：2010-6-9
 * 类说明：
 */
public class MemberRoleChangeState extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		String success="0";
		//获得角色编号
		String role_id=ra.getParameter("role_id");
		//获得用户编号
		String mem_id=ra.getParameter("mem_id");	
		String mem_state=ra.getParameter("mem_state");
		if(role_id!=null&&!"".equals(role_id)&&mem_id!=null&&!"".equals(mem_id)){			
			SqlMapClient sc=DataSource.getSqlMapInstance();
			try{
				sc.startTransaction();
				sc.startBatch();
				String[] memids=UtilString.split(mem_id,"|");
				MemberRole mr=new MemberRole();
				mr.setRole_id(role_id);
				mr.setRole_state(mem_state);
				String des=ra.getParameter("application_record");
				if(des==null)des="";
				mr.setApplication_description(des);
				//申请记录
				String admin_name=ra.getUser().getMem_id();
				SimpleDateFormat   sdf  =  new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
				String date=sdf.format(new Date());
				String record="#修改角色状态-管理员:"+admin_name+"-"+date;
				mr.setApplication_record(record);
				mr.setConfirmed_time(new Date());
				mr.setApplication_review(ra.getUser().getMem_id());
				for(int i=0;i<memids.length;i++){
					mr.setMem_id(memids[i]);
					log().info("memid="+memids[i]+"  mem_state="+mem_state+"  role_id="+role_id);
					sc.update("Role.updateMemberRoleState",mr);
					//清空缓存
					UserService.getInstance().clearCache(memids[i]);
				}				
				sc.executeBatch();
				sc.commitTransaction();
				success="1";
			}catch(Exception e){
				success="0";
				throw e;
			}finally{
				sc.endTransaction();
			}			
		}
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":\""+success+"\"}");
	}
}
