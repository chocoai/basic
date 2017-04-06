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
import com.originsys.realtygis.domain.MapVersion;

public class MapVersionGrid extends BaseAction implements IGet{
	/**
	 * 类说明：地图版本号查询结果jqGrid列表类
	 * @创建时间：2014-1-7
	 * @作者：洛佳明
	 */
	private static final long serialVersionUID = 1L;
	public DataAndView<Map> execute(RequestAction ra)
			throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		Map map=new HashMap();
		MapVersion version =new MapVersion();
		
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
		int totalnum=(Integer)sc.queryForObject("Realtygis.selectVersionCount", version);
		int end=totalnum;
		//获得总页数
		int totalpage=totalnum%pageNum==0?totalnum/pageNum:(totalnum/pageNum+1);
		//获得当前页
		int currentNum=1;
		if(currentPage!=null && !"".equals(currentPage)){
			currentNum=Integer.parseInt(currentPage);
		}
		//重新设置起始条数
		start=(currentNum-1)*pageNum;
		end=start+pageNum;
		//返回到页面总页数和当前页数
		Page p=new Page(totalpage, currentNum, totalnum);
		
		// 排序字段+排序方式
		String sortname=ra.getParameter("sidx");
		if (sortname == null || "".equals(sortname)) {
			sortname = "version_number";
		}
		String sortorder= ra.getParameter("sord");
		if (sortorder == null || "".equals(sortorder)) {
			sortorder = "asc";
		}
		// 定义参数
		Map param = new HashMap();
		param.put("_page_start", start);
		param.put("_page_end", end);
		param.put("_sortname", sortname);
		param.put("_sortorder", sortorder);
		param.put("version", version);
				
		@SuppressWarnings("unchecked")
//		List<MapVersion>  list=sc.queryForList("Realtygis.mapversiongrid", version,start,pageNum);
		List<MapVersion>  list=sc.queryForList("Realtygis.mapversiongrid", param);
		
		map.put("page", p);
		map.put("list", list);
		return new DataAndView<Map>(map, "map");
	}

}
