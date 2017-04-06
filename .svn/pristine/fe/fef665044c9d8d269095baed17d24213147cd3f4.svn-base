package com.originsys.realtygis.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.realtygis.domain.HouseHeightRange;

public class CityBuildingAreaTj extends BaseAction implements IGet{
	/**
	 * 类说明：全市历年完成的房屋建筑面积的统计
	 * @创建时间：2014年4月8日
	 * @作者：zhanglf
	 */
	public DataAndView<Map> execute(RequestAction ra)
			throws Exception {	
		String type=ra.getParameter("type");
		String surverStartDate=ra.getParameter("surverStartDate");
		String surverEndDate=ra.getParameter("surverEndDate");
		Map map=new HashMap();
		map.put("type",type );
		List yearList=new ArrayList();
		for(int k=Integer.parseInt(surverStartDate);k<=Integer.parseInt(surverEndDate);k++){
			yearList.add(k);
		}
		map.put("yearList",yearList );
		
		Map param=new HashMap();
		param.put("surverStartDate",surverStartDate );
		param.put("surverEndDate",surverEndDate );
		
		SqlMapClient sc=DataSource.getSqlMapInstance();//定义一个操作数据库的ibatis接口变量
		
		List survertype=(List)sc.queryForList("Realtygis.getCityBuildingSurverType");//获取测绘类型
		map.put("survertype",survertype );
		
		List surverarea=(List)sc.queryForList("Realtygis.getCityBuildingAreatj", param);//从数据库中按年按测绘类型获取全市的建筑面积
		
		List relist=new ArrayList();
		for(int i=0;i<survertype.size();i++){
			Map typeMap=new HashMap();
			typeMap.put("SURVERTYPE", survertype.get(i));
			List typeList=new ArrayList();
			for(int k=Integer.parseInt(surverStartDate);k<=Integer.parseInt(surverEndDate);k++){
				int a=0;
				for(int j=0;j<surverarea.size();j++){
					Map m=(Map) surverarea.get(j);
					BigDecimal bd=(BigDecimal) m.get("SURVERTYPE");
					
					if((bd.intValue())==((Integer)survertype.get(i))&&m.get("YEAR").equals(k+"")){
						if(m.get("AREA")!=null&&!"".equals(m.get("AREA"))){
							typeList.add(m);
						}else{
							Map tempMap=new HashMap();
							tempMap.put("YEAR", k);
							tempMap.put("AREA", 0);
							typeList.add(tempMap);
						}
						break;
					}else{
						a++;
					}
				}
				if(a==surverarea.size()){
					Map tempMap=new HashMap();
					tempMap.put("YEAR", k);
					tempMap.put("AREA", 0);
					typeList.add(tempMap);
				}
			}
			typeMap.put("TYPELIST", typeList);
			relist.add(typeMap);
		}
		
//		for(int b=0;b<relist.size();b++){
//			Map n=(Map) relist.get(b);
//			List l=(List) n.get("TYPELIST");
//			for(int c=0;c<l.size();c++){
//				Map obj=(Map) l.get(c);
//				System.out.println("------typelist-----"+obj.get("YEAR")+"----area---"+obj.get("AREA"));
//			}
//		}		
		
		map.put("relist", relist);

		return new DataAndView<Map>(map, "map");
}
}