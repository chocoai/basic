package com.originsys.datacenter.qd.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.HTablePool;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.filter.RegexStringComparator;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.util.Bytes;

import com.originsys.datacenter.domain.HBuilding;
import com.originsys.datacenter.domain.HBuildingSafe;
import com.originsys.datacenter.domain.HHouse;
import com.originsys.datacenter.domain.HRT_prolinkbase;
import com.originsys.datacenter.domain.HSurverBasic;
import com.originsys.datacenter.domain.HSurverProject;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.FileReaderUtil;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-3-10
   描述：千度搜索详细
 */
public class SearchDetail extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {
		Map<String,Object> remap=new HashMap<String,Object>();//返回值
		/**根据楼幢编号查询详细信息或是根据房屋编号查询详细信息*/
		String info_type=ra.getParameter("info_type");
		String info_id=ra.getParameter("info_id");
		String building_id="";
		HBaseConfiguration config = new HBaseConfiguration();
//		config.set("hbase.zookeeper.quorum", "192.168.85.129"); 
		HTablePool pool = new HTablePool(config, 1000);  
		Map<String,String> housemap=new HashMap<String,String>();
//		if("house".equals(info_type)){
//			remap.put("type", "house");
//			
//			//查询房屋的基本信息
//			HTableInterface table = pool.getTable(HHouse.TABLE_NAME);
//			Scan s=new Scan();
//			s.setFilter(new RowFilter(CompareOp.EQUAL,new RegexStringComparator(".*"+info_id+"$")));
//			s.addColumn(HHouse.COLFAMILY, HHouse.BUILDING_MAPID);
//			s.addColumn(HHouse.COLFAMILY, HHouse.BUILDING_ID);
//			s.addColumn(HHouse.COLFAMILY, HHouse.FW_ADDRESS);
//			s.addColumn(HHouse.COLFAMILY, HHouse.LAY_NUM);
//			s.addColumn(HHouse.COLFAMILY, HHouse.JZ_AREA);
//			s.addColumn(HHouse.COLFAMILY, HHouse.TNJZ_AREA);
//			s.addColumn(HHouse.COLFAMILY, HHouse.FT_AREA);
//			s.addColumn(HHouse.COLFAMILY, HHouse.YT_AREA);
//			s.addColumn(HHouse.COLFAMILY, HHouse.STRUCT);
//			s.addColumn(HHouse.COLFAMILY, HHouse.UNIT_NUMBER);
//			s.addColumn(HHouse.COLFAMILY, HHouse.ROOM_NUMBER);
//			s.addColumn(HHouse.COLFAMILY, HHouse.DESIGN_YT);
//			s.addColumn(HHouse.COLFAMILY, HHouse.FACT_YT);
//			s.addColumn(HHouse.COLFAMILY, HHouse.FW_cb);
//			s.addColumn(HHouse.COLFAMILY, HHouse.DOOR_TYPE);
//			s.setMaxVersions();			
//			ResultScanner ss=table.getScanner(s);
//			int i=0;
//			for(Result res:ss){
//				if(i>0){
//					break;
//				}
//				housemap.put("house_id", Bytes.toString(res.getRow()));
//				housemap.put("building_id", Bytes.toString(res.getValue(HHouse.COLFAMILY, HHouse.BUILDING_ID)));
//				housemap.put("fw_address", Bytes.toString(res.getValue(HHouse.COLFAMILY, HHouse.FW_ADDRESS)));
//				housemap.put("lay_num", Bytes.toString(res.getValue(HHouse.COLFAMILY, HHouse.LAY_NUM)));
//				housemap.put("jz_area", Bytes.toString(res.getValue(HHouse.COLFAMILY, HHouse.JZ_AREA)));
//				housemap.put("tnjz_area", Bytes.toString(res.getValue(HHouse.COLFAMILY, HHouse.TNJZ_AREA)));
//				housemap.put("ft_area", Bytes.toString(res.getValue(HHouse.COLFAMILY, HHouse.FT_AREA)));
//				housemap.put("yt_area", Bytes.toString(res.getValue(HHouse.COLFAMILY, HHouse.YT_AREA)));
//				housemap.put("struct", Bytes.toString(res.getValue(HHouse.COLFAMILY, HHouse.STRUCT)));
//				housemap.put("unit_number", Bytes.toString(res.getValue(HHouse.COLFAMILY, HHouse.UNIT_NUMBER)));
//				housemap.put("room_number", Bytes.toString(res.getValue(HHouse.COLFAMILY, HHouse.ROOM_NUMBER)));
//				housemap.put("design_yt", Bytes.toString(res.getValue(HHouse.COLFAMILY, HHouse.DESIGN_YT)));
//				housemap.put("fact_yt", Bytes.toString(res.getValue(HHouse.COLFAMILY, HHouse.FACT_YT)));
//				housemap.put("fw_cb", Bytes.toString(res.getValue(HHouse.COLFAMILY, HHouse.FW_cb)));
//				housemap.put("door_type", Bytes.toString(res.getValue(HHouse.COLFAMILY, HHouse.DOOR_TYPE)));
//				housemap.put("birth_date", Bytes.toString(res.getValue(HHouse.COLFAMILY, HHouse.BIRCH_DATE)));
//				building_id=Bytes.toString(res.getValue(HHouse.COLFAMILY, HHouse.BUILDING_ID));				
//				i++;
//			}
//			ss.close();
//		}
		if("building".equals(info_type)){
			building_id=info_id;
			remap.put("type", "building");			
		}
			//查询楼的基本信息
			HTableInterface table = pool.getTable(HBuilding.TABLE_NAME);
			Get g=new Get(Bytes.toBytes(info_id));
			g.addColumn(HBuilding.COLFAMILY, HBuilding.BUILDING_ID);
			g.addColumn(HBuilding.COLFAMILY, HBuilding.BUILDING_ADDRESS);
			g.addColumn(HBuilding.COLFAMILY, HBuilding.BUILDING_MAPID);
			g.addColumn(HBuilding.COLFAMILY, HBuilding.SURVERPROJECT_ID);
			g.addColumn(HBuilding.COLFAMILY, HBuilding.USE_DESGIN);
			g.addColumn(HBuilding.COLFAMILY, HBuilding.BUILD_STRUCT);
			g.addColumn(HBuilding.COLFAMILY, HBuilding.REAL_TYPE);
			g.addColumn(HBuilding.COLFAMILY, HBuilding.TN_AREA);
			g.addColumn(HBuilding.COLFAMILY, HBuilding.FT_AREA);
			g.addColumn(HBuilding.COLFAMILY, HBuilding.BUILD_AREA);
			g.addColumn(HBuilding.COLFAMILY, HBuilding.BUILDING_DATE);
			g.addColumn(HBuilding.COLFAMILY, HBuilding.UNIT);
			g.addColumn(HBuilding.COLFAMILY, HBuilding.FLOORUP_COUNT);
			g.addColumn(HBuilding.COLFAMILY, HBuilding.HOUSE_COUNT);
			Result r=table.get(g);
			Map<String,String> building=new HashMap<String,String>();
			building.put("building_id", Bytes.toString(r.getValue(HBuilding.COLFAMILY, HBuilding.BUILDING_ID)));
			building.put("building_address", Bytes.toString(r.getValue(HBuilding.COLFAMILY, HBuilding.BUILDING_ADDRESS)));
			building.put("building_mapid", Bytes.toString(r.getValue(HBuilding.COLFAMILY, HBuilding.BUILDING_MAPID)));
			building.put("surverproject_id", Bytes.toString(r.getValue(HBuilding.COLFAMILY, HBuilding.SURVERPROJECT_ID)));
			building.put("use_design", Bytes.toString(r.getValue(HBuilding.COLFAMILY, HBuilding.USE_DESGIN)));
			building.put("build_struct", Bytes.toString(r.getValue(HBuilding.COLFAMILY, HBuilding.BUILD_STRUCT)));
			building.put("real_type", Bytes.toString(r.getValue(HBuilding.COLFAMILY, HBuilding.REAL_TYPE)));
			building.put("tn_area", Bytes.toString(r.getValue(HBuilding.COLFAMILY, HBuilding.TN_AREA)));
			building.put("ft_area", Bytes.toString(r.getValue(HBuilding.COLFAMILY, HBuilding.FT_AREA)));
			building.put("build_area", Bytes.toString(r.getValue(HBuilding.COLFAMILY, HBuilding.BUILD_AREA)));
			building.put("building_date", Bytes.toString(r.getValue(HBuilding.COLFAMILY, HBuilding.BUILDING_DATE)));
			building.put("unit", Bytes.toString(r.getValue(HBuilding.COLFAMILY, HBuilding.UNIT)));
			building.put("floorup_count", Bytes.toString(r.getValue(HBuilding.COLFAMILY, HBuilding.FLOORUP_COUNT)));
			building.put("house_count", Bytes.toString(r.getValue(HBuilding.COLFAMILY, HBuilding.HOUSE_COUNT)));
			/**查询基础测绘和项目测绘的*/
			List<HashMap> plist=new ArrayList<HashMap>();//项目测绘的list
			List<HashMap> basiclist=new ArrayList<HashMap>();//基础测绘的list
			List<String> projectids=new ArrayList<String>();
			String building_mapid=Bytes.toString(r.getValue(HBuilding.COLFAMILY, HBuilding.BUILDING_MAPID));
			/**根据楼幢的唯一编号，查询项目测绘文件*/
			HTableInterface table1 = pool.getTable(HSurverProject.TABLE_NAME);
			Scan s=new Scan();
			Scan s2=new Scan();
			String cehui_buildingid=Bytes.toString(r.getValue(HHouse.COLFAMILY, HHouse.BUILDING_ID));
			if(building_mapid!=null&&!"".equals(building_mapid)&&!"-1".equals(building_mapid)){
				//查找前缀，以什么开头的
				s.setFilter(new PrefixFilter(building_mapid.getBytes()));
				s2.setFilter(new PrefixFilter(building_mapid.getBytes()));
			}else{
				//根据楼幢编号，获得测绘文件
				s.setFilter(new RowFilter(CompareOp.EQUAL,new RegexStringComparator(".*"+cehui_buildingid+"$")));
				s2.setFilter(new RowFilter(CompareOp.EQUAL,new RegexStringComparator(".*"+cehui_buildingid+"$")));
			}
			if((building_mapid!=null&&!"".equals(building_mapid)&&!"-1".equals(building_mapid))
					||(cehui_buildingid!=null&&!"".equals(cehui_buildingid))){
				s.addColumn(HSurverProject.COLFAMILY, HSurverProject.SURVERPROJECT_ID);
				s.addColumn(HSurverProject.COLFAMILY, HSurverProject.SURVERPROJECT_CREATEDATE);
				s.addColumn(HSurverProject.COLFAMILY, HSurverProject.ENTRUST_UNIT);
				s.addColumn(HSurverProject.COLFAMILY, HSurverProject.SURVER_TYPE);
				s.addColumn(HSurverProject.COLFAMILY, HSurverProject.SURVERPROJECT_NAME);
				s.addColumn(HSurverProject.COLFAMILY, HSurverProject.BUILDING_ID);
				s.addColumn(HSurverProject.COLFAMILY, HSurverProject.BUILDING_MAPID);
				s.setMaxVersions();
				ResultScanner ss=table1.getScanner(s);
		        for(Result res:ss){
		        	HashMap<String,String> temp=new HashMap<String,String>();
		        	temp.put("surverproject_id", Bytes.toString(res.getValue(HSurverProject.COLFAMILY, HSurverProject.SURVERPROJECT_ID)));
		        	temp.put("surverproject_createdate", Bytes.toString(res.getValue(HSurverProject.COLFAMILY, HSurverProject.SURVERPROJECT_CREATEDATE)));
		        	temp.put("entrust_unit", Bytes.toString(res.getValue(HSurverProject.COLFAMILY, HSurverProject.ENTRUST_UNIT)));
		        	temp.put("surver_type", Bytes.toString(res.getValue(HSurverProject.COLFAMILY, HSurverProject.SURVER_TYPE)));
		        	temp.put("surverproject_name", Bytes.toString(res.getValue(HSurverProject.COLFAMILY, HSurverProject.SURVERPROJECT_NAME)));
		        	temp.put("building_id", Bytes.toString(res.getValue(HSurverProject.COLFAMILY, HSurverProject.BUILDING_ID)));
		        	temp.put("building_mapid", Bytes.toString(res.getValue(HSurverProject.COLFAMILY, HSurverProject.BUILDING_MAPID)));
		        	projectids.add(Bytes.toString(res.getValue(HSurverProject.COLFAMILY, HSurverProject.SURVERPROJECT_ID)));
		        	plist.add(temp);
		        	temp=null;
		        }
				ss.close();
				/**查找基础测绘的*/
				HTableInterface table3 = pool.getTable(HSurverBasic.TABLE_NAME);
				s2.addColumn(HSurverBasic.COLFAMILY, HSurverBasic.SURVERBASIC_NAME);
				s2.addColumn(HSurverBasic.COLFAMILY, HSurverBasic.ENTRUST_UNIT);
				s2.addColumn(HSurverBasic.COLFAMILY, HSurverBasic.SURVERBASIC_CREATEDATE);
				s2.addColumn(HSurverBasic.COLFAMILY, HSurverBasic.BUILDING_ID);
				s2.addColumn(HSurverBasic.COLFAMILY, HSurverBasic.BUILDING_MAPID);
				ResultScanner res=table3.getScanner(s2);
				for(Result r3:res){
					HashMap<String,String> temp=new HashMap<String,String>();
		        	temp.put("surverbasic_id", Bytes.toString(r3.getRow()));
		        	temp.put("entrust_unit", Bytes.toString(r3.getValue(HSurverBasic.COLFAMILY, HSurverBasic.ENTRUST_UNIT)));
		        	temp.put("surverbasic_name", Bytes.toString(r3.getValue(HSurverBasic.COLFAMILY, HSurverBasic.SURVERBASIC_NAME)));
		        	temp.put("surverbasic_createdate", Bytes.toString(r3.getValue(HSurverBasic.COLFAMILY, HSurverBasic.SURVERBASIC_CREATEDATE)));
		        	temp.put("building_id", Bytes.toString(r3.getValue(HSurverBasic.COLFAMILY, HSurverBasic.BUILDING_ID)));
		        	temp.put("building_mapid", Bytes.toString(r3.getValue(HSurverBasic.COLFAMILY, HSurverBasic.BUILDING_MAPID)));
		        	basiclist.add(temp);
		        	temp=null;
				}
				res.close();
			
			}
			/**查询安全管理的===================*/
			List safelist=new ArrayList();
			Scan s3=new Scan();
			//查找前缀，以什么开头的
			s3.setFilter(new PrefixFilter(info_id.getBytes()));
			s3.addColumn(HBuildingSafe.COLFAMILY, HBuildingSafe.OP);
			s3.addColumn(HBuildingSafe.COLFAMILY, HBuildingSafe.OPDATE);
			s3.addColumn(HBuildingSafe.COLFAMILY, HBuildingSafe.OPRESULT);
			s3.addColumn(HBuildingSafe.COLFAMILY, HBuildingSafe.OPTYPE);
			s3.addColumn(HBuildingSafe.COLFAMILY, HBuildingSafe.ANNEX_IMAGE);
			s3.addColumn(HBuildingSafe.COLFAMILY, HBuildingSafe.ANNEX_FILE);
			HTableInterface table4 = pool.getTable(HBuildingSafe.TABLE_NAME);
			ResultScanner res3=table4.getScanner(s3);
			ResourceBundle rb=FileReaderUtil.getInstance().getResourceBundle("datacenter");
			String safe_url=rb.getString("safemanage");
			for(Result r3:res3){
				HashMap<String,String> temp=new HashMap<String,String>();
	        	temp.put("op", Bytes.toString(r3.getValue(HBuildingSafe.COLFAMILY, HBuildingSafe.OP)));
	        	temp.put("opdate", Bytes.toString(r3.getValue(HBuildingSafe.COLFAMILY, HBuildingSafe.OPDATE)));
	        	temp.put("opresult", Bytes.toString(r3.getValue(HBuildingSafe.COLFAMILY, HBuildingSafe.OPRESULT)));
	        	temp.put("optype", Bytes.toString(r3.getValue(HBuildingSafe.COLFAMILY, HBuildingSafe.OPTYPE)));
	        	String annex_image=Bytes.toString(r3.getValue(HBuildingSafe.COLFAMILY, HBuildingSafe.ANNEX_IMAGE));
	        	if(annex_image!=null&&!"".equals(annex_image)){
	        		if(annex_image.startsWith("../"))
	        			annex_image=annex_image.replace("../", safe_url);
	        		else
	        			annex_image=annex_image.replace("http://192.168.0.9:8081/", safe_url);
	        	}
	        	temp.put("annex_image", annex_image);
	        	String annex_file=Bytes.toString(r3.getValue(HBuildingSafe.COLFAMILY, HBuildingSafe.ANNEX_FILE));
	        	if(annex_file!=null&&!"".equals(annex_file)){
	        		if(annex_file.startsWith("/"))
	        			annex_file=safe_url+annex_file;	
	        		else
	        			annex_file=annex_file.replace("http://192.168.0.9:8081/", safe_url);
	        	}
	        	temp.put("annex_file", annex_file);
	        	safelist.add(temp);
	        	temp=null;
			}
			res3.close();
			
			/**权属的===================*/
			
			//增加返回对象
			remap.put("building", building);//楼幢基本信息
			remap.put("plist", plist);//项目测绘list
			remap.put("basiclist", basiclist);//基础测绘list
			remap.put("safelist", safelist);//安全管理的list
			remap.put("house", housemap);
			remap.put("building_id", building_id);//大数据中的主键图斑的smuserid
			remap.put("cehui_buildingid", cehui_buildingid);//测绘编号
			building=null;
			plist=null;
			basiclist=null;
			housemap=null;
		return new DataAndView(remap,"block");
	}

}
