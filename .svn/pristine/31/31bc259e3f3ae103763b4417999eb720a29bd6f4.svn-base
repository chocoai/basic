package com.originsys.safemanage.safecheck.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.common.domain.Department;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.domain.User;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.TSafeManager;

/**
 auth:zhanglf 2014-5-20
   描述：安全管理员属性信息详细
 */
public class SafeManagerUserDetail  extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		//获取主键
		String  mem_id = ra.getParameter("mem_id");
		//获取ibatis执行
		SqlMapClient sc=DataSource.getSqlMapInstance();
		User mem=(User)sc.queryForObject("User.getUserByMemId",mem_id);
		Map<String,Object> remap=new HashMap<String,Object>();
		remap.put("member", mem);
		//用户所属部门对象（用户和部门的对应）
		List<Department> listdepart=sc.queryForList("organ.getDepartmentsByMemid", mem_id);
		if(listdepart!=null&&listdepart.size()>0){
			Department depart=(Department)listdepart.get(0);
			remap.put("department", depart);
		}
		//根据主键查询信息
		TSafeManager safemanager=(TSafeManager)sc.queryForObject("Safecheck.getTSafeManager",mem_id);
		remap.put("safemanager", safemanager);
		//返回结果
		return new DataAndView(remap,"block");
	}

}
