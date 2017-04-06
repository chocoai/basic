package com.originsys.datacenter.domain;

/**
 auth:boy 2014-5-8
   描述：楼幢安全跟踪表
   楼幢的安全普查，安全检查，安全鉴定
 */
public class HBuildingSafe {
	/**表名*/
	public static final String TABLE_NAME="building_safe";
	/**列族信息 info*/
	public static final byte[] COLFAMILY="info".getBytes();
	/**rowkey是building_id+时间串*/
	/**操作*/
	public static final byte[] OP="op".getBytes();
	/**操作时间*/
	public static final byte[] OPDATE="opdate".getBytes();
	/**操作结果*/
	public static final byte[] OPRESULT="opresult".getBytes();
	/**危楼类型*/
	public static final byte[] OPTYPE="optype".getBytes();
	/**相关图片--存放图片路径*/
	public static final byte[] ANNEX_IMAGE="annex_image".getBytes();
	/**相关附件-存放下载地址*/
	public static final byte[] ANNEX_FILE="annex_file".getBytes();
	
}
