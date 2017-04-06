package com.originsys.auth.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.UserInfo;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.domain.Page;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-7-1
   描述：企业管理员列表
 */
public class EadminPropertyList  extends BaseAction implements IGet {

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
		UserInfo user=new UserInfo();
		user.setFamily_name(ra.getParameter("family_name"));
		user.setMem_name(ra.getParameter("mem_name"));
		user.setMem_sex(ra.getParameter("mem_sex"));
		user.setMem_state(ra.getParameter("mem_state"));
		int totalnum=(Integer)sc.queryForObject("Auth.getEadminListCount", user);
		
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
		int end = currentNum*pageNum;
		//定义参数
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("_page_start", start);
		param.put("_page_nums", pageNum);//该参数是为MySQL数据库准备的
		param.put("_page_end", end);//该参数是为Oracle数据库准备的
		param.put("userInfo", user);	
		List<UserInfo> userlist=(List<UserInfo>)sc.queryForList("Auth.getEadminList",param);
		Map<String,Object> remap=new HashMap<String,Object>();
		remap.put("page", page);
		remap.put("userlist", userlist);
		return new DataAndView<Map>(remap,"block");
	}

}
