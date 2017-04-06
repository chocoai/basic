package com.originsys.realtygis.action;

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
import com.originsys.realtygis.domain.House;

public class BuildingListGridJson extends BaseAction implements IGet{
	/**
	 * 类说明：房屋面积查询类
	 * @创建时间：2013-12-17
	 * @作者：洛佳明
	 */
	private static final long serialVersionUID = 1L;
	public DataAndView<Map<String, List<House>>> execute(RequestAction ra)
			throws Exception {	
		SqlMapClient sc=DataSource.getSqlMapInstance();
		Map map=new HashMap();
		House hou=new House();
		if(ra.getParameter("min")==""||ra.getParameter("min")==null){
			hou.setJz_areamin(0.0);
		}
		else{
			Double jz_areamin = Double.parseDouble(ra.getParameter("min"));
			hou.setJz_areamin(jz_areamin);
		}
		if(ra.getParameter("max")==""||ra.getParameter("max")==null){
			hou.setJz_areamax(0.0);
		}
		else{
			Double jz_areamax = Double.parseDouble(ra.getParameter("max"));
			hou.setJz_areamax(jz_areamax);	
		}
		if(ra.getParameter("buildingdate")==""||ra.getParameter("buildingdate")==null){
			hou.setBuilding_date_start(0);
		}
		else{
			Integer building_date_start = Integer.parseInt(ra.getParameter("buildingdate"));
			hou.setBuilding_date_start(building_date_start);
		}
		if(ra.getParameter("buildingdate2")==""||ra.getParameter("buildingdate2")==null){
			hou.setBuilding_date_end(0);
		}
		else{
			Integer building_date_end = Integer.parseInt(ra.getParameter("buildingdate2"));
			hou.setBuilding_date_end(building_date_end);
		}
		if(ra.getParameter("floormin")==""||ra.getParameter("floormin")==null){
			hou.setFloor_countmin(0);
		}
		else{
			Integer floor_countmin = Integer.parseInt(ra.getParameter("floormin"));
			hou.setFloor_countmin(floor_countmin);
		}
		if(ra.getParameter("floormax")==""||ra.getParameter("floormax")==null){
			hou.setFloor_countmax(0);
		}
		else{
			Integer floor_countmax = Integer.parseInt(ra.getParameter("floormax"));
			hou.setFloor_countmax(floor_countmax);
		}
		//获取地址参数
		if(!"".equals(ra.getParameter("building_address"))||ra.getParameter("building_address")!=null){
			String tmp = new String(ra.getParameter("building_address").getBytes("ISO8859_1"),"utf-8");
			hou.setBuilding_address(tmp);
		}
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
		int totalnum=(Integer)sc.queryForObject("Realtygis.selectBuildingCount", hou);
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
		Page p=new Page(totalpage, currentNum, totalnum);
		
		@SuppressWarnings("unchecked")
		List<House>  list=sc.queryForList("Realtygis.buildingarealist", hou,start,pageNum);
		map.put("page", p);
		map.put("list", list);
		return new DataAndView(map, "map");
		
	}

}
