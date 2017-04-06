package com.originsys.auth.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.domain.Page;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.auth.domain.RoleRegister;
import com.originsys.auth.domain.UserRole;
/**
 * @author   Email: 
 * @version 1.0 创建时间： 
 * 类说明： 列表页
 * 查询用户在当前管理员的当前组织中的对应角色列表
 */
public class UserRoleList  extends BaseAction implements IGet{

	public DataAndView<Map> execute(RequestAction ra)throws Exception {
		/**组织查询条件对象*/
		UserRole userRole=new UserRole();
		userRole.setRoleid(ra.getParameter("roleid"));//String:角色id
		userRole.setSite_id(ra.getParameter("site_id"));//String:站点
		userRole.setMem_id(ra.getParameter("mem_id"));//String:用户id
		userRole.setMem_state(ra.getParameter("mem_state"));//String:用户状态
		userRole.setCom_id(ra.getParameter("com_id"));//String:该角色所属的企业
		userRole.setRole_register_id(ra.getParameter("role_register_id"));//String:角色注册id
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		//获得起始条数
		int start=0;
		//获得每页显示的条数
		int pageNum=10;
		if(ra.getParameter("rows")!=null){
			pageNum=Integer.parseInt(ra.getParameter("rows"));
		}
		else{
			pageNum=10;
		}
		pageNum=(pageNum==0)?10:pageNum;
		//获取总条数
		int totalnum=(Integer)sc.queryForObject("Auth.getMemberRoleListCountBy1", userRole);
		//获得总页数
		int totalpage=totalnum%pageNum==0?totalnum/pageNum:(totalnum/pageNum+1);		
		//获得当前页
		String currentPage=ra.getParameter("page");
		int currentNum=1;
		if(currentPage!=null && !"".equals(currentPage)){
			currentNum=Integer.parseInt(currentPage);
		}
		//重新设置起始条数
		start=(currentNum-1)*pageNum;
		int end = currentNum*pageNum;
		//排序字段+排序方式
		String sortname=ra.getParameter("sidx");
		if(sortname==null||"".equals(sortname)){
					sortname="roleid";
		}
		String sortorder= ra.getParameter("sord");
		if(sortorder==null||"".equals(sortorder)){
			sortorder="asc";
		}
		//定义参数
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("_page_start", start);
		param.put("_page_nums", pageNum);//该参数是为MySQL数据库准备的
		param.put("_page_end", end);//该参数是为Oracle数据库准备的
		param.put("_sortname", sortname);
		param.put("_sortorder", sortorder);
		param.put("userRole", userRole);	  
		//查询结果
		List<RoleRegister> resultList=(List<RoleRegister>)sc.queryForList("Auth.getMemberRoleListBy1", param);
		Page page=new Page(totalpage,currentNum,totalnum);
		Map<String,Object> resultMap=new HashMap<String,Object>();
		resultMap.put("page", page);
		resultMap.put("resultList", resultList);
		return new DataAndView(resultMap,"block");
	}
}