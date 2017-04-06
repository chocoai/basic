package com.originsys.realtygis.action;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.realtygis.domain.Building;


public class PropertyListForUpdate extends BaseAction implements IGet{
	/**
	 * 类说明：楼栋表属性更新类
	 * @创建时间：2014-2-14
	 * @作者：洛佳明
	 */
	private static final long serialVersionUID = 1L;
	public DataAndView execute(RequestAction ra)
			throws Exception {	
		SqlMapClient sc=DataSource.getSqlMapInstance();
		Map map=new HashMap();
		Building eo=new Building();
		String building_id=ra.getParameter("building_id");
		if(building_id!=null){
			eo.setBuilding_id(building_id);
		}
		map.put("flag", "0");
		if("update".equals(ra.getParameter("method"))){
		if(!"".equals(ra.getParameter("cx"))||ra.getParameter("cx")!=null){
			String cx = new String(ra.getParameter("cx").getBytes("ISO8859_1"),"utf-8");
			eo.setCx(cx);
		}	
		if(!"".equals(ra.getParameter("dissent_state"))||ra.getParameter("dissent_state")!=null){
			String dissent_state = new String(ra.getParameter("dissent_state").getBytes("ISO8859_1"),"utf-8");
			eo.setDissent_state(dissent_state);
		}	
		if(!"".equals(ra.getParameter("dtlx"))||ra.getParameter("dtlx")!=null){
			String dtlx = new String(ra.getParameter("dtlx").getBytes("ISO8859_1"),"utf-8");
			eo.setDtlx(dtlx);
		}	
		if(!"".equals(ra.getParameter("dtsm"))||ra.getParameter("dtsm")!=null){
			String dtsm = new String(ra.getParameter("dtsm").getBytes("ISO8859_1"),"utf-8");
			eo.setDtsm(dtsm);
		}	
		if(!"".equals(ra.getParameter("freeze_state"))||ra.getParameter("freeze_state")!=null){
			String freeze_state = new String(ra.getParameter("freeze_state").getBytes("ISO8859_1"),"utf-8");
			eo.setFreeze_state(freeze_state);
		}	
		if(!"".equals(ra.getParameter("general_state"))||ra.getParameter("general_state")!=null){
			String general_state = new String(ra.getParameter("general_state").getBytes("ISO8859_1"),"utf-8");
			eo.setGeneral_state(general_state);
		}	
		if(!"".equals(ra.getParameter("guarantee_state"))||ra.getParameter("guarantee_state")!=null){
			String guarantee_state = new String(ra.getParameter("guarantee_state").getBytes("ISO8859_1"),"utf-8");
			eo.setGuarantee_state(guarantee_state);
		}	
		if(!"".equals(ra.getParameter("jzjg"))||ra.getParameter("jzjg")!=null){
			String jzjg = new String(ra.getParameter("jzjg").getBytes("ISO8859_1"),"utf-8");
			eo.setJzjg(jzjg);
		}	
		if(!"".equals(ra.getParameter("lg"))||ra.getParameter("lg")!=null){
			String lg = new String(ra.getParameter("lg").getBytes("ISO8859_1"),"utf-8");
			eo.setLg(lg);
		}	
		if(!"".equals(ra.getParameter("ltlx"))||ra.getParameter("ltlx")!=null){
			String ltlx = new String(ra.getParameter("ltlx").getBytes("ISO8859_1"),"utf-8");
			eo.setLtlx(ltlx);
		}	
		if(!"".equals(ra.getParameter("ltsm"))||ra.getParameter("ltsm")!=null){
			String ltsm = new String(ra.getParameter("ltsm").getBytes("ISO8859_1"),"utf-8");
			eo.setLtsm(ltsm);
		}	
		if(!"".equals(ra.getParameter("mapping_state"))||ra.getParameter("mapping_state")!=null){
			String mapping_state = new String(ra.getParameter("mapping_state").getBytes("ISO8859_1"),"utf-8");
			eo.setMapping_state(mapping_state);
		}	
		if(!"".equals(ra.getParameter("ownership_state"))||ra.getParameter("ownership_state")!=null){
			String ownership_state = new String(ra.getParameter("ownership_state").getBytes("ISO8859_1"),"utf-8");
			eo.setOwnership_state(ownership_state);
		}	
		if(!"".equals(ra.getParameter("pgp_state"))||ra.getParameter("pgp_state")!=null){
			String pgp_state = new String(ra.getParameter("pgp_state").getBytes("ISO8859_1"),"utf-8");
			eo.setPgp_state(pgp_state);
		}	
		if(!"".equals(ra.getParameter("pledge_state"))||ra.getParameter("pledge_state")!=null){
			String pledge_state = new String(ra.getParameter("pledge_state").getBytes("ISO8859_1"),"utf-8");
			eo.setPledge_state(pledge_state);
		}	
		if(!"".equals(ra.getParameter("sealup_state"))||ra.getParameter("sealup_state")!=null){
			String sealup_state = new String(ra.getParameter("sealup_state").getBytes("ISO8859_1"),"utf-8");
			eo.setSealup_state(sealup_state);
		}	
		
			
		 // Date  updatedate=new java.sql.;
		//	eo.setUpdatedate((java.sql.Date)updatedate);
		
		try{
			sc.startTransaction();
			sc.update("Realtygis.updatebuildingproperty", eo);
			sc.commitTransaction();
			map.put("flag", "1");
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			sc.endTransaction();
		}
		}
		List<Building>  list=(List<Building>)sc.queryForList("Realtygis.getpropertylist", eo);
		map.put("list", list);
		
		return new DataAndView(map, "map");
		
	}
}