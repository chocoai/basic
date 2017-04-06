package com.originsys.safemanage.unit.action;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.TBuildingUnit;

/**
 * @author boy Email:
 * @version 1.0 创建时间： 类说明： 安全责任单位详细
 */
public class TBuildingUnitDetail extends BaseAction implements IGet {

	public DataAndView execute(RequestAction ra) throws Exception {
		// 获取主键
		String unit_id = ra.getParameter("unit_id");
		// 获取ibatis执行
		SqlMapClient sc = DataSource.getSqlMapInstance();
		// 根据主键查询信息
		TBuildingUnit result = (TBuildingUnit) sc.queryForObject(
				"Safecheck.getTBuildingUnit", unit_id);
		// 返回结果
		return new DataAndView(result, "result");
	}
}