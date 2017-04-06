package com.originsys.datacenter.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.datacenter.domain.YcDatacenterServiceRegister;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.domain.Page;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-3-12
   描述：服务的编辑列表，根据不同的状态去不同的数据，前台页面进行不同的操作,需要分页
 */
public class ServiceEditList extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		String state=ra.getParameter("state");
		SqlMapClient sc=DataSource.getSqlMapInstance();
		//获得起始条数
		int start=0;
		//获得每页显示的条数
		int pageNum=8;
		if(ra.getParameter("rows")!=null){
			pageNum=Integer.parseInt(ra.getParameter("rows"));
		}
		else{
			pageNum=8;
		}
		pageNum=(pageNum==0)?8:pageNum;
		//获取总条数
		int totalnum=(Integer)sc.queryForObject("datacenter.getServiceListCount",state);
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
			sortname="create_date";
		}
		String sortorder= ra.getParameter("sord");
		if(sortorder==null||"".equals(sortorder)){
			sortorder="desc";
		}
		//定义参数
		Map param=new HashMap();
		param.put("_page_start", start);
		param.put("_page_nums", pageNum);//该参数是为MySQL数据库准备的
		param.put("_page_end", end);//该参数是为Oracle数据库准备的
		param.put("_sortname", sortname);
		param.put("_sortorder", sortorder);
		param.put("service_state", state);
		List<YcDatacenterServiceRegister> resultList=(List<YcDatacenterServiceRegister>)sc.queryForList("datacenter.getServiceList", param);
		Page page=new Page(totalpage,currentNum,totalnum);
		
		Map<String,Object> remap=new HashMap<String,Object>();
		remap.put("state",state);
		remap.put("page", page);
		remap.put("resultList", resultList);
		
		return new DataAndView(remap,"block");
	}

}
