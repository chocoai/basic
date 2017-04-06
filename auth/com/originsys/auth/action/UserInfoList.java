package com.originsys.auth.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.domain.Page;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.auth.domain.UserInfo;
import java.text.SimpleDateFormat;
/**
 * @author   Email: 
 * @version 1.0 创建时间： 
 * 类说明： 列表页
 * 查询当前用户所在组织中的所有用户列表
 */
public class UserInfoList  extends BaseAction implements IGet{

	public DataAndView<Map> execute(RequestAction ra)throws Exception {
		String orgcom_id=ra.getUser().getOrgcom_id();
		if(orgcom_id!=null&&!"".equals(orgcom_id)){
			/**组织查询条件对象*/
			UserInfo userInfo=new UserInfo();
			userInfo.setMem_id(ra.getParameter("mem_id"));//String:用户id
			userInfo.setFamily_name(ra.getParameter("family_name"));
			userInfo.setMem_name(ra.getParameter("mem_name"));
			userInfo.setMem_sex(ra.getParameter("mem_sex"));
			userInfo.setMem_state(ra.getParameter("mem_state"));
			userInfo.setNote_info(orgcom_id);//用个不常用的字段存放组织编号
			/**获取ibatis执行*/
			SqlMapClient sc=DataSource.getSqlMapInstance();
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
			int totalnum=(Integer)sc.queryForObject("Auth.getUserInfoCount", userInfo);
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
			//定义参数
			Map param=new HashMap();
			param.put("_page_start", start);
			param.put("_page_nums", pageNum);//该参数是为MySQL数据库准备的
			param.put("_page_end", end);//该参数是为Oracle数据库准备的
			param.put("_sortname", sortname);
			param.put("_sortorder", sortorder);
			param.put("userInfo", userInfo);	  
			//查询结果
			List<UserInfo> resultList=(List<UserInfo>)sc.queryForList("Auth.getUserInfoList", param);
			Page page=new Page(totalpage,currentNum,totalnum);
			Map resultMap=new HashMap();
			resultMap.put("page", page);
			resultMap.put("resultList", resultList);
			return new DataAndView(resultMap,"block");
		}else{
			Map<String,Object> resultMap=new HashMap<String,Object>();
			resultMap.put("page", new Page());
			resultMap.put("resultList", new ArrayList());
			return new DataAndView(resultMap,"block");
		}		
	}
}