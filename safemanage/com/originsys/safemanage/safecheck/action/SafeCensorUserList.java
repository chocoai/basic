package com.originsys.safemanage.safecheck.action;

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
import com.originsys.safemanage.domain.TSafeCensor;

/**
 auth:boy 2014-4-16
   描述：安全检查员列表
 */
public class SafeCensorUserList extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		/**组织查询条件对象*/
		TSafeCensor tSafeCensor=new TSafeCensor();
		tSafeCensor.setMem_name(ra.getParameter("mem_name"));
		tSafeCensor.setFirstname(ra.getParameter("fullname"));
		
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		//获取当前登录用户的mem_id
		String mem_id=ra.getUser().getMem_id();
		//获取当前登录用户管理的区域
		List<String> regionList=(List<String>)sc.queryForList("Safecheck.getBuildingSafeManageRegion", mem_id);
		if(regionList.size()>0){
			tSafeCensor.setRegion(regionList.get(0));//该用户有管理的区域
		}else{
			tSafeCensor.setRegion("-1");//该用户没有管理的区域
		}
				
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
		int totalnum=(Integer)sc.queryForObject("Safecheck.getTSafeCensorCount", tSafeCensor);
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
					sortname="mem_id";
		}
		String sortorder= ra.getParameter("sord");
		if(sortorder==null||"".equals(sortorder)){
			sortorder="asc";
		}
		//定义参数
		Map param=new HashMap();
		param.put("_page_start", start);
		param.put("_page_nums", pageNum);//该参数是为MySQL数据库准备的
		param.put("_page_end", end);//该参数是为Oracle数据库准备的
		param.put("_sortname", sortname);
		param.put("_sortorder", sortorder);
		param.put("tSafeCensor", tSafeCensor);	  
		//查询结果
		List<TSafeCensor> resultList=(List<TSafeCensor>)sc.queryForList("Safecheck.getTSafeCensorList", param);
		Page page=new Page(totalpage,currentNum,totalnum);
		Map resultMap=new HashMap();
		resultMap.put("page", page);
		resultMap.put("resultList", resultList);
		return new DataAndView(resultMap,"block");
	}

}
