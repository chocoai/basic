package com.originsys.safemanage.safecheck.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.common.domain.YcAnnexImage;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.safemanage.domain.TBuilding;
import com.originsys.safemanage.domain.TBuildingSafe;
import com.originsys.safemanage.domain.TInvmBase;
import com.originsys.safemanage.domain.TInvmField;

/**
 auth:boy 2014-5-8
   描述：楼幢普查详细信息
 */
public class BuildingSafeDetail extends BaseAction implements  IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		String  building_id = ra.getParameter("building_id");
		String info_id=ra.getParameter("info_id");
		String op=ra.getParameter("op");
		SqlMapClient sc=DataSource.getSqlMapInstance();
		//获取info_id
		if(info_id==null||"".equals(info_id)){
			/**获取最新的鉴定信息的编号*/
			info_id=(String)sc.queryForObject("Safecheck.getNewInfoId",building_id);
		}
		if(info_id==null) info_id="";
		/**楼幢基本信息*/
		TBuilding building=(TBuilding)sc.queryForObject("Safecheck.getTBuilding",building_id);
		/**普查结果信息*/
		TBuildingSafe buildingsafe=(TBuildingSafe)sc.queryForObject("Safecheck.getTBuildingSafe",info_id);
		/**相关图片列表*/
		List<YcAnnexImage> imagelist=new ArrayList<YcAnnexImage>();
		String imgs=buildingsafe.getAnnex_pic();
		if(imgs!=null&&!"".equals(imgs)){
			imgs=imgs.replace(",", "','");
			imgs="'"+imgs+"'";
			imagelist=sc.queryForList("AnnexFile.getAnnexImage",imgs);
		}
		/**地基基础信息*/
		TInvmBase invmbase=(TInvmBase)sc.queryForObject("Safecheck.getTInvmBase",info_id);
		/**现场调查场地环境*/
		TInvmField invmfield=(TInvmField)sc.queryForObject("Safecheck.getTInvmField",info_id);
		/**组织返回的对象*/
		Map<String,Object> remap=new HashMap<String,Object>();
		remap.put("building", building);
		remap.put("buildingsafe", buildingsafe);
		remap.put("imagelist", imagelist);
		remap.put("invmbase", invmbase);
		remap.put("invmfield", invmfield);
		remap.put("op", op);
		return new DataAndView(remap,"block");
	}

}
