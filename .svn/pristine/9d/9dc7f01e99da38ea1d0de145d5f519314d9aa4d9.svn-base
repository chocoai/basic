package com.originsys.safemanage.safecheck.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.BuildingSurvey;



public class BuildingCommonQuery  extends BaseAction implements IGet{
	/**
	 * 类说明：房屋普查通用条件查询类
	 * @创建时间：2014-6-5
	 * @作者：洛佳明
	 */
	private static final long serialVersionUID = 1L;
	public DataAndView<Map<String, List<BuildingSurvey>>> execute(RequestAction ra)
			throws Exception {	
		SqlMapClient sc=DataSource.getSqlMapInstance();
		Map<String, List<BuildingSurvey>> map=new HashMap<String, List<BuildingSurvey>>();
		BuildingSurvey building=new BuildingSurvey();
		
		if(ra.getParameter("building_datestart")==""||ra.getParameter("building_datestart")==null){
			building.setBuilding_datestart(null);
		}
		else{
			Double building_datestart = Double.parseDouble(ra.getParameter("building_datestart"));
			building.setBuilding_datestart(building_datestart);
		}
		if(ra.getParameter("building_dateend")==""||ra.getParameter("building_dateend")==null){
			building.setBuilding_dateend(null);
		}
		else{
			Double building_dateend = Double.parseDouble(ra.getParameter("building_dateend"));
			building.setBuilding_dateend(building_dateend);	
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

		if(ra.getParameter("building_address")==""||ra.getParameter("building_address")==null){
			building.setBuilding_address(null);
		}
		else{
			String building_address = ra.getParameter("building_address");
			building.setBuilding_address(building_address);
		}
		if(ra.getParameter("building_holder")==""||ra.getParameter("building_holder")==null){
			building.setBuilding_holder(null);
		}
		else{
			String building_holder = ra.getParameter("building_holder");
			building.setBuilding_holder(building_holder);
		}
		if(ra.getParameter("building_manager_name")==""||ra.getParameter("building_manager_name")==null){
			building.setBuilding_manager_name(null);
		}
		else{
			String building_manager_name = ra.getParameter("building_manager_name");
			building.setBuilding_manager_name(building_manager_name);
		}
		if(ra.getParameter("build_dept")==""||ra.getParameter("build_dept")==null){
			building.setBuild_dept(null);
		}
		else{
			String build_dept = ra.getParameter("build_dept");
			building.setBuild_dept(build_dept);
		}
		if(ra.getParameter("design_dept")==""||ra.getParameter("design_dept")==null){
			building.setDesign_dept(null);
		}
		else{
			String design_dept = ra.getParameter("design_dept");
			building.setDesign_dept(design_dept);
		}
		if(ra.getParameter("construct_dept")==""||ra.getParameter("construct_dept")==null){
			building.setConstruct_dept(null);
		}
		else{
			String construct_dept = ra.getParameter("construct_dept");
			building.setConstruct_dept(construct_dept);
		}
		if(ra.getParameter("build_struct")==""||ra.getParameter("build_struct")==null){
			building.setBuild_struct(null);
		}
		else{
			String build_struct = ra.getParameter("build_struct");
			building.setBuild_struct(build_struct);
		}
		if(ra.getParameter("upon_type")==""||ra.getParameter("upon_type")==null){
			building.setUpon_type(null);
		}
		else{
			String upon_type = ra.getParameter("upon_type");
			building.setUpon_type(upon_type);
		}
		if(ra.getParameter("wm_type")==""||ra.getParameter("wm_type")==null){
			building.setWm_type(null);
		}
		else{
			String wm_type = ra.getParameter("wm_type");
			building.setWm_type(wm_type);
		}
		if(ra.getParameter("building_properties")==""||ra.getParameter("building_properties")==null){
			building.setBuilding_properties(null);
		}
		else{
			String building_properties = ra.getParameter("building_properties");
			building.setBuilding_properties(building_properties);
		}
		if(ra.getParameter("building_safecondition")==""||ra.getParameter("building_safecondition")==null){
			building.setBuilding_safecondition(null);
		}
		else{
			String building_safecondition = ra.getParameter("building_safecondition");
			building.setBuilding_safecondition(building_safecondition);
		}
		/**如果是安全普查员，则增加填写人的过滤条件*/
		if(ra.getUser()!=null){
			List<String> rolelist=ra.getUser().getRoleList();
			String pcy_roleid="safepc";//普查员
			String pcy_roleid1="surveychecker";//市局安全普查员
			boolean flag=false;
			if(rolelist!=null){
				for(String roleid:rolelist){
					if(pcy_roleid.equals(roleid)||pcy_roleid1.equals(roleid)){
						flag=true;
						break;
					}
				}
			}
			if(flag){
				building.setReport_userid(ra.getUser().getMem_id());
			}
		}

		// 定义参数
		Map param = new HashMap();
		param.put("building", building);

		@SuppressWarnings("unchecked")
//		List<Building>  list=sc.queryForList("Realtygis.BasicBuildingMultiQuery", building,start,pageNum);
		List<BuildingSurvey>  list=sc.queryForList("Safecheck.BuildingCommonMultiQuery", param);
		map.put("list", list);
		return new DataAndView(map, "map");
		
	}

}
