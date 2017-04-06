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

public class AuthBuildAreaHz extends BaseAction implements IGet{
	/**
	 * 类说明：安全鉴定各区县建筑面积汇总
	 * @创建时间：2014年6月11日
	 * @作者：zhanglf
	 */
	public DataAndView<Map> execute(RequestAction ra)
			throws Exception {	
		SqlMapClient sc=DataSource.getSqlMapInstance();//定义一个操作数据库的ibatis接口变量
			
		List district=(List)sc.queryForList("Safecheck.getDistrict");//获取各区县

		List tmpResult=(List)sc.queryForList("Safecheck.getJdBuildAreaHz");//从数据库中按年获取各区县的楼幢数
		
		List totalResult=(List)sc.queryForList("Safecheck.getJdBuildAreaGradeHz");//从数据库中按年获取各等级楼幢数
		
		Map map=new HashMap();
		List relist=new ArrayList();
		int dAREA=0;
		for(int i=0;i<district.size();i++){
			Map districtMap=new HashMap();
			districtMap.put("DISTRICT", district.get(i));
			List districtList=new ArrayList();
			double totalAREA=0;
			for(int j=1;j<=4;j++){
				Map tempMap=new HashMap();
				if(dAREA<tmpResult.size()){
					Map m=(Map) tmpResult.get(dAREA);
					if(district.get(i).equals(m.get("DISTRICT")) && m.get("SAFEGRADE").equals(j+"")){
						if(m.get("AREA")!=null&&!"".equals(m.get("AREA"))){
							tempMap.put("AREA", m.get("AREA"));
							tempMap.put("SAFEGRADE", j);
							BigDecimal bd=(BigDecimal) m.get("AREA");
							totalAREA += bd.doubleValue();
						}else{
							tempMap.put("AREA", 0);
							tempMap.put("SAFEGRADE", j);
						}
						dAREA++;
					}else{
						tempMap.put("AREA", 0);
						tempMap.put("SAFEGRADE", j);
					}
				}else{
					tempMap.put("AREA", 0);
					tempMap.put("SAFEGRADE", j);
				}
				districtList.add(tempMap);
				districtMap.put("DISTRICTAREA", totalAREA);
			}
			districtMap.put("districtList", districtList);
			relist.add(districtMap);
		}
		double totalAREA=0;
		int scount=0;
		List countlist=new ArrayList();
		for(int i=1;i<5;i++){
			Map countMap=new HashMap();
			countMap.put("SAFEGRADE", i);
			List countList=new ArrayList();
			if(scount<totalResult.size()){
				Map m=(Map) totalResult.get(scount);
				if(m.get("SAFEGRADE").equals(i+"")){
					if(m.get("AREA")!=null&&!"".equals(m.get("AREA"))){
						countMap.put("AREA", m.get("AREA"));
						BigDecimal bd=(BigDecimal) m.get("AREA");
//						totalAREA += bd.intValue();
						totalAREA += bd.doubleValue();
					}else{
						countMap.put("AREA", 0);
					}
					scount++;
				}else{
					countMap.put("AREA", 0);
				}
			}else{
				countMap.put("AREA", 0);
			}
			countlist.add(countMap);
		}
		
		String current_time=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		map.put("current_time", current_time);
		map.put("relist", relist);
		map.put("totallist", countlist);
		map.put("totalarea", totalAREA);
		
		return new DataAndView<Map>(map, "map");
}
}