package com.originsys.datacenter.domain;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

import com.originsys.datacenter.domain.Building;

/**
 auth:boy 2014-3-3
   描述：hbase的楼幢表 
 */
public class HBuilding {
	/**表名*/
	public static final String TABLE_NAME="buildingn";
	/**列族信息 info*/
	public static final byte[] COLFAMILY="info".getBytes();
	/**rowkey是图斑编号*/
	
	public static final byte[] BUILDING_ID="building_id".getBytes();//测绘幢号内码
	public static final byte[] WS_ZB="ws_zb".getBytes();//西南角坐标
	public static final byte[] SBUILDING_ID="sbuilding_id".getBytes();//标准楼幢编号
	public static final byte[] SURVERPROJECT_ID="surverproject_id".getBytes();//项目测绘流程内码
	public static final byte[] UNIT="unit".getBytes();//施测单位
	public static final byte[] SURVER="surver".getBytes();//测绘比例
	public static final byte[] USE_DESGIN="use_desgin".getBytes();//设计用途
	public static final byte[] REAL_TYPE="real_type".getBytes();//房屋产别
	public static final byte[] TN_AREA="tn_area".getBytes();//总套内建筑面积
	public static final byte[] FT_AREA="ft_area".getBytes();//总分摊共用面积
	public static final byte[] BUILD_AREA="build_area".getBytes();//总建筑面积
	public static final byte[] NOFT_AREA="noft_area".getBytes();//总不分摊面积
	public static final byte[] NO_AREA="no_area".getBytes();//总不计面积
	public static final byte[] DISCREPANT_AREA="discrepant_area".getBytes();//面积校核差值
	public static final byte[] SRUVER_DATE="sruver_date".getBytes();//测绘日期
	public static final byte[] SURVER_ENDDATE="surver_enddate".getBytes();//结束日期
	public static final byte[] BUILDING_NUMBER="building_number".getBytes();//幢号
	public static final byte[] BUILD_STRUCT="build_struct".getBytes();//结构
	public static final byte[] GRAPHICS_CODE="graphics_code".getBytes();//幢编号
	public static final byte[] GRAPHICS_NUMBER="graphics_number".getBytes();//丘地号（丘号）
	public static final byte[] INPUT_DATE="input_date".getBytes();//入库时间
	public static final byte[] FLOORUP_COUNT="floorup_count".getBytes();//地上层数
	public static final byte[] FLOORDOWN_COUNT="floordown_count".getBytes();//地下层数
	public static final byte[] CITY_DISTRICT="city_district".getBytes();//行政区划
	public static final byte[] BUILDING_MAPID="building_mapid".getBytes();//所在楼盘内码 唯一的	
	public static final byte[] BUILDING_ADDRESS="building_address".getBytes();//幢坐落
	public static final byte[] BUILDING_DATE="building_date".getBytes();//建成时间 
	public static final byte[] FLOOR_COUNT="floor_count".getBytes();//层数 
	public static final byte[] HOUSE_COUNT="house_count".getBytes();//套数
	
	public Building toBuilding(Result rs){
		Building building=new Building();
		building.setSb_id(Bytes.toString(rs.getRow()));
		if(rs.getValue(this.COLFAMILY, this.BUILDING_ID)!=null)
			building.setBuilding_id(Bytes.toString(rs.getValue(this.COLFAMILY, this.BUILDING_ID)));
		if(rs.getValue(this.COLFAMILY, this.WS_ZB)!=null)
			building.setWs_zb(Bytes.toString(rs.getValue(this.COLFAMILY, this.WS_ZB)));
		if(rs.getValue(this.COLFAMILY, this.SBUILDING_ID)!=null)
			building.setSbuilding_id(Bytes.toString(rs.getValue(this.COLFAMILY, this.SBUILDING_ID)));
		if(rs.getValue(this.COLFAMILY, this.SURVERPROJECT_ID)!=null)
			building.setSurverproject_id(Bytes.toString(rs.getValue(this.COLFAMILY, this.SURVERPROJECT_ID)));
		if(rs.getValue(this.COLFAMILY, this.UNIT)!=null)
			building.setUnit(Bytes.toString(rs.getValue(this.COLFAMILY, this.UNIT)));
		if(rs.getValue(this.COLFAMILY, this.SURVER)!=null)
			building.setSurver(Bytes.toString(rs.getValue(this.COLFAMILY, this.SURVER)));
		if(rs.getValue(this.COLFAMILY, this.USE_DESGIN)!=null)
			building.setUse_desgin(Bytes.toString(rs.getValue(this.COLFAMILY, this.USE_DESGIN)));
		if(rs.getValue(this.COLFAMILY, this.REAL_TYPE)!=null)
			building.setReal_type(Bytes.toString(rs.getValue(this.COLFAMILY, this.REAL_TYPE)));
		if(rs.getValue(this.COLFAMILY, this.TN_AREA)!=null)
			building.setTn_area(Bytes.toString(rs.getValue(this.COLFAMILY, this.TN_AREA)));
		if(rs.getValue(this.COLFAMILY, this.FT_AREA)!=null)
			building.setFt_area(Bytes.toString(rs.getValue(this.COLFAMILY, this.FT_AREA)));
		if(rs.getValue(this.COLFAMILY, this.BUILD_AREA)!=null)
			building.setBuild_area(Bytes.toString(rs.getValue(this.COLFAMILY, this.BUILD_AREA)));
		if(rs.getValue(this.COLFAMILY, this.NO_AREA)!=null)
			building.setNo_area(Bytes.toString(rs.getValue(this.COLFAMILY, this.NO_AREA)));
		if(rs.getValue(this.COLFAMILY, this.NOFT_AREA)!=null)
			building.setNoft_area(Bytes.toString(rs.getValue(this.COLFAMILY, this.NOFT_AREA)));
		if(rs.getValue(this.COLFAMILY, this.DISCREPANT_AREA)!=null)
			building.setDiscrepant_area(Bytes.toString(rs.getValue(this.COLFAMILY, this.DISCREPANT_AREA)));
		if(rs.getValue(this.COLFAMILY, this.SRUVER_DATE)!=null)
			building.setSruver_date(Bytes.toString(rs.getValue(this.COLFAMILY, this.SRUVER_DATE)));
		if(rs.getValue(this.COLFAMILY, this.SURVER_ENDDATE)!=null)
			building.setSurver_enddate(Bytes.toString(rs.getValue(this.COLFAMILY, this.SURVER_ENDDATE)));
		if(rs.getValue(this.COLFAMILY, this.BUILDING_NUMBER)!=null)
			building.setBuilding_number(Bytes.toString(rs.getValue(this.COLFAMILY, this.BUILDING_NUMBER)));
		if(rs.getValue(this.COLFAMILY, this.BUILD_STRUCT)!=null)
			building.setBuild_struct(Bytes.toString(rs.getValue(this.COLFAMILY, this.BUILD_STRUCT)));
		if(rs.getValue(this.COLFAMILY, this.GRAPHICS_CODE)!=null)
			building.setGraphics_code(Bytes.toString(rs.getValue(this.COLFAMILY, this.GRAPHICS_CODE)));
		if(rs.getValue(this.COLFAMILY, this.GRAPHICS_NUMBER)!=null)
			building.setGraphics_number(Bytes.toString(rs.getValue(this.COLFAMILY, this.GRAPHICS_NUMBER)));
		if(rs.getValue(this.COLFAMILY, this.INPUT_DATE)!=null)
			building.setInput_date(Bytes.toString(rs.getValue(this.COLFAMILY, this.INPUT_DATE)));
		if(rs.getValue(this.COLFAMILY, this.FLOORUP_COUNT)!=null)
			building.setFloorup_count(Bytes.toString(rs.getValue(this.COLFAMILY, this.FLOORUP_COUNT)));
		if(rs.getValue(this.COLFAMILY, this.FLOORDOWN_COUNT)!=null)
			building.setFloordown_count(Bytes.toString(rs.getValue(this.COLFAMILY, this.FLOORDOWN_COUNT)));
		if(rs.getValue(this.COLFAMILY, this.CITY_DISTRICT)!=null)
			building.setCity_district(Bytes.toString(rs.getValue(this.COLFAMILY, this.CITY_DISTRICT)));
		if(rs.getValue(this.COLFAMILY, this.BUILDING_MAPID)!=null)
			building.setBuilding_mapid(Bytes.toString(rs.getValue(this.COLFAMILY, this.BUILDING_MAPID)));
		if(rs.getValue(this.COLFAMILY, this.BUILDING_ADDRESS)!=null)
			building.setBuilding_address(Bytes.toString(rs.getValue(this.COLFAMILY, this.BUILDING_ADDRESS)));
		if(rs.getValue(this.COLFAMILY, this.BUILDING_DATE)!=null)
			building.setBuilding_date(Bytes.toString(rs.getValue(this.COLFAMILY, this.BUILDING_DATE)));
		if(rs.getValue(this.COLFAMILY, this.FLOOR_COUNT)!=null)
			building.setFloor_count(Bytes.toString(rs.getValue(this.COLFAMILY, this.FLOOR_COUNT)));
		if(rs.getValue(this.COLFAMILY, this.HOUSE_COUNT)!=null)
			building.setHouse_count(Bytes.toString(rs.getValue(this.COLFAMILY, this.HOUSE_COUNT)));
		
		return building;
	}
	
	public Put getHBuildingPut(Building building) throws Exception{
//		String sbid=RegionUtil.getSBuilingid(building.getCity_district(), building.getGraphics_number(), building.getBuilding_number());
//		Put put=new Put(Bytes.toBytes(building.getBuilding_id()));
		Put put=new Put(Bytes.toBytes(building.getSb_id()));
		put.add(HBuilding.COLFAMILY, HBuilding.BUILDING_ID, Bytes.toBytes(building.getBuilding_id()));
		if(building.getSurverproject_id()!=null)
			put.add(HBuilding.COLFAMILY, HBuilding.SURVERPROJECT_ID, Bytes.toBytes(building.getSurverproject_id()));
	    if(building.getUnit()!=null)
	    	put.add(HBuilding.COLFAMILY, HBuilding.UNIT, Bytes.toBytes(building.getUnit()));
	    if(building.getSurver()!=null)
	    	put.add(HBuilding.COLFAMILY, HBuilding.SURVER, Bytes.toBytes(building.getSurver()));
	    if(building.getUse_desgin()!=null)
	    	put.add(HBuilding.COLFAMILY, HBuilding.USE_DESGIN, Bytes.toBytes(building.getUse_desgin()));
	    if(building.getReal_type()!=null)
	    	put.add(HBuilding.COLFAMILY, HBuilding.REAL_TYPE, Bytes.toBytes(building.getReal_type()));
	    if(building.getTn_area()!=null)
	    	put.add(HBuilding.COLFAMILY, HBuilding.TN_AREA, Bytes.toBytes(building.getTn_area()));
	    if(building.getFt_area()!=null)
	    	put.add(HBuilding.COLFAMILY, HBuilding.FT_AREA, Bytes.toBytes(building.getFt_area()));
	    if(building.getBuild_area()!=null)
	    	put.add(HBuilding.COLFAMILY, HBuilding.BUILD_AREA, Bytes.toBytes(building.getBuild_area()));
	    if(building.getNoft_area()!=null)
	    	put.add(HBuilding.COLFAMILY, HBuilding.NOFT_AREA, Bytes.toBytes(building.getNoft_area()));
	    if(building.getNo_area()!=null)
	    	put.add(HBuilding.COLFAMILY, HBuilding.NO_AREA, Bytes.toBytes(building.getNo_area()));
	    if(building.getDiscrepant_area()!=null)
	    	put.add(HBuilding.COLFAMILY, HBuilding.DISCREPANT_AREA, Bytes.toBytes(building.getDiscrepant_area()));
	    if(building.getSruver_date()!=null)
	    	put.add(HBuilding.COLFAMILY, HBuilding.SRUVER_DATE, Bytes.toBytes(building.getSruver_date()));
	    if(building.getSurver_enddate()!=null)
	    	put.add(HBuilding.COLFAMILY, HBuilding.SURVER_ENDDATE, Bytes.toBytes(building.getSurver_enddate()));
	    if(building.getBuilding_number()!=null)
	    	put.add(HBuilding.COLFAMILY, HBuilding.BUILDING_NUMBER, Bytes.toBytes(building.getBuilding_number()));
	    if(building.getBuild_struct()!=null)
	    	put.add(HBuilding.COLFAMILY, HBuilding.BUILD_STRUCT, Bytes.toBytes(building.getBuild_struct()));
	    if(building.getGraphics_code()!=null)
	    	put.add(HBuilding.COLFAMILY, HBuilding.GRAPHICS_CODE, Bytes.toBytes(building.getGraphics_code()));
	    if(building.getGraphics_number()!=null)
	    	put.add(HBuilding.COLFAMILY, HBuilding.GRAPHICS_NUMBER, Bytes.toBytes(building.getGraphics_number()));
	    if(building.getInput_date()!=null)
	    	put.add(HBuilding.COLFAMILY, HBuilding.INPUT_DATE, Bytes.toBytes(building.getInput_date()));
	    if(building.getFloorup_count()!=null)
	    	put.add(HBuilding.COLFAMILY, HBuilding.FLOORUP_COUNT, Bytes.toBytes(building.getFloorup_count()));
	    if(building.getFloordown_count()!=null)
	    	put.add(HBuilding.COLFAMILY, HBuilding.FLOORDOWN_COUNT, Bytes.toBytes(building.getFloordown_count()));
	    if(building.getCity_district()!=null){
	    	if(RegionUtil.toBZRegioncode(building.getCity_district())!=null)
	    		put.add(HBuilding.COLFAMILY, HBuilding.CITY_DISTRICT, Bytes.toBytes(RegionUtil.toBZRegioncode(building.getCity_district())));
	    }
//	    if(building.getBuilding_mapid()!=null)
//	    	put.add(HBuilding.COLFAMILY, HBuilding.BUILDING_MAPID, Bytes.toBytes(building.getBuilding_mapid()));
	    if(building.getBuilding_address()!=null)
	    	put.add(HBuilding.COLFAMILY, HBuilding.BUILDING_ADDRESS, Bytes.toBytes(building.getBuilding_address()));
	    if(building.getBuilding_date()!=null)
	    	put.add(HBuilding.COLFAMILY, HBuilding.BUILDING_DATE, Bytes.toBytes(building.getBuilding_date()));
	    if(building.getFloor_count()!=null)
	    	put.add(HBuilding.COLFAMILY, HBuilding.FLOOR_COUNT, Bytes.toBytes(building.getFloor_count()));
	    if(building.getHouse_count()!=null)
	    	put.add(HBuilding.COLFAMILY, HBuilding.HOUSE_COUNT, Bytes.toBytes(building.getHouse_count()));
	    
		return put;
	}
}
