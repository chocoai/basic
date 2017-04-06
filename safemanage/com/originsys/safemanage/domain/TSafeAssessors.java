package com.originsys.safemanage.domain;
import java.io.Serializable;
import java.util.Date;

import com.originsys.eap.domain.User;

/**安全鉴定员用户类型属性表*/
public class TSafeAssessors extends User implements Serializable{
	/**用户id*/
	private String mem_id;
	/**从业资格证书编号*/
	private String certificate_number;
	/**证书取得时间*/
	private Date certificate_date;
	/**从业资格证书复印件*/
	private String certificate;
	/**专业技术职称*/
	private String professional_titles;
	/**工作经验年限*/
	private int work_years;
	/**从事专业*/
	private String professional;
	/**手写签名*/
	private String signature;
	//----------------------------------------------------------------
	/**设置用户id的get方法*/
	public String getMem_id() {
		return mem_id;
	}
	/**设置用户id的set方法*/
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	/**设置从业资格证书编号的get方法*/
	public String getCertificate_number() {
		return certificate_number;
	}
	/**设置从业资格证书编号的set方法*/
	public void setCertificate_number(String certificate_number) {
		this.certificate_number = certificate_number;
	}
	/**设置证书取得时间的get方法*/
	public Date getCertificate_date() {
		return certificate_date;
	}
	/**设置证书取得时间的set方法*/
	public void setCertificate_date(Date certificate_date) {
		this.certificate_date = certificate_date;
	}
	/**设置从业资格证书复印件的get方法*/
	public String getCertificate() {
		return certificate;
	}
	/**设置从业资格证书复印件的set方法*/
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	/**设置专业技术职称的get方法*/
	public String getProfessional_titles() {
		return professional_titles;
	}
	/**设置专业技术职称的set方法*/
	public void setProfessional_titles(String professional_titles) {
		this.professional_titles = professional_titles;
	}
	/**设置工作经验年限的get方法*/
	public int getWork_years() {
		return work_years;
	}
	/**设置工作经验年限的set方法*/
	public void setWork_years(int work_years) {
		this.work_years = work_years;
	}
	/**设置从事专业的get方法*/
	public String getProfessional() {
		return professional;
	}
	/**设置从事专业的set方法*/
	public void setProfessional(String professional) {
		this.professional = professional;
	}
	/**设置手写签名的get方法*/
	public String getSignature() {
		return signature;
	}
	/**设置手写签名的set方法*/
	public void setSignature(String signature) {
		this.signature = signature;
	}
}