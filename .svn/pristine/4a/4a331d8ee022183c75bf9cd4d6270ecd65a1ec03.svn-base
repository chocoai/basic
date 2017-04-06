package com.originsys.datacenter.domain;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

/**
 auth:boy 2014-3-3
   描述：项目测绘表
   和t_building表中通过building_id关联
   一幢楼在t_building表中可能会有多条，每次测绘都会在t_building表中增加一条，
   但是t_building 表中的building_mapid 一幢楼是唯一的
   也就是千度的时候根据幢座楼BUILDING_ADDRESS查询的时候，在t_building表可能查出多条
   在显示详细的时候，展示测绘结果的时候需要注意
 */
public class HSurverProject {
	/**表名*/
	public static final String TABLE_NAME="surverproject";
	/**列族信息 info*/
	public static final byte[] COLFAMILY="info".getBytes();
	
	/**rowkey 是building_mapid+building_id*/
	public static final byte[] SURVERPROJECT_ID="surverproject_id".getBytes();//项目测绘编号
	public static final byte[] BUILDING_ID="building_id".getBytes();//所在楼盘 唯一的
	public static final byte[] BUILDING_MAPID="building_mapid".getBytes();//所在楼盘内码 唯一的	
	public static final byte[] SURVERPROINST_ID="surverproinst_id".getBytes();//项目测绘流程内码
	public static final byte[] SURVERPROJECT_NAME="surverproject_name".getBytes();//项目测绘名称
	public static final byte[] SURVERPROJECT_CREATEDATE="surverproject_createdate".getBytes();//创建时间
	public static final byte[] SURVERPROJECT_ENDDATE="surverproject_enddate".getBytes();//结束时间
	public static final byte[] ENTRUST_UNIT="entrust_unit".getBytes();//委托单位
	public static final byte[] LINKMAN="linkman".getBytes();//联系人
	public static final byte[] LINKMAN_TEL="linkman_tel".getBytes();//联系方式
	public static final byte[] SURVER_TYPE="surver_type".getBytes();//测绘类型
	public static final byte[] SURVERPROJECT_DESC="surverproject_desc".getBytes();//备注
	public static final byte[] GRAPHICS_CODE="graphics_code".getBytes();//楼幢编号
	public static final byte[] SURVEY_PURPOSE="surver_purpose".getBytes();//测绘目的
	public static final byte[] PROJECTFILE_FILENAME="projectfile_filename".getBytes();//项目测绘报告文件名称
	public static final byte[] PROJECTSDDFILE_ID="projectsddfile_id".getBytes();
	
	public Put getHSurverProjectPut(YcDatacenterSurverProject project) throws Exception{
		byte[] rowkey;
		if(project.getBuilding_mapid()!=null)
			rowkey=Bytes.add(Bytes.toBytes(project.getBuilding_mapid()),Bytes.toBytes(project.getBuilding_id()));
		else{
			if(project.getBuilding_id()!=null)
				rowkey=Bytes.toBytes(project.getBuilding_id());
			else
				return null;
		}
		Put put=new Put(rowkey);
		if(project.getSurverproject_id()!=null)
			put.add(this.COLFAMILY,this.SURVERPROJECT_ID,Bytes.toBytes(project.getSurverproject_id()));//项目测绘编号
		if(project.getBuilding_id()!=null)	
			put.add(this.COLFAMILY,this.BUILDING_ID,Bytes.toBytes(project.getBuilding_id()));//所在楼盘 唯一的
		if(project.getBuilding_mapid()!=null)	
			put.add(this.COLFAMILY,this.BUILDING_MAPID,Bytes.toBytes(project.getBuilding_mapid()));//所在楼盘内码 唯一的
		if(project.getSurverproinst_id()!=null)	
			put.add(this.COLFAMILY,this.SURVERPROINST_ID,Bytes.toBytes(project.getSurverproinst_id()));//项目测绘流程内码
		if(project.getSurverproject_name()!=null)	
			put.add(this.COLFAMILY,this.SURVERPROJECT_NAME,Bytes.toBytes(project.getSurverproject_name()));//项目测绘名称
		if(project.getSurverproject_createdate()!=null)	
			put.add(this.COLFAMILY,this.SURVERPROJECT_CREATEDATE,Bytes.toBytes(project.getSurverproject_createdate()));//创建时间
		if(project.getSurverproject_enddate()!=null)	
			put.add(this.COLFAMILY,this.SURVERPROJECT_ENDDATE,Bytes.toBytes(project.getSurverproject_enddate()));//结束时间
		if(project.getEntrust_unit()!=null)	
			put.add(this.COLFAMILY,this.ENTRUST_UNIT,Bytes.toBytes(project.getEntrust_unit()));//委托单位
		if(project.getLinkman()!=null)	
			put.add(this.COLFAMILY,this.LINKMAN,Bytes.toBytes(project.getLinkman()));//联系人
		if(project.getLinkman_tel()!=null)	
			put.add(this.COLFAMILY,this.LINKMAN_TEL,Bytes.toBytes(project.getLinkman_tel()));//联系方式
		if(project.getSurver_type()!=null)	
			put.add(this.COLFAMILY,this.SURVER_TYPE,Bytes.toBytes(project.getSurver_type()));//测绘类型
		if(project.getSurverproject_desc()!=null)	
			put.add(this.COLFAMILY,this.SURVERPROJECT_DESC,Bytes.toBytes(project.getSurverproject_desc()));//备注
		if(project.getGraphics_code()!=null)	
			put.add(this.COLFAMILY,this.GRAPHICS_CODE,Bytes.toBytes(project.getGraphics_code()));//楼幢编号
		if(project.getSurver_purpose()!=null)	
			put.add(this.COLFAMILY,this.SURVEY_PURPOSE,Bytes.toBytes(project.getSurver_purpose()));//测绘目的
		if(project.getProjectfile_filename()!=null)	
			put.add(this.COLFAMILY,this.PROJECTFILE_FILENAME,Bytes.toBytes(project.getProjectfile_filename()));//项目测绘报告文件名称
		if(project.getProjectsddfile_id()!=null)
			put.add(this.COLFAMILY,this.PROJECTSDDFILE_ID,Bytes.toBytes(project.getProjectsddfile_id()));
						
		return put;
	}
	
}
