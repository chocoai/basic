package com.originsys.auth.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.caucho.hessian.client.HessianProxyFactory;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.YcEadminProperty;
import com.originsys.auth.hessian.BasicService;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.FileReaderUtil;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-7-1
   描述：企业管理员属性详细
 */
public class EadminPropertyDetail extends BaseAction implements  IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		String  mem_id = ra.getParameter("mem_id");
		SqlMapClient sc=DataSource.getSqlMapInstance();
		YcEadminProperty eadmin=(YcEadminProperty)sc.queryForObject("Auth.getEadminDetail", mem_id);
		String organ_id=eadmin.getOrgan_id();
		/**返回对象*/
		Map<String,Object> remap=new HashMap<String,Object>();
		if(organ_id!=null&&!"".equals(organ_id)){
			/**从注册站调用接口取企业名称，如果取不到的，可能企业在注册站上已经删除，就不要显示了*/
		    String n_ogan_id=organ_id.replaceAll(" ", "'").replaceAll(",", "',");
			n_ogan_id=n_ogan_id.substring(0, n_ogan_id.length()-1);
			List<Map> organlist=sc.queryForList("Auth.getEadminOrgans", n_ogan_id);
		    remap.put("organlist", organlist);
		}	
		remap.put("mem_id", mem_id);
		remap.put("eadmin", eadmin);
		return new DataAndView(remap,"block");
	}

}
