package com.originsys.authclient.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.authclient.util.ApiUtil;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.common.domain.Department;
import com.originsys.eap.common.domain.DepartmentMember;
import com.originsys.eap.control.Constants;
import com.originsys.eap.domain.PostDataAndView;
import com.originsys.eap.domain.SwitchType;
import com.originsys.eap.domain.User;
import com.originsys.eap.iservice.IPost;
import com.originsys.eap.service.DepartmentService;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.GetMD5;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.safecheck.action.SafeCensorService;
import com.originsys.safemanage.safecheck.action.SafeManagerService;

/**
 auth:boy 2014-7-16
   描述：客户端接口登录
   获取用户名和密码的，调用接口获取用户信息，加载本地角色列表，把用户放到session中
 */
public class LoginClient extends BaseAction implements IPost{

	public PostDataAndView execute(RequestAction ra) throws Exception {
		String newAction="authclient.client.loginblock";
		if(ra.getHeader("referer")!=null)
			newAction=ra.getHeader("referer");
		SwitchType st=SwitchType.REDIRECT;
		String success="0";
		String username = ra.getParameter("mem_name");
		String password = ra.getParameter("mem_pass");
		//记录操作日志
		ra.operate.setOperateModule("用户登录");
		ra.operate.setOperateContent("用户:"+username+"登录");
		HttpSession session = ra.getSession();
		String code=(String) session.getAttribute("validateCode");
		String validatecode="";
		if(code==null){
			code="";
		}else
			validatecode=ra.getParameter("validatecode");
		session.setAttribute("empusername", username);
		session.setAttribute("emppassword", password);
		if(!"1".equals(ra.getParameter("jump_flag"))){
			
		}else{
			code="";
			validatecode="";
		}
		if(code.equals(validatecode)){
			password = GetMD5.getMd5(password);
			/**调用接口返回用户信息和操作标示*/
			Map<String,Object> remap=ApiUtil.getService().doClientLogin(username, password);
			success=(String)remap.get("success");
			if("1".equals((String)remap.get("success"))){
				User user=(User)remap.get("user");
				 SqlMapClient sc = DataSource.getSqlMapInstance();
				    /**获取本站用户角色列表,作为用户属性roleList*/
					List<String> roleList = (List) sc.queryForList("User.getRoleList1", user.getMem_id());
					if (roleList == null) {
						roleList = new ArrayList();
					}
					List<String> roleList1=user.getRoleList();
					roleList1.addAll(roleList);
					user.setRoleList(roleList1);
					/***获取用户的相关部门信息存放起来(部门表暂时没有使用到 2015-1-7)*/
					DepartmentMember temp=(DepartmentMember)sc.queryForObject("organ.getDepartmentMemberByMemid", user.getMem_id());
					List department_list=new ArrayList<Object>();
					if(temp!=null&&!"".equals(temp.getDepartment_id())){
						department_list.add(temp);
						user.setOrgan(temp.getDepartment_id());
						if (!"".equals(temp.getDepartment_id().trim())) {
							Department depart=DepartmentService.getInstance().getDepartmentById(temp.getDepartment_id());
							user.setOrgan_name(depart.getDepartment_name());
							//user.setRegion_id(depart.getRegion_id());
						}
					}
					user.setDepartmentList(department_list);
					
					/**安全管理系统需要根据安全检查员和安全管理员的管理区域，区分地图的显示，
					 * 所以把扩展信息表中的地区信息放到用户的region_id里*/
					String region="";//记录登录的用户管辖的区域
					if(SafeCensorService.getInstance().getTSafeCensor(user.getMem_id())!=null){
					//	region=SafeCensorService.getInstance().getTSafeCensor(user.getMem_id()).getRegion();
						/**获取相关责任单位，查询所管理的楼幢编号 放到_internal_state这个属性中*/
						String manage_scope=SafeCensorService.getInstance().getTSafeCensor(user.getMem_id()).getManage_scope();
						if(manage_scope!=null&&!"".equals(manage_scope)){
							List<String> ids=sc.queryForList("Safecheck.getBuildingIds", manage_scope);
							if(ids!=null){
								String _internal_state="";
								for(int i=0;i<ids.size();i++){
									if(ids.get(i)!=null){
										if("".equals(_internal_state))
											_internal_state=ids.get(i);
										else
											_internal_state+=","+ids.get(i);
									}
								}
								user.set_internal_state(_internal_state);
							}
						}
					}if(SafeManagerService.getInstance().getTSafeManager(user.getMem_id())!=null){
						region=SafeManagerService.getInstance().getTSafeManager(user.getMem_id()).getRegion();
					//if(region==null)region="";					 
					    user.setRegion_id(region);				    
					}else{
						System.out.println("用户所在行政区域:"+user.getRegion_id());
					}
					    
					session.setAttribute(Constants.User, user);
					ra.getUser().setMem_id(user.getMem_id());
			}
		}else{
			//验证码不正确
			success="6";
		}
		session.setAttribute("error", success);
		return new PostDataAndView(null, "map", newAction, st);
	}
}
