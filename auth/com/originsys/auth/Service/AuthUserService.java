package com.originsys.auth.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.Orgcom;
import com.originsys.auth.domain.OrgcomMember;
import com.originsys.auth.domain.UserInfo;
import com.originsys.auth.domain.UserRole;
import com.originsys.eap.control.Constants;
import com.originsys.eap.domain.User;
import com.originsys.eap.util.CacheUtil;
import com.originsys.eap.util.DataSource;


/**
 auth:boy 2013-7-14
   描述：注册站用户服务类
 */
public class AuthUserService {
	static class SingletonHolder {
		static AuthUserService instance = new AuthUserService();
	}

	public static AuthUserService getInstance() {
		return SingletonHolder.instance;
	}

	static Logger logger = Logger.getLogger(AuthUserService.class.getName());
	
	public User getUser(String userid) throws Exception {
		User user;
		if (CacheUtil.userCache().get(userid) != null) {
			user = (User) CacheUtil.userCache().get(userid).getValue();
			
		} else {
			synchronized (this) {
				if (CacheUtil.userCache().get(userid) != null) {
					user = (User) CacheUtil.userCache().get(
							String.valueOf(userid)).getValue();
					return user;
				}
				SqlMapClient sc = DataSource.getSqlMapInstance();
				UserInfo info=(UserInfo)sc.queryForObject("Auth.getUserInfo", userid);
				if(info==null)
					return null;
				user=UserInfoToUser.toUser(info);
				List<String> roleList=new ArrayList<String>();
				/**取注册站的用户角色列表*/
				/**组织查询条件对象*/
				UserRole userRole=new UserRole();
//				userRole.setSite_id(ra.getParameter("site_id"));//String:站点
				userRole.setMem_id(userid);//String:用户id
				userRole.setMem_state("1");//String:用户状态
//				userRole.setCom_id(ra.getParameter("com_id"));//String:该角色所属的企业
				//定义参数
				Map<String,Object> param=new HashMap<String,Object>();
				param.put("userRole", userRole);
				param.put("_page_start", 0);
				param.put("_page_nums", 100);//该参数是为MySQL数据库准备的
				param.put("_page_end", 100);//该参数是为Oracle数据库准备的
				roleList.add(Constants.Nologin);
				roleList.add(Constants.Register);
				//查询结果
				List<UserRole> urlist=(List<UserRole>)sc.queryForList("Auth.getUserRoleList", param);
				if(urlist!=null){
					for(UserRole userrole:urlist){
						roleList.add(userrole.getRoleid());
					}
				}
				/**取企业站的用户角色列表*/
				/**
				 * 获取用户角色列表,作为用户属性roleList
				 */
				List<String> mroleList = (List) sc.queryForList(
						"User.getRoleList1", user.getMem_id());
				if(mroleList!=null){
					for(String roleid:mroleList){
						roleList.add(roleid);
					}
				}
				user.setRoleList(roleList);
				/**取用户企业对应信息*/
				OrgcomMember orgcomMember=new OrgcomMember();
				orgcomMember.setMem_id(userid);
//				orgcomMember.setState("1");//String:状态
				List<Object> ocmlist=(List<Object>)sc.queryForList("Auth.getOrgcomMemberList1", orgcomMember);
				if(ocmlist==null)ocmlist=new ArrayList<Object>();
				user.setOrgcomList(ocmlist);
				if(ocmlist.size()==1){
					OrgcomMember temp=(OrgcomMember)ocmlist.get(0);
					user.setOrgcom_id(temp.getOrgan_id());
					user.setOrgcom_name(temp.getOrgan_name());
					user.setRegion_id(temp.getOrgan_region());
					Orgcom orgcom=OrgComService.getInstance().getOrgcomByID(temp.getOrgan_id());
					if(orgcom!=null)
						user.setOrgcom_code(orgcom.getOrgan_code());
					else
						user.setOrgcom_code("");
				}				
				/**获取当前管理的企业*/
				String ceadmin=(String)sc.queryForObject("Auth.getCurrentEadmin", userid);
				if(ceadmin!=null&&!"".equals(ceadmin)){
					/**调用接口，获取企业的名字，如果名字为空，则说明企业不存在，提示用户重新设置当前企业*/
					user.setOrgcom_id(ceadmin);
					user.setOrgcom_name("");
				}
			}
		}
		return user;
	}
	
	/**根据企业站传递过来的用户id列表返回用户列表信息*/
	public List<User> getUserListByMids(List<String> memids) throws Exception{
		if(memids==null){
			return new ArrayList<User>();
		}
		if(memids.size()==0){
			return new ArrayList<User>();
		}
		SqlMapClient sc=DataSource.getSqlMapInstance();
		Map<String,Object> term=new HashMap<String,Object>();
		term.put("memidlist", memids);
		List<UserInfo> userinfolist=sc.queryForList("Auth.getUserInfoByList", term);
		List<User> relist=new ArrayList<User>();
		if(userinfolist!=null){
			for(UserInfo info:userinfolist){
				User user=UserInfoToUser.toUser(info);
				relist.add(user);
			}
		}
		return relist;
	}
	
	/**根据企业站传递过来的角色id获得对应的用户列表的总数*/
	public Integer getUserListCountByRoleID(String role_id,String site_id)  throws Exception{
		SqlMapClient sc=DataSource.getSqlMapInstance();
		UserRole userRole=new UserRole();
		userRole.setRoleid(role_id);//String:角色id
		userRole.setSite_id(site_id);
		return (Integer)sc.queryForObject("Auth.getUserRoleCount", userRole);
		
	}
	
	/**根据企业站传递过来的角色id及分页信息，查询用户列表*/
	public List<User> getUserListBy(Map term) throws Exception{
		UserRole userRole=new UserRole();
		userRole.setRoleid((String)term.get("role_id"));//String:角色id
		userRole.setSite_id((String)term.get("site_id"));//String:站点
		term.put("userRole", userRole);
		SqlMapClient sc=DataSource.getSqlMapInstance();
		List<UserInfo> resultList=(List<UserInfo>)sc.queryForList("Auth.getUserInfoList3", term);
		List<User> relist=new ArrayList<User>();
		if(resultList!=null){
			for(UserInfo info:resultList){
				User user=UserInfoToUser.toUser(info);
				relist.add(user);
			}
		}
		return relist;
	}
}
