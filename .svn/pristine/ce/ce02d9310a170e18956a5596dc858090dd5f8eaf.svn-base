package com.originsys.safemanage.usertype.action;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.Info;
import com.originsys.eap.domain.User;
import com.originsys.eap.iservice.IUserType;
import com.originsys.eap.util.DataSource;
import com.originsys.safemanage.domain.TSafeAssessors;

/**
 auth:zhanglf 2014-5-22
   描述：安全鉴定员用户类型接口
 */
public class SafeAssessorsUserTypeIm extends BaseAction implements IUserType {

	public Info destory(User user) throws Exception {
		Info info=new Info();
		SqlMapClient sc=DataSource.getSqlMapInstance();
		int result=sc.delete("Safecheck.deleteTSafeAssessors",user.getMem_id());
		if(result>0){
			info.setComplete(true);
		}else{
			info.setComplete(false);
		}
		return info;
	}

	public void init(User user) throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		int count=(Integer) sc.queryForObject("Safecheck.getCountByMemid2",user.getMem_id());
		if(count==0){
			TSafeAssessors assessors=new TSafeAssessors();
			assessors.setMem_id(user.getMem_id());
			assessors.setWork_years(0);
			sc.insert("Safecheck.addTSafeAssessors",assessors);
		}
	}

}
