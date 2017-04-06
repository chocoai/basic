package com.originsys.safemanage.warning.action;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.originsys.safemanage.domain.DisasterWarn;

/**
 auth:zhanglf 2014-7-23
   描述:突发事件预警列表
 */
public class DisasterWarnList extends BaseAction implements IGet{

	@SuppressWarnings("unchecked")
	public DataAndView execute(RequestAction ra) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String disaster_name=ra.getParameter("disaster_name");//灾害简称
		String disaster_region=ra.getParameter("disaster_region");//所属区域
		String disaster_type=ra.getParameter("disaster_type");//灾害类型@1-火灾&2-泥石流&3-地震&4-洪水
		String disaster_grade=ra.getParameter("disaster_grade");//灾害级别@1-一般&2-较大&3-重大&4-特别重大
		String disaster_date=ra.getParameter("disaster_date");//灾害发生时间
		String info_state=ra.getParameter("info_state");//预警状态@0-未审核&1-审核通过&2-审核驳回&3-已取消
		/**组织查询条件对象*/
		DisasterWarn DWarn=new DisasterWarn();
		if(null!=disaster_name&&!"".equals(disaster_name)){
			DWarn.setDisaster_name(disaster_name);
		}
		if(null!=disaster_region&&!"".equals(disaster_region)){
			DWarn.setDisaster_region(disaster_region);
		}
		if(null!=disaster_type&&!"".equals(disaster_type)){
			DWarn.setDisaster_type(disaster_type);
		}
		if(null!=disaster_grade&&!"".equals(disaster_grade)){
			DWarn.setDisaster_grade(disaster_grade);
		}
		if(null!=disaster_date&&!"".equals(disaster_date)){
			DWarn.setDisaster_date(sdf.parse(disaster_date));
		}
		if(null!=info_state&&!"".equals(info_state)){
			DWarn.setInfo_state(info_state);
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
		int totalnum=(Integer)sc.queryForObject("Safecheck.getDisasterWarnCount", DWarn);
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
					sortname="disaster_id";
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
		param.put("disasterWarn", DWarn);	  
		//查询结果
		List<DisasterWarn> resultList=(List<DisasterWarn>)sc.queryForList("Safecheck.getDisasterWarnList", param);
		Page page=new Page(totalpage,currentNum,totalnum);
		Map resultMap=new HashMap();
		resultMap.put("page", page);
		resultMap.put("resultList", resultList);
		resultMap.put("current_time", sdf.format(new Date()));
		return new DataAndView(resultMap,"block");
	}

}
