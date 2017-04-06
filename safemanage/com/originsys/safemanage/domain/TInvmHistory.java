package com.originsys.safemanage.domain;
import java.io.Serializable;

public class TInvmHistory implements Serializable{
	/**房子编号*/
	private String house_id;
	/**使用历史结构拆改@1-无拆改&2-一般拆改&3-严重拆改*/
	private String struct_alter;
	/**使用历史加层改造@1-无加层&2-加一层&3-加二层&4-加三层及以上*/
	private String floor_add;
	/**使用历史修缮加固正常使用@1-否&2-是*/
	private String reinforce_normal;
	/**使用历史修缮加固质量原因@1-否&2-是*/
	private String reinforce_quality;
	/**使用历史修缮加固灾害原因@1-否&2-是*/
	private String reinforce_calamity;
	/**使用历史修缮加固使用功能原因@1-否&2-是*/
	private String reinforce_usage;
	/**使用历史修缮加固其他原因@1-否&2-是*/
	private String reinforce_else;
	/**使用历史灾害正常使用@1-否&2-是*/
	private String calamity_normal;
	/**使用历史灾害火灾@1-否&2-是*/
	private String calamity_fire;
	/**使用历史灾害风灾@1-否&2-是*/
	private String calamity_wind;
	/**使用历史灾害雪灾@1-否&2-是*/
	private String calamity_snow;
	/**使用历史灾害水灾@1-否&2-是*/
	private String calamity_water;
	/**使用历史灾害地质@1-否&2-是*/
	private String calamity_geo;
	/**使用历史灾害其他@1-否&2-是*/
	private String calamity_else;
	/**使用历史使用功能变更无变更@1-否&2-是*/
	private String usagealter_none;
	/**使用历史使用功能变更住宅变商业@1-否&2-是*/
	private String usagealter_h2c;
	/**使用历史使用功能变更住宅变办公@1-否&2-是*/
	private String usagealter_h2o;
	/**使用历史使用功能变更办公变商业@1-否&2-是*/
	private String usagealter_o2c;
	/**使用历史使用功能变更工业变商业@1-否&2-是*/
	private String usagealter_i2c;
	/**使用历史使用功能变更工业变办公@1-否&2-是*/
	private String usagealter_i2o;
	/**使用历史使用功能变更其他@1-否&2-是*/
	private String usagealter_else;
	/**使用历史子项健康评级@1-a&2-b,2c****/
	private String history_grading;
	/**使用历史备注*/
	private String history_tdesc;
	//----------------------------------------------------------------
	/**设置房子编号的get方法*/
	public String getHouse_id() {
		return house_id;
	}
	/**设置房子编号的set方法*/
	public void setHouse_id(String house_id) {
		this.house_id = house_id;
	}
	/**设置使用历史结构拆改@1-无拆改&2-一般拆改&3-严重拆改的get方法*/
	public String getStruct_alter() {
		return struct_alter;
	}
	/**设置使用历史结构拆改@1-无拆改&2-一般拆改&3-严重拆改的set方法*/
	public void setStruct_alter(String struct_alter) {
		this.struct_alter = struct_alter;
	}
	/**设置使用历史加层改造@1-无加层&2-加一层&3-加二层&4-加三层及以上的get方法*/
	public String getFloor_add() {
		return floor_add;
	}
	/**设置使用历史加层改造@1-无加层&2-加一层&3-加二层&4-加三层及以上的set方法*/
	public void setFloor_add(String floor_add) {
		this.floor_add = floor_add;
	}
	/**设置使用历史修缮加固正常使用@1-否&2-是的get方法*/
	public String getReinforce_normal() {
		return reinforce_normal;
	}
	/**设置使用历史修缮加固正常使用@1-否&2-是的set方法*/
	public void setReinforce_normal(String reinforce_normal) {
		this.reinforce_normal = reinforce_normal;
	}
	/**设置使用历史修缮加固质量原因@1-否&2-是的get方法*/
	public String getReinforce_quality() {
		return reinforce_quality;
	}
	/**设置使用历史修缮加固质量原因@1-否&2-是的set方法*/
	public void setReinforce_quality(String reinforce_quality) {
		this.reinforce_quality = reinforce_quality;
	}
	/**设置使用历史修缮加固灾害原因@1-否&2-是的get方法*/
	public String getReinforce_calamity() {
		return reinforce_calamity;
	}
	/**设置使用历史修缮加固灾害原因@1-否&2-是的set方法*/
	public void setReinforce_calamity(String reinforce_calamity) {
		this.reinforce_calamity = reinforce_calamity;
	}
	/**设置使用历史修缮加固使用功能原因@1-否&2-是的get方法*/
	public String getReinforce_usage() {
		return reinforce_usage;
	}
	/**设置使用历史修缮加固使用功能原因@1-否&2-是的set方法*/
	public void setReinforce_usage(String reinforce_usage) {
		this.reinforce_usage = reinforce_usage;
	}
	/**设置使用历史修缮加固其他原因@1-否&2-是的get方法*/
	public String getReinforce_else() {
		return reinforce_else;
	}
	/**设置使用历史修缮加固其他原因@1-否&2-是的set方法*/
	public void setReinforce_else(String reinforce_else) {
		this.reinforce_else = reinforce_else;
	}
	/**设置使用历史灾害正常使用@1-否&2-是的get方法*/
	public String getCalamity_normal() {
		return calamity_normal;
	}
	/**设置使用历史灾害正常使用@1-否&2-是的set方法*/
	public void setCalamity_normal(String calamity_normal) {
		this.calamity_normal = calamity_normal;
	}
	/**设置使用历史灾害火灾@1-否&2-是的get方法*/
	public String getCalamity_fire() {
		return calamity_fire;
	}
	/**设置使用历史灾害火灾@1-否&2-是的set方法*/
	public void setCalamity_fire(String calamity_fire) {
		this.calamity_fire = calamity_fire;
	}
	/**设置使用历史灾害风灾@1-否&2-是的get方法*/
	public String getCalamity_wind() {
		return calamity_wind;
	}
	/**设置使用历史灾害风灾@1-否&2-是的set方法*/
	public void setCalamity_wind(String calamity_wind) {
		this.calamity_wind = calamity_wind;
	}
	/**设置使用历史灾害雪灾@1-否&2-是的get方法*/
	public String getCalamity_snow() {
		return calamity_snow;
	}
	/**设置使用历史灾害雪灾@1-否&2-是的set方法*/
	public void setCalamity_snow(String calamity_snow) {
		this.calamity_snow = calamity_snow;
	}
	/**设置使用历史灾害水灾@1-否&2-是的get方法*/
	public String getCalamity_water() {
		return calamity_water;
	}
	/**设置使用历史灾害水灾@1-否&2-是的set方法*/
	public void setCalamity_water(String calamity_water) {
		this.calamity_water = calamity_water;
	}
	/**设置使用历史灾害地质@1-否&2-是的get方法*/
	public String getCalamity_geo() {
		return calamity_geo;
	}
	/**设置使用历史灾害地质@1-否&2-是的set方法*/
	public void setCalamity_geo(String calamity_geo) {
		this.calamity_geo = calamity_geo;
	}
	/**设置使用历史灾害其他@1-否&2-是的get方法*/
	public String getCalamity_else() {
		return calamity_else;
	}
	/**设置使用历史灾害其他@1-否&2-是的set方法*/
	public void setCalamity_else(String calamity_else) {
		this.calamity_else = calamity_else;
	}
	/**设置使用历史使用功能变更无变更@1-否&2-是的get方法*/
	public String getUsagealter_none() {
		return usagealter_none;
	}
	/**设置使用历史使用功能变更无变更@1-否&2-是的set方法*/
	public void setUsagealter_none(String usagealter_none) {
		this.usagealter_none = usagealter_none;
	}
	/**设置使用历史使用功能变更住宅变商业@1-否&2-是的get方法*/
	public String getUsagealter_h2c() {
		return usagealter_h2c;
	}
	/**设置使用历史使用功能变更住宅变商业@1-否&2-是的set方法*/
	public void setUsagealter_h2c(String usagealter_h2c) {
		this.usagealter_h2c = usagealter_h2c;
	}
	/**设置使用历史使用功能变更住宅变办公@1-否&2-是的get方法*/
	public String getUsagealter_h2o() {
		return usagealter_h2o;
	}
	/**设置使用历史使用功能变更住宅变办公@1-否&2-是的set方法*/
	public void setUsagealter_h2o(String usagealter_h2o) {
		this.usagealter_h2o = usagealter_h2o;
	}
	/**设置使用历史使用功能变更办公变商业@1-否&2-是的get方法*/
	public String getUsagealter_o2c() {
		return usagealter_o2c;
	}
	/**设置使用历史使用功能变更办公变商业@1-否&2-是的set方法*/
	public void setUsagealter_o2c(String usagealter_o2c) {
		this.usagealter_o2c = usagealter_o2c;
	}
	/**设置使用历史使用功能变更工业变商业@1-否&2-是的get方法*/
	public String getUsagealter_i2c() {
		return usagealter_i2c;
	}
	/**设置使用历史使用功能变更工业变商业@1-否&2-是的set方法*/
	public void setUsagealter_i2c(String usagealter_i2c) {
		this.usagealter_i2c = usagealter_i2c;
	}
	/**设置使用历史使用功能变更工业变办公@1-否&2-是的get方法*/
	public String getUsagealter_i2o() {
		return usagealter_i2o;
	}
	/**设置使用历史使用功能变更工业变办公@1-否&2-是的set方法*/
	public void setUsagealter_i2o(String usagealter_i2o) {
		this.usagealter_i2o = usagealter_i2o;
	}
	/**设置使用历史使用功能变更其他@1-否&2-是的get方法*/
	public String getUsagealter_else() {
		return usagealter_else;
	}
	/**设置使用历史使用功能变更其他@1-否&2-是的set方法*/
	public void setUsagealter_else(String usagealter_else) {
		this.usagealter_else = usagealter_else;
	}
	/**设置使用历史子项健康评级@1-a&2-b,2c***的get方法*/
	public String getHistory_grading() {
		return history_grading;
	}
	/**设置使用历史子项健康评级@1-a&2-b,2c***的set方法*/
	public void setHistory_grading(String history_grading) {
		this.history_grading = history_grading;
	}
	/**设置使用历史备注的get方法*/
	public String getHistory_tdesc() {
		return history_tdesc;
	}
	/**设置使用历史备注的set方法*/
	public void setHistory_tdesc(String history_tdesc) {
		this.history_tdesc = history_tdesc;
	}
}