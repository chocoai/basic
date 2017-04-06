package com.originsys.access.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.access.domain.Building;
import com.originsys.access.domain.QueryParames;

public class BuildingQueList extends BaseAction implements IData {

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
		String building1=arg0.getParameter("buildingnature");
		String building2=arg0.getParameter("buildingstructure");
		String building3=arg0.getParameter("buildingtype");
		String building4=arg0.getParameter("buildinguse");
		String buildingnature = null;
		String buildingstructure = null;
		String buildingfloortype = null;
		String buildingfloortypemin=null;
		String buildingfloortypemax=null;
		String buildinguse = null;
		//对传入的属性值是汉字的进行转换
		if(building1!=""){
			if(building1=="国有房产"){buildingnature="8100";}
			if(building1=="集体所有制"){buildingnature="8200";}
			if(building1=="私有房产"){buildingnature="8300";}
			if(building1=="其他房产"){buildingnature="8400";}
			if(building1=="股份制企业房产"){buildingnature="8500";}
			if(building1=="港、澳、台投资房产"){buildingnature="8600";}
			if(building1=="涉外房产"){buildingnature="8700";}
			if(building1=="联营企业房产"){buildingnature="8800";}
		}
		if(building2!=""){
			if(building2=="钢结构"){buildingstructure="1";}
			if(building2=="钢、钢混结构"){buildingstructure="2";}
			if(building2=="钢砼结构"){buildingstructure="3";}
			if(building2=="混合结构"){buildingstructure="4";}
			if(building2=="砖木结构"){buildingstructure="5";}
			if(building2=="木结构"){buildingstructure="6";}
			if(building2=="其他结构"){buildingstructure="7";}
		}
		if(building3!=""){
			if(building3=="平房"){buildingfloortype="1";}
			if(building3=="多层"){
				buildingfloortypemin="2";
				buildingfloortypemax="7";
			   }
			if(building3=="小高层"){
				buildingfloortypemin="8";
				buildingfloortypemax="12";
			}
			if(building3=="多层"){
				buildingfloortypemin="13";
			}
		}
		if(building4!=""){
			if(building4=="住宅"){buildinguse="1010";}
			if(building4=="非住宅"){buildinguse="1020";}
			if(building4=="商业服务"){buildinguse="1025";}
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
		List<Building> list=(List<Building>)sc.queryForList("Access.buildingmiltyquery", qp);
		//List<QueryParames> list=new ArrayList<QueryParames>();
		//list.add(qp);
		String callback=jsoncallback+"("+JSONArray.fromObject(list)+");"; 
	    out.print(callback); 
		
	}

}
