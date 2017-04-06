package com.originsys.realtygis.action;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Arrays;
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
import com.originsys.realtygis.domain.Building;


public class BuildingFromMapJson extends BaseAction implements IGet{
	/**
	 * 类说明：楼幢综合查询类
	 * @创建时间：2014-3-17
	 * @作者：洛佳明
	 */
	private static final long serialVersionUID = 1L;
	public DataAndView<Map<String, List<Building>>> execute(RequestAction ra)
			throws Exception {	
		
		SqlMapClient sc=DataSource.getSqlMapInstance();
		Map map=new HashMap();
		Building building=new Building();

		String fea=ra.getParameter("fea");
		String[] arr=fea.split("\\,");
		List arrlist = Arrays.asList(arr);  
		building.setArrlist(arrlist);			
		
		//获得当前页数
		String currentPage=ra.getParameter("page");
		//获得起始条数
		int start=0;	
		
		//TODO 获得每页显示的条数
		int pageNum=10;
		  if(ra.getParameter("rows")!=null)
			pageNum=Integer.parseInt(ra.getParameter("rows"));
		  else
			pageNum=10;
		pageNum=(pageNum==0)?10:pageNum;
		int totalnum=(Integer)sc.queryForObject("Realtygis.buildingfrommapcount", building);
		//获得总页数
		int totalpage=totalnum%pageNum==0?totalnum/pageNum:(totalnum/pageNum+1);
		int end=totalnum;
		//获得当前页
		int currentNum=1;
		if(currentPage!=null && !"".equals(currentPage)){
			currentNum=Integer.parseInt(currentPage);
		}
		//重新设置起始条数
		start=(currentNum-1)*pageNum;
		end=start+pageNum;
		//返回到页面总页数和当前页数
		Page p=new Page(totalpage, currentNum, totalnum);
		// 排序字段+排序方式
		String sortname=ra.getParameter("sidx");
		if (sortname == null || "".equals(sortname)) {
			sortname = "building_mapid";
		}
		String sortorder= ra.getParameter("sord");
		if (sortorder == null || "".equals(sortorder)) {
			sortorder = "asc";
		}
//		System.out.println("---start---"+start+"---end-"+end);
		// 定义参数
		Map param = new HashMap();
		param.put("_page_start", start);
		param.put("_page_end", end);
		param.put("_sortname", sortname);
		param.put("_sortorder", sortorder);
		param.put("building", building);

		@SuppressWarnings("unchecked")
//		List<Building>  list=sc.queryForList("Realtygis.BasicBuildingMultiQuery", building,start,pageNum);
		List<Building>  list=sc.queryForList("Realtygis.buildingfrommaplist", param);
		map.put("page", p);
		map.put("list", list);
		return new DataAndView(map, "map");
		
	}

}
