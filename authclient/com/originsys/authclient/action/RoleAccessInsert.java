package com.originsys.authclient.action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.ModuleType;
import com.originsys.eap.domain.RoleAccess;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.CacheUtil;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

import freemarker.template.utility.StringUtil;

/**
 * @author boy Email:wangbaoaiboy@163.com
 * @version 1.0 创建时间：2010-6-10
 * 类说明：角色对应权限增加新的栏目或是组件
 */
public class RoleAccessInsert extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		int success = 0;
		SqlMapClient sc=DataSource.getSqlMapInstance();		
		String role_id=ra.getParameter("role_id");
		if(role_id!=null&& !"".equals(role_id)){
			try{
				sc.startTransaction();
				sc.startBatch();
				//获得栏目号
				String[] blockids=ra.getParameterValues("block_id");
				if(blockids!=null){
					for(int i=0;i<blockids.length;i++){
						String blockidstr=blockids[i];
						String str[]=StringUtil.split(blockidstr, '#');
						String blockid=str[0];
						String comid=str[1];
						RoleAccess temp=new RoleAccess();
						temp.setRole_id(role_id);
//						log().info("...................comid="+comid+".."+blockid+"..."+comid.equals(blockid));
						if(blockid.equals("0")){
							temp.setModule_type(ModuleType.COMPONENT);
							temp.setModule_id(comid);
						}
						else{
							temp.setModule_type(ModuleType.BLOCK);
							temp.setModule_id(blockid);
						}
						temp.setComponent_id(comid);
						String functiongroups[]=ra.getParameterValues(blockid+"_"+comid+"_fg");
						if(functiongroups!=null){
							for(int x=0;x<functiongroups.length;x++){							
								String group_id=functiongroups[x];
								if(group_id!=null){
									temp.setGroup_id(group_id);
									//增加一条记录
									sc.insert("FunctionGroup.insertAccess",temp);
								}
							}
						}
					}
				}
				sc.executeBatch();
				sc.commitTransaction();
				success = 1;
			}catch(Exception e){
				success = 0;
				throw e;
			}finally{
				sc.endTransaction();
			}
			//清除权限缓存
			CacheUtil.accessCache().remove(role_id);
			response.setContentType("text/plain");
			PrintWriter out = response.getWriter();
			out.print("{\"success\":" + success + "}");
		}else{
			throw new Exception("The parameters \"role_id\" is empty, we must select a record");
		}
	}

}
