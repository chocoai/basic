package com.originsys.safemanage.warning.action;

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
import com.originsys.safemanage.domain.TAppraisalReport;

/**
 auth:zhanglf 2014-7-18
   描述:危房通知逾期预警列表
 */
public class NoticeWarnList extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String building_address=ra.getParameter("building_address");//坐落
		String building_region=ra.getParameter("building_region");//所属区域
		String jdmember=ra.getParameter("jdmember");//鉴定人
		String jd_department=ra.getParameter("jd_department");//鉴定单位
		String jd_date=ra.getParameter("jd_date");//鉴定时间
		String dangerous_level=ra.getParameter("dangerous_level");//危房等级
		String over_grade=ra.getParameter("over_grade");//逾期情况@1-临近逾期&2-已逾期
		/**组织查询条件对象*/
		TAppraisalReport tApp=new TAppraisalReport();
		if(null!=building_address&&!"".equals(building_address)){
			tApp.setBuilding_address(building_address);
		}
		if(null!=building_region&&!"".equals(building_region)){
			tApp.setBuilding_region(building_region);
		}
		if(null!=jdmember&&!"".equals(jdmember)){
			tApp.setJdmember(jdmember);
		}
		if(null!=jd_department&&!"".equals(jd_department)){
			tApp.setJd_department(jd_department);
		}
		if(null!=jd_date&&!"".equals(jd_date)){
			tApp.setJd_date(sdf.parse(jd_date));
		}
		if(null!=dangerous_level&&!"".equals(dangerous_level)){
			tApp.setDangerous_level(dangerous_level);
		}
		if(null!=over_grade&&!"".equals(over_grade)){
			tApp.setOver_grade(over_grade);
		}
		
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
		int totalnum=(Integer)sc.queryForObject("safeauth.getNoticeWarnCount", tApp);
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
					sortname="building_id";
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
		param.put("tAppraisalReport", tApp);	  
		//查询结果
		List<TAppraisalReport> resultList=(List<TAppraisalReport>)sc.queryForList("safeauth.getNoticeWarnList", param);
		Page page=new Page(totalpage,currentNum,totalnum);
		Map resultMap=new HashMap();
		resultMap.put("page", page);
		resultMap.put("resultList", resultList);
		return new DataAndView(resultMap,"block");
	}

}
