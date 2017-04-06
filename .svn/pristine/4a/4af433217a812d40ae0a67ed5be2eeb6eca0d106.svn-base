package com.originsys.access.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.access.domain.Building;
import com.originsys.access.domain.QueryParames;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.access.domain.HouseHeightRange;

public class buildingmiltygetnum extends BaseAction implements IData{
	public void execute(RequestAction arg0, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		String arrayString="";
	    response.setContentType("application/javascript");  
	    response.setHeader("P3P","CP=\"CURa ADMa DEVa PSAo PSDo OUR BUS UNI PUR INT DEM STA PRE COM NAV OTC NOI DSP COR\"");  
	    response.setCharacterEncoding("utf-8");  
	    PrintWriter out = response.getWriter();  
		String jsoncallback = arg0.getParameter("jsoncallback");
		SqlMapClient sc=DataSource.getSqlMapInstance();
		QueryParames qp=new QueryParames();
		String area=arg0.getParameter("area");
		String areamax=arg0.getParameter("areamax");
		String areamin=arg0.getParameter("areamin");
		String buildingdata=arg0.getParameter("buildingdata");
		String buildingdatamin=arg0.getParameter("buildingdatamin");
		String buildingdatamax=arg0.getParameter("buildingdatamax");
		String floor=arg0.getParameter("floor");
		String floormax=arg0.getParameter("floormax");
		String floormin=arg0.getParameter("floormin");
		String building2=arg0.getParameter("buildingstructure");
		String buildingnature = null;
		String buildingstructure = null;
		String buildingfloortype = null;
		String buildingfloortypemin=null;
		String buildingfloortypemax=null;
		String buildinguse = null;
		//对传入的属性值是汉字的进行转换
		if(building2!=""){
			if(building2=="钢结构"){buildingstructure="1";}
			if(building2=="钢、钢混结构"){buildingstructure="2";}
			if(building2=="钢砼结构"){buildingstructure="3";}
			if(building2=="混合结构"){buildingstructure="4";}
			if(building2=="砖木结构"){buildingstructure="5";}
			if(building2=="木结构"){buildingstructure="6";}
			if(building2=="其他结构"){buildingstructure="7";}
		}
		qp.setArea(area);
		qp.setAreamax(areamax);
		qp.setAreamin(areamin);
		qp.setBuildingdata(buildingdata);
		qp.setBuildingdatamax(buildingdatamax);
		qp.setBuildingdatamin(buildingdatamin);
		qp.setBuildingnature(buildingnature);
		qp.setBuildingstructure(buildingstructure);
		qp.setBuildingfloortype(buildingfloortype);
		qp.setBuildingfloortypemax(buildingfloortypemax);
		qp.setBuildingfloortypemin(buildingfloortypemin);
		qp.setBuildinguse(buildinguse);
		qp.setFloor(floor);
		qp.setFloormax(floormax);
		qp.setFloormin(floormin);
		List<HouseHeightRange> list=(List<HouseHeightRange>)sc.queryForList("Access.buildingmiltygetnum", qp);
		//List<QueryParames> list=new ArrayList<QueryParames>();
		//list.add(qp);
		HouseHeightRange house=(HouseHeightRange) list.get(0);
		house.range_name="查询结果";
		String callback=jsoncallback+"("+JSONArray.fromObject(list)+");"; 
	    out.print(callback); 
		 
	}
}
