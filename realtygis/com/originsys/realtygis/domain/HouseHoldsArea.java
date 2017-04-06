package com.originsys.realtygis.domain;

public class HouseHoldsArea {
 private int firstnum;
 private int nextnum;
public int getFirstnum() {
	return firstnum;
}
public void setFirstnum(int firstnum) {
	this.firstnum = firstnum;
}
public int getNextnum() {
	return nextnum;
}
public void setNextnum(int nextnum) {
	this.nextnum = nextnum;
}
 public HouseHoldsArea(){
	 super();
 }
 public HouseHoldsArea(int firstnum,int nextnum){
	 super();
	 this.firstnum=firstnum;
	 this.nextnum=nextnum;
 }
}
