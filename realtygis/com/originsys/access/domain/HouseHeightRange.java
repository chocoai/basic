package com.originsys.access.domain;

//声明楼高范围值类，包含两个属性
public class HouseHeightRange {
public String range_name;//声明一个整型变量，存放范围值
public int range_value;//声明整型变量，存储第一个范围值0的楼房个数
//属性的get和set方法	
  public String getRange_name() {
		return range_name;
	}
	public void setRange_name(String range_name) {
		this.range_name = range_name;
	}
	public int getRange_value() {
		return range_value;
	}
	public void setRange_value(int range_value) {
		this.range_value = range_value;
	}
	public HouseHeightRange(){
	  	super();
	  }
	public HouseHeightRange(String rangename,int rangevalue){
  	super();
  	this.range_name=rangename;
  	this.range_value=rangevalue;
  }
}
