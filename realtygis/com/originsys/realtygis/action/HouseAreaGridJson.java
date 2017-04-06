package com.originsys.realtygis.action;

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
import com.originsys.realtygis.domain.House;

public class HouseAreaGridJson extends BaseAction implements IGet{
	/**
	 * 类说明：户面积查询结果jqGrid列表json类
	 * @创建时间：2013-12-30
	 * @作者：洛佳明
	 */
	private static final long serialVersionUID = 1L;
	public DataAndView<Map> execute(RequestAction ra)
			throws Exception {	
		SqlMapClient sc=DataSource.getSqlMapInstance();
		Map map=new HashMap();
		House hou=new House();
		String building_id=ra.getParameter("id");
		hou.setBuilding_id(building_id);
		if(ra.getParameter("min")==""||ra.getParameter("min")==null){
			hou.setJz_areamin(0.0);
		}
		else{
			Double jz_areamin = Double.parseDouble(ra.getParameter("min"));
			hou.setJz_areamin(jz_areamin);
		}
		if(ra.getParameter("max")==""||ra.getParameter("max")==null){
			hou.setJz_areamax(0.0);
		}
		else{
			Double jz_areamax = Double.parseDouble(ra.getParameter("max"));
			hou.setJz_areamax(jz_areamax);	
		}
		//获取地址参数
				if(!"".equals(ra.getParameter("fw_address"))||ra.getParameter("fw_address")!=null){
					String tmp = new String(ra.getParameter("fw_address").getBytes("ISO8859_1"),"utf-8");
					hou.setFw_address(tmp);
				}
				//获得当前页数
				String currentPage=ra.getParameter("page");
				//获得起始条数
				int start=0;		
				//TODO 获得每页显示的条数
				int pageNum=10;
				  if(ra.getParameter("rows")!=null)
					pageNum=Integer.parseInt(ra.getParameter("rows"));
				  else
					pageNum=10;
				pageNum=(pageNum==0)?10:pageNum;
				int totalnum=(Integer)sc.queryForObject("Realtygis.selectHouseCount", hou);
				//获得总页数
				int totalpage=totalnum%pageNum==0?totalnum/pageNum:(totalnum/pageNum+1);
				//获得当前页
				int currentNum=1;
				if(currentPage!=null && !"".equals(currentPage)){
					currentNum=Integer.parseInt(currentPage);
				}
				//重新设置起始条数
				start=(currentNum-1)*pageNum;
				//返回到页面总页数和当前页数
				Page p=new Page(totalpage, currentNum, totalnum);
				
				@SuppressWarnings("unchecked")
				List<House>  list=sc.queryForList("Realtygis.houseareagrid", hou,start,pageNum);
				map.put("page", p);
				map.put("list", list);
		return new DataAndView<Map>(map, "map");
	}

}
