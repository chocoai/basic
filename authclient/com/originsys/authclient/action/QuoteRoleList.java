package com.originsys.authclient.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.caucho.hessian.client.HessianProxyFactory;
import com.originsys.auth.hessian.BasicService;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.domain.Page;
import com.originsys.eap.domain.Role;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.FileReaderUtil;
import com.originsys.eap.util.RequestAction;

/**
 * auth:boy 2014-7-2 描述：引用角色列表，列出注册站非未登录用户和注册用户的其他角色列表
 */
public class QuoteRoleList extends BaseAction implements IGet {

	public DataAndView execute(RequestAction ra) throws Exception {
		/** 调用接口 */
		ResourceBundle rb = FileReaderUtil.getInstance().getResourceBundle(
				"authclient");
		String authurl = rb.getString("authurl");
		HessianProxyFactory factory = new HessianProxyFactory();
		BasicService basicService = (BasicService) factory.create(
				BasicService.class, authurl);

		// 获得当前页数
		String currentPage = ra.getParameter("page");
		// 获得起始条数
		int start = 0;

		// 获得每页显示的条数
		int pageNum = 10;
		if (ra.getParameter("rows") != null)
			pageNum = Integer.parseInt(ra.getParameter("rows"));
		else
			pageNum = 10;
		pageNum = (pageNum == 0) ? 10 : pageNum;
		// 分页
		// 获得总条数
		Role role = new Role();
		String role_name = ra.getParameter("role_name");
		if (role_name != null && !"".equals(role_name))
			role.setRole_name(ra.getParameter("role_name"));
		int totalnum = (Integer) basicService.getQuoteRoleCount(role);
		// 获得总页数
		int totalpage = totalnum % pageNum == 0 ? totalnum / pageNum : (totalnum / pageNum + 1);

		// 获得当前页
		int currentNum = 1;
		if (currentPage != null && !"".equals(currentPage)) {
			currentNum = Integer.parseInt(currentPage);
		}
		// 重新设置起始条数
		start = (currentNum - 1) * pageNum;
		// 返回到页面总页数和当前页数
		Page page = new Page(totalpage, currentNum, totalnum);
		int end = currentNum*pageNum;
		//定义参数
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("_page_start", start);
		param.put("_page_nums", pageNum);//该参数是为MySQL数据库准备的
		param.put("_page_end", end);//该参数是为Oracle数据库准备的
		param.put("role", role);	
		List<Role> rolelist = basicService.getQuoteRoleList(param);

		Map<String,Object> remap=new HashMap<String,Object>();
		remap.put("page", page);
		remap.put("rolelist", rolelist);
		
		return new DataAndView<Map>(remap,"role");
	}

}
