package com.pageModel;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "relyOrg")
public class RelyingOrgInfo implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8627992124931981967L;
	private String orgId;
	private String orgName;
	private String orgType;
	private String ratifyDepartment;
	private String  ratifyDate;
	private String amountSubsidy;
	private String declareId;
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgType() {
		return orgType;
	}
	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}
	public String getRatifyDepartment() {
		return ratifyDepartment;
	}
	public void setRatifyDepartment(String ratifyDepartment) {
		this.ratifyDepartment = ratifyDepartment;
	}
	public String getRatifyDate() {
		return ratifyDate;
	}
	public void setRatifyDate(String ratifyDate) {
		this.ratifyDate = ratifyDate;
	}
	public String getAmountSubsidy() {
		return amountSubsidy;
	}
	public void setAmountSubsidy(String amountSubsidy) {
		this.amountSubsidy = amountSubsidy;
	}
	public String getDeclareId() {
		return declareId;
	}
	public void setDeclareId(String declareId) {
		this.declareId = declareId;
	}
	
	
	
}
