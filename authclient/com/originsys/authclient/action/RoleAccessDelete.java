package com.originsys.authclient.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.ModuleType;
import com.originsys.eap.domain.RoleAccess;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.CacheUtil;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

import freemarker.template.utility.StringUtil;

/**
 * @author boy Email:wangbaoaiboy@163.com
 * @version 1.0 创建时间：2010-6-10 类说明：角色对应权限的删除
 */
public class RoleAccessDelete extends BaseAction implements IData {

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		String role_id = ra.getParameter("role_id");
		int success = 0;
		if (role_id != null && !"".equals(role_id)) {
			SqlMapClient sc = DataSource.getSqlMapInstance();
			// 获得栏目号
			String[] blockids = ra.getParameterValues("block_id");
			if (blockids != null) {
				try {
					sc.startTransaction();
					sc.startBatch();
					for (int i = 0; i < blockids.length; i++) {
						String blockidstr = blockids[i];
						String str[] = StringUtil.split(blockidstr, '#');
						String blockid = str[0];
						String comid = str[1];
						RoleAccess temp = new RoleAccess();
						temp.setRole_id(role_id);
						if ("0".equals(blockid)) {
							temp.setModule_type(ModuleType.COMPONENT);
							temp.setModule_id(comid);
						} else {
							temp.setModule_type(ModuleType.BLOCK);
							temp.setModule_id(blockid);
						}
						sc.delete("FunctionGroup.deleteAccessByRAccess", temp);
					}
					sc.executeBatch();
					sc.commitTransaction();
					success = 1;
				} catch (Exception e) {
					success = 0;
					throw e;
				} finally {
					sc.endTransaction();
				}
			}
			// 清除权限缓存
			CacheUtil.accessCache().remove(role_id);

			response.setContentType("text/plain");
			PrintWriter out = response.getWriter();
			out.print("{\"success\":" + success + "}");
		} else {
			throw new Exception(
					"The parameters \"role_id\" is empty, we must select a record");
		}
	}

}
