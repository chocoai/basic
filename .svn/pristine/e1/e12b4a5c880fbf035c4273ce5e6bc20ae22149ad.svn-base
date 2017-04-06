package com.originsys.safemanage.unit.action;

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
import com.originsys.safemanage.domain.TBuildingUnit;
import java.text.SimpleDateFormat;

/**
 * @author boy Email:
 * @version 1.0 创建时间： 类说明：安全责任单位编辑列表页
 */
public class TBuildingUnitList extends BaseAction implements IGet {

	public DataAndView<Map> execute(RequestAction ra) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		/** 组织查询条件对象 */
		TBuildingUnit tBuildingUnit = new TBuildingUnit();
		tBuildingUnit.setUnit_name(ra.getParameter("unit_name_select"));// String:安全责任单位名称
		tBuildingUnit.setUnit_type(ra.getParameter("unit_type_select"));// String:安全责任单位类型
		tBuildingUnit.setCity_district(ra.getParameter("city_district_select"));// String:所属区域
		tBuildingUnit.setReview_state(ra.getParameter("review_state_select"));// String:审核状态
		/** 获取ibatis执行 */
		SqlMapClient sc = DataSource.getSqlMapInstance();
		// 获得起始条数
		int start = 0;
		// 获得每页显示的条数
		int pageNum = 10;
		if (ra.getParameter("rows") != null) {
			pageNum = Integer.parseInt(ra.getParameter("rows"));
		} else {
			pageNum = 10;
		}
		pageNum = (pageNum == 0) ? 10 : pageNum;
		// 获取总条数
		int totalnum = (Integer) sc.queryForObject(
				"Safecheck.getTBuildingUnitCount", tBuildingUnit);
		// 获得总页数
		int totalpage = totalnum % pageNum == 0 ? totalnum / pageNum
				: (totalnum / pageNum + 1);
		// 获得当前页
		String currentPage = ra.getParameter("page");
		int currentNum = 1;
		if (currentPage != null && !"".equals(currentPage)) {
			currentNum = Integer.parseInt(currentPage);
		}
		// 重新设置起始条数
		start = (currentNum - 1) * pageNum;
		int end = currentNum * pageNum;
		// 排序字段+排序方式
		String sortname = ra.getParameter("sidx");
		if (sortname == null || "".equals(sortname)) {
			sortname = "unit_id";
		}
		String sortorder = ra.getParameter("sord");
		if (sortorder == null || "".equals(sortorder)) {
			sortorder = "asc";
		}
		// 定义参数
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("_page_start", start);
		param.put("_page_nums", pageNum);// 该参数是为MySQL数据库准备的
		param.put("_page_end", end);// 该参数是为Oracle数据库准备的
		param.put("_sortname", sortname);
		param.put("_sortorder", sortorder);
		param.put("tBuildingUnit", tBuildingUnit);
		// 查询结果
		List<TBuildingUnit> resultList = (List<TBuildingUnit>) sc.queryForList(
				"Safecheck.getTBuildingUnitList", param);
		if(resultList!=null){
			for(int i=0;i<resultList.size();i++){
				TBuildingUnit temp=resultList.get(i);
				if(temp.getUnit_desc()!=null){
					temp.setUnit_desc(temp.getUnit_desc().trim().replaceAll("\r","").replaceAll("\n", ""));
					resultList.set(i, temp);
				}
			}
		}
		Page page = new Page(totalpage, currentNum, totalnum);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("page", page);
		resultMap.put("resultList", resultList);
		return new DataAndView(resultMap, "block");
	}
}