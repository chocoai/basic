package com.originsys.auth.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.ehcache.Element;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.Service.OrgComService;
import com.originsys.auth.domain.Orgcom;
import com.originsys.auth.domain.OrgcomType;
import com.originsys.auth.domain.OrgcomtypeOrgcom;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.MemberRole;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.CacheUtil;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2013-7-16
   描述：组织审核
 */
public class OrgcomCheck extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		String organ_id = ra.getParameter("organ_id");
		Orgcom orgcom=new Orgcom();
		orgcom.setOrgan_id(organ_id);
		String authentication_state="0";
		authentication_state=ra.getParameter("state");
		orgcom.setAuthentication_state(authentication_state);		
		SqlMapClient sc=DataSource.getSqlMapInstance();
		int success=0;		
		try{
			sc.startTransaction();//事务开始
			//审核企业的状态
			sc.update("Auth.orgcomcheck", orgcom);
			//审核企业类型的状态
			@SuppressWarnings("unchecked")
			List<OrgcomType> typelist=sc.queryForList("Auth.getOrgTypeListByOrgID1", organ_id);
			String organ_type_state="0";
			if(typelist!=null){				
				for(OrgcomType type:typelist){
					String type_state=ra.getParameter(type.getOrgan_type_id());
					OrgcomtypeOrgcom temp=new OrgcomtypeOrgcom();
					temp.setOrgan_type_id(type.getOrgan_type_id());
					temp.setOrgan_id(organ_id);
					temp.setOrgan_type_state(type_state);
					sc.update("Auth.orgcomtypecheck", temp);
					if(type.getOrgan_type_id().equals("3")){
						organ_type_state=type_state;
					}
				}
			}
			//如果审核企业状态以及企业类型状态为通过,则修改该企业的企业管理员用户角色状态为正常
			
			MemberRole memberRole=(MemberRole) sc.queryForObject("Auth.getMemberRole",organ_id);
			if("1".equals(authentication_state)&&"1".equals(organ_type_state))
			memberRole.setRole_state("1");
			else
		    memberRole.setRole_state("0");	
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			memberRole.setConfirmed_time(sdf.parse(sdf.format(new Date())));// Date:认证时间			
			sc.update("Role.updateMemberRole",memberRole);
			
			//清除缓存
			CacheUtil.dataCache().remove("orgcom_"+organ_id);
			orgcom=OrgComService.getInstance().getOrgcomByID(organ_id);
			//重新放到缓存中
			CacheUtil.dataCache().put(new Element("orgcom_"+organ_id,orgcom));
			CacheUtil.dataCache().put(new Element(orgcom.getOrgan_code(),orgcom));
			success=1;
			sc.commitTransaction();
		}catch (Exception e) {
			success=0;
			log().info(e.getMessage());
			log().info(e.getStackTrace());
			throw e;
		}finally{
			sc.endTransaction();
		}
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":"+success+"}");
	}
}
