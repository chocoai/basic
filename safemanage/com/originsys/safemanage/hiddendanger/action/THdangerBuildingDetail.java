package com.originsys.safemanage.hiddendanger.action;

import javax.servlet.http.HttpServletRequest;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.THdangerBuilding;

/**
 * @author   Email: 
 * @version 1.0 创建时间： 
 * 类说明： 隐患楼幢上报详细
 */
public class THdangerBuildingDetail extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		//获取主键
		String  info_id = ra.getParameter("info_id");
		//获取ibatis执行
		SqlMapClient sc=DataSource.getSqlMapInstance();
		//根据主键查询信息
		THdangerBuilding result=(THdangerBuilding)sc.queryForObject("Safecheck.getTHdangerBuilding",info_id);
		//返回结果
		return new DataAndView(result,"result");
	}
}