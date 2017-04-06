package com.originsys.authclient.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.domain.Page;
import com.originsys.eap.domain.Role;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 * @author boy Email:wangbaoaiboy@163.com
 * @version 1.0 创建时间：2010-6-23
 * 类说明：列出本站所有可申请角色
 */
public class RoleListDialog extends BaseAction implements IGet{

	public DataAndView<Map> execute(RequestAction ra) throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		//获得当前页数
		String currentPage=ra.getParameter("page");
		//获得起始条数
		int start=0;

		// 获得每页显示的条数
		int pageNum=15;
		pageNum=(pageNum==0)?15:pageNum;
		//分页
		//获得总条数
		Role role=new Role();
		String role_name=ra.getParameter("role_name");
		if(role_name!=null&&!"".equals(role_name))
			role.setRole_name(ra.getParameter("role_name"));
		role.setZ_conditional_expression(ra.getSqlCondiation());
		int totalnum=(Integer)sc.queryForObject("Role.selectReqRoleCounta",role);
		//获得总页数
		int totalpage=totalnum%pageNum==0?totalnum/pageNum:(totalnum/pageNum+1);
		
		//获得当前页
		int currentNum=1;
		if(currentPage!=null && !"".equals(currentPage)){
			currentNum=Integer.parseInt(currentPage);
		}
		
		String mem_id=ra.getParameter("mem_id");
		List<String> haverolelist=(List<String>)sc.queryForList("Role.getRoleNameByMemId",mem_id);
		String haverole="";
		for(String r:haverolelist){
			haverole+=r+",";
		}
		log().debug(mem_id+"|"+haverole);
		//重新设置起始条数
		start=(currentNum-1)*pageNum;
		//返回到页面总页数和当前页数
		Page page=new Page(totalpage,currentNum,totalnum);
		Map termmap=new HashMap();
		termmap.put("role_name", role_name);
		termmap.put("haveroles", haverole);
		termmap.put("site_name", ra.getParameter("site_name"));
		termmap.put("mem_id", mem_id);
		
		List<Role> rolelist=(List<Role>)sc.queryForList("Role.selectReqRoleLista", role, start, pageNum);
		
		/**返回结果*/
		Map remap=new HashMap();
		remap.put("page", page);
		remap.put("term", termmap);
		remap.put("rolelist", rolelist);
				
		return new DataAndView<Map>(remap,"role");
	}

}
