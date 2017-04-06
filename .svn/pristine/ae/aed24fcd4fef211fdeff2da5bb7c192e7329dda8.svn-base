package com.originsys.datacenter.domain;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

import com.originsys.realtygis.domain.House;

/**
 auth:boy 2014-3-3
   描述：hbase数据库房屋表
 */
public class HHouse {
	/**表名*/
	public static final String TABLE_NAME="house";
	/**列族信息 info*/
	public static final byte[] COLFAMILY="info".getBytes();
	/**rowkey是building_id+house_id*/
	//内码
	public static final byte[] HOUSE_ID="house_id".getBytes();//房屋内码
	public static final byte[] SHOUSE_ID="shouse_id".getBytes();//标准房屋内码
	public static final byte[] BUILDING_ID="building_id".getBytes();//幢号内码
	public static final byte[] PROJECTSDDFILE_ID="psfile_id".getBytes();
	public static final byte[] FLOOR_ID="floor_id".getBytes();//楼层表内码
	public static final byte[] FW_ADDRESS="fw_address".getBytes();//房屋坐落
	public static final byte[] LAY_NUM="lay_num".getBytes();//所属层数
	public static final byte[] FLOOR_START="floor_start".getBytes();//房屋开始层
	public static final byte[] FLOOR_END="floor_end".getBytes();//房屋结束层
	public static final byte[] UNIT_NUMBER="unit_number".getBytes();//单元号
	public static final byte[] UNIT_ALIAS="unit_alias".getBytes();//单元别名
	public static final byte[] ROOM_NUMBER="room_number".getBytes();//房号
	public static final byte[] ROOM_ALIAS="room_alias".getBytes();//房号别名
	public static final byte[] ZH="zh".getBytes();//幢号
	public static final byte[] FW_LAYERS="fw_layers".getBytes();//主体所在层
	public static final byte[] STRUCT="struct".getBytes();//结构
	public static final byte[] TNJZ_AREA="tnjz_area".getBytes();//套内建筑面积
	public static final byte[] FT_AREA="ft_area".getBytes();//分摊面积
	public static final byte[] JZ_AREA="jz_area".getBytes();//建筑面积
	public static final byte[] YT_AREA="yt_area".getBytes();//阳台面积
	public static final byte[] SY_AREA="sy_area".getBytes();//使用面积
	public static final byte[] DESIGN_YT="design_yt".getBytes();//设计用途
	public static final byte[] FACT_YT="fact_yt".getBytes();//实际用途
	public static final byte[] FW_cb="fw_cb".getBytes();//房屋产别
	public static final byte[] BIRCH_DATE="birth_date".getBytes();//建成时间
	public static final byte[] FW_DH="fw_dh".getBytes();//房屋地号
	public static final byte[] RIGHT_NUM="right_num".getBytes();//房屋权号
	public static final byte[] DOOR_TYPE="door_type".getBytes();//户室类型
	public static final byte[] YS_ADDRESS="ys_address".getBytes();//预售坐落
	public static final byte[] JC_DOORNUM="jc_doornum".getBytes();//基层房号
	public static final byte[] FLOOR_NUM="floor_num".getBytes();//地上层号
	public static final byte[] FLOORDOWN_NUM="floordown_num".getBytes();//楼幢地下层数
	public static final byte[] FT_COEFF="ft_coeff".getBytes();//分摊系数
	public static final byte[] YC_AREA="yc_area".getBytes();//预测面积
	public static final byte[] HOUSE_CODE="house_code".getBytes();//房屋编号
	public static final byte[] BUILDING_MAPID="building_mapid".getBytes();//所在楼盘内码
	public static final byte[] MAP_ID="map_id".getBytes();//户室图形内码
	public static final byte[] INPUT_DATE="input_date".getBytes();//入库时间
	public static final byte[] BEFORHAND_MAPPING="beforhand_mapping".getBytes();//预实测绘（区分预测绘还是实测绘）
	public static final byte[] HOUSE_STAT="house_stat".getBytes();//房屋状态
	public static final byte[] DIE_TIME="die_time".getBytes();//消亡时间
	public static final byte[] ROOM_NUMBER_ORDER="room_number_order".getBytes();//房间序号（1，2，3，4，5）
	
	public House toHouse(Result rs){
		House house=new House();
		house.setBuilding_id(Bytes.toString(rs.getValue(this.COLFAMILY, this.BUILDING_ID)));
		house.setHouse_id(Bytes.toString(rs.getValue(this.COLFAMILY, this.HOUSE_ID)));
		if(rs.getValue(this.COLFAMILY, this.PROJECTSDDFILE_ID)!=null)
			house.setProjectsddfile_id(Bytes.toString(rs.getValue(this.COLFAMILY, this.PROJECTSDDFILE_ID)));
		if(rs.getValue(this.COLFAMILY, this.FLOOR_ID)!=null)
			house.setFloor_id(Bytes.toString(rs.getValue(this.COLFAMILY, this.FLOOR_ID)));
		if(rs.getValue(this.COLFAMILY, this.FW_ADDRESS)!=null)
			house.setFw_address(Bytes.toString(rs.getValue(this.COLFAMILY, this.FW_ADDRESS)));
		if(rs.getValue(this.COLFAMILY, this.LAY_NUM)!=null)
			house.setLay_num(Bytes.toString(rs.getValue(this.COLFAMILY, this.LAY_NUM)));
		if(rs.getValue(this.COLFAMILY, this.FLOOR_START)!=null)
			house.setFloor_start(Bytes.toString(rs.getValue(this.COLFAMILY, this.FLOOR_START)));
		if(rs.getValue(this.COLFAMILY, this.FLOOR_END)!=null)
			house.setFloor_end(Bytes.toString(rs.getValue(this.COLFAMILY, this.FLOOR_END)));
		if(rs.getValue(this.COLFAMILY, this.UNIT_NUMBER)!=null)
			house.setUnit_number(Bytes.toString(rs.getValue(this.COLFAMILY, this.UNIT_NUMBER)));
		if(rs.getValue(this.COLFAMILY, this.UNIT_ALIAS)!=null)
			house.setUnit_alias(Bytes.toString(rs.getValue(this.COLFAMILY, this.UNIT_ALIAS)));
		if(rs.getValue(this.COLFAMILY, this.ROOM_NUMBER)!=null)
			house.setRoom_number(Bytes.toString(rs.getValue(this.COLFAMILY, this.ROOM_NUMBER)));
		if(rs.getValue(this.COLFAMILY, this.ROOM_ALIAS)!=null)
			house.setRoom_alias(Bytes.toString(rs.getValue(this.COLFAMILY, this.ROOM_ALIAS)));
		if(rs.getValue(this.COLFAMILY, this.ZH)!=null)
			house.setZh(Bytes.toString(rs.getValue(this.COLFAMILY, this.ZH)));
		if(rs.getValue(this.COLFAMILY, this.FW_LAYERS)!=null)
			house.setFw_layers(Bytes.toString(rs.getValue(this.COLFAMILY, this.FW_LAYERS)));
		if(rs.getValue(this.COLFAMILY, this.STRUCT)!=null)
			house.setStruct(Bytes.toString(rs.getValue(this.COLFAMILY, this.STRUCT)));
		if(rs.getValue(this.COLFAMILY, this.TNJZ_AREA)!=null)
			house.setTnjz_area(Bytes.toString(rs.getValue(this.COLFAMILY, this.TNJZ_AREA)));
		if(rs.getValue(this.COLFAMILY, this.FT_AREA)!=null)
			house.setFt_area(Bytes.toString(rs.getValue(this.COLFAMILY, this.FT_AREA)));
		if(rs.getValue(this.COLFAMILY, this.JZ_AREA)!=null){
			String jz_area=Bytes.toString(rs.getValue(this.COLFAMILY, this.JZ_AREA));
			Double jzarea=0.0;
			try{
				jzarea=Double.parseDouble(jz_area);
			}catch(Exception e){
				jzarea=0.0;
			}
			house.setJz_area(jzarea);
		}
		if(rs.getValue(this.COLFAMILY, this.YT_AREA)!=null)
			house.setYt_area(Bytes.toString(rs.getValue(this.COLFAMILY, this.YT_AREA)));
		if(rs.getValue(this.COLFAMILY, this.SY_AREA)!=null)
			house.setSy_area(Bytes.toString(rs.getValue(this.COLFAMILY, this.SY_AREA)));
		if(rs.getValue(this.COLFAMILY, this.DESIGN_YT)!=null)
			house.setDesign_yt(Bytes.toString(rs.getValue(this.COLFAMILY, this.DESIGN_YT)));
		if(rs.getValue(this.COLFAMILY, this.FACT_YT)!=null)
			house.setFact_yt(Bytes.toString(rs.getValue(this.COLFAMILY, this.FACT_YT)));
		if(rs.getValue(this.COLFAMILY, this.FW_cb)!=null)
			house.setFw_cb(Bytes.toString(rs.getValue(this.COLFAMILY, this.FW_cb)));
		if(rs.getValue(this.COLFAMILY, this.BIRCH_DATE)!=null)
			house.setBirth_date(Bytes.toString(rs.getValue(this.COLFAMILY, this.BIRCH_DATE)));
		if(rs.getValue(this.COLFAMILY, this.FW_DH)!=null)
			house.setFw_dh(Bytes.toString(rs.getValue(this.COLFAMILY, this.FW_DH)));
		if(rs.getValue(this.COLFAMILY, this.RIGHT_NUM)!=null)
			house.setRight_num(Bytes.toString(rs.getValue(this.COLFAMILY, this.RIGHT_NUM)));
		if(rs.getValue(this.COLFAMILY, this.DOOR_TYPE)!=null)
			house.setDoor_type(Bytes.toString(rs.getValue(this.COLFAMILY, this.DOOR_TYPE)));
		if(rs.getValue(this.COLFAMILY, this.YS_ADDRESS)!=null)
			house.setYs_address(Bytes.toString(rs.getValue(this.COLFAMILY, this.YS_ADDRESS)));
		if(rs.getValue(this.COLFAMILY, this.JC_DOORNUM)!=null)
			house.setJc_doornum(Bytes.toString(rs.getValue(this.COLFAMILY, this.JC_DOORNUM)));
		if(rs.getValue(this.COLFAMILY, this.FLOOR_NUM)!=null)
			house.setFloor_num(Bytes.toString(rs.getValue(this.COLFAMILY, this.FLOOR_NUM)));
		if(rs.getValue(this.COLFAMILY, this.FLOORDOWN_NUM)!=null)
			house.setFloordown_num(Bytes.toString(rs.getValue(this.COLFAMILY, this.FLOORDOWN_NUM)));
		if(rs.getValue(this.COLFAMILY, this.FT_COEFF)!=null)
			house.setFt_coeff(Bytes.toString(rs.getValue(this.COLFAMILY, this.FT_COEFF)));
		if(rs.getValue(this.COLFAMILY, this.YC_AREA)!=null)
			house.setYc_area(Bytes.toString(rs.getValue(this.COLFAMILY, this.YC_AREA)));
		if(rs.getValue(this.COLFAMILY, this.HOUSE_CODE)!=null)
			house.setHouse_code(Bytes.toString(rs.getValue(this.COLFAMILY, this.HOUSE_CODE)));
		if(rs.getValue(this.COLFAMILY, this.BUILDING_MAPID)!=null)
			house.setBuilding_mapid(Bytes.toString(rs.getValue(this.COLFAMILY, this.BUILDING_MAPID)));
		if(rs.getValue(this.COLFAMILY, this.MAP_ID)!=null)
			house.setMap_id(Bytes.toString(rs.getValue(this.COLFAMILY, this.MAP_ID)));
		if(rs.getValue(this.COLFAMILY, this.INPUT_DATE)!=null)
			house.setInput_date(Bytes.toString(rs.getValue(this.COLFAMILY, this.INPUT_DATE)));
		if(rs.getValue(this.COLFAMILY, this.BEFORHAND_MAPPING)!=null)
			house.setBeforhand_mapping(Bytes.toString(rs.getValue(this.COLFAMILY, this.BEFORHAND_MAPPING)));
		if(rs.getValue(this.COLFAMILY, this.HOUSE_STAT)!=null)
			house.setHouse_stat(Bytes.toString(rs.getValue(this.COLFAMILY, this.HOUSE_STAT)));
		if(rs.getValue(this.COLFAMILY, this.DIE_TIME)!=null)
			house.setDie_time(Bytes.toString(rs.getValue(this.COLFAMILY, this.DIE_TIME)));
		if(rs.getValue(this.COLFAMILY, this.ROOM_NUMBER_ORDER)!=null)
			house.setRoom_number_order(Bytes.toString(rs.getValue(this.COLFAMILY, this.ROOM_NUMBER_ORDER)));
		return house;
	}
	
	public Put getHHousePut(House house) throws Exception{
		byte[] rowkey=Bytes.add(Bytes.toBytes(house.getBuilding_id()),Bytes.toBytes(house.getHouse_id()));
		Put put=new Put(rowkey);
		put.add(this.COLFAMILY, this.HOUSE_ID, Bytes.toBytes(house.getHouse_id()));//房屋内码		
		put.add(this.COLFAMILY, this.BUILDING_ID,Bytes.toBytes(house.getBuilding_id()));//幢号内码
		if(house.getProjectsddfile_id()!=null)
			put.add(this.COLFAMILY, this.PROJECTSDDFILE_ID,Bytes.toBytes(house.getProjectsddfile_id()));
		if(house.getFloor_id()!=null)
			put.add(this.COLFAMILY, this.FLOOR_ID,Bytes.toBytes(house.getFloor_id()));//楼层表内码
		if(house.getFw_address()!=null)
			put.add(this.COLFAMILY, this.FW_ADDRESS,Bytes.toBytes(house.getFw_address()));//房屋坐落
		if(house.getLay_num()!=null)
			put.add(this.COLFAMILY, this.LAY_NUM,Bytes.toBytes(house.getLay_num()));//所属层数
		if(house.getFloor_start()!=null)
			put.add(this.COLFAMILY, this.FLOOR_START,Bytes.toBytes(house.getFloor_start()));//房屋开始层
		if(house.getFloor_end()!=null)
			put.add(this.COLFAMILY, this.FLOOR_END,Bytes.toBytes(house.getFloor_end()));//房屋结束层
		if(house.getUnit_number()!=null)
			put.add(this.COLFAMILY, this.UNIT_NUMBER,Bytes.toBytes(house.getUnit_number()));//单元号
		if(house.getUnit_alias()!=null)
			put.add(this.COLFAMILY, this.UNIT_ALIAS,Bytes.toBytes(house.getUnit_alias()));//单元别名
		if(house.getRoom_number()!=null)
			put.add(this.COLFAMILY, this.ROOM_NUMBER,Bytes.toBytes(house.getRoom_number()));//房号
		if(house.getRoom_alias()!=null)
			put.add(this.COLFAMILY, this.ROOM_ALIAS,Bytes.toBytes(house.getRoom_alias()));//房号别名
		if(house.getZh()!=null)
			put.add(this.COLFAMILY, this.ZH,Bytes.toBytes(house.getZh()));//幢号
		if(house.getFw_layers()!=null)
			put.add(this.COLFAMILY, this.FW_LAYERS,Bytes.toBytes(house.getFw_layers()));//主体所在层
		if(house.getStruct()!=null)
			put.add(this.COLFAMILY, this.STRUCT,Bytes.toBytes(house.getStruct()));//结构
		if(house.getTnjz_area()!=null)
			put.add(this.COLFAMILY, this.TNJZ_AREA,Bytes.toBytes(house.getTnjz_area()));//套内建筑面积
		if(house.getFt_area()!=null)
			put.add(this.COLFAMILY, this.FT_AREA,Bytes.toBytes(house.getFt_area()));//分摊面积
		if(house.getJz_area()!=null)
			put.add(this.COLFAMILY, this.JZ_AREA,(Bytes.toBytes(house.getJz_area()+"")));//建筑面积
		if(house.getYt_area()!=null)
			put.add(this.COLFAMILY, this.YT_AREA,Bytes.toBytes(house.getYt_area()));//阳台面积
		if(house.getSy_area()!=null)
			put.add(this.COLFAMILY, this.SY_AREA,Bytes.toBytes(house.getSy_area()));//使用面积
		if(house.getDesign_yt()!=null)
			put.add(this.COLFAMILY, this.DESIGN_YT,Bytes.toBytes(house.getDesign_yt()));//设计用途
		if(house.getFact_yt()!=null)
			put.add(this.COLFAMILY, this.FACT_YT,Bytes.toBytes(house.getFact_yt()));//实际用途
		if(house.getFw_cb()!=null)
			put.add(this.COLFAMILY, this.FW_cb,Bytes.toBytes(house.getFw_cb()));//房屋产别
		if(house.getBirth_date()!=null)
			put.add(this.COLFAMILY, this.BIRCH_DATE,Bytes.toBytes(house.getBirth_date()));//建成时间
		if(house.getFw_dh()!=null)
			put.add(this.COLFAMILY, this.FW_DH,Bytes.toBytes(house.getFw_dh()));//房屋地号		
		if(house.getRight_num()!=null)
			put.add(this.COLFAMILY, this.RIGHT_NUM,Bytes.toBytes(house.getRight_num()));//房屋权号
		if(house.getDoor_type()!=null)
			put.add(this.COLFAMILY, this.DOOR_TYPE,Bytes.toBytes(house.getDoor_type()));//户室类型
		if(house.getYs_address()!=null)
			put.add(this.COLFAMILY, this.YS_ADDRESS,Bytes.toBytes(house.getYs_address()));//预售坐落
		if(house.getJc_doornum()!=null)
			put.add(this.COLFAMILY, this.JC_DOORNUM,Bytes.toBytes(house.getJc_doornum()));//基层房号
		if(house.getFloor_num()!=null)
			put.add(this.COLFAMILY, this.FLOOR_NUM,Bytes.toBytes(house.getFloor_num()));//地上层号
		if(house.getFloordown_num()!=null)
			put.add(this.COLFAMILY, this.FLOORDOWN_NUM,Bytes.toBytes(house.getFloordown_num()));//楼幢地下层数
		if(house.getFt_coeff()!=null)
			put.add(this.COLFAMILY, this.FT_COEFF,Bytes.toBytes(house.getFt_coeff()));//分摊系数
		if(house.getYc_area()!=null)
			put.add(this.COLFAMILY, this.YC_AREA,Bytes.toBytes(house.getYc_area()));//预测面积
		if(house.getHouse_code()!=null)
			put.add(this.COLFAMILY, this.HOUSE_CODE,Bytes.toBytes(house.getHouse_code()));//房屋编号
		if(house.getBuilding_mapid()!=null)
			put.add(this.COLFAMILY, this.BUILDING_MAPID,Bytes.toBytes(house.getBuilding_mapid()));//所在楼盘内码
		if(house.getMap_id()!=null)
			put.add(this.COLFAMILY, this.MAP_ID,Bytes.toBytes(house.getMap_id()));//户室图形内码
		if(house.getInput_date()!=null)
			put.add(this.COLFAMILY, this.INPUT_DATE,Bytes.toBytes(house.getInput_date()));//入库时间
		if(house.getBeforhand_mapping()!=null)
			put.add(this.COLFAMILY, this.BEFORHAND_MAPPING,Bytes.toBytes(house.getBeforhand_mapping()));//预实测绘（区分预测绘还是实测绘）
		if(house.getHouse_stat()!=null)
			put.add(this.COLFAMILY, this.HOUSE_STAT,Bytes.toBytes(house.getHouse_stat()));//房屋状态
		if(house.getDie_time()!=null)
			put.add(this.COLFAMILY, this.DIE_TIME,Bytes.toBytes(house.getDie_time()));//消亡时间
		if(house.getRoom_number_order()!=null)
			put.add(this.COLFAMILY, this.ROOM_NUMBER_ORDER,Bytes.toBytes(house.getRoom_number_order()));//房间序号（1，2，3，4，5）		
		return put;
	}
}
