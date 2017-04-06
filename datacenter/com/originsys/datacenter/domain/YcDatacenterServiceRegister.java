package com.originsys.datacenter.domain;
import java.io.Serializable;
import java.util.Date;

public class YcDatacenterServiceRegister implements Serializable{
	/**服务编号*/
	private String service_id;
	/**服务名称*/
	private String service_name;
	/**服务描述*/
	private String service_desc;
	/**服务提供者*/
	private String service_provide;
	/**是否审核 0不需要 1需要*/
	private String is_check;
	/**版本*/
	private String service_version;
	/**代理服务类型 http，webservice*/
	private String proxy_type;
	/**服务类型 数据资源服务1，云平台服务2，业务数据服务3，逻辑服务4，通用服务5*/
	private String service_type;
	/**服务状态（ 8是正常可用(上线)，0是新增 （待审核） 1审核驳回  2下线  7是暂存的还可以再修改）*/
	private String service_state;
	/**服务创建时间*/
	private Date create_date;
	/**服务创建人*/
	private String creator;
	/**审核者*/
	private String checkor;
	/**审核时间*/
	private Date check_date;
	/**请求地址*/
	private String request_url;
	/**返回示例图片*/
	private String example_image;
	/**是否需要用户授权 0不需要 1需要*/
	private String is_authorize;
	/**服务申请授权方式 */
	private String authorize_mode;
	//----------------------------------------------------------------
	/**设置服务编号的get方法*/
	public String getService_id() {
		return service_id;
	}
	/**设置服务编号的set方法*/
	public void setService_id(String service_id) {
		this.service_id = service_id;
	}
	/**设置服务名称的get方法*/
	public String getService_name() {
		return service_name;
	}
	/**设置服务名称的set方法*/
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	/**设置服务描述的get方法*/
	public String getService_desc() {
		return service_desc;
	}
	/**设置服务描述的set方法*/
	public void setService_desc(String service_desc) {
		this.service_desc = service_desc;
	}
	/**设置服务提供者的get方法*/
	public String getService_provide() {
		return service_provide;
	}
	/**设置服务提供者的set方法*/
	public void setService_provide(String service_provide) {
		this.service_provide = service_provide;
	}
	/**设置是否审核的get方法*/
	public String getIs_check() {
		return is_check;
	}
	/**设置是否审核的set方法*/
	public void setIs_check(String is_check) {
		this.is_check = is_check;
	}
	/**设置版本的get方法*/
	public String getService_version() {
		return service_version;
	}
	/**设置版本的set方法*/
	public void setService_version(String service_version) {
		this.service_version = service_version;
	}
	/**设置代理服务类型的get方法*/
	public String getProxy_type() {
		return proxy_type;
	}
	/**设置代理服务类型的set方法*/
	public void setProxy_type(String proxy_type) {
		this.proxy_type = proxy_type;
	}
	/**设置服务类型的get方法*/
	public String getService_type() {
		return service_type;
	}
	/**设置服务类型的set方法*/
	public void setService_type(String service_type) {
		this.service_type = service_type;
	}
	/**设置服务状态的get方法*/
	public String getService_state() {
		return service_state;
	}
	/**设置服务状态的set方法*/
	public void setService_state(String service_state) {
		this.service_state = service_state;
	}
	/**设置服务创建时间的get方法*/
	public Date getCreate_date() {
		return create_date;
	}
	/**设置服务创建时间的set方法*/
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	/**设置服务创建人的get方法*/
	public String getCreator() {
		return creator;
	}
	/**设置服务创建人的set方法*/
	public void setCreator(String creator) {
		this.creator = creator;
	}
	/**设置审核者的get方法*/
	public String getCheckor() {
		return checkor;
	}
	/**设置审核者的set方法*/
	public void setCheckor(String checkor) {
		this.checkor = checkor;
	}
	/**设置审核时间的get方法*/
	public Date getCheck_date() {
		return check_date;
	}
	/**设置审核时间的set方法*/
	public void setCheck_date(Date check_date) {
		this.check_date = check_date;
	}
	/**设置请求地址的get方法*/
	public String getRequest_url() {
		return request_url;
	}
	/**设置请求地址的set方法*/
	public void setRequest_url(String request_url) {
		this.request_url = request_url;
	}
	/**设置返回示例图片的get方法*/
	public String getExample_image() {
		return example_image;
	}
	/**设置返回示例图片的set方法*/
	public void setExample_image(String example_image) {
		this.example_image = example_image;
	}
	/**设置是否需要用户授权的get方法*/
	public String getIs_authorize() {
		return is_authorize;
	}
	/**设置是否需要用户授权的set方法*/
	public void setIs_authorize(String is_authorize) {
		this.is_authorize = is_authorize;
	}
	/**设置服务申请授权方式的get方法*/
	public String getAuthorize_mode() {
		return authorize_mode;
	}
	/**设置服务申请授权方式的set方法*/
	public void setAuthorize_mode(String authorize_mode) {
		this.authorize_mode = authorize_mode;
	}
}