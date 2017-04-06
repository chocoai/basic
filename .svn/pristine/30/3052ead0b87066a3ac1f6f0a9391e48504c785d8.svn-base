package com.originsys.auth.Service;

import net.sf.ehcache.Element;

import org.apache.log4j.Logger;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.OrgcomRole;
import com.originsys.auth.domain.RoleRegister;
import com.originsys.eap.domain.Role;
import com.originsys.eap.util.CacheUtil;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.UUIDshort;

/**
 auth:boy 2013-7-11
   描述：注册站的角色服务类
 */
public class AuthRoleService {
	static class SingletonHolder {
		static AuthRoleService instance = new AuthRoleService();
	}

	public static AuthRoleService getInstance() {
		return SingletonHolder.instance;
	}

	static Logger logger = Logger.getLogger(AuthRoleService.class.getName());
	
	/**根据角色注册id返回角色对象*/
	public RoleRegister getRoleRegister(String reg_id) throws Exception{
		RoleRegister role_reg=null;
		if (CacheUtil.dataCache().get(reg_id)!=null){
			role_reg=(RoleRegister)CacheUtil.dataCache().get(reg_id).getValue();
		}else{
			synchronized (this) {
				if (CacheUtil.dataCache().get(reg_id)!=null){
					role_reg=(RoleRegister)CacheUtil.dataCache().get(reg_id).getValue();
					return role_reg;
				}
				SqlMapClient sc = DataSource.getSqlMapInstance();
				role_reg=(RoleRegister)sc.queryForObject("Auth.getRoleRegister", reg_id);
				if(role_reg!=null)
					CacheUtil.dataCache().put(new Element(reg_id,role_reg));
			}
		}
		return role_reg;
	}
	
	/**从企业站同步角色信息到注册站*/
	public void addRole(Role role,String site_id) throws Exception {
		/**增加角色信息*/
		RoleRegister rolereg=new RoleRegister();
	
		rolereg.setRole_id(role.getRole_id());
		rolereg.setRole_name(role.getRole_name());
		rolereg.setSite_id(site_id);
		rolereg.setRole_description(role.getRole_description());
		rolereg.setIscheck(role.getIscheck());
		rolereg.setPreposition_role(role.getPrepositive_role());
		rolereg.setCheck_url("");
		/**增加机构和角色的对应信息*/
		OrgcomRole orgcomrole=new OrgcomRole();
		
		orgcomrole.setRoleid(role.getRole_id());
		orgcomrole.setSite_id(site_id);
		orgcomrole.setOrgan_type_id(role.getOrgan_type_id());
		orgcomrole.setRole_organ_type_state("1");
		SqlMapClient sc = DataSource.getSqlMapInstance();
		try{
			sc.startTransaction();
			//如果原来存在则修改
			RoleRegister temp=(RoleRegister)sc.queryForObject("Auth.getRoleBy2", rolereg);
			if(temp!=null){
				rolereg.setRole_register_id(temp.getRole_register_id());
				sc.update("Auth.updateRoleRegister", rolereg);
				orgcomrole.setRole_register_id(temp.getRole_register_id());
				/**判断角色和企业对应是否存在*/
				OrgcomRole orgrole=(OrgcomRole)sc.queryForObject("Auth.getOrgcomRole2",orgcomrole);
				if(orgrole==null){
					sc.insert("Auth.addOrgcomRole",orgcomrole);
				}
			}else{
				String key=UUIDshort.get();
				rolereg.setRole_register_id(key);
				orgcomrole.setRole_register_id(key);
				sc.insert("Auth.addRoleRegister",rolereg);
				sc.insert("Auth.addOrgcomRole",orgcomrole);
			}			
			sc.commitTransaction();
		}catch(Exception e){
			throw e;
		}finally{
			sc.endTransaction();
		}
	}
		
	public RoleRegister getRoleRegisterBy(String role_id,String site_id) throws Exception{
		SqlMapClient sc = DataSource.getSqlMapInstance();
		RoleRegister term=new RoleRegister();
		term.setRole_id(role_id);
		term.setSite_id(site_id);
		RoleRegister role_reg=(RoleRegister)sc.queryForObject("Auth.getRoleRegBy2", term);
		return role_reg;
	}
}
