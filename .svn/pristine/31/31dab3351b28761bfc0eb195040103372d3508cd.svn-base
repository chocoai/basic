package com.originsys.realtygis.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.realtygis.domain.Building;
import com.originsys.realtygis.domain.HouseHeightRange;

public class HouseAreaTj extends BaseAction implements IGet{
	/**
	 * 类说明：指定楼幢面按照房屋建筑面积分类统计房屋数量
	 * @创建时间：2014年3月25日
	 * @作者：zhanglf
	 */
	public DataAndView<Map> execute(RequestAction ra)
			throws Exception {	
		String type=ra.getParameter("type");

		Map map=new HashMap();
		map.put("type",type );
		
		String building_mapid=ra.getParameter("building_mapid");
		String[] arr=building_mapid.split("\\,");
		List arrlist = Arrays.asList(arr);  		
//		for(int i=0;i<arrlist.size();i++){
//			System.out.println("----building_mapid---"+arrlist.get(i));
//		}
		
		String surver_type=ra.getParameter("surver_type");
		String small=ra.getParameter("small");
		String middle=ra.getParameter("middle");
		String big=ra.getParameter("big");
		map.put("small",small );
		map.put("middle",middle );
		map.put("big",big );
//		System.out.println("--柱状图---surver_type---"+surver_type+"----small----"+small+"---middle--"+middle+"----big----"+big);
		
		Building build = new Building();
		build.setArrlist(arrlist);	
//		if(null!=surver_type&&!"".equals(surver_type)){
//			build.setSurver_type(Integer.parseInt(surver_type));
//		}
		
		
		SqlMapClient sc=DataSource.getSqlMapInstance();
		
		List houseareatj=(List)sc.queryForList("Realtygis.getHouseAreatj", build);//从数据库中按年获取面积小于90平方米的
		
//		for(int j=0;j<houseareatj.size();j++){
//			Map m=(Map) houseareatj.get(j);
//			System.out.println("----mapid----"+m.get("ADDRESS")+"----count1----"+m.get("SMALLHOUSECOUNT")+"----2---"+m.get("HITHOUSECOUNT")+"----3---"+m.get("BIGHOUSECOUNT"));
//		}
		
		
		map.put("houseareatj", houseareatj);
				
		return new DataAndView<Map>(map, "map");
}
}