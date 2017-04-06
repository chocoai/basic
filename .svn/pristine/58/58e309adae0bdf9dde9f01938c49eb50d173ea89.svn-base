package com.originsys.authclient.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.authclient.util.ApiUtil;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.domain.MemberRole;
import com.originsys.eap.domain.Page;
import com.originsys.eap.domain.User;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.OrgContextHolder;
import com.originsys.eap.util.RequestAction;

/**
 * @author boy Email:wangbaoaiboy@163.com
 * @version 1.0 创建时间：2010-6-8
 * 类说明：角色对应用户列表，可根据用户登录名模糊查询,采用转发的模式
 * 角色绑定企业类型的用户角色的对应关系从注册站取
 * 角色未绑定企业类型的用户角色的对应关系从本地取，取了对应关系之后再从注册站取对应的用户列表
 */
public class MemberListByRoleId extends BaseAction implements IGet{

	public DataAndView<Map> execute(RequestAction ra)
			throws Exception {
		//获得角色编号
		String role_id=ra.getParameter("role_id");
		if(role_id!=null&& !"".equals(role_id)){
			SqlMapClient sc=DataSource.getSqlMapInstance();
			MemberRole term=new MemberRole();
			term.setRole_id(role_id);
			term.setMem_id(ra.getParameter("mem_id"));
			term.setRole_name(ra.getParameter("role_name"));
			//获得当前页数
			String currentPage=ra.getParameter("page");
			//获得起始条数
			int start=0;
			//获得每页显示的条数
			int pageNum=10;
			if(ra.getParameter("rows")!=null)
				pageNum=Integer.parseInt(ra.getParameter("rows"));
			else
				pageNum=10;
			pageNum=(pageNum==0)?10:pageNum;
			
		    String organ_type=ra.getParameter("organ_type");
			if(organ_type!=null&&!"".equals(organ_type)){
				Map<String,Object> param=new HashMap<String,Object>();
				param.put("username", ra.getParameter("mem_id"));//用户姓名
				param.put("role_id", role_id);//角色id
				param.put("site_id", OrgContextHolder.getVendorType());
				//从注册站取对应用户
				//获取总条数
				int totalnum=ApiUtil.getService().getUserListCountByRoleID(param);
				//获得总页数
				int totalpage=totalnum%pageNum==0?totalnum/pageNum:(totalnum/pageNum+1);		
				//获得当前页
				currentPage=ra.getParameter("page");
				int currentNum=1;
				if(currentPage!=null && !"".equals(currentPage)){
					currentNum=Integer.parseInt(currentPage);
				}
				//重新设置起始条数
				start=(currentNum-1)*pageNum;
				int end = currentNum*pageNum;
				//定义参数
				param.put("_page_start", start);
				param.put("_page_nums", pageNum);//该参数是为MySQL数据库准备的
				param.put("_page_end", end);//该参数是为Oracle数据库准备的
				//查询结果
				List<User> resultList=ApiUtil.getService().getUserListBy(param);
				Page page=new Page(totalpage,currentNum,totalnum);
				Map<String,Object> resultMap=new HashMap<String,Object>();
				resultMap.put("page", page);
				resultMap.put("term", term);
				resultMap.put("userlist", resultList);
				return new DataAndView(resultMap,"userlist");
			}else{
				//先从企业站取角色对应的用户id，再从注册站取对应的用户列表
				MemberRole mr=new MemberRole();
				mr.setRole_id(role_id);
				mr.setMem_id(ra.getParameter("mem_id"));
				mr.setZ_conditional_expression(ra.getSqlCondiation());
				List<String> memidlist=(List<String>)sc.queryForList("Role.getMemIDListByRoleId", mr);
				if(memidlist==null)
					memidlist=new ArrayList<String>();
				//定义参数
				Map<String,Object> param=new HashMap<String,Object>();
				param.put("memidlist", memidlist);//用户ids
				param.put("username", ra.getParameter("mem_id"));//用户姓名
				
				int totalnum=ApiUtil.getService().getUserListCountByMids(param);
				//获得总页数
				int totalpage=totalnum%pageNum==0?totalnum/pageNum:(totalnum/pageNum+1);
				//获得当前页
				int currentNum=1;
				if(currentPage!=null && !"".equals(currentPage)){
					currentNum=Integer.parseInt(currentPage);
				}
				//重新设置起始条数
				start=(currentNum-1)*pageNum;
				int end = currentNum*pageNum;
				//返回到页面总页数和当前页数
				Page page=new Page(totalpage,currentNum,totalnum);
				
				
				param.put("_page_start", start);
				param.put("_page_nums", pageNum);//该参数是为MySQL数据库准备的
				param.put("_page_end", end);//该参数是为Oracle数据库准备的
				
				
				List<User> userlist=ApiUtil.getService().getUserListByMids(param);
				//在本地遍历，取本地yc_member_role 表中的状态
				if(userlist!=null){
					for(int i=0;i<userlist.size();i++){	
						mr.setMem_id(userlist.get(i).getMem_id());
						userlist.get(i).set_internal_state((String)sc.queryForObject("Role.getRoleState", mr));
					}
				}
				Map<String,Object> remap=new HashMap<String,Object>();
				remap.put("page", page);
				remap.put("term", term);
				remap.put("userlist", userlist);
				return new DataAndView<Map>(remap,"userlist");
			}
		}else{
			throw new Exception("The parameters \"role_id\" is empty, we must select a record");
		}
	}

}
