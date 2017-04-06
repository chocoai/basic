package com.originsys.datacenter.domain;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

/**
 auth:boy 2014-3-3
   描述：基础测绘表 
   和项目测绘通过hrt_prolinkbase表中的对应关系关联
   通过项目测绘编号表中的t_building表中关联
 */
public class HSurverBasic {
	/**表名*/
	public static final String TABLE_NAME="surverbasic";
	/**列族信息 info*/
	public static final byte[] COLFAMILY="info".getBytes();
	/**rowkey 是building_mapid+building_id*/
	public static final byte[] SURVERBASIC_ID="surverbasic_id".getBytes();//基础测绘id
	public static final byte[] BUILDING_ID="building_id".getBytes();//所在楼盘 唯一的
	public static final byte[] BUILDING_MAPID="building_mapid".getBytes();//所在楼盘内码 唯一的	
	public static final byte[] SURVERPROINST_ID="surverproinst_id".getBytes();//基础测绘内码
	public static final byte[] SURVERBASIC_NAME="surverbasic_name".getBytes();//基础测绘名称
	public static final byte[] SURVER_TYPE="surver_type".getBytes();//测绘类型
	public static final byte[] SURVERBASIC_CREATEDATE="surverbasic_createdate".getBytes();//创建时间
	public static final byte[] SURVERBASIC_ENDDATE="surverbasic_enddate".getBytes();//结束时间
	public static final byte[] ENTRUST_UNIT="entrust_unit".getBytes();//委托单位
	public static final byte[] LINKMAN="linkman".getBytes();//联系人
	public static final byte[] LINKMAN_TEL="linkman_tel".getBytes();//联系方式
	public static final byte[] SURVERBASIC_ADDRESS="surverbasic_address".getBytes();//坐落
	public static final byte[] SURVERBASIC_DESC="surverbasic_desc".getBytes();//备注
	public static final byte[] CITY_DISTRICT="city_district".getBytes();//所属城区
	public static final byte[] SURVERAREA_VALUE="surverarea_value".getBytes();//测绘面积
	public static final byte[] BASICPRODUCT_FILENAME="basicproduct_filename".getBytes();//基础测绘成果文件名
	
	public Put getHSurverBasicPut(YcDatacenterSurverBasic basic) throws Exception{
		byte[] rowkey;
		if(basic.getBuilding_mapid()!=null)
			rowkey=Bytes.add(Bytes.toBytes(basic.getBuilding_mapid()),Bytes.toBytes(basic.getBuilding_id()));
		else
			rowkey=Bytes.toBytes(basic.getBuilding_id());
		Put put=new Put(rowkey);
		if(basic.getSurverbasic_id()!=null)
			put.add(this.COLFAMILY,this.SURVERBASIC_ID,Bytes.toBytes(basic.getSurverbasic_id()));//基础测绘id
		if(basic.getBuilding_id()!=null)
			put.add(this.COLFAMILY,this.BUILDING_ID,Bytes.toBytes(basic.getBuilding_id()));//所在楼盘 唯一的
		if(basic.getBuilding_mapid()!=null)	
			put.add(this.COLFAMILY,this.BUILDING_MAPID,Bytes.toBytes(basic.getBuilding_mapid()));//所在楼盘内码 唯一的	
		if(basic.getSurverproinst_id()!=null)	
			put.add(this.COLFAMILY,this.SURVERPROINST_ID,Bytes.toBytes(basic.getSurverproinst_id()));//基础测绘内码
		if(basic.getSurverbasic_name()!=null)	
			put.add(this.COLFAMILY,this.SURVERBASIC_NAME,Bytes.toBytes(basic.getSurverbasic_name()));//基础测绘名称
		if(basic.getSurver_type()!=null)	
			put.add(this.COLFAMILY,this.SURVER_TYPE,Bytes.toBytes(basic.getSurver_type()));//测绘类型
		if(basic.getSurverbasic_createdate()!=null)	
			put.add(this.COLFAMILY,this.SURVERBASIC_CREATEDATE,Bytes.toBytes(basic.getSurverbasic_createdate()));//创建时间
		if(basic.getSurverbasic_enddate()!=null)	
			put.add(this.COLFAMILY,this.SURVERBASIC_ENDDATE,Bytes.toBytes(basic.getSurverbasic_enddate()));//结束时间
		if(basic.getEntrust_unit()!=null)	
			put.add(this.COLFAMILY,this.ENTRUST_UNIT,Bytes.toBytes(basic.getEntrust_unit()));//委托单位
		if(basic.getLinkman()!=null)	
			put.add(this.COLFAMILY,this.LINKMAN,Bytes.toBytes(basic.getLinkman()));//联系人
		if(basic.getLinkman_tel()!=null)	
			put.add(this.COLFAMILY,this.LINKMAN_TEL,Bytes.toBytes(basic.getLinkman_tel()));//联系方式
		if(basic.getSurverbasic_address()!=null)	
			put.add(this.COLFAMILY,this.SURVERBASIC_ADDRESS,Bytes.toBytes(basic.getSurverbasic_address()));//坐落
		if(basic.getSurverbasic_desc()!=null)	
			put.add(this.COLFAMILY,this.SURVERBASIC_DESC,Bytes.toBytes(basic.getSurverbasic_desc()));//备注
		if(basic.getCity_district()!=null)	
			put.add(this.COLFAMILY,this.CITY_DISTRICT,Bytes.toBytes(basic.getCity_district()));//所属城区
		if(basic.getSurverarea_value()!=null)	
			put.add(this.COLFAMILY,this.SURVERAREA_VALUE,Bytes.toBytes(basic.getSurverarea_value()));//测绘面积
		if(basic.getBasicproduct_filename()!=null)	
			put.add(this.COLFAMILY,this.BASICPRODUCT_FILENAME,Bytes.toBytes(basic.getBasicproduct_filename()));//基础测绘成果文件名
		return put;
	}
}
