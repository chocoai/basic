package com.originsys.realtygis.action;

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
import com.originsys.realtygis.domain.CountyLZCountAndAreaBean;
import com.originsys.realtygis.domain.MapVersion;

public class CountyLZCountAndArea extends BaseAction implements IGet {

	
	public DataAndView execute(RequestAction arg0) throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		Map map=new HashMap();
//		Map m = new HashMap();
//		m.put("name","历下区");
//		m.put("count","5678");
//		m.put("area","38729");
//		list.add(m);
		//查询出济南所有的区县名称和代码
		List<CountyLZCountAndAreaBean>  county = sc.queryForList("Realtygis.queryCounty");
		//统计各区县房屋数量和面积
		List<CountyLZCountAndAreaBean>  list = sc.queryForList("Realtygis.queryCountyLZCountAndArea");
		//用来存放没有统计出数量和面积的区县
		List<CountyLZCountAndAreaBean>  temp = new ArrayList<CountyLZCountAndAreaBean>();
		
		for(CountyLZCountAndAreaBean bee : county){
			String code = bee.getCode();
			String name = bee.getName();
			boolean flag = true;
			for(CountyLZCountAndAreaBean been : list){
				String code1 = been.getCode();
				if(been.getCount()==null){
					been.setCount("0");
				}
				if(been.getArea()==null){
					been.setArea("0");
				}
				if(code.equals(code1)){
					flag=false;
				}
			}
			if(flag){
				//list中不包含该条county信息，则增加此条信息
				CountyLZCountAndAreaBean b = new CountyLZCountAndAreaBean(code,name,"0","0");
				temp.add(b);
			}
		}

		list.addAll(temp);
		map.put("list", list);
		return new DataAndView<Map>(map, "map");
	}

}
