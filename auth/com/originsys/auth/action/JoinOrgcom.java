package com.originsys.auth.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.OrgcomMember;
import com.originsys.auth.domain.UserInfo;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2013-7-10
   描述：加入公司保存
 */
public class JoinOrgcom extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		String mem_id=ra.getUser().getMem_id();//用户id的获取方式
		/**修改用户的基本信息*/
		UserInfo userInfo=new UserInfo();
		userInfo.setMem_id(mem_id);//String:用户id
		userInfo.setFamily_name(ra.getParameter("family_name"));//String:姓
		userInfo.setFirst_name(ra.getParameter("first_name"));//String:名
		userInfo.setMem_sex(ra.getParameter("mem_sex"));//String:性别
		if(ra.getParameter("mem_born")!=null && !"".equals(ra.getParameter("mem_born"))){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			userInfo.setMem_born(sdf.parse(ra.getParameter("mem_born")));//Date:生日
		}
		
		/**增加企业用户的对应关系*/
		OrgcomMember orgcomMember=new OrgcomMember();		
		orgcomMember.setMem_id(mem_id);//String:用户id
		String organ_id=ra.getParameter("organ_id");//String:企业id
		orgcomMember.setOrgan_id(organ_id);//String:企业id
		if(ra.getParameter("join_in_time")!=null && !"".equals(ra.getParameter("join_in_time"))){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			orgcomMember.setJoin_in_time(sdf.parse(ra.getParameter("join_in_time")));//Date:入职时间
		}
		orgcomMember.setNote(ra.getParameter("note"));//String:备注
		orgcomMember.setState("0");//String:状态
		orgcomMember.setIs_manager("0");//String:是否管理员
		int success=0;
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		Map param=new HashMap();
		param.put("mem_id", mem_id);
		param.put("organ_id", organ_id);
		
		try{
			int num=(Integer)sc.queryForObject("Auth.selectOrgcomMemberCount",param);
			if(num>0){
				success=2;
			}else{
				sc.update("Auth.updateUserInfo",userInfo);
				sc.insert("Auth.addOrgcomMember",orgcomMember);	
				success=1;
			}
		}catch (Exception e) {
			success=0;
			log().info(e.getMessage());
			log().info(e.getStackTrace());
			throw e;
		}
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":"+success+"}");
	}

}
