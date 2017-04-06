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
   描述：楼幢健康等级pop窗口（超级管理员）
 */
public class BuildingSafePop1 extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		JSONObject obj = new JSONObject();
		String pcgrade="检查健康等级:<br/>";
		String jdgrade="鉴定健康等级:<br/>";
		try{
			List HealthGradePc=(List)sc.queryForList("Safecheck.getHealthGradePc");
			List HealthGradeJd=(List)sc.queryForList("Safecheck.getHealthGradeJd");
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
