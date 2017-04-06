package com.originsys.auth.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.OrgcomMember;
import com.originsys.eap.util.DataSource;

/**
 auth:boy 2013-7-10
   描述：用户机构对应的服务类
 */
public class OrgancomMemberService {
	static class SingletonHolder {
		static OrgancomMemberService instance = new OrgancomMemberService();
	}

	public static OrgancomMemberService getInstance() {
		return SingletonHolder.instance;
	}

	static Logger logger = Logger.getLogger(OrgancomMemberService.class.getName());
	
	/**加入机构
	 * @param String mem_id 用户编号
	 * @param String organ_id 组织编号*/
	public void joinOrgancom(String mem_id,String organ_id) throws Exception {
		/**增加企业用户的对应关系*/
		OrgcomMember orgcomMember=new OrgcomMember();		
		orgcomMember.setMem_id(mem_id);//String:用户id
		orgcomMember.setOrgan_id(organ_id);//String:企业id
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		orgcomMember.setJoin_in_time(sdf.parse(sdf.format(new Date())));//Date:入职时间
		orgcomMember.setNote("");//String:备注
		orgcomMember.setState("0");//String:状态
		orgcomMember.setIs_manager("0");//String:是否管理员
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		sc.insert("Auth.addOrgcomMember",orgcomMember);	
	}
	
	/**加入机构
	 * @param String mem_id 用户编号
	 * @param String organ_code 组织代码
	 * @return String organ_id 组织编号*/
	public String joinOrgancom1(String mem_id,String organ_code) throws Exception {
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		/**根据机构代码查询机构编号*/
		String organ_id=(String)sc.queryForObject("Auth.getOrganid", organ_code);
		/**查询机构编号查询用户是否在这个组织里，如果没有，增加用户和组织的对应关系*/
		Map<String,String> map=new HashMap<String,String>();
		map.put("mem_id",mem_id);
		map.put("organ_id",organ_id);
		Integer num=(Integer)sc.queryForObject("Auth.getMemberOrgCount", map);
		if(organ_id!=null&&!"".equals(organ_id)&&num==0){
			joinOrgancom(mem_id,organ_id);
		}	
		return organ_id;
	}
	
	
	/**审核员工*/
	public void checkOrgancom(String mem_id,String organ_id) throws Exception {
		OrgcomMember orgcomMember=new OrgcomMember();		
		orgcomMember.setMem_id(mem_id);//String:用户id
		orgcomMember.setOrgan_id(organ_id);//String:企业id
		orgcomMember.setState("1");//String:状态
		SqlMapClient sc=DataSource.getSqlMapInstance();
		sc.update("Auth.updateOrgcomMember", orgcomMember);
	}
	
}
