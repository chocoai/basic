package com.originsys.auth.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.Orgcom;
import com.originsys.auth.domain.OrgcomType;
import com.originsys.auth.domain.OrgcomtypeOrgcom;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.service.RegionService;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 * @author Email:
 * @version 1.0 创建时间： 类说明： 列表页
 */
public class OrgcomDetail extends BaseAction implements IGet {

	public DataAndView execute(RequestAction ra) throws Exception {
		// 获取主键
		String organ_id = ra.getParameter("organ_id");
		// 获取ibatis执行
		SqlMapClient sc = DataSource.getSqlMapInstance();
		// 根据主键查询信息
		Orgcom result = (Orgcom) sc.queryForObject("Auth.getOrgcom", organ_id);
		result.setOrgan_region_name(RegionService.getInstance()
				.getRegionFullName(result.getOrgan_region()));
		String organCode = result.getOrgan_code();
		
		String organ_code1 = "";
		String organ_code2 = "";
		if(organCode!=null&&!"".equals(organCode)){
			String str[] = organCode.split("-");
			if (str.length == 2) {
				organ_code1 = str[0];
				organ_code2 = str[1];
			}
		}
		result.setOrgcomtype_list(sc.queryForList(
				"Auth.getOrgTypeListByOrgID1", result.getOrgan_id()));
		
		List<OrgcomType> typelist=sc.queryForList("Auth.getOrgcomTypeList");

		Map resultMap = new HashMap();
		resultMap.put("result", result);
		resultMap.put("typelist", typelist);
		resultMap.put("organ_code1", organ_code1);
		resultMap.put("organ_code2", organ_code2);
		// 对应企业类型字符串
		String orgtype_str = "";
		// 查询对应企业类型
		List<OrgcomtypeOrgcom> orgtypelist = sc.queryForList(
				"Auth.getOrgTypeListByOrgID", organ_id);
		if (orgtypelist != null) {
			for (OrgcomtypeOrgcom orgtype : orgtypelist) {
				orgtype_str += "," + orgtype.getOrgan_type_id() + " ";
			}
		}
		resultMap.put("orgtype_str", orgtype_str);
		// 返回结果
		return new DataAndView(resultMap, "resultMap");
	}
}