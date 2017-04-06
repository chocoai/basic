package com.originsys.safemanage.authenticate.action;

import java.text.SimpleDateFormat;
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
import com.originsys.safemanage.domain.TAppraisalTask;
import com.originsys.safemanage.domain.TBuilding;

/**
 auth:boy 2014-8-8
   描述：鉴定任务单列表
 */
public class JdTaskList extends BaseAction implements  IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		/**组织查询条件对象*/
		TAppraisalTask tAppraisalTask=new TAppraisalTask();
		tAppraisalTask.setBuilding_address(ra.getParameter("building_address"));//String:楼幢地址
		tAppraisalTask.setBuilding_region(ra.getParameter("building_region"));//String:所属区域
		tAppraisalTask.setSafe_grade(ra.getParameter("safe_grade"));//String:安全情况@1-a级&2-b级&3-c级&4-d级
		tAppraisalTask.setAgent(ra.getParameter("agent"));//String:经办人/委托人
		if(ra.getParameter("building_date")!=null && !"".equals(ra.getParameter("building_date"))){
			tAppraisalTask.setBuilding_date(Integer.parseInt(ra.getParameter("building_date")));////Date:建成时间
		}
		tAppraisalTask.setData_origin(ra.getParameter("data_origin"));//数据来源
		System.out.println("ra.getParameter(data_origin)="+ra.getParameter("data_origin"));
//		tAppraisalTask.setInfo_state(ra.getParameter("info_state"));//String:鉴定信息状态0暂存1待审核2审核驳回8审核通过
		
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
		int totalnum=(Integer)sc.queryForObject("safeauth.getTAppraisalTaskCount", tAppraisalTask);
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
			sortname="add_time";
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
		param.put("tAppraisalTask", tAppraisalTask);	  
		//查询结果
		List<TAppraisalTask> resultList=(List<TAppraisalTask>)sc.queryForList("safeauth.getTAppraisalTaskList", param);
		Page page=new Page(totalpage,currentNum,totalnum);
		Map resultMap=new HashMap();
		resultMap.put("page", page);
		resultMap.put("resultList", resultList);
		return new DataAndView(resultMap,"block");
	}

}
