package com.originsys.auth.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.Service.OrgComService;
import com.originsys.auth.domain.Orgcom;
import com.originsys.auth.domain.OrgcomType;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.control.Constants;
import com.originsys.eap.domain.PostDataAndView;
import com.originsys.eap.domain.SwitchType;
import com.originsys.eap.domain.User;
import com.originsys.eap.iservice.IPost;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.GetMD5;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2013-7-24
   描述：组织机构登录
 */
public class OrgcomLogin extends BaseAction implements IPost{

	public PostDataAndView execute(RequestAction ra) throws Exception {
		HttpSession session = ra.getSession();
		SqlMapClient sc = DataSource.getSqlMapInstance();
		String newAction="auth.loginblock1";
		SwitchType st=SwitchType.REDIRECT;
		String success="0";
		String organ_id=ra.getParameter("organ_id");
		String sotp=ra.getParameter("sotp");
		String password = ra.getParameter("organ_pass");
		password = GetMD5.getMd5(password);
		Orgcom orgcom=(Orgcom)sc.queryForObject("Auth.getOrgcom",organ_id);
		if(orgcom==null){
			//组织机构不存在
			success="2";
		}else{
			if("1".equals(orgcom.getAuthentication_state())){
				boolean is_continue=true;				
				if(is_continue){
					//判断登录密码是否正确
					if((password).equals(orgcom.getOrgan_pass())){
						is_continue=true;
					}else{
						//登录密码不正确
						success="8";
						is_continue=false;
					}
				}
				if(is_continue){
					//验证成功，组织一个用户对象返回
					User user=new User();
					user.setMem_name(orgcom.getOrgan_id());
					user.setFirstname(orgcom.getOrgan_name());
					user.setFullname(orgcom.getOrgan_name());
					List<String> roleList=new ArrayList<String>();
					roleList.add(Constants.Nologin);
					roleList.add(Constants.Register);
					roleList.add("qyadmin");
					/**如果单位有评委会办事机构类型，并且机构类型通过审核，则再绑定审核机构角色*/
					List<OrgcomType> typelist=sc.queryForList("Auth.getOrgTypeListByOrgID1", orgcom.getOrgan_id());
					if(typelist!=null){
						for(int i=0;i<typelist.size();i++){
							OrgcomType temp=typelist.get(i);
							String type_id=temp.getOrgan_type_id();
							String type_state=temp.getOrgan_type_state();
							if("2".equals(type_id)&&"1".equals(type_state)){
								roleList.add("shjg");
							}
						}
					}
					user.setRoleList(roleList);
					user.setOrgcom_id(organ_id);
					user.setOrgcom_name(orgcom.getOrgan_name());
//					/**取用户的扩展信息*/
//					ZcpsOrgancomParam orgcomparam=(ZcpsOrgancomParam)sc.queryForObject("Zcps.getOrgancomParam1", organ_id);
//					if(orgcomparam==null)orgcomparam=new ZcpsOrgancomParam();
//					user.set_attach(orgcomparam);
					ra.getSession().setAttribute(Constants.User, user);
					success="1";				
				}
			}else{
				//组织机构未认证通过
				success="3";
			}			
		}
		session.setAttribute("orgcom_error", success);
		return new PostDataAndView(null, "map", newAction, st);
	}

}
