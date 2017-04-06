package com.originsys.safemanage.dangeroushouse.action;

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
import com.originsys.safemanage.domain.TBuilding;

/**
 auth:zhanglf 2014-6-17
   描述：危房列表
  超级管理员看所有的危房列表
 */
public class DangerousManageList extends BaseAction implements  IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		/**组织查询条件对象*/
		TBuilding tBuilding=new TBuilding();
		tBuilding.setBuilding_address(ra.getParameter("building_address"));//String:楼幢坐落
		if(ra.getParameter("floor_count")!=null && !"".equals(ra.getParameter("floor_count"))){
				tBuilding.setFloor_count(Integer.parseInt(ra.getParameter("floor_count")));//Integer
		}
		if(ra.getParameter("build_area")!=null && !"".equals(ra.getParameter("build_area"))){
				tBuilding.setBuild_area(Float.parseFloat(ra.getParameter("build_area")));//Float:建筑面积
		}
		tBuilding.setReal_type(ra.getParameter("real_type"));//String:房屋产别
		tBuilding.setUse_desgin(ra.getParameter("use_desgin"));//String:设计用途
		if(ra.getParameter("building_date")!=null && !"".equals(ra.getParameter("building_date"))){
				tBuilding.setBuilding_date(Integer.parseInt(ra.getParameter("building_date")));//Integer
		}
		tBuilding.setBuild_struct(ra.getParameter("build_struct"));//String:房屋与结构
		tBuilding.setHealth_grade_jd(ra.getParameter("health_grade_jd"));//String:健康等级-鉴定@1-a级&2-b级&3-c级&4-d级
		tBuilding.setIs_die(ra.getParameter("is_die"));//String:
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
		int totalnum=(Integer)sc.queryForObject("safeauth.getDangerousListCount", tBuilding);
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
			sortorder="desc";
		}
		//定义参数
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("_page_start", start);
		param.put("_page_nums", pageNum);//该参数是为MySQL数据库准备的
		param.put("_page_end", end);//该参数是为Oracle数据库准备的
		param.put("_sortname", sortname);
		param.put("_sortorder", sortorder);
		param.put("tBuilding", tBuilding);	  
		//查询结果
		List<TBuilding> resultList=(List<TBuilding>)sc.queryForList("safeauth.getDangerousList", param);
		Page page=new Page(totalpage,currentNum,totalnum);
		Map resultMap=new HashMap();
		resultMap.put("page", page);
		resultMap.put("resultList", resultList);
		return new DataAndView(resultMap,"block");
	}

}
