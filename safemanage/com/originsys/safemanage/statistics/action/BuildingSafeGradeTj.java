package com.originsys.safemanage.statistics.action;

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

public class BuildingSafeGradeTj extends BaseAction implements IGet{
	/**
	 * 类说明：安全检查各区县安全等级统计楼幢数
	 * @创建时间：2014年6月11日
	 * @作者：zhanglf
	 */
	public DataAndView<Map> execute(RequestAction ra)
			throws Exception {	
		SqlMapClient sc=DataSource.getSqlMapInstance();//定义一个操作数据库的ibatis接口变量
			
		List district=(List)sc.queryForList("Safecheck.getDistrict");//获取各区县
		
		List tmpResult=(List)sc.queryForList("Safecheck.getPcSafeGradeTj");//从数据库中按年获取各区县的套数
		
		Map map=new HashMap();
		List relist=new ArrayList();
		int safe=0;
		for(int j=1;j<=4;j++){
			Map districtMap=new HashMap();
			districtMap.put("SAFEGRADE", j);
			List districtList=new ArrayList();
			for(int i=0;i<district.size();i++){
				Map tempMap=new HashMap();
				if(safe<tmpResult.size()){
					Map m=(Map) tmpResult.get(safe);
					if(district.get(i).equals(m.get("DISTRICT")) && m.get("SAFEGRADE").equals(j+"")){
						if(m.get("COUNT")!=null&&!"".equals(m.get("COUNT"))){
							tempMap.put("COUNT", m.get("COUNT"));
							tempMap.put("DISTRICT", district.get(i));
						}else{
							tempMap.put("COUNT", 0);
							tempMap.put("DISTRICT", district.get(i));
						}
						safe++;
					}else{
						tempMap.put("COUNT", 0);
						tempMap.put("DISTRICT", district.get(i));
					}
				}else{
					tempMap.put("COUNT", 0);
					tempMap.put("DISTRICT", district.get(i));
				}
				
				districtList.add(tempMap);
			}
			districtMap.put("districtList", districtList);
			relist.add(districtMap);
		}
		
		map.put("relist", relist);	
		map.put("district", district);	
		
		return new DataAndView<Map>(map, "map");
}
}