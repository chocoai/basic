package com.originsys.realtygis.action;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.domain.Page;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.realtygis.domain.Building;


public class BufferAnalysisCount extends BaseAction implements IGet{
	/**
	 * 类说明：缓冲分析结果统计类
	 * @创建时间：2014-4-8
	 * @作者：洛佳明
	 */
	private static final long serialVersionUID = 1L;
	public DataAndView<Map<String, List>> execute(RequestAction ra)
			throws Exception {	
		
		SqlMapClient sc=DataSource.getSqlMapInstance();
		Map map=new HashMap();
		Building building=new Building();

		String fea=ra.getParameter("fea");
		String[] arr=fea.split("\\,");
		List arrlist = Arrays.asList(arr);  
		building.setArrlist(arrlist);			
		
		@SuppressWarnings("unchecked")
//		List<Building>  list=sc.queryForList("Realtygis.BasicBuildingMultiQuery", building,start,pageNum);
		List  list=sc.queryForList("Realtygis.bufferAnalysistj", building);
		map.put("list", list);
		return new DataAndView(map, "map");
		
	}

}
