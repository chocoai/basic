package com.originsys.safemanage.safecheck.action;

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

public class SurveyHouseCountTj extends BaseAction implements IGet{
	/**
	 * 类说明：楼幢普查各区县楼幢数统计
	 * @创建时间：2014年6月4日
	 * @作者：zhanglf
	 */
	public DataAndView<Map> execute(RequestAction ra)
			throws Exception {	
		SqlMapClient sc=DataSource.getSqlMapInstance();//定义一个操作数据库的ibatis接口变量
			
		List district=(List)sc.queryForList("Safecheck.getDistrict");//获取各区县
//		for(int i=0;i<district.size();i++){
//			System.out.println("----district---"+district.get(i));
//		}
		List tmpResult=(List)sc.queryForList("Safecheck.getHouseCountTj");//从数据库中获取各区县的套数
		
		Map map=new HashMap();
		List relist=new ArrayList();
		int dcount=0;
		for(int i=0;i<district.size();i++){
			Map districtMap=new HashMap();
			districtMap.put("DISTRICT", district.get(i));
			if(dcount<tmpResult.size()){
				Map m=(Map) tmpResult.get(dcount);
	//			System.out.println("----district---"+district.get(i).getClass()+"----m.district---"+m.get("DISTRICT").getClass());
				if(district.get(i).equals(m.get("DISTRICT"))){
					if(m.get("COUNT")!=null&&!"".equals(m.get("COUNT")))
						districtMap.put("COUNT", m.get("COUNT"));
					else
						districtMap.put("COUNT", 0);
					dcount++;
				}else{
					districtMap.put("COUNT", 0);
				}
			}else{
				districtMap.put("COUNT", 0);
			}
			relist.add(districtMap);
		}
//		for(int i=0;i<relist.size();i++){
//			Map m=(Map) relist.get(i);
//			System.out.println("---count---"+m.get("COUNT")+"----district---"+m.get("DISTRICT"));
//		}
		map.put("relist", relist);	
		
		return new DataAndView<Map>(map, "map");
}
}