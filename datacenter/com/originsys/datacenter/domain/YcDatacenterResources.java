package com.originsys.datacenter.domain;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**资源注册表*/
public class YcDatacenterResources implements Serializable{
	/**资源编号*/
	private String resources_id;
	/**资源名称*/
	private String resources_name;
	/**资源描述*/
	private String resources_desc;
	/**来源业务系统*/
	private String source_business_systems;
	/**资源状态 8是正常可用(上线)，0是新增 （待审核） 1审核驳回  2下线  7是暂存的还可以再修改*/
	private String resources_state;
	/**资源表名*/
	private String resources_tablename;
	/**资源类型 扩展增加还是新表（0是扩展资源，1是新资源）*/
	private String resources_type;
	/**注册时间*/
	private Date reg_date;
	/**注册人id*/
	private String reg_memid;
	/**数据源 以后可能有用，预留的*/
	private String resources_datasource;
	/**字段list<String>*/
	private List<String> cols_list;
	/**索引对象*/
	private List<String> index_list;
	/**索引分隔符*/
	private String index_separate;
	//----------------------------------------------------------------
	
	/**设置资源编号的get方法*/
	public String getResources_id() {
		return resources_id;
	}
	public List<String> getCols_list() {
		return cols_list;
	}
	public void setCols_list(List<String> cols_list) {
		this.cols_list = cols_list;
	}
	public List<String> getIndex_list() {
		return index_list;
	}
	public void setIndex_list(List<String> index_list) {
		this.index_list = index_list;
	}
	public String getIndex_separate() {
		return index_separate;
	}
	public void setIndex_separate(String index_separate) {
		this.index_separate = index_separate;
	}
	/**设置资源编号的set方法*/
	public void setResources_id(String resources_id) {
		this.resources_id = resources_id;
	}
	/**设置资源名称的get方法*/
	public String getResources_name() {
		return resources_name;
	}
	/**设置资源名称的set方法*/
	public void setResources_name(String resources_name) {
		this.resources_name = resources_name;
	}
	/**设置资源描述的get方法*/
	public String getResources_desc() {
		return resources_desc;
	}
	/**设置资源描述的set方法*/
	public void setResources_desc(String resources_desc) {
		this.resources_desc = resources_desc;
	}
	/**设置来源业务系统的get方法*/
	public String getSource_business_systems() {
		return source_business_systems;
	}
	/**设置来源业务系统的set方法*/
	public void setSource_business_systems(String source_business_systems) {
		this.source_business_systems = source_business_systems;
	}
	/**设置资源状态的get方法*/
	public String getResources_state() {
		return resources_state;
	}
	/**设置资源状态的set方法*/
	public void setResources_state(String resources_state) {
		this.resources_state = resources_state;
	}
	/**设置资源表名的get方法*/
	public String getResources_tablename() {
		return resources_tablename;
	}
	/**设置资源表名的set方法*/
	public void setResources_tablename(String resources_tablename) {
		this.resources_tablename = resources_tablename;
	}
	/**设置的get方法*/
	public String getResources_type() {
		return resources_type;
	}
	/**设置的set方法*/
	public void setResources_type(String resources_type) {
		this.resources_type = resources_type;
	}
	/**设置注册时间的get方法*/
	public Date getReg_date() {
		return reg_date;
	}
	/**设置注册时间的set方法*/
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	/**设置注册人id的get方法*/
	public String getReg_memid() {
		return reg_memid;
	}
	/**设置注册人id的set方法*/
	public void setReg_memid(String reg_memid) {
		this.reg_memid = reg_memid;
	}
	/**设置数据源的get方法*/
	public String getResources_datasource() {
		return resources_datasource;
	}
	/**设置数据源的set方法*/
	public void setResources_datasource(String resources_datasource) {
		this.resources_datasource = resources_datasource;
	}
}