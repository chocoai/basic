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

public class BuildingBuildAreaTj extends BaseAction implements IGet{
	/**
	 * 类说明：安全检查各区县建筑面积统计
	 * @创建时间：2014年6月11日
	 * @作者：zhanglf
	 */
	public DataAndView<Map> execute(RequestAction ra)
			throws Exception {	
		SqlMapClient sc=DataSource.getSqlMapInstance();//定义一个操作数据库的ibatis接口变量
			
		List district=(List)sc.queryForList("Safecheck.getDistrict");//获取各区县
		List tmpResult=(List)sc.queryForList("Safecheck.getPcBuildAreaTj");//从数据库中按年获取各区县的套数
		
		Map map=new HashMap();
		List relist=new ArrayList();
		int darea=0;
		for(int i=0;i<district.size();i++){
			Map districtMap=new HashMap();
			districtMap.put("DISTRICT", district.get(i));
			if(darea<tmpResult.size()){
				Map m=(Map) tmpResult.get(darea);
				if(district.get(i).equals(m.get("DISTRICT"))){
					if(m.get("AREA")!=null&&!"".equals(m.get("AREA")))
						districtMap.put("AREA", m.get("AREA"));
					else
						districtMap.put("AREA", 0);
					darea++;
				}else{
					districtMap.put("AREA", 0);
				}
			}else{
				districtMap.put("AREA", 0);
			}
			relist.add(districtMap);
		}
		
		map.put("relist", relist);	
		
		return new DataAndView<Map>(map, "map");
}
}