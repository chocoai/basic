package com.originsys.safemanage.safecheck.action;

import java.util.HashMap;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.TWFZZ;
import com.originsys.eap.iservice.IData;
import javax.servlet.http.HttpServletResponse;
import com.originsys.eap.util.UUIDshort;
import java.io.PrintWriter;
import java.net.URLDecoder;

/**
 * @author boy Email:
 * @version 1.0 创建时间： 类说明： 危房整治增加
 */
public class TBuildingWFZZAdd extends BaseAction implements IData {

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		// 获取值
		TWFZZ twfzz = new TWFZZ();

		String key = UUIDshort.get();
		String building_id = ra.getParameter("building_id");
		String builiding_region = URLDecoder.decode(ra.getParameter("builiding_region") , "UTF-8");
		System.out.println(building_id+" building_id  builiding_region "+builiding_region);
		twfzz.setId(key); // String:维修记录编号
		twfzz.setBuilding_id(building_id);// String:楼幢编号
		twfzz.setWfzz_type(ra.getParameter("zzlx"));// String:整治类型
		twfzz.setWfzz_content(ra.getParameter("zznr"));// String:整治内容
		twfzz.setBuiliding_region(builiding_region);
		String success = "0";
		
		
		/** 获取ibatis执行 */
		SqlMapClient sc = DataSource.getSqlMapInstance();
		try {
			sc.startTransaction();
			//第一步 把数据存入数据表T_BUILDING 中
			sc.insert("Safecheck.addWFZZRecord", twfzz);
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("key", key);
			paramMap.put("building_id", building_id);
			paramMap.put("builiding_region", builiding_region);
			paramMap.put("zzlx", ra.getParameter("zzlx"));
			paramMap.put("zznr", ra.getParameter("zznr"));
			sc.insert("Safecheck.addWFZZRecord", twfzz);
			//第二步 更新表T_WFZZ字段
			TWFZZ b = new TWFZZ();
			b.setBuilding_id(building_id);
			b.setStatus("已整治");
			Map<String, String> param = new HashMap<String, String>();
			param.put("status", "已整治");
			param.put("building_id", building_id);
			sc.update("Safecheck.updateWFZZstatus", b);
			
			sc.commitTransaction();
			success = "1";
		} catch (Exception e) {
			success = "0";
			throw e;
		} finally {
			sc.getCurrentConnection().rollback();
			sc.endTransaction();
		}
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.print("{\"success\":\"" + success + "\",\"key\":\"" + key + "\"}");
	}
}