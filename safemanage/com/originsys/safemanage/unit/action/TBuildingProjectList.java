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
import com.originsys.safemanage.domain.TBuildingProject;
import com.originsys.safemanage.domain.TBuildingUnit;

import java.text.SimpleDateFormat;

/**
 * @author boy Email:
 * @version 1.0 创建时间： 类说明：管理项目小区列表
 */
public class TBuildingProjectList extends BaseAction implements IGet {

	public DataAndView<Map> execute(RequestAction ra) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		/** 组织查询条件对象 */
		TBuildingProject tBuildingProject = new TBuildingProject();
		tBuildingProject.setProject_id(ra.getParameter("project_id_select"));// String:管理项目编号
		tBuildingProject
				.setProject_name(ra.getParameter("project_name_select"));// String:管理项目名称
		tBuildingProject.setProject_address(ra
				.getParameter("project_address_select"));// String:管理项目地址		
		tBuildingProject.setCity_district(ra.getParameter("city_district_select"));// String:所属区域	
		tBuildingProject
				.setProject_desc(ra.getParameter("project_desc_select"));// String:备注
		tBuildingProject.setProject_buildingids(ra
				.getParameter("project_buildingids_select"));// String:包含楼幢
		//济南房产测绘研究院用户暂时拥有超级管理员审核权限，故此不参与数据权限过滤的过程
		if(null!=ra.getUser().getOrgcom_id()&&!"".equals(ra.getUser().getOrgcom_id())&&!"jnfchy".equals(ra.getUser().getOrgcom_id()))
		tBuildingProject.setUnit_id(ra.getUser().getOrgcom_id());	
		else
		tBuildingProject.setUnit_name(ra.getParameter("unit_id_select"));// String:责任单位编号
		tBuildingProject
				.setReview_state(ra.getParameter("review_state_select"));// String:信息状态0未审核;1审核通过;2审核驳回
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
				"Safecheck.getTBuildingProjectCount", tBuildingProject);
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
			sortname = "project_id";
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
		param.put("tBuildingProject", tBuildingProject);
		// 查询结果
		List<TBuildingProject> resultList = (List<TBuildingProject>) sc
				.queryForList("Safecheck.getTBuildingProjectList", param);
		if(resultList!=null){
			for(int i=0;i<resultList.size();i++){
				TBuildingProject temp=resultList.get(i);
				if(temp.getProject_desc()!=null){
					temp.setProject_desc(temp.getProject_desc().trim().replaceAll("\r","").replaceAll("\n", ""));
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