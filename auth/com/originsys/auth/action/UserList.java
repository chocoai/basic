package com.originsys.auth.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.domain.UserInfo;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.domain.Page;
import com.originsys.eap.domain.User;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
/**角色对应用户选择用户中的：所有用户列表*/
public class UserList extends BaseAction implements IGet {

	private static final long serialVersionUID = 3447798814084700365L;

	public DataAndView<Map> execute(RequestAction ra) throws Exception {
		SqlMapClient sc=DataSource.getSqlMapInstance();
		Map termmap=new HashMap();
		//获得当前页数
		String currentPage=ra.getParameter("page");
		//获得起始条数
		int start=0;
		
		//TODO 获得每页显示的条数
		int pageNum=10;
		if(ra.getParameter("rows")!=null)
			pageNum=Integer.parseInt(ra.getParameter("rows"));
		else
			pageNum=10;
		pageNum=(pageNum==0)?10:pageNum;
		//分页
		//获得总条数
		UserInfo user=new UserInfo();
		user.setFamily_name(ra.getParameter("family_name"));
		user.setFirst_name(ra.getParameter("firstname"));
		user.setMem_name(ra.getParameter("memname"));
		if(!"".equals(ra.getParameter("family_name"))||ra.getParameter("family_name")!=null){
			termmap.put("family_name",ra.getParameter("family_name"));
		}
		if(!"".equals(ra.getParameter("firstname"))||ra.getParameter("firstname")!=null){
			termmap.put("firstname", ra.getParameter("firstname"));
		}
		//user.set
		int totalnum=(Integer)sc.queryForObject("Auth.getUserInfoCount1", user);
		
		//获得总页数
		int totalpage=totalnum%pageNum==0?totalnum/pageNum:(totalnum/pageNum+1);
		
		//获得当前页
		int currentNum=1;
		if(currentPage!=null && !"".equals(currentPage)){
			currentNum=Integer.parseInt(currentPage);
		}
		//重新设置起始条数
		start=(currentNum-1)*pageNum;
		//返回到页面总页数和当前页数
		Page page=new Page(totalpage,currentNum,totalnum);
		termmap.put("haveusers", ra.getParameter("haveusers"));
		int end = currentNum*pageNum;
		//定义参数
		Map param=new HashMap();
		param.put("_page_start", start);
		param.put("_page_nums", pageNum);//该参数是为MySQL数据库准备的
		param.put("_page_end", end);//该参数是为Oracle数据库准备的
		param.put("userInfo", user);	
		List<UserInfo> userlist1=(List<UserInfo>)sc.queryForList("Auth.getUserInfoList1",param);
		List<User> userlist=new ArrayList<User>();
		
		for(UserInfo userinfo1:userlist1){
			User temp=new User();
			temp.setMem_id(userinfo1.getMem_id());
			temp.setMem_name(userinfo1.getMem_name());
			temp.setFamily_name(userinfo1.getFamily_name());
			temp.setFirstname(userinfo1.getFirst_name());
			temp.setFullname(userinfo1.getFamily_name().trim()+userinfo1.getFirst_name().trim());
			temp.setRegister_time(userinfo1.getRegister_time());
			temp.setLast_time(userinfo1.getLast_time());
			userlist.add(temp);
		}
		Map remap=new HashMap();
		remap.put("page", page);
		remap.put("term", termmap);
		remap.put("userlist", userlist);
		return new DataAndView<Map>(remap,"block");
	}
}
