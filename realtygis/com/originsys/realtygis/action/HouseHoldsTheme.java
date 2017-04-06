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
import com.originsys.realtygis.domain.HouseHeightRange;
import com.originsys.realtygis.domain.HouseHoldsArea;

public class HouseHoldsTheme extends BaseAction implements IGet {

	public DataAndView execute(RequestAction arg0) throws Exception {
		// TODO Auto-generated method stub
		SqlMapClient sc=DataSource.getSqlMapInstance();//定义一个操作数据库的ibatis接口变量
		//HouseHeightRange range=new HouseHeightRange();//定义一个量存储结果
		HouseHoldsArea harea=new HouseHoldsArea();
		harea.setFirstnum(Integer.parseInt(arg0.getParameter("firstnum")));
		harea.setNextnum(Integer.parseInt(arg0.getParameter("nextnum")));
		List<HouseHeightRange>households=(List)sc.queryForList("Realtygis.households", harea);//从数据库中选择以当前页的起始条数为起点，当前页面显示条数为长度的记录数
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("househeight",households);
		map.put("num", harea);
		return new DataAndView(map,"map");//返回结果
	}

}
