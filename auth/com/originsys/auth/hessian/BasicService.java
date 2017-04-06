package com.originsys.auth.hessian;

import com.originsys.auth.domain.Email;
import com.originsys.auth.domain.Orgcom;
import com.originsys.auth.domain.OrgcomType;
import com.originsys.auth.domain.RoleRegister;
import com.originsys.auth.domain.UserInfo;
import com.originsys.auth.domain.UserRegister;
import com.originsys.eap.domain.Role;
import com.originsys.eap.domain.User;

import java.util.List;
import java.util.Map;

/**
 auth:boy 2014-6-27
   描述：用户认证hessian服务接口
 */
public interface BasicService {
    public void setServiceName(String serverName); 
    public String getServiceName(); 
    /**从企业站同步角色信息到注册站*/
	public void addRole(Role role,String site_id) throws Exception;
	/**从企业站同步删除注册站的角色信息*/
	public void deleteRole(String role_id,String site_id) throws Exception;
	/**返回企业类型列表*/
	public List<OrgcomType> getOrgcomTypeList(String site_id) throws Exception;
	/**根据企业站传递过来的角色id获得对应的用户列表的总数
	 * Map<String,Object> param=new HashMap<String,Object>();
				param.put("username", ra.getParameter("mem_id"));//用户姓名
				param.put("role_id", role_id);//角色id
				param.put("site_id", OrgContextHolder.getVendorType());*/
	public Integer getUserListCountByRoleID(Map param)  throws Exception;
	/**根据企业站传递过来的角色id及分页信息，查询用户列表
	 *  Map<String,Object> param=new HashMap<String,Object>();
				param.put("username", ra.getParameter("mem_id"));//用户姓名
				param.put("role_id", role_id);//角色id
				param.put("site_id", OrgContextHolder.getVendorType());
				param.put("_page_start", start);
				param.put("_page_nums", pageNum);//该参数是为MySQL数据库准备的
				param.put("_page_end", end);//该参数是为Oracle数据库准备的*/
	public List<User> getUserListBy(Map term) throws Exception;
	/**根据企业站传递过来的用户id列表返回用户列表信息
	 * //定义参数
				Map<String,Object> param=new HashMap<String,Object>();
				param.put("_page_start", start);
				param.put("_page_nums", pageNum);//该参数是为MySQL数据库准备的
				param.put("_page_end", end);//该参数是为Oracle数据库准备的
				param.put("memidlist", memidlist);//用户ids
				param.put("username", ra.getParameter("mem_id"));//用户姓名*/
	public List<User> getUserListByMids(Map param) throws Exception;
	/**根据企业站传递过来的用户id列表返回用户列表信息
	 * //定义参数
				Map<String,Object> param=new HashMap<String,Object>();
				param.put("memidlist", memidlist);//用户ids
				param.put("username", ra.getParameter("mem_id"));//用户姓名*/
	public Integer getUserListCountByMids(Map param) throws Exception;
	/**获取用户列表总数*/
	public Integer getUserListCount(UserInfo user)  throws Exception;
	/**获取用户列表
	 * Map param=new HashMap();
		param.put("_page_start", start);
		param.put("_page_nums", pageNum);//该参数是为MySQL数据库准备的
		param.put("_page_end", end);//该参数是为Oracle数据库准备的
		param.put("userInfo", user);
	*/
	public List<UserInfo> getUserList(Map param)  throws Exception;
	/**根据用户管理企业的organ_id返回企业id和名称的map list*/
	public List<Map> getEadminOrgans(String organ_id) throws Exception;
	/**根据用户编号获得用户信息，包括用户的基本信息，用户角色信息，用户的企业信息*/
	public User getUserByMemid(String mem_id) throws Exception;
	/**根据AccessToken获得用户信息，包括用户的基本信息，用户角色信息，用户的企业信息*/
	public User getUserByToken(String token) throws Exception;
	/**获取企业用户的数量*/
	public Integer getUserInfoCount(UserInfo userInfo) throws Exception;
	/**获取企业用户的列表*/
	public List<UserInfo> getUserInfoList(Map param) throws Exception;
	/**获得注册站的非未登录用户和非注册用户角色数量*/
	public Integer getQuoteRoleCount(Role role) throws Exception;
	/**获得注册站的非未登录用户和非注册用户角色列表*/
	public List<Role> getQuoteRoleList(Map param) throws Exception;
	/**判断mem_name是否存在，返回数量*/
	public Integer getMemnameCount(String mem_name) throws Exception;
	/**企业管理员增加企业用户，保存用户的注册信息和基本信息及用户和企业的对应关系
	 * Map<String,Object> param=new HashMap<String,Object>();
		param.put("userRegister", userRegister);
		param.put("userInfo", userInfo);
		param.put("orgcomMember", orgcomMember);
		param.put("mem_name", ra.getParameter("mem_name"));*/
	public int addQyUser(Map param) throws Exception;
	/**根据企业管理员的当前管理企业的organ_id和当前的企业站点id获得企业类型id*/
	public String getOrganTypeID(String organ_id,String site_id) throws Exception;
	/**返回企业管理员当前管理企业在本站点下的角色列表*/
	public List<RoleRegister> getAllQyRoleList(String organ_id,String site_id) throws Exception;
	/**返回指定用户在企业管理员当前管理企业在本站点下的角色列表*/
	public List<RoleRegister> getQyRoleListByMemid(String organ_id,String site_id,String mem_id) throws Exception;
	/**企业管理员增加角色和用户的对应关系*/
	public String addQyUserRole(String mem_id,String organ_id,String role_reg_id) throws Exception;
	/**企业管理员删除角色和用户的对应关系*/
	public int delQyUserRole(String mem_id,String role_reg_id) throws Exception;
	/**企业管理员删除用户与企业的对应关系及本企业的角色对应关系*/
	public int delQyUser(String mem_id,String organ_id) throws Exception;
	/**企业管理员从服务端修改用户的密码*/
	public int resetQyUserPass(UserRegister reg,UserInfo info) throws Exception;
	/**根据mem_id返回用户信息*/
	public UserInfo getUserInfoByMemid(String mem_id) throws Exception;
	/**修改用户信息*/
	public int updateUserInfo(UserInfo userinfo) throws Exception;
	/**用户登录*/
	public Map<String,Object> doClientLogin(String mem_name,String password) throws Exception;
	/**发邮件*/
	public String sendMail(Email email) throws Exception;
	/**根据企业站传递过来的组织公司id及分页信息，查询组织公司列表*/
	public List<Orgcom> getOrgcomList(Map<String,Object> param) throws Exception;
	/**根据企业站传递过来的组织公司的属性信息,查询符合条件的组织公司的数目*/
	public int getOrgcomCount(Orgcom orgcom) throws Exception;
}
