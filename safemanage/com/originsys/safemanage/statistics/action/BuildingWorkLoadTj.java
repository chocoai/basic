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

public class BuildingWorkLoadTj extends BaseAction implements IGet{
	/**
	 * 类说明：安全检查工作量统计
	 * @创建时间：2014年6月11日
	 * @作者：zhanglf
	 */
	public DataAndView<Map> execute(RequestAction ra)
			throws Exception {	
		 String start_time = ra.getParameter("start_time");
		    String end_time = ra.getParameter("end_time");

		    Map param = new HashMap();
		    if ((start_time != null) && (!"".equals(start_time))) {
		      param.put("start_time", start_time);
		    }
		    if ((end_time != null) && (!"".equals(end_time))) {
		      param.put("end_time", end_time);
		    }

		    SqlMapClient sc = DataSource.getSqlMapInstance();

		    List district = sc.queryForList("Safecheck.getDistrict");
		    List tmpResult = sc.queryForList("Safecheck.getPcWorkLoadTj", param);

		    Map map = new HashMap();
		    List relist = new ArrayList();
		    int dcount = 0;
		    for (int i = 0; i < district.size(); i++) {
		      Map districtMap = new HashMap();
		      districtMap.put("DISTRICT", district.get(i));
		      if (dcount < tmpResult.size()) {
		        Map m = (Map)tmpResult.get(dcount);
		        if (district.get(i).equals(m.get("DISTRICT"))) {
		          if ((m.get("COUNT") != null) && (!"".equals(m.get("COUNT"))))
		            districtMap.put("COUNT", m.get("COUNT"));
		          else
		            districtMap.put("COUNT", Integer.valueOf(0));
		          dcount++;
		        } else {
		          districtMap.put("COUNT", Integer.valueOf(0));
		        }
		      } else {
		        districtMap.put("COUNT", Integer.valueOf(0));
		      }
		      relist.add(districtMap);
		    }

		    map.put("relist", relist);
		    map.put("start_time", start_time);
		    map.put("end_time", end_time);

		    return new DataAndView(map, "map");
}
}