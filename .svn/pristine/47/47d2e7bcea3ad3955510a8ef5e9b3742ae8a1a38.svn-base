package com.originsys.safemanage.safecheck.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
 auth:zhanglf 2014-6-9
   描述:健康等级pop窗口列表数据（区县管理员）
 */
public class BuildingSafePopList extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String building_address=ra.getParameter("building_address");
		String builiding_region=ra.getParameter("builiding_region");
		String real_type=ra.getParameter("real_type");
		String use_desgin=ra.getParameter("use_desgin");
		String building_date=ra.getParameter("building_date");
		String build_struct=ra.getParameter("build_struct");
		String health_type = ra.getParameter("health_type");
		String health_grade = ra.getParameter("health_grade");
		/**组织查询条件对象*/
		TBuilding tBuilding=new TBuilding();
		if(null!=building_address&&!"".equals(building_address)){
			tBuilding.setBuilding_address(building_address);
		}
		if(null!=builiding_region&&!"".equals(builiding_region)){
			tBuilding.setBuiliding_region(builiding_region);
		}
		if(null!=real_type&&!"".equals(real_type)){
			tBuilding.setReal_type(real_type);
		}
		if(null!=use_desgin&&!"".equals(use_desgin)){
			tBuilding.setUse_desgin(use_desgin);
		}
		if(null!=building_date&&!"".equals(building_date)){
			tBuilding.setBuilding_date(Integer.parseInt(building_date));
		}
		if(null!=build_struct&&!"".equals(build_struct)){
			tBuilding.setBuild_struct(build_struct);
		}
		
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		//获取当前登录用户的mem_id
		String mem_id=ra.getUser().getMem_id();
		//获取当前登录用户管理的区域
		List<String> regionList=(List<String>)sc.queryForList("Safecheck.getBuildingSafeManageRegion", mem_id);
		if(regionList.size()>0){
			tBuilding.setBuiliding_region(regionList.get(0));//该用户有管理的区域
		}else{
			tBuilding.setBuiliding_region("-1");//该用户没有管理的区域
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
		 int totalnum = 0;

		    if (health_type.equals("1")) {
		      if ((health_grade != null) && (!"".equals(health_grade))) {
		        tBuilding.setHealth_grade_pc(health_grade);
		      }
		      totalnum = ((Integer)sc.queryForObject("Safecheck.getPcBuildingSafePopListCount", tBuilding)).intValue();
		    } else {
		      if ((health_grade != null) && (!"".equals(health_grade))) {
		        tBuilding.setHealth_grade_jd(health_grade);
		      }
		      totalnum = ((Integer)sc.queryForObject("Safecheck.getJdBuildingSafePopListCount", tBuilding)).intValue();
		    }

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
		param.put("tBuilding", tBuilding);	  
		//查询结果
		List resultList = new ArrayList();
		    if (health_type.equals("1"))
		      resultList = sc.queryForList("Safecheck.getPcBuildingSafePopList", param);
		    else {
		      resultList = sc.queryForList("Safecheck.getJdBuildingSafePopList", param);
		    }
		Page page=new Page(totalpage,currentNum,totalnum);
		Map resultMap=new HashMap();
		resultMap.put("page", page);
		resultMap.put("resultList", resultList);
		return new DataAndView(resultMap,"block");
	}

}
