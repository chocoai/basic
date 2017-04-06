package com.originsys.auth.action;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.UserRegister;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.PostDataAndView;
import com.originsys.eap.domain.SwitchType;
import com.originsys.eap.iservice.IPost;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.GetMD5;
import com.originsys.eap.util.RequestAction;

/**
 * @author boy Email:wangbaoaiboy@163.com
 * @version 1.0 创建时间：2010-6-21
 * 类说明：邮箱和密码重置
 */
public class ResetPassword extends BaseAction implements IPost{

	public PostDataAndView execute(RequestAction ra)
			throws Exception {
		String mem_id=ra.getParameter("mem_id");
		if(mem_id==null||"".equals(mem_id)){
			throw new Exception("please chose user for update!");
		}else{
			SqlMapClient sc = DataSource.getSqlMapInstance();
			UserRegister mr=new UserRegister();
			String password=ra.getParameter("password");
	        password=GetMD5.getMd5(password);
	        mr.setMem_pass(password);
	        mr.setMem_id(ra.getParameter("mem_id"));
	        sc.update("Auth.updatePass", mr);	        
	        String newaction="main";
			return new PostDataAndView(null,null,newaction,SwitchType.REDIRECT);
		}
	}

}
