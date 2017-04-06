package com.originsys.realtygis.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.realtygis.domain.House;

/**
 auth:boy 2014-2-12
   描述：根据房屋编号获得房屋信息
 */
public class HouseDetail extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		String house_id=ra.getParameter("house_id");
		House house=(House)sc.queryForObject("Realtygis.housedetail", house_id);
		if(house==null)
			house=new House();
		JSONObject obj = new JSONObject();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("fw_dh",house.getFw_dh());
		map.put("fw_address",house.getFw_address());
		map.put("unit_number",house.getUnit_number());
		map.put("room_number",house.getRoom_number());
		map.put("lay_num",house.getLay_num());
		obj.putAll(map);
		house=null;
		map=null;
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.print(obj);		
	}

}
