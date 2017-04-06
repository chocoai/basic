package com.originsys.safemanage.domain;
import java.io.Serializable;

public class TInvmEquipment implements Serializable{
	/**房子编号*/
	private String house_id;
	/**设施设备电路设施无异常@1-否&2-是*/
	private String circuit_normal;
	/**设施设备电路设施经常跳闸@1-否&2-是*/
	private String circuit_trip;
	/**设施设备电路设施经常断电维修@1-否&2-是*/
	private String circuit_ddwx;
	/**设施设备给排水管道无异常@1-否&2-是*/
	private String waterpip_noraml;
	/**设施设备给排水管道老化破损@1-否&2-轻微&3-一般&4-严重*/
	private String waterpip_aging;
	/**设施设备给排水管道堵塞@1-否&2-轻微&3-一般&4-严重*/
	private String waterpip_chuck;
	/**设施设备燃气管道无异常@1-否&2-是*/
	private String firepip_normal;
	/**设施设备燃气管道老化@1-否&2-轻微&3-一般&4-严重*/
	private String firepip_aging;
	/**设施设备燃气管道漏气@1-否&2-是*/
	private String firepip_leakage;
	/**设施设备防雷设备完好@1-否&2-是*/
	private String lightning_protect;
	/**设施设备防雷设备老化程度@1-否&2-轻微&3-一般&4-严重*/
	private String lightning_aging;
	/**设施设备消防设备完好@1-否&2-是*/
	private String fire_protect;
	/**设施设备消防设备老化程度@1-否&2-轻微&3-一般&4-严重*/
	private String fire_aging;
	/**设施设备子项健康评级@1-a级&2-b级&3-c级*/
	private String equipment_grading;
	/**设施设备备注*/
	private String equipment_tdesc;
	/**设施设备一户一表@1-否&2-是*/
	private String watchonedoor;
	/**设施设备电线凌乱程度@1-否&2-轻微&3-一般&4-严重*/
	private String linemessy;
	/**设施设备电线材质@1-铜&2-铝&3-铜铝混用*/
	private String linematerial;
	/**设施设备电线老化@1-否&2-轻微&3-一般&4-严重*/
	private String lineageing;
	//----------------------------------------------------------------
	/**设置房子编号的get方法*/
	public String getHouse_id() {
		return house_id;
	}
	/**设置房子编号的set方法*/
	public void setHouse_id(String house_id) {
		this.house_id = house_id;
	}
	/**设置设施设备电路设施无异常@1-否&2-是的get方法*/
	public String getCircuit_normal() {
		return circuit_normal;
	}
	/**设置设施设备电路设施无异常@1-否&2-是的set方法*/
	public void setCircuit_normal(String circuit_normal) {
		this.circuit_normal = circuit_normal;
	}
	/**设置设施设备电路设施经常跳闸@1-否&2-是的get方法*/
	public String getCircuit_trip() {
		return circuit_trip;
	}
	/**设置设施设备电路设施经常跳闸@1-否&2-是的set方法*/
	public void setCircuit_trip(String circuit_trip) {
		this.circuit_trip = circuit_trip;
	}
	/**设置设施设备电路设施经常断电维修@1-否&2-是的get方法*/
	public String getCircuit_ddwx() {
		return circuit_ddwx;
	}
	/**设置设施设备电路设施经常断电维修@1-否&2-是的set方法*/
	public void setCircuit_ddwx(String circuit_ddwx) {
		this.circuit_ddwx = circuit_ddwx;
	}
	/**设置设施设备给排水管道无异常@1-否&2-是的get方法*/
	public String getWaterpip_noraml() {
		return waterpip_noraml;
	}
	/**设置设施设备给排水管道无异常@1-否&2-是的set方法*/
	public void setWaterpip_noraml(String waterpip_noraml) {
		this.waterpip_noraml = waterpip_noraml;
	}
	/**设置设施设备给排水管道老化破损@1-否&2-轻微&3-一般&4-严重的get方法*/
	public String getWaterpip_aging() {
		return waterpip_aging;
	}
	/**设置设施设备给排水管道老化破损@1-否&2-轻微&3-一般&4-严重的set方法*/
	public void setWaterpip_aging(String waterpip_aging) {
		this.waterpip_aging = waterpip_aging;
	}
	/**设置设施设备给排水管道堵塞@1-否&2-轻微&3-一般&4-严重的get方法*/
	public String getWaterpip_chuck() {
		return waterpip_chuck;
	}
	/**设置设施设备给排水管道堵塞@1-否&2-轻微&3-一般&4-严重的set方法*/
	public void setWaterpip_chuck(String waterpip_chuck) {
		this.waterpip_chuck = waterpip_chuck;
	}
	/**设置设施设备燃气管道无异常@1-否&2-是的get方法*/
	public String getFirepip_normal() {
		return firepip_normal;
	}
	/**设置设施设备燃气管道无异常@1-否&2-是的set方法*/
	public void setFirepip_normal(String firepip_normal) {
		this.firepip_normal = firepip_normal;
	}
	/**设置设施设备燃气管道老化@1-否&2-轻微&3-一般&4-严重的get方法*/
	public String getFirepip_aging() {
		return firepip_aging;
	}
	/**设置设施设备燃气管道老化@1-否&2-轻微&3-一般&4-严重的set方法*/
	public void setFirepip_aging(String firepip_aging) {
		this.firepip_aging = firepip_aging;
	}
	/**设置设施设备燃气管道漏气@1-否&2-是的get方法*/
	public String getFirepip_leakage() {
		return firepip_leakage;
	}
	/**设置设施设备燃气管道漏气@1-否&2-是的set方法*/
	public void setFirepip_leakage(String firepip_leakage) {
		this.firepip_leakage = firepip_leakage;
	}
	/**设置设施设备防雷设备完好@1-否&2-是的get方法*/
	public String getLightning_protect() {
		return lightning_protect;
	}
	/**设置设施设备防雷设备完好@1-否&2-是的set方法*/
	public void setLightning_protect(String lightning_protect) {
		this.lightning_protect = lightning_protect;
	}
	/**设置设施设备防雷设备老化程度@1-否&2-轻微&3-一般&4-严重的get方法*/
	public String getLightning_aging() {
		return lightning_aging;
	}
	/**设置设施设备防雷设备老化程度@1-否&2-轻微&3-一般&4-严重的set方法*/
	public void setLightning_aging(String lightning_aging) {
		this.lightning_aging = lightning_aging;
	}
	/**设置设施设备消防设备完好@1-否&2-是的get方法*/
	public String getFire_protect() {
		return fire_protect;
	}
	/**设置设施设备消防设备完好@1-否&2-是的set方法*/
	public void setFire_protect(String fire_protect) {
		this.fire_protect = fire_protect;
	}
	/**设置设施设备消防设备老化程度@1-否&2-轻微&3-一般&4-严重的get方法*/
	public String getFire_aging() {
		return fire_aging;
	}
	/**设置设施设备消防设备老化程度@1-否&2-轻微&3-一般&4-严重的set方法*/
	public void setFire_aging(String fire_aging) {
		this.fire_aging = fire_aging;
	}
	/**设置设施设备子项健康评级@1-a级&2-b级&3-c级的get方法*/
	public String getEquipment_grading() {
		return equipment_grading;
	}
	/**设置设施设备子项健康评级@1-a级&2-b级&3-c级的set方法*/
	public void setEquipment_grading(String equipment_grading) {
		this.equipment_grading = equipment_grading;
	}
	/**设置设施设备备注的get方法*/
	public String getEquipment_tdesc() {
		return equipment_tdesc;
	}
	/**设置设施设备备注的set方法*/
	public void setEquipment_tdesc(String equipment_tdesc) {
		this.equipment_tdesc = equipment_tdesc;
	}
	/**设置设施设备一户一表@1-否&2-是的get方法*/
	public String getWatchonedoor() {
		return watchonedoor;
	}
	/**设置设施设备一户一表@1-否&2-是的set方法*/
	public void setWatchonedoor(String watchonedoor) {
		this.watchonedoor = watchonedoor;
	}
	/**设置设施设备电线凌乱程度@1-否&2-轻微&3-一般&4-严重的get方法*/
	public String getLinemessy() {
		return linemessy;
	}
	/**设置设施设备电线凌乱程度@1-否&2-轻微&3-一般&4-严重的set方法*/
	public void setLinemessy(String linemessy) {
		this.linemessy = linemessy;
	}
	/**设置设施设备电线材质@1-铜&2-铝&3-铜铝混用的get方法*/
	public String getLinematerial() {
		return linematerial;
	}
	/**设置设施设备电线材质@1-铜&2-铝&3-铜铝混用的set方法*/
	public void setLinematerial(String linematerial) {
		this.linematerial = linematerial;
	}
	/**设置设施设备电线老化@1-否&2-轻微&3-一般&4-严重的get方法*/
	public String getLineageing() {
		return lineageing;
	}
	/**设置设施设备电线老化@1-否&2-轻微&3-一般&4-严重的set方法*/
	public void setLineageing(String lineageing) {
		this.lineageing = lineageing;
	}
}