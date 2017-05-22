package com.model;

import java.io.Serializable;
import java.util.Date;

public class RelyingOrg extends AbstractDO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String orgId;
	private String orgName;
	private String orgType;
	private String ratifyDepartment;
	private Date ratifyDate;
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
	public Date getRatifyDate() {
		return ratifyDate;
	}
	public void setRatifyDate(Date ratifyDate) {
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
	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
