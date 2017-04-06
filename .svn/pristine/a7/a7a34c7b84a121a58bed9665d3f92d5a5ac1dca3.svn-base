package com.originsys.safemanage.safecheck.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.TBuilding;

/**
 auth:zhanglf 2014-6-10
   描述：获取前台传入builing_mapid ， 组织成标准标号，调用hbase Api 获取基本数据。将楼幢号，坐落地址初始化到t_building表中
 */
public class SurveyForInsert1  extends BaseAction implements  IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		String sbid=ra.getParameter("smuserid");
		String address=ra.getParameter("address");
		Map<String,Object> remap=new HashMap<String,Object>();
			remap.put("sbid", sbid);
			remap.put("building_address", address);
		int flag=0;
		SqlMapClient sc=DataSource.getSqlMapInstance();
		/**楼幢基本信息*/
		TBuilding tBuilding=new TBuilding();
		tBuilding.setBuilding_id(sbid);//Integer:楼幢编号图斑编号sm_id
		tBuilding.setBuilding_address(address);//坐落地址
		
		int num = (Integer)sc.queryForObject("Safecheck.getTBuildingCount", sbid);
		if(num>0){
			num = (Integer)sc.queryForObject("Safecheck.getSurveyCount", sbid);
			if(num>0){
				flag=1;
			}
		}else{
			//初始化到t_building表
			sc.insert("Safecheck.addTBuilding", tBuilding);
			num = (Integer)sc.queryForObject("Safecheck.getSurveyCount", sbid);
			if(num>0){
				flag=1;
			}
		}
		remap.put("flag", flag);
		//获取当前登录用户的mem_id
		String mem_id=ra.getUser().getMem_id();
		String region="";
//		List roles=(List)sc.queryForList("Safecheck.getRoles", mem_id);
		List roles=ra.getUser().getRoleList();
		for(int i=0;i<roles.size();i++){
			this.log().debug("角色"+(i+1)+":"+roles.get(i));
			if("surveychecker".equals(roles.get(i))){//检查员
				//region=SafeCensorService.getInstance().getTSafeCensor(mem_id).getRegion();
				region="-1";
				break;
			}else if("surveymanager".equals(roles.get(i))){//管理员
				region="-1";//管理员可以管理所有的区域
				break;
			}else if("surveyregionmanager".equals(roles.get(i))){//区县管理员
				region=SafeManagerService.getInstance().getTSafeManager(mem_id).getRegion();
				break;
			}else if("safepc".equals(roles.get(i))){
				region=SafeCensorService.getInstance().getTSafeCensor(mem_id).getRegion();
				if(null==region){
					region="-1";
				}
				break;
			}
		}
		this.log().debug("所属区域："+region);
		remap.put("building_region", region);
		return new DataAndView(remap,"block");
	}

}
