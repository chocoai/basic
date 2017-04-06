package com.originsys.datacenter.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.datacenter.domain.YcDatacenterResources;
import com.originsys.datacenter.domain.YcDatacenterResourcesColumns;
import com.originsys.datacenter.domain.YcDatacenterResourcesIndex;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.iservice.IData;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.eap.util.UUIDshort;

/**
 auth:boy 2014-3-13
   描述：资源修改保存
 */
public class ResourcesUpdate  extends BaseAction implements IData{

	public void execute(RequestAction ra, HttpServletResponse response)
			throws Exception {
		String key=ra.getParameter("resources_id");
		YcDatacenterResources ycDatacenterResources=new YcDatacenterResources();
		ycDatacenterResources.setResources_id(key);//String:资源编号
		ycDatacenterResources.setResources_name(ra.getParameter("resources_name"));//String:资源名称
		ycDatacenterResources.setResources_desc(ra.getParameter("resources_desc"));//String:资源描述
		ycDatacenterResources.setSource_business_systems(ra.getParameter("source_business_systems"));//String:来源业务系统
		if("1".equals(ra.getParameter("op_type")))
			ycDatacenterResources.setResources_state("7");//String:资源状态,暂存
		else
			ycDatacenterResources.setResources_state("0");//String:资源状态，提交 待审核
		ycDatacenterResources.setResources_tablename(ra.getParameter("resources_tablename"));//String:资源表名
		ycDatacenterResources.setResources_type(ra.getParameter("resources_type"));//String:
		ycDatacenterResources.setResources_datasource(ra.getParameter("resources_datasource"));//String:数据源
		
		String success="0";
		/**获取ibatis执行*/
		SqlMapClient sc=DataSource.getSqlMapInstance();
		try{
			sc.startTransaction();
			sc.update("datacenter.updateYcDatacenterResources",ycDatacenterResources);
			/**删掉原来的列信息和索引信息，重新增加*/
			sc.delete("datacenter.deleteDataSources", key);
			sc.delete("datacenter.deleteDataIndex", key);
			String[] column_ename=ra.getParameterValues("column_ename");
			String[] column_name=ra.getParameterValues("column_name");
			String[] column_desc=ra.getParameterValues("column_desc");
			if(column_ename!=null){
				for(int i=0;i<column_ename.length;i++){
					YcDatacenterResourcesColumns ycDatacenterResourcesColumns=new YcDatacenterResourcesColumns();
					ycDatacenterResourcesColumns.setResources_id(key);//String:资源编号
					String key1=UUIDshort.get();
					ycDatacenterResourcesColumns.setColumn_id(key1);//String:字段编号
					ycDatacenterResourcesColumns.setColumn_ename(column_ename[i]);//String:字段英文名称
					ycDatacenterResourcesColumns.setColumn_name(column_name[i]);//String:字段中文名称
					ycDatacenterResourcesColumns.setColumn_desc(column_desc[i]);//String:字段描述
	//				ycDatacenterResourcesColumns.setColumn_type(ra.getParameter("column_type"));//String:字段类型
	//				ycDatacenterResourcesColumns.setColumn_length(ra.getParameter("column_length"));//String:字段长度
	//				ycDatacenterResourcesColumns.setIs_empty(ra.getParameter("is_empty"));//String:是否可空
	//				ycDatacenterResourcesColumns.setColumn_enum(ra.getParameter("column_enum"));//String:数据字典
					sc.insert("datacenter.addYcDatacenterResourcesColumns",ycDatacenterResourcesColumns);
				}
			}
			String[] index_type=ra.getParameterValues("index_type");
			String[] index_column=ra.getParameterValues("index_column");
			String[] index_separate=ra.getParameterValues("index_separate");
			String[] index_desc=ra.getParameterValues("index_desc");
			if(index_type!=null){
				for(int i=0;i<index_type.length;i++){
					YcDatacenterResourcesIndex ycDatacenterResourcesIndex=new YcDatacenterResourcesIndex();
					ycDatacenterResourcesIndex.setResources_id(key);
					String key2=UUIDshort.get();
					ycDatacenterResourcesIndex.setIndex_id(key2);//String:索引编号
					ycDatacenterResourcesIndex.setIndex_type(index_type[i]);//String:索引类型（rowkey）
					ycDatacenterResourcesIndex.setIndex_column(index_column[i]);//String:索引对应列名
					ycDatacenterResourcesIndex.setIndex_separate(index_separate[i]);//String:分隔符
					ycDatacenterResourcesIndex.setIndex_desc(index_desc[i]);//String:索引描述
					sc.insert("datacenter.addYcDatacenterResourcesIndex",ycDatacenterResourcesIndex);
				}
			}
			
			sc.commitTransaction();
			success="1";
		}catch (Exception e) {
			success="0";
			throw e;
		}finally{
			sc.getCurrentConnection().rollback();
			sc.endTransaction();
		}
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.print("{\"success\":\""+success+"\",\"key\":\""+key+"\"}");
	}

}
