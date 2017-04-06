package com.originsys.authclient.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.OrgcomType;
import com.originsys.authclient.util.ApiUtil;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.Component;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.domain.Page;
import com.originsys.eap.domain.Role;
import com.originsys.eap.domain.Site;
import com.originsys.eap.domain.UserType;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.service.ComponentService;
import com.originsys.eap.util.BeanFactory;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.OrgContextHolder;
import com.originsys.eap.util.RequestAction;
import com.originsys.manager.domain.SiteManagerService;

public class RoleList extends BaseAction implements IGet {

	public DataAndView<Map> execute(RequestAction ra) throws Exception {      
		SqlMapClient sc=DataSource.getSqlMapInstance();
		//获得当前页数
		String currentPage=ra.getParameter("page");
		//获得起始条数
		int start=0;

		// 获得每页显示的条数
		int pageNum=10;
		if(ra.getParameter("rows")!=null)
			pageNum=Integer.parseInt(ra.getParameter("rows"));
		else
			pageNum=10;
		pageNum=(pageNum==0)?10:pageNum;
		//分页
		//获得总条数
		Role role=new Role();
		String site_id=ra.getParameter("site_id");
		if(site_id!=null&&!"".equals(site_id))
			role.setSite_id(ra.getParameter("site_id"));
		String role_name=ra.getParameter("role_name");
		if(role_name!=null&&!"".equals(role_name))
			role.setRole_name(ra.getParameter("role_name"));
		role.setZ_conditional_expression(ra.getSqlCondiation());
		int totalnum=(Integer)sc.queryForObject("Role.selectRoleCount",role);
		//获得总页数
		int totalpage=totalnum%pageNum==0?totalnum/pageNum:(totalnum/pageNum+1);
		
		//获得当前页
		int currentNum=1;
		if(currentPage!=null && !"".equals(currentPage)){
			currentNum=Integer.parseInt(currentPage);
		}
		//重新设置起始条数
		start=(currentNum-1)*pageNum;
		//返回到页面总页数和当前页数
		Page page=new Page(totalpage,currentNum,totalnum);
		Map<String,String> termmap=new HashMap<String,String>();
		termmap.put("site_id", site_id);
		termmap.put("role_name", role_name);
		termmap.put("site_name", ra.getParameter("site_name"));
		//Map<String,Object> map=new HashMap<String,Object>();
		List<Role> rolelist=(List)sc.queryForList("Role.selectRoleList", role, start, pageNum);
		Site site=SiteManagerService.getInstance().getCurrentSite(ra);
		String user_site_id="";
		if(null!=site){
			user_site_id=site.getSite_id();
		}
		
		/**取本站点的企业类型*/
		String site_id1=OrgContextHolder.getVendorType();
		List<OrgcomType> orgcomtype_list=ApiUtil.getService().getOrgcomTypeList(site_id1);
	    /**循环企业类型，放到map中工下面调用*/
	    Map<String,String> typemap=new HashMap<String,String>();
	    if(orgcomtype_list!=null){
	    	for(OrgcomType octype:orgcomtype_list){
	    		typemap.put(octype.getOrgan_type_id(), octype.getOrgan_type_cname());
	    	}
	    }
		
		List<Role> relist=new ArrayList<Role>();		
		if(rolelist!=null){
			for(int i=0;i<rolelist.size();i++){
				Role temp=(Role)rolelist.get(i);
				if(user_site_id.equals(temp.getSite_id())){
					String role_id=temp.getRole_id();
					if(!"nologin".equals(role_id)&&!"register".equals(role_id))
						temp.set_internal_state("1");
					else
						temp.set_internal_state("0");
				}
				else
					temp.set_internal_state("0");
				String user_type=temp.getUser_type();
				if(null!=user_type&&!"".equals(user_type)){
					String[] types=user_type.split("\\.");
					UserType userType=BeanFactory.userTypeMap.get(user_type);
					if(userType!=null){
						Component component=ComponentService.getInstance().getComponentById(types[0]);
						if(component!=null)
							temp.setUser_type(component.getComponent_name()+"-"+userType.getName());
						temp.setList_action(userType.getListAction());
					}
				}
				/**从注册站获取企业类型*/
				if(temp.getOrgan_type_id()!=null&&!"".equals(temp.getOrgan_type_id())){
					temp.setOrgan_type_id(typemap.get(temp.getOrgan_type_id()));
				}
				relist.add(temp);
			}
		}
		
		Map remap=new HashMap();
		remap.put("page", page);
		remap.put("term", termmap);
		remap.put("rolelist", relist);
		
		return new DataAndView<Map>(remap,"role");
	}

}
