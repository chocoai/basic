package com.originsys.safemanage.statistics.action;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

public class DangerousTj extends BaseAction implements IGet{
	/**
	 * 类说明：隐患房屋综合统计
	 * @创建时间：2014年6月12日
	 * @作者：zhanglf
	 */
	public DataAndView<Map> execute(RequestAction ra)
			throws Exception {	
		SqlMapClient sc=DataSource.getSqlMapInstance();//定义一个操作数据库的ibatis接口变量
			
		List district=(List)sc.queryForList("Safecheck.getDistrict");//获取各区县

		List tmpResult=(List)sc.queryForList("Safecheck.getJdHouseCountHz");//从数据库中获取各区县鉴定的楼幢数
		List tmpResult1=(List)sc.queryForList("Safecheck.getPcHouseCountHz");//从数据库中获取各区县检查的楼幢数
		
		List totalResult=(List)sc.queryForList("Safecheck.getJdHouseCountGradeHz");//从数据库中获取各等级鉴定的楼幢数
		List totalResult1=(List)sc.queryForList("Safecheck.getPcHouseCountGradeHz");//从数据库中获取各等级检查的楼幢数
		Map map=new HashMap();
		List relist=new ArrayList();
		int dcount=0,dcount1=0;
		for(int i=0;i<district.size();i++){
			Map districtMap=new HashMap();
			districtMap.put("DISTRICT", district.get(i));
			List districtList=new ArrayList();
			int totalcount=0;
			for(int j=1;j<=4;j++){
				Map tempMap=new HashMap();
				if(dcount<tmpResult.size()){
					Map m=(Map) tmpResult.get(dcount);
					if(district.get(i).equals(m.get("DISTRICT")) && m.get("SAFEGRADE").equals(j+"")){
						if(j!=1){
							if(m.get("COUNT")!=null&&!"".equals(m.get("COUNT"))){
								tempMap.put("COUNT", m.get("COUNT"));
								tempMap.put("SAFEGRADE", j);
								BigDecimal bd=(BigDecimal) m.get("COUNT");
								totalcount += bd.intValue();
							}else{
								tempMap.put("COUNT", 0);
								tempMap.put("SAFEGRADE", j);
							}
						}
						dcount++;
					}else{
						tempMap.put("COUNT", 0);
						tempMap.put("SAFEGRADE", j);
					}
				}else{
					tempMap.put("COUNT", 0);
					tempMap.put("SAFEGRADE", j);
				}
				if(j!=1){
					districtList.add(tempMap);
				}
			}
			
			for(int j=1;j<=4;j++){
				Map tempMap=new HashMap();
				if(dcount1<tmpResult1.size()){
					Map m=(Map) tmpResult1.get(dcount1);
					if(district.get(i).equals(m.get("DISTRICT")) && m.get("SAFEGRADE").equals(j+"")){
						if(j!=1){
							if(m.get("COUNT")!=null&&!"".equals(m.get("COUNT"))){
								tempMap.put("COUNT", m.get("COUNT"));
								tempMap.put("SAFEGRADE", j);
								BigDecimal bd=(BigDecimal) m.get("COUNT");
								totalcount += bd.intValue();
							}else{
								tempMap.put("COUNT", 0);
								tempMap.put("SAFEGRADE", j);
							}
						}
						dcount1++;
					}else{
						tempMap.put("COUNT", 0);
						tempMap.put("SAFEGRADE", j);
					}
				}else{
					tempMap.put("COUNT", 0);
					tempMap.put("SAFEGRADE", j);
				}
				if(j!=1){
					districtList.add(tempMap);
				}
			}
			districtMap.put("DISTRICTCOUNT", totalcount);
			districtMap.put("districtList", districtList);
			relist.add(districtMap);
		}
		
		int totalcount=0,scount=0,scount1=0;
		List countlist=new ArrayList();
		for(int i=1;i<5;i++){
			Map countMap=new HashMap();
			countMap.put("SAFEGRADE", i);
			List countList=new ArrayList();
			if(scount<totalResult.size()){
				Map m=(Map) totalResult.get(scount);
				if(m.get("SAFEGRADE").equals(i+"")){
					if(i!=1){
						if(m.get("COUNT")!=null&&!"".equals(m.get("COUNT"))){
							countMap.put("COUNT", m.get("COUNT"));
							BigDecimal bd=(BigDecimal) m.get("COUNT");
							totalcount += bd.intValue();
						}else{
							countMap.put("COUNT", 0);
						}
					}
					scount++;
				}else{
					countMap.put("COUNT", 0);
				}
			}else{
				countMap.put("COUNT", 0);
			}
			if(i!=1){
				countlist.add(countMap);
			}
		}
		for(int i=1;i<5;i++){
			Map countMap=new HashMap();
			countMap.put("SAFEGRADE", i);
			List countList=new ArrayList();
			if(scount1<totalResult1.size()){
				Map m=(Map) totalResult1.get(scount1);
				if(m.get("SAFEGRADE").equals(i+"")){
					if(i!=1){
						if(m.get("COUNT")!=null&&!"".equals(m.get("COUNT"))){
							countMap.put("COUNT", m.get("COUNT"));
							BigDecimal bd=(BigDecimal) m.get("COUNT");
							totalcount += bd.intValue();
						}else{
							countMap.put("COUNT", 0);
						}
					}
					scount1++;
				}else{
					countMap.put("COUNT", 0);
				}
			}else{
				countMap.put("COUNT", 0);
			}
			if(i!=1){
				countlist.add(countMap);
			}
		}
		
		
		String current_time=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		map.put("current_time", current_time);
		map.put("relist", relist);
		map.put("totallist", countlist);
		map.put("totalcount", totalcount);
		
		return new DataAndView<Map>(map, "map");
}
}