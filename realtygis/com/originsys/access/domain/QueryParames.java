package com.originsys.access.domain;
/**
 * 综合查询参数类
 * @author 李洪云 2014 02 24
 *
 */
public class QueryParames {
    private String area;//等值查询建筑面积
    private String areamax;//范围值查询最大建筑面积
    private String areamin;//范围值查询最小建筑面积
    private String buildingdata;//等值查询建成年代
    private String buildingdatamin;//范围值查询最小建成年代
    private String buildingdatamax;//范围值查询最大建成年代
    private String floor;//等值查询楼层数
    private String floormin;//范围值查询最小楼层数
    private String floormax;//范围值查询最大楼层数
    private String buildingnature;//房屋产权性质
	private String buildingstructure;//房屋建筑结构类型
	private String buildingfloortype;//房屋楼层类型
	private String buildingfloortypemin;//房屋楼层范围最小值
	private String buildingfloortypemax;//房屋楼层范围最大值
	private String buildinguse;//房屋用途
	private String sqlworld;//查询语句
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAreamax() {
		return areamax;
	}
	public void setAreamax(String areamax) {
		this.areamax = areamax;
	}
	public String getAreamin() {
		return areamin;
	}
	public void setAreamin(String areamin) {
		this.areamin = areamin;
	}
	public String getBuildingdata() {
		return buildingdata;
	}
	public void setBuildingdata(String buildingdata) {
		this.buildingdata = buildingdata;
	}
	public String getBuildingdatamin() {
		return buildingdatamin;
	}
	public void setBuildingdatamin(String buildingdatamin) {
		this.buildingdatamin = buildingdatamin;
	}
	public String getBuildingdatamax() {
		return buildingdatamax;
	}
	public void setBuildingdatamax(String buildingdatamax) {
		this.buildingdatamax = buildingdatamax;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getFloormin() {
		return floormin;
	}
	public void setFloormin(String floormin) {
		this.floormin = floormin;
	}
	public String getFloormax() {
		return floormax;
	}
	public void setFloormax(String floormax) {
		this.floormax = floormax;
	}
	public String getBuildingnature() {
		return buildingnature;
	}
	public void setBuildingnature(String buildingnature) {
		this.buildingnature = buildingnature;
	}
	public String getBuildingstructure() {
		return buildingstructure;
	}
	public void setBuildingstructure(String buildingstructure) {
		this.buildingstructure = buildingstructure;
	}
	public String getBuildinguse() {
		return buildinguse;
	}
	public void setBuildinguse(String buildinguse) {
		this.buildinguse = buildinguse;
	}
    public String getBuildingfloortype() {
		return buildingfloortype;
	}
	public void setBuildingfloortype(String buildingfloortype) {
		this.buildingfloortype = buildingfloortype;
	}
	public String getBuildingfloortypemin() {
		return buildingfloortypemin;
	}
	public void setBuildingfloortypemin(String buildingfloortypemin) {
		this.buildingfloortypemin = buildingfloortypemin;
	}
	public String getBuildingfloortypemax() {
		return buildingfloortypemax;
	}
	public void setBuildingfloortypemax(String buildingfloortypemax) {
		this.buildingfloortypemax = buildingfloortypemax;
	}
public String getSqlworld() {
		return sqlworld;
	}
	public void setSqlworld(String sqlworld) {
		this.sqlworld = sqlworld;
	}
public QueryParames(){
	 super();
}
public QueryParames(String area,String areamax,String areamin,String buildingdata,
		String buildingdatamin,String buildingdatamax,String floor,String floormin,
		String floormax, String buildingnature,String buildingstructure,
		String buildingfloortype,String buildingfloortypemin,String buildingfloortypemax,String buildinguse){
	 super();
	 this.area=area;
	 this.areamax=areamax;
	 this.areamin=areamin;
	 this.buildingdata=buildingdata;
	 this.buildingdatamax=buildingdatamax;
	 this.buildingdatamin=buildingdatamin;
	 this.buildingnature=buildingnature;
	 this.buildingstructure=buildingstructure;
	 this.buildingfloortype=buildingfloortype;
	 this.buildingfloortypemax=buildingfloortypemax;
	 this.buildingfloortypemin=buildingfloortypemin;
	 this.buildinguse=buildinguse;
	 this.floor=floor;
	 this.floormax=floormax;
	 this.floormin=floormin;
}
}