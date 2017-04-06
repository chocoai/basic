package com.originsys.datacenter.qd.action;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.HTablePool;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.coprocessor.AggregationClient;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.RegexStringComparator;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;

import com.originsys.datacenter.domain.HBuilding;
import com.originsys.datacenter.domain.HHouse;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.domain.Page;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.RequestAction;

/**
 auth:boy 2014-3-10
   描述：千度查询
   先做根据地址到楼幢或是房屋表中查询
   1：查询结果分页
 */
public class Search extends BaseAction implements IGet{

	public DataAndView execute(RequestAction ra) throws Exception {	
		HBaseConfiguration config = new HBaseConfiguration();
//		String coprocessClassName = "org.apache.hadoop.hbase.coprocessor.AggregateImplementation";
//        HBaseAdmin admin = new HBaseAdmin(config);
//        admin.disableTable(HHouse.TABLE_NAME);
//        HTableDescriptor htd = admin.getTableDescriptor(Bytes.toBytes("house"));
//        htd.addCoprocessor(coprocessClassName);
//        admin.modifyTable(Bytes.toBytes("house"), htd); 
//        admin.enableTable(HHouse.TABLE_NAME);
        
		String key=ra.getParameter("keyword");
		List<HashMap> relist=new ArrayList<HashMap>();
//		HBaseConfiguration config = new HBaseConfiguration();
		HTablePool pool = new HTablePool(config, 1000);
		HTableInterface table1 = pool.getTable(HBuilding.TABLE_NAME);  
		/**builiding 扫描对象*/
		Scan s=new Scan();
		s.setFilter(new SingleColumnValueFilter(HBuilding.COLFAMILY,HBuilding.BUILDING_ADDRESS,CompareOp.EQUAL,new RegexStringComparator(".*"+key+".*$")));
		s.setMaxVersions();
//	    /**house扫描对象*/
//	    Scan s2=new Scan();
//		s2.setFilter(new SingleColumnValueFilter(HHouse.COLFAMILY,HHouse.FW_ADDRESS,CompareOp.EQUAL,new RegexStringComparator(".*"+key+".*$")));
//	    s2.setMaxVersions();
	    /**查询总数量*/
	    long rowCount = 0;//总数量
	    long b_rowCount=0;//building查询结果总数
	    long h_rowCount=0;//house查询结果总数
	    AggregationClient aggregationClient = new AggregationClient(config);
	    s.addColumn(HBuilding.COLFAMILY,HBuilding.BUILDING_ADDRESS);
//	    s2.addColumn(HHouse.COLFAMILY,HHouse.FW_ADDRESS);
	    try {
	    	b_rowCount = aggregationClient.rowCount(HBuilding.TABLE_NAME.getBytes(), null, s);
//	    	System.out.println("楼幢的数量："+b_rowCount);
//	    	h_rowCount = aggregationClient.rowCount(HHouse.TABLE_NAME.getBytes(), null, s2);
//	    	System.out.println("房屋的数量："+h_rowCount);
	    	rowCount=b_rowCount+h_rowCount;
		} catch (Throwable e) {
			e.printStackTrace();
		} 
	   log().info("========查询关键字="+key+"=====查询结果数量："+rowCount+"......h_rowCount="+h_rowCount);
	    /**分页查询*/
	  //获得起始条数
	  int start=0;
	  //获得每页显示的条数
	  int pageNum=20;
	  if(ra.getParameter("rows")!=null){
	  	pageNum=Integer.parseInt(ra.getParameter("rows"));
	  }
	  else{
	  	pageNum=20;
	  }
	  pageNum=(pageNum==0)?20:pageNum;
	  //获取总条数
	  int totalnum=(int)rowCount;
	  //获得总页数
	  int totalpage=totalnum%pageNum==0?totalnum/pageNum:(totalnum/pageNum+1);		
	 //获得当前页
	 String currentPage=ra.getParameter("page");
	 int currentNum=1;
	 if(currentPage!=null && !"".equals(currentPage)){
	   currentNum=Integer.parseInt(currentPage);
	  }
	  //重新设置起始条数
	  start=(currentNum-1)*pageNum;
	  int end = currentNum*pageNum;
	  	    
	    /**查询building中的结果*/
	    ResultScanner ss=table1.getScanner(s);
	    int i = 0;
        for(Result res:ss){
        	if (i >= start && i < end) {
	        	HashMap<String,String> temp=new HashMap<String,String>();
	        	temp.put("type", "building");
	        	temp.put("id", Bytes.toString(res.getRow()));
	        	temp.put("address", Bytes.toString(res.getValue(HBuilding.COLFAMILY, HBuilding.BUILDING_ADDRESS)));
	        	relist.add(temp);
	        	temp=null;
        	}
        	if(i==end)
        		break;
        	i++;
        }
        /**通过scan取完数据后，记得要关闭ResultScanner，否则RegionServer可能会出现问题（对应的Server资源无法释放）。*/
        ss.close();
        s=null;       	    
	    ss=null;
//	    
//        if(i<end){
//        	start=0;
//        	end=pageNum-x;
//        	int j=0;
//	        /**查询house中的结果*/
//	        HTableInterface table2 = pool.getTable(HHouse.TABLE_NAME);  
//			ResultScanner ss2=table2.getScanner(s2);
//	        for(Result res:ss2){
//	        	if (j >= start && j < end) {
//		        	HashMap<String,String> temp=new HashMap<String,String>();
//		        	temp.put("type", "house");
//		        	temp.put("id", Bytes.toString(res.getRow()));
//		        	temp.put("address", Bytes.toString(res.getValue(HHouse.COLFAMILY, HHouse.FW_ADDRESS)));
//		        	relist.add(temp);
//		        	temp=null;
//	        	}
//	        	if(j==end)
//	        		break;
//	        	j++;
//	        }
//	        s2=null;
//	        ss2.close();
//	        ss2=null;
//        }

        Page page=new Page(totalpage,currentNum,totalnum);
        Map<String,Object> remap=new HashMap<String,Object>();
        remap.put("page", page);
        remap.put("relist",relist);
        remap.put("keyword", key);
        remap.put("rowCount", rowCount);
		return new DataAndView(remap,"block");
	}

}
