package com.originsys.realtygis.domain;

import java.math.BigDecimal;

public class Invmprj {
	
	private  Integer invm_prj_id;//内码***
	private  String dc_number;//编号
	private  Integer zh_nm;//幢号内码(产权)
	private  Integer build_id;//所在楼盘ID(GIS)***
	private  Integer cq_name;//城区@1-历下区-市中区-槐荫区-天桥区-历城区-高新区-长清区-章丘市-平阴县-济阳县-南河县
	private  String parcel_code;//图号
	private  String fw_dh;//地号
	private  String build_name;//房屋名称
	private  Integer build_right;//产权年限@1-50年-70年-其它
	private  Integer right_type;//产权性质@1-直管公房-自管房-私房-其它
	private  String owner;//产权单位
	private  String address_o;//坐落
	private  String address_n;//用户名称字段***
	private  String structarea;//建筑面积
	private  BigDecimal jz_area;//建筑面积***
	private  Integer floor_cnt;//地上层数
	private  Integer floor_down;//地下层数
	private  Integer usage;//使用功能@1-住宅-综合楼-办公-商业-学校用房-医院用房-工业用房-其它
	private  Integer birth_decade;//建成年代
	private  BigDecimal heigth;//高度m
	private  BigDecimal depth;//檐高m
	private  Integer plane_shape;//平面@1-规则-不规则
	private  Integer exposure;//朝向@1-东西-南北-其它
	private  Integer lm_shape;//立面@1-规则-不规则
	private  Integer base_type;//基础类型@1-毛石-砖-混凝土-钢筋混凝土-其它
	private  Integer upon_type;//上部结构类型@1-钢结构-钢、钢筋混凝土结构-钢筋混凝土结构-混合结构-砖木结构-其他结构
	private  Integer lg_type;//楼盖类型@1-现浇板-预制板-现浇、预制板混用-木楼板-其它
	private  Integer wm_type;//屋面类型@1-预制板平屋面-现浇板平屋面-现浇板坡屋面-有檩系坡屋面-其它
	private  String bxf_type;//变形缝类型@1-未设置-伸缩缝-沉降缝-抗震缝
	private  Integer lt_number;//楼梯数目@1-一个-二个-三个-多个
	private  Integer lt_type;//楼梯类型@1-木-混凝土-钢-其它
	private  Integer dt_number;//电梯数目@1-一个-二个-三个-多个
	private  String dt_tdesc;//电梯、楼梯备注
	private  Integer yt_type;//阳台类型@1-未设置-梁式-板式-落地
	private  String wq_type;//外墙饰面@1-玻璃-石材-面砖-马赛克-砂浆-涂料-清水墙-其它
	private  String zx_tdesc;//装修、装饰情况***
	private  String management_unit;//经营管理单位
	private  Integer floor_num;//户数
	private  BigDecimal floor_height;//层高
	private  Integer frozen_area;//是否冻结片区@1-是-否
	private  String struct_desc;//装饰装修备注
	private  String bz_desc;//基本信息备注
	private  String dere_desc;//上下部结构形式备注
	private  Integer wairang_type;//外廊类型@1-未设置-梁式-板式-落地
	public Integer getInvm_prj_id() {
		return invm_prj_id;
	}
	public void setInvm_prj_id(Integer invm_prj_id) {
		this.invm_prj_id = invm_prj_id;
	}
	public String getDc_number() {
		return dc_number;
	}
	public void setDc_number(String dc_number) {
		this.dc_number = dc_number;
	}
	public Integer getZh_nm() {
		return zh_nm;
	}
	public void setZh_nm(Integer zh_nm) {
		this.zh_nm = zh_nm;
	}
	public Integer getBuild_id() {
		return build_id;
	}
	public void setBuild_id(Integer build_id) {
		this.build_id = build_id;
	}
	public Integer getCq_name() {
		return cq_name;
	}
	public void setCq_name(Integer cq_name) {
		this.cq_name = cq_name;
	}
	public String getParcel_code() {
		return parcel_code;
	}
	public void setParcel_code(String parcel_code) {
		this.parcel_code = parcel_code;
	}
	public String getFw_dh() {
		return fw_dh;
	}
	public void setFw_dh(String fw_dh) {
		this.fw_dh = fw_dh;
	}
	public String getBuild_name() {
		return build_name;
	}
	public void setBuild_name(String build_name) {
		this.build_name = build_name;
	}
	public Integer getBuild_right() {
		return build_right;
	}
	public void setBuild_right(Integer build_right) {
		this.build_right = build_right;
	}
	public Integer getRight_type() {
		return right_type;
	}
	public void setRight_type(Integer right_type) {
		this.right_type = right_type;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getAddress_o() {
		return address_o;
	}
	public void setAddress_o(String address_o) {
		this.address_o = address_o;
	}
	public String getAddress_n() {
		return address_n;
	}
	public void setAddress_n(String address_n) {
		this.address_n = address_n;
	}
	public String getStructarea() {
		return structarea;
	}
	public void setStructarea(String structarea) {
		this.structarea = structarea;
	}
	public BigDecimal getJz_area() {
		return jz_area;
	}
	public void setJz_area(BigDecimal jz_area) {
		this.jz_area = jz_area;
	}
	public Integer getFloor_cnt() {
		return floor_cnt;
	}
	public void setFloor_cnt(Integer floor_cnt) {
		this.floor_cnt = floor_cnt;
	}
	public Integer getFloor_down() {
		return floor_down;
	}
	public void setFloor_down(Integer floor_down) {
		this.floor_down = floor_down;
	}
	public Integer getUsage() {
		return usage;
	}
	public void setUsage(Integer usage) {
		this.usage = usage;
	}
	public Integer getBirth_decade() {
		return birth_decade;
	}
	public void setBirth_decade(Integer birth_decade) {
		this.birth_decade = birth_decade;
	}
	public BigDecimal getHeigth() {
		return heigth;
	}
	public void setHeigth(BigDecimal heigth) {
		this.heigth = heigth;
	}
	public BigDecimal getDepth() {
		return depth;
	}
	public void setDepth(BigDecimal depth) {
		this.depth = depth;
	}
	public Integer getPlane_shape() {
		return plane_shape;
	}
	public void setPlane_shape(Integer plane_shape) {
		this.plane_shape = plane_shape;
	}
	public Integer getExposure() {
		return exposure;
	}
	public void setExposure(Integer exposure) {
		this.exposure = exposure;
	}
	public Integer getLm_shape() {
		return lm_shape;
	}
	public void setLm_shape(Integer lm_shape) {
		this.lm_shape = lm_shape;
	}
	public Integer getBase_type() {
		return base_type;
	}
	public void setBase_type(Integer base_type) {
		this.base_type = base_type;
	}
	public Integer getUpon_type() {
		return upon_type;
	}
	public void setUpon_type(Integer upon_type) {
		this.upon_type = upon_type;
	}
	public Integer getLg_type() {
		return lg_type;
	}
	public void setLg_type(Integer lg_type) {
		this.lg_type = lg_type;
	}
	public Integer getWm_type() {
		return wm_type;
	}
	public void setWm_type(Integer wm_type) {
		this.wm_type = wm_type;
	}
	public String getBxf_type() {
		return bxf_type;
	}
	public void setBxf_type(String bxf_type) {
		this.bxf_type = bxf_type;
	}
	public Integer getLt_number() {
		return lt_number;
	}
	public void setLt_number(Integer lt_number) {
		this.lt_number = lt_number;
	}
	public Integer getLt_type() {
		return lt_type;
	}
	public void setLt_type(Integer lt_type) {
		this.lt_type = lt_type;
	}
	public Integer getDt_number() {
		return dt_number;
	}
	public void setDt_number(Integer dt_number) {
		this.dt_number = dt_number;
	}
	public String getDt_tdesc() {
		return dt_tdesc;
	}
	public void setDt_tdesc(String dt_tdesc) {
		this.dt_tdesc = dt_tdesc;
	}
	public Integer getYt_type() {
		return yt_type;
	}
	public void setYt_type(Integer yt_type) {
		this.yt_type = yt_type;
	}
	public String getWq_type() {
		return wq_type;
	}
	public void setWq_type(String wq_type) {
		this.wq_type = wq_type;
	}
	public String getZx_tdesc() {
		return zx_tdesc;
	}
	public void setZx_tdesc(String zx_tdesc) {
		this.zx_tdesc = zx_tdesc;
	}
	public String getManagement_unit() {
		return management_unit;
	}
	public void setManagement_unit(String management_unit) {
		this.management_unit = management_unit;
	}
	public Integer getFloor_num() {
		return floor_num;
	}
	public void setFloor_num(Integer floor_num) {
		this.floor_num = floor_num;
	}
	public BigDecimal getFloor_height() {
		return floor_height;
	}
	public void setFloor_height(BigDecimal floor_height) {
		this.floor_height = floor_height;
	}
	public Integer getFrozen_area() {
		return frozen_area;
	}
	public void setFrozen_area(Integer frozen_area) {
		this.frozen_area = frozen_area;
	}
	public String getStruct_desc() {
		return struct_desc;
	}
	public void setStruct_desc(String struct_desc) {
		this.struct_desc = struct_desc;
	}
	public String getBz_desc() {
		return bz_desc;
	}
	public void setBz_desc(String bz_desc) {
		this.bz_desc = bz_desc;
	}
	public String getDere_desc() {
		return dere_desc;
	}
	public void setDere_desc(String dere_desc) {
		this.dere_desc = dere_desc;
	}
	public Integer getWairang_type() {
		return wairang_type;
	}
	public void setWairang_type(Integer wairang_type) {
		this.wairang_type = wairang_type;
	}


}
