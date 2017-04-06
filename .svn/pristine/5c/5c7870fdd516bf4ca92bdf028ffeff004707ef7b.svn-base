package com.originsys.safemanage.usertype.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.caucho.hessian.client.HessianProxyFactory;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.auth.hessian.BasicService;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.domain.Page;
import com.originsys.eap.domain.User;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.FileReaderUtil;
import com.originsys.eap.util.RequestAction;

/**
 auth:zhanglf 2014-5-22
   描述：安全鉴定员列表
 */
public class SafeAssessorsUserList extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		/**获取所有的安全检查员属性表中的用户编号*/
		List<String> memidlist=(List<String>)sc.queryForList("Safecheck.getAssessorsMemids");	
		
		//定义参数
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("memidlist", memidlist);//用户ids
		param.put("username", ra.getParameter("fullname"));//用户姓名
		
		/**调用接口增加，将角色信息同步到注册站，同时在注册站增加企业类型和角色的对应*/
		ResourceBundle rb=FileReaderUtil.getInstance().getResourceBundle("authclient");
		String authurl=rb.getString("authurl");
		HessianProxyFactory factory = new HessianProxyFactory();
	    BasicService basicService = (BasicService)factory.create(BasicService.class, authurl);
		
		//获得起始条数
		int start=0;
		//获得每页显示的条数
		int pageNum=10;
		if(ra.getParameter("rows")!=null){
			pageNum=Integer.parseInt(ra.getParameter("rows"));
		}
		else{
			pageNum=10;
		}
		pageNum=(pageNum==0)?10:pageNum;
		//获取总条数
		int totalnum=basicService.getUserListCountByMids(param);
		//获得总页数
		int totalpage=totalnum%pageNum==0?totalnum/pageNum:(totalnum/pageNum+1);		
		//获得当前页
		String currentPage=ra.getParameter("page");
		int currentNum=1;
		if(currentPage!=null && !"".equals(currentPage)){
			currentNum=Integer.parseInt(currentPage);
		}
		//重新设置起始条数
		start=(currentNum-1)*pageNum;
		int end = currentNum*pageNum;
		//排序字段+排序方式
		String sortname=ra.getParameter("sidx");
		if(sortname==null||"".equals(sortname)){
					sortname="mem_id";
		}
		String sortorder= ra.getParameter("sord");
		if(sortorder==null||"".equals(sortorder)){
			sortorder="asc";
		}
		
		param.put("_page_start", start);
		param.put("_page_nums", pageNum);//该参数是为MySQL数据库准备的
		param.put("_page_end", end);//该参数是为Oracle数据库准备的
		param.put("_sortname", sortname);
		param.put("_sortorder", sortorder);  
		//查询结果
		List<User> userlist=basicService.getUserListByMids(param);
		Page page=new Page(totalpage,currentNum,totalnum);
		Map<String,Object> resultMap=new HashMap<String,Object>();
		resultMap.put("page", page);
		resultMap.put("resultList", userlist);
		return new DataAndView(resultMap,"block");
	}

}
