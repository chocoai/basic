package com.originsys.auth.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.AccessApp;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.domain.Page;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-7-24
   描述：应用管理列表
 */
public class AppListManage extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		AccessApp app=new AccessApp();
		if(ra.getParameter("app_name")!=null&&!"".equals(ra.getParameter("app_name")))
			app.setApp_name(ra.getParameter("app_name"));
		if(ra.getParameter("app_state")!=null&&!"".equals(ra.getParameter("app_state")))
			app.setApp_state(ra.getParameter("app_state"));
		
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
		int totalnum=(Integer)sc.queryForObject("Auth.getAppListCount", app);
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
			sortname="reg_date";
		}
		String sortorder= ra.getParameter("sord");
		if(sortorder==null||"".equals(sortorder)){
			sortorder="desc";
		}
		//定义参数
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("_page_start", start);
		param.put("_page_nums", pageNum);//该参数是为MySQL数据库准备的
		param.put("_page_end", end);//该参数是为Oracle数据库准备的
		param.put("_sortname", sortname);
		param.put("_sortorder", sortorder);
		param.put("app", app);	  
		//查询结果
		List<AccessApp> resultList=(List<AccessApp>)sc.queryForList("Auth.getAppList", param);
		Page page=new Page(totalpage,currentNum,totalnum);
		Map<String,Object> resultMap=new HashMap<String,Object>();
		resultMap.put("page", page);
		resultMap.put("applist", resultList);

		return new DataAndView(resultMap,"block");
	}

}
