package com.originsys.safemanage.safecheck.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.service.AccessService;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:zhanglf 2014-06-09
   描述：楼幢健康等级pop窗口（区县管理员）
 */
public class BuildingSafePop extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		JSONObject obj = new JSONObject();
		String pcgrade="检查健康等级:<br/>";
		String jdgrade="鉴定健康等级:<br/>";
		try{
			//获取当前登录用户的mem_id
			String mem_id=ra.getUser().getMem_id();
			//获取当前登录用户管理的区域
			List<String> regionList=(List<String>)sc.queryForList("Safecheck.getBuildingSafeManageRegion", mem_id);
			String builiding_region="";
			if(regionList.size()>0){
				builiding_region=regionList.get(0);//该用户有管理的区域
			}else{
				builiding_region="-1";//该用户没有管理的区域
			}
			
			List HealthGradePc=(List)sc.queryForList("Safecheck.getHealthGradePc",builiding_region);
			List HealthGradeJd=(List)sc.queryForList("Safecheck.getHealthGradeJd",builiding_region);
			int pccount=0,jdcount=0;
			List pcList=new ArrayList();
			List jdList=new ArrayList();
			for(int i=1;i<5;i++){
				Map pcMap=new HashMap();
				pcMap.put("GRADE", i);
				char grade=(char) ('A'+i-1);
				pcgrade += grade+"级楼幢共 ";
				if(pccount<HealthGradePc.size()){
					Map m1=(Map) HealthGradePc.get(pccount);
					if(m1.get("GRADE").equals(i+"")){
						if(null!=m1.get("COUNT")&&!"".equals(m1.get("COUNT"))){
							pcMap.put("COUNT", m1.get("COUNT"));
							pcgrade += m1.get("COUNT")+" 幢<br/>";
						}else{
							pcMap.put("COUNT", 0);
							pcgrade += "0 幢<br/>";
						}
						pccount++;
					}else{
						pcMap.put("COUNT", 0);
						pcgrade += "0 幢<br/>";
					}
				}else{
					pcMap.put("COUNT", 0);
					pcgrade += "0 幢<br/>";
				}
				pcList.add(pcMap);
				
				Map jdMap=new HashMap();
				jdMap.put("GRADE", i);
				jdgrade += grade+"级楼幢共 ";
				if(jdcount<HealthGradeJd.size()){
					Map m1=(Map) HealthGradeJd.get(jdcount);
					if(m1.get("GRADE").equals(i+"")){
						if(null!=m1.get("COUNT")&&!"".equals(m1.get("COUNT"))){
							jdMap.put("COUNT", m1.get("COUNT"));
							jdgrade += m1.get("COUNT")+" 幢<br/>";
						}else{
							jdMap.put("COUNT", 0);
							jdgrade += "0 幢<br/>";
						}
						jdcount++;
					}else{
						jdMap.put("COUNT", 0);
						jdgrade += "0 幢<br/>";
					}
				}else{
					jdMap.put("COUNT", 0);
					jdgrade += "0 幢<br/>";
				}
				jdList.add(jdMap);
					
			}
			//obj.put("HealthGradePc", pcList);
			//obj.put("HealthGradeJd", jdList);
			obj.put("message", pcgrade+jdgrade);
			obj.put("success", "true");
		}catch(Exception e){
			obj.put("success", "false");
			throw e;
		}finally{
			//设置返回值为文本数据,并输出
			response.setContentType("text/plain");
			PrintWriter out = response.getWriter(); 
			out.print(obj);
		}		
		
	}

}
