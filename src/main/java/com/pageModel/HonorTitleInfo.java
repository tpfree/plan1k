package com.pageModel;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "honor")
public class HonorTitleInfo implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1768533612134868788L;
	private String honorId;
	private String honorName;  //荣誉称号
	private String honorDate;
	private String department;
	private String certificate;
	private String declareId;
	private int honorlevel;
	private String baseId;
	private AjaxDone attachment=new AjaxDone(); 
	private Integer flag;
	
	
	
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public AjaxDone getAttachment() {
		return attachment;
	}
	public void setAttachment(AjaxDone attachment) {
		this.attachment = attachment;
	}
	public String getBaseId() {
		return baseId;
	}
	public void setBaseId(String baseId) {
		this.baseId = baseId;
	}
	public int getHonorlevel() {
		return honorlevel;
	}
	public void setHonorlevel(int honorlevel) {
		this.honorlevel = honorlevel;
	}
	public String getHonorId() {
		return honorId;
	}
	public void setHonorId(String honorId) {
		this.honorId = honorId;
	}
	public String getHonorName() {
		return honorName;
	}
	public void setHonorName(String honorName) {
		this.honorName = honorName;
	}
	
	public String getHonorDate() {
		return honorDate;
	}
	public void setHonorDate(String honorDate) {
		this.honorDate = honorDate;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public String getDeclareId() {
		return declareId;
	}
	public void setDeclareId(String declareId) {
		this.declareId = declareId;
	}
	
	
}
