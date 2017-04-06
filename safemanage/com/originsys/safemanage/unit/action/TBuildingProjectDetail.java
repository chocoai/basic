package com.originsys.safemanage.unit.action;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.FileReaderUtil;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.TBuildingProject;

/**
 * @author boy Email:
 * @version 1.0 创建时间： 类说明：管理项目小区详细
 */
public class TBuildingProjectDetail extends BaseAction implements IGet {

	public DataAndView execute(RequestAction ra) throws Exception {
		// 获取主键
		String project_id = ra.getParameter("project_id");
		// 获取ibatis执行
		SqlMapClient sc = DataSource.getSqlMapInstance();
		// 根据主键查询信息
		TBuildingProject result = (TBuildingProject) sc.queryForObject(
				"Safecheck.getTBuildingProject", project_id);		
		//读取属性文件 
		ResourceBundle rb=FileReaderUtil.getInstance().getResourceBundle("safecheck");
		String map_url=rb.getString("map_url");
		Map<String,Object> remap=new HashMap<String,Object>();
		remap.put("map_url", map_url);
		remap.put("result",result);
		return new DataAndView(remap,"block");
		// 返回结果
		//return new DataAndView(result, "result");
	}
}