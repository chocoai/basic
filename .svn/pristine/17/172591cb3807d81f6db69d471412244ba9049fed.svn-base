package com.originsys.access.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.realtygis.domain.Building;
import com.originsys.realtygis.domain.House;

public class BuildingQueryFromSurvey  extends BaseAction implements IData{
	public void execute(RequestAction arg0, HttpServletResponse response) throws Exception {
	String arrayString="";
    response.setContentType("application/javascript");  
    response.setHeader("P3P","CP=\"CURa ADMa DEVa PSAo PSDo OUR BUS UNI PUR INT DEM STA PRE COM NAV OTC NOI DSP COR\"");  
    response.setCharacterEncoding("utf-8");  
    PrintWriter out = response.getWriter();  
	String jsoncallback = arg0.getParameter("jsoncallback");
	SqlMapClient sc=DataSource.getSqlMapInstance();
	Map map=new HashMap();
	Building eo=new Building();
	String building_mapid = arg0.getParameter("id");
	eo.setBuilding_mapid(building_mapid);
	if(!"".equals(building_mapid)||building_mapid!=null){
		map.put("id",building_mapid);
	}	
	List<Building>  list=(List<Building>)sc.queryForList("Access.buildinglist", eo);	
	String callback=jsoncallback+"("+JSONArray.fromObject(list)+");"; 
    out.print(callback); 
}

}
