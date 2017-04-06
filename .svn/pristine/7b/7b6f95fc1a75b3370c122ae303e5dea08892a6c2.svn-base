package com.originsys.auth.action;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.UserRegister;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.PostDataAndView;
import com.originsys.eap.domain.SwitchType;
import com.originsys.eap.iservice.IPost;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;

/**
 * @author boy Email:wangbaoaiboy@163.com
 * @version 1.0 创建时间：2010-6-21
 * 类说明：真正的密码找回
 */
public class PasswordFind extends BaseAction implements IPost{

	public PostDataAndView execute(RequestAction ra)
			throws Exception {
		String flag=ra.getParameter("mail_flag");
		SqlMapClient sc = DataSource.getSqlMapInstance();
		if("1".equals(flag)){
//			//邮箱找回密码
//			String email=ra.getParameter("user_mail");		
//			String new_pass="";
//			boolean w_flag=false;
//			do{
//				//产生随即的密码
//				Random r = new Random();
//				int x = r.nextInt(999999); 
//				if(x>100000){
//					new_pass=x+"";
//					w_flag=false;
//				}else{
//					w_flag=true;
//				}
//			}while(w_flag);
//			Member user=new Member();
//			user.setMem_name(email);
//			String password=new_pass;
//			user.setMem_pass(password);
//			//发送邮件 告诉用户新密码===================
//			Component cc=ComponentService.getInstance().getComponentById("manager");
//			String smtp=((Map)cc.getParamMap().get("smtp")).get("value").toString();
////			String smtp="smtp.163.com";
//			String auth_name=((Map)cc.getParamMap().get("auth_name")).get("value").toString();
//			String auth_pass=((Map)cc.getParamMap().get("auth_pass")).get("value").toString();
////			String viewFile=(String) ra.getParamValue("mailtemplate");
//			String viewFile="com/originsys/eap/common/login/view/passwordmail.ftl";
//			String title="密码找回";
//			EmailUtil.sendEmail(smtp, auth_name, auth_pass, user, viewFile, title,null);
//			
//			//修改数据库中用户的密码
//	        password=GetMD5.getMd5(password);
//	        user.setMem_name(ra.getParameter("user_name"));
//	        user.setMem_pass(password);
//			sc.update("User.updatepassword", user);
//			
//			String newaction="commonservice.login.loginblock";
//			return new PostDataAndView("","",newaction,SwitchType.REDIRECT);
			return null;
		}else if("0".equals(flag)){
			//问题找回密码
			String user_mail=ra.getParameter("user_mail");
			String question=ra.getParameter("mem_question");
			String answer=ra.getParameter("mem_answer");
			UserRegister mr=new UserRegister();
			mr.setMem_name(user_mail);
			mr.setMem_question(question);
			mr.setMem_answer(answer);
			
			UserRegister temp=(UserRegister)sc.queryForObject("Auth.selectUserReg", mr);
			String newaction;
			if(temp!=null&&temp.getMem_id()!=null){
				newaction="auth.forresetpassword?mem_id="+temp.getMem_id();
			}else{
				newaction="auth.passwordforfind1?error=have";
			}			
			return new PostDataAndView("","",newaction,SwitchType.REDIRECT);
		}else{
			throw new Exception("the mail_flag is error");
		}
	}

}
