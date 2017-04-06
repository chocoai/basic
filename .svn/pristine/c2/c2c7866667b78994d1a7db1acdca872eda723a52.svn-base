package com.originsys.auth.action;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.YcEadminProperty;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.Info;
import com.originsys.eap.domain.User;
import com.originsys.eap.iservice.IUserType;
import com.originsys.eap.util.DataSource;

/**
 auth:boy 2014-7-1
   描述：企业管理员用户类型接口
 */
public class EadminUserTypeIm extends BaseAction implements IUserType{

	public Info destory(User user) throws Exception {
		Info info=new Info();
		SqlMapClient sc=DataSource.getSqlMapInstance();
		int result=sc.delete("Auth.deleteEadmin",user.getMem_id());
		if(result>0){
			info.setComplete(true);
		}else{
			info.setComplete(false);
		}
		return info;
	}

	public void init(User user) throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		int count=(Integer) sc.queryForObject("Auth.getEadminCount",user.getMem_id());
		if(count==0){
			YcEadminProperty eadmin=new YcEadminProperty();
			eadmin.setMem_id(user.getMem_id());
			eadmin.setOrgan_id("");
			eadmin.setCurrent_organ("");
			sc.insert("Auth.initEadmin",eadmin);
		}
	}

}
