package com.originsys.datacenter.action;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.HTablePool;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.datacenter.domain.HBuilding;
import com.originsys.datacenter.domain.HHouse;
import com.originsys.datacenter.domain.HSurverBasic;
import com.originsys.datacenter.domain.HSurverProject;
import com.originsys.datacenter.domain.YcDatacenterSurverBasic;
import com.originsys.datacenter.domain.YcDatacenterSurverProject;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.FileReaderUtil;
import com.originsys.eap.util.OrgContextHolder;
import com.originsys.datacenter.domain.Building;
import com.originsys.realtygis.domain.House;

/**
 auth:boy 2014-3-17
   描述：数据同步
 */
public class DataSynch extends BaseAction implements Job{

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		/** 设置线程的局部变量 读取属性配置文件*/
		OrgContextHolder.setVendorType("eap2");		
		
		/**记录操作日志，最终写到文件中，这样出问题的时候也好查找是哪里的问题，每次同步记录一个日志文件*/
		StringBuffer logbuf=new StringBuffer();
		Date logdate=new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    	String logdatestr=sdf.format(logdate);
		logbuf.append(logdatestr+"数据同步开始\r\n");
		/**同步房屋信息*/
//		logbuf.append(synchHouse());
		/**同步楼幢信息*/
		logbuf.append(synchBuilding());
		/**同步基础测绘信息*/
		logbuf.append(synchSurverBasic());
		/**同步项目测绘信息*/
		logbuf.append(synchSurverProject());
		try{
			ResourceBundle rb=FileReaderUtil.getInstance().getResourceBundle("realtygis");
			SimpleDateFormat simpledateformat =
					new SimpleDateFormat("yyyy-MM-dd");			
			/**输出日志文件*/
			File f = new File(rb.getString("logfilepath")+"HbaseSynchDataLog_"+simpledateformat.format(new Date())+".txt");
			if(f.exists()){  
			}else{
				f.createNewFile();
			} 
			BufferedWriter output = new BufferedWriter(new FileWriter(f)); 
			output.write(logbuf.toString()); 
			output.flush();
			output.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private String synchHouse(){
		SqlMapClient sc=DataSource.getSqlMapInstance();
		StringBuffer sb=new StringBuffer();
		sb.append("Hbase数据库house表数据同步开始========================\r\n");		
		try{
			/**获取表中的总数量，如果数据大于0，则同步，如果大于1000条，则分页查询*/
			int total_num=((Integer)sc.queryForObject("datacenter.getDCHouseListNum")).intValue();
			if(total_num>0){
				HBaseConfiguration config = new HBaseConfiguration(); 
				int page=1;
			    int start=0;
			    int pagenum=1000;
			    int end=1000;
			    int add_num=0;
	 	        int del_num=0;
			    if(total_num>1000){
			    	int x1=total_num%1000;
			    	if(x1>0){
			    		page=(int)total_num/1000+1;
			    	}else
			    		page=(int)total_num/1000;
			    }
			    Map<String,Integer> param=new HashMap<String,Integer>();
			    for(int j=1;j<=page;j++){
			    	HTablePool pool = new HTablePool(config, 1000);
			    	HTableInterface table = pool.getTable(HHouse.TABLE_NAME);
			    	start=(j-1)*pagenum;
			    	end = j*pagenum;
			    	param.put("_page_start", start);
					param.put("_page_nums", pagenum);//该参数是为MySQL数据库准备的
					param.put("_page_end", end);//该参数是为Oracle数据库准备的
					List<House> houselist=sc.queryForList("datacenter.getDCHouseList",param);					
					if(houselist!=null){
						for(int i=0;i<houselist.size();i++){
							House house=houselist.get(i);
							try{	
								if("00".equals(house.getSynch_type())||"01".equals(house.getSynch_type())){
									Put put=new HHouse().getHHousePut(house);
									table.put(put);
									add_num++;
								}
								if("02".equals(house.getSynch_type())){
									byte[] rowkey=Bytes.add(house.getBuilding_id().getBytes(),house.getHouse_id().getBytes());
									Delete d=new Delete(rowkey);
								    table.delete(d);
								    del_num++;
								}
								/**删掉原来的数据*/
								sc.delete("datacenter.deleteHouseSyn", house.getSid());
								house=null;						
							}catch(Exception e){
								sb.append("Hbase数据库house表数据同步异常:"+e.getMessage()+"======sid="+house.getSid()+"\r\n");
								e.printStackTrace();
								continue;
							}
						}
						table.close();
						pool.close();
					}
					houselist=null;
			    }				
				sb.append("Hbase数据库house表数据同步成功,增加数据"+add_num+"条，删除数据"+del_num+"条\r\n");
			}else{
				sb.append("Hbase数据库house表没有需要同步的数据\r\n");
			}
		}catch(Exception e){
			e.printStackTrace();
			sb.append("Hbase数据库house表数据同步失败，异常是:"+e.getMessage()+"\r\n");
		}		
		return sb.toString();
	}
	
	private String synchBuilding(){
		SqlMapClient sc=DataSource.getSqlMapInstance();
		StringBuffer sb=new StringBuffer();
		sb.append("Hbase数据库building表数据同步开始========================\r\n");		
		try{
			/**获取表中的总数量，如果数据大于0，则同步，如果大于1000条，则分页查询*/
			int total_num=((Integer)sc.queryForObject("datacenter.getDCBuildingListNum")).intValue();
			if(total_num>0){
				HBaseConfiguration config = new HBaseConfiguration(); 
				int page=1;
			    int start=0;
			    int pagenum=1000;
			    int end=1000;
			    int add_num=0;
	 	        int del_num=0;
			    if(total_num>1000){
			    	int x1=total_num%1000;
			    	if(x1>0){
			    		page=(int)total_num/1000+1;
			    	}else
			    		page=(int)total_num/1000;
			    }
			    Map<String,Integer> param=new HashMap<String,Integer>();
			    for(int j=1;j<=page;j++){
			    	start=(j-1)*pagenum;
			    	end = j*pagenum;
			    	param.put("_page_start", start);
					param.put("_page_nums", pagenum);//该参数是为MySQL数据库准备的
					param.put("_page_end", end);//该参数是为Oracle数据库准备的
					HTablePool pool = new HTablePool(config, 1000);  
					HTableInterface table = pool.getTable(HBuilding.TABLE_NAME);
					List<Building> buildinglist=sc.queryForList("datacenter.getDCBuildingList",param);
					if(buildinglist!=null){
						for(int i=0;i<buildinglist.size();i++){
							Building building=buildinglist.get(i);
							/**================将building_mapid的值附给building_id 这样可以确保和大数据匹配*/
							if(building.getBuilding_mapid()!=null&&!"".equals(building.getBuilding_mapid()))
								building.setBuilding_id(building.getBuilding_mapid());
							try{	
								if("00".equals(building.getSynch_type())||"01".equals(building.getSynch_type())){
									Put put=new HBuilding().getHBuildingPut(building);
									table.put(put);
									add_num++;
								}
								if("02".equals(building.getSynch_type())){
									Delete d=new Delete(building.getBuilding_id().getBytes());
								    table.delete(d);
								    del_num++;
								}
								/**删掉原来的数据*/
								sc.delete("datacenter.deleteBuildingSyn", building.getSid());
								building=null;						
							}catch(Exception e){
								sb.append("Hbase数据库building表数据同步异常:"+e.getMessage()+"======sid="+building.getSid()+"\r\n");
								e.printStackTrace();
								continue;
							}
						}
						table.close();
						pool.close();
					}
					buildinglist=null;
			    }
			    sb.append("Hbase数据库building表数据同步成功,增加数据"+add_num+"条，删除数据"+del_num+"条\r\n");
			}else{
				sb.append("Hbase数据库building表没有需要同步的数据\r\n");
			}			
		}catch(Exception e){
			e.printStackTrace();
			sb.append("Hbase数据库building表数据同步失败，异常是:"+e.getMessage()+"\r\n");
		}		
		return sb.toString();
	}
	
	private String synchSurverBasic(){
		SqlMapClient sc=DataSource.getSqlMapInstance();
		StringBuffer sb=new StringBuffer();
		sb.append("Hbase数据库surverbasic表数据同步开始========================\r\n");		
		try{
			/**获取表中的总数量，如果数据大于0，则同步，如果大于1000条，则分页查询*/
			int total_num=((Integer)sc.queryForObject("datacenter.getDCBasicListNum")).intValue();
			if(total_num>0){
				HBaseConfiguration config = new HBaseConfiguration(); 
				int page=1;
			    int start=0;
			    int pagenum=1000;
			    int end=1000;
			    int add_num=0;
	 	        int del_num=0;
			    if(total_num>1000){
			    	int x1=total_num%1000;
			    	if(x1>0){
			    		page=(int)total_num/1000+1;
			    	}else
			    		page=(int)total_num/1000;
			    }
			    Map<String,Integer> param=new HashMap<String,Integer>();
			    for(int j=1;j<=page;j++){
			    	start=(j-1)*pagenum;
			    	end = j*pagenum;
			    	param.put("_page_start", start);
					param.put("_page_nums", pagenum);//该参数是为MySQL数据库准备的
					param.put("_page_end", end);//该参数是为Oracle数据库准备的  
					HTablePool pool = new HTablePool(config, 1000);  
				    HTableInterface table = pool.getTable(HSurverBasic.TABLE_NAME);
					List<YcDatacenterSurverBasic> basiclist=sc.queryForList("datacenter.getDCBasicList",param);
					if(basiclist!=null){
						for(int i=0;i<basiclist.size();i++){
							YcDatacenterSurverBasic basic=basiclist.get(i);
							try{	
								if("00".equals(basic.getSynch_type())||"01".equals(basic.getSynch_type())){
									Put put=new HSurverBasic().getHSurverBasicPut(basic);
									table.put(put);
									add_num++;
								}
								if("02".equals(basic.getSynch_type())){
									byte[] rowkey;
									if(basic.getBuilding_mapid()!=null)
										rowkey=Bytes.add(basic.getBuilding_mapid().getBytes(),basic.getBuilding_id().getBytes());
									else
										rowkey=basic.getBuilding_id().getBytes();
									Delete d=new Delete(rowkey);
								    table.delete(d);
								    del_num++;
								}
								/**删掉原来的数据*/
								sc.delete("datacenter.deleteSurverBasicSyn", basic.getSid());
								basic=null;						
							}catch(Exception e){
								sb.append("Hbase数据库surverbasic表数据同步异常:"+e.getMessage()+"======id="+basic.getSid()+"\r\n");
								e.printStackTrace();
								continue;
							}
						}
						table.close();
						pool.close();
					}
					basiclist=null;
			    }
				sb.append("Hbase数据库surverbasic表数据同步成功,增加数据"+add_num+"条，删除数据"+del_num+"条\r\n");
			}else{
				sb.append("Hbase数据库surverbasic表没有需要同步的数据\r\n");
			}
		}catch(Exception e){
			e.printStackTrace();
			sb.append("Hbase数据库surverbasic表数据同步失败，异常是:"+e.getMessage()+"\r\n");
		}		
		return sb.toString();
	}
	
	private String synchSurverProject(){
		SqlMapClient sc=DataSource.getSqlMapInstance();
		StringBuffer sb=new StringBuffer();
		sb.append("Hbase数据库surverproject表数据同步开始========================\r\n");		
		try{
			/**获取表中的总数量，如果数据大于0，则同步，如果大于1000条，则分页查询*/
			int total_num=((Integer)sc.queryForObject("datacenter.getDCProjectListNum")).intValue();
			if(total_num>0){
				HBaseConfiguration config = new HBaseConfiguration(); 
				int page=1;
			    int start=0;
			    int pagenum=1000;
			    int end=1000;
			    int add_num=0;
	 	        int del_num=0;
			    if(total_num>1000){
			    	int x1=total_num%1000;
			    	if(x1>0){
			    		page=(int)total_num/1000+1;
			    	}else
			    		page=(int)total_num/1000;
			    }
			    Map<String,Integer> param=new HashMap<String,Integer>();
			    for(int j=1;j<=page;j++){
			    	start=(j-1)*pagenum;
			    	end = j*pagenum;
			    	param.put("_page_start", start);
					param.put("_page_nums", pagenum);//该参数是为MySQL数据库准备的
					param.put("_page_end", end);//该参数是为Oracle数据库准备的   
					HTablePool pool = new HTablePool(config, 1000);
				    HTableInterface table = pool.getTable(HSurverProject.TABLE_NAME);
					List<YcDatacenterSurverProject> projectlist=sc.queryForList("datacenter.getDCProjectList",param);
					if(projectlist!=null){
						for(int i=0;i<projectlist.size();i++){
							YcDatacenterSurverProject project=projectlist.get(i);
							try{	
								if("00".equals(project.getSynch_type())||"01".equals(project.getSynch_type())){
									Put put=new HSurverProject().getHSurverProjectPut(project);
									if(put!=null){
										table.put(put);
										add_num++;
									}
								}
								if("02".equals(project.getSynch_type())){
									byte[] rowkey;
									if(project.getBuilding_mapid()!=null)
										rowkey=Bytes.add(project.getBuilding_mapid().getBytes(),project.getBuilding_id().getBytes());
									else
										rowkey=project.getBuilding_id().getBytes();
									Delete d=new Delete(rowkey);
								    table.delete(d);
								    del_num++;
								}
								/**删掉原来的数据*/
								sc.delete("datacenter.deleteSurverProjectSyn", project.getSid());
								project=null;						
							}catch(Exception e){
								sb.append("Hbase数据库surverproject表数据同步异常:"+e.getMessage()+"======id="+project.getSid()+"\r\n");
								e.printStackTrace();
								continue;
							}
						}
						table.close();
						pool.close();
					}
					projectlist=null;
			    }
			    sb.append("Hbase数据库surverproject表数据同步成功,增加数据"+add_num+"条，删除数据"+del_num+"条\r\n");
			}else{
				sb.append("Hbase数据库surverproject表没有需要同步的数据\r\n");
			}
		}catch(Exception e){
			e.printStackTrace();
			sb.append("Hbase数据库surverproject表数据同步失败，异常是:"+e.getMessage()+"\r\n");
		}		
		return sb.toString();
	}
}
