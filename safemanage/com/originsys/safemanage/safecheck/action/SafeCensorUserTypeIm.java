package com.originsys.safemanage.safecheck.action;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.Info;
import com.originsys.eap.domain.User;
import com.originsys.eap.iservice.IUserType;
import com.originsys.eap.util.DataSource;
import com.originsys.safemanage.domain.TSafeCensor;

/**
 auth:boy 2014-4-16
   描述：安全检查员用户类型接口
 */
public class SafeCensorUserTypeIm extends BaseAction implements IUserType {

	public Info destory(User user) throws Exception {
		Info info=new Info();
		SqlMapClient sc=DataSource.getSqlMapInstance();
		int result=sc.delete("Safecheck.deleteTSafeCensor",user.getMem_id());
		if(result>0){
			info.setComplete(true);
		}else{
			info.setComplete(false);
		}
		return info;
	}

	public void init(User user) throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		int count=(Integer) sc.queryForObject("Safecheck.getCountByMemid",user.getMem_id());
		if(count==0){
			TSafeCensor censor=new TSafeCensor();
			censor.setMem_id(user.getMem_id());
			censor.setWork_years(0);
			sc.insert("Safecheck.addTSafeCensor",censor);
		}
	}

}
