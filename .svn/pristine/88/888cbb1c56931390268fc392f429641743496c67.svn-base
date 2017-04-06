package com.originsys.realtygis.action;

import java.text.SimpleDateFormat;
import java.sql.Date;
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


public class BuildingMultiQuery extends BaseAction implements IGet{
	/**
	 * 类说明：楼幢综合查询类
	 * @创建时间：2014-3-17
	 * @作者：洛佳明
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DataAndView<Map<String, List<Building>>> execute(RequestAction ra)
			throws Exception {	
		SqlMapClient sc=DataSource.getSqlMapInstance();
		
		Map map=new HashMap();
		Building building=new Building();
		
		if(ra.getParameter("building_datestart")==""||ra.getParameter("building_datestart")==null){
			building.setBuilding_datestart(0.0);
		}
		else{
			Double building_datestart = Double.parseDouble(ra.getParameter("building_datestart"));
			building.setBuilding_datestart(building_datestart);
		}
		if(ra.getParameter("building_dateend")==""||ra.getParameter("building_dateend")==null){
			building.setBuilding_dateend(0.0);
		}
		else{
			Double building_dateend = Double.parseDouble(ra.getParameter("building_dateend"));
			building.setBuilding_dateend(building_dateend);	
		}
		
		if(ra.getParameter("use_desgin")==""||ra.getParameter("use_desgin")==null){
			building.setUse_desgin(0);
		}
		else{
			Integer use_desgin = Integer.parseInt(ra.getParameter("use_desgin"));
			building.setUse_desgin(use_desgin);	
		}
		
		if(ra.getParameter("real_type")==""||ra.getParameter("real_type")==null){
			building.setReal_type(0);
		}
		else{
			Integer real_type = Integer.parseInt(ra.getParameter("real_type"));
			building.setReal_type(real_type);	
		}
		
		if(ra.getParameter("tn_areamin")==""||ra.getParameter("tn_areamin")==null){
			building.setTn_areamin(null);
		}
		else{
			Double tn_areamin = Double.parseDouble(ra.getParameter("tn_areamin"));
			building.setTn_areamin(tn_areamin);	
		}
		
		if(ra.getParameter("tn_areamax")==""||ra.getParameter("tn_areamax")==null){
			building.setTn_areamax(null);
		}
		else{
			Double tn_areamax = Double.parseDouble(ra.getParameter("tn_areamax"));
			building.setTn_areamax(tn_areamax);	
		}
		if(ra.getParameter("ft_areamin")==""||ra.getParameter("ft_areamin")==null){
			building.setFt_areamin(null);
		}
		else{
			Double ft_areamin = Double.parseDouble(ra.getParameter("ft_areamin"));
			building.setFt_areamin(ft_areamin);
		}
		if(ra.getParameter("ft_areamax")==""||ra.getParameter("ft_areamax")==null){
			building.setFt_areamax(null);
		}
		else{
			Double ft_areamax = Double.parseDouble(ra.getParameter("ft_areamax"));
			building.setFt_areamax(ft_areamax);
		}
		if(ra.getParameter("build_areamin")==""||ra.getParameter("build_areamin")==null){
			building.setBuild_areamin(null);
		}
		else{
			Double build_areamin = Double.parseDouble(ra.getParameter("build_areamin"));
			building.setBuild_areamin(build_areamin);
		}
		if(ra.getParameter("build_areamax")==""||ra.getParameter("build_areamax")==null){
			building.setBuild_areamax(null);
		}
		else{
			Double build_areamax = Double.parseDouble(ra.getParameter("build_areamax"));
			building.setBuild_areamax(build_areamax);
		}
		if(ra.getParameter("floor_countmin")==""||ra.getParameter("floor_countmin")==null){
			building.setFloor_countmin(null);
		}
		else{
			Integer floor_countmin = Integer.parseInt(ra.getParameter("floor_countmin"));
			building.setFloor_countmin(floor_countmin);
		}
		if(ra.getParameter("floor_countmax")==""||ra.getParameter("floor_countmax")==null){
			building.setFloor_countmax(null);
		}
		else{
			Integer floor_countmax = Integer.parseInt(ra.getParameter("floor_countmax"));
			building.setFloor_countmax(floor_countmax);
		}
		SimpleDateFormat sdf =
				new SimpleDateFormat("yyyy-MM-dd");
		
		if(ra.getParameter("surver_enddatemin")==""||ra.getParameter("surver_enddatemin")==null){
			building.setSurver_enddatemin(null);
		}
		else{
			//Date surver_enddatemin = sdf.parse(ra.getParameter("surver_enddatemin"));
			Date surver_enddatemin =new java.sql.Date(sdf.parse(ra.getParameter("surver_enddatemin")).getTime());
			building.setSurver_enddatemin((java.sql.Date)surver_enddatemin);
		}
		if(ra.getParameter("surver_enddatemax")==""||ra.getParameter("surver_enddatemax")==null){
			building.setSurver_enddatemax(null);
		}
		else{
			//Date surver_enddatemax = (java.sql.Date) sdf.parse(ra.getParameter("surver_enddatemax"));
			Date surver_enddatemax =new java.sql.Date(sdf.parse(ra.getParameter("surver_enddatemax")).getTime());
			building.setSurver_enddatemax((java.sql.Date)surver_enddatemax);
		}
		if(ra.getParameter("building_address")==""||ra.getParameter("building_address")==null){
			building.setBuilding_address(null);
		}
		else{
			String building_address = ra.getParameter("building_address");
			//String building_address = ra.getParameter("building_address");
			building.setBuilding_address(building_address);
		}
		if(ra.getParameter("entrust_unit")==""||ra.getParameter("entrust_unit")==null){
			building.setEntrust_unit(null);
		}
		else{
			String entrust_unit = ra.getParameter("entrust_unit");
			//String entrust_unit = ra.getParameter("entrust_unit");
			building.setEntrust_unit(entrust_unit);
		}
		
		if(ra.getParameter("build_struct")==""||ra.getParameter("build_struct")==null){
			building.setBuild_struct(0);
		}
		else{
			Integer build_struct = Integer.parseInt(ra.getParameter("build_struct"));
			building.setBuild_struct(build_struct);
		}
		
		if(ra.getParameter("surver_type")==""||ra.getParameter("surver_type")==null){
			building.setSurver_type(0);
		}
		else{
			Integer surver_type = Integer.parseInt(ra.getParameter("surver_type"));
			building.setSurver_type(surver_type);
		}
		
		if(ra.getParameter("graphics_code")==""||ra.getParameter("graphics_code")==null){
			building.setGraphics_code("0");
		}
		else{
			String graphics_code = ra.getParameter("graphics_code");
			building.setGraphics_code(graphics_code);
		}
		
		if(ra.getParameter("city_district")==""||ra.getParameter("city_district")==null){
			building.setCity_district(0);
		}
		else{
			Integer city_district = Integer.parseInt(ra.getParameter("city_district"));
			building.setCity_district(city_district);
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
		int totalnum=(Integer)sc.queryForObject("Realtygis.selectBasicBuildingCount", building);
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
		
//		List<Building>  list=sc.queryForList("Realtygis.BasicBuildingMultiQuery", building,start,pageNum);
		List<Building>  list=sc.queryForList("Realtygis.BasicBuildingMultiQuery", param);
		map.put("page", p);
		map.put("list", list);
		return new DataAndView(map, "map");
		
	}

}
