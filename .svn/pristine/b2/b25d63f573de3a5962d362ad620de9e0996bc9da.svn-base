package com.originsys.datacenter.domain;

import org.apache.hadoop.hbase.client.Result;

import com.originsys.realtygis.domain.RT_prolinkbase;

/**
 auth:boy 2014-3-3
   描述：基础测绘和项目测绘关联表，项目测绘编号是唯一的，且会根据项目编号找基础测绘编号
   多个项目测绘编号可能对应一个基础测绘编号
 */
public class HRT_prolinkbase {
	/**表名*/
	public static final String TABLE_NAME="rt_prolinkbase";
	/**列族信息 info*/
	public static final byte[] COLFAMILY="info".getBytes();
	/**rowkey 是项目测绘编号SURVERPROJECT_ID*/
	public static final byte[] SURVERPROJECT_ID="sp_id".getBytes();//项目测绘编号
	public static final byte[] SURVERBASIC_ID="sb_id".getBytes();//基础测绘编号
	
	public RT_prolinkbase toRTprolinkbase(Result rs){
		RT_prolinkbase temp=new RT_prolinkbase();
		byte[] sp_id=rs.getValue(this.COLFAMILY, this.SURVERPROJECT_ID);
		int spid=0;
		if(sp_id!=null){
			spid=Integer.parseInt(new String(sp_id));
		}
		temp.setSurverproject_id(spid);
		byte[] sb_id=rs.getValue(this.COLFAMILY, this.SURVERBASIC_ID);
		int sbid=0;
		if(sb_id!=null){
			sbid=Integer.parseInt(new String(sb_id));
		}
		temp.setSurverbasic_id(sbid);
		sp_id=null;
		sb_id=null;
		return temp;
	}
}
