package com.model;

import java.io.Serializable;
import java.util.Date;

public class PersonalPatent extends AbstractDO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return null;
	}

	private String patentId;
	private String patentName;
	private Integer protectPeriod;
	private Integer patentType;
	private String authorizedCountry;
	private String patentOwner;
	private String certificate;
	private String declareId;
	private String baseId;
	
	
	
	public String getBaseId() {
		return baseId;
	}
	public void setBaseId(String baseId) {
		this.baseId = baseId;
	}
	public String getPatentId() {
		return patentId;
	}
	public void setPatentId(String patentId) {
		this.patentId = patentId;
	}
	public String getPatentName() {
		return patentName;
	}
	public void setPatentName(String patentName) {
		this.patentName = patentName;
	}
	public Integer getProtectPeriod() {
		return protectPeriod;
	}
	public void setProtectPeriod(Integer protectPeriod) {
		this.protectPeriod = protectPeriod;
	}
	public Integer getPatentType() {
		return patentType;
	}
	public void setPatentType(Integer patentType) {
		this.patentType = patentType;
	}
	public String getAuthorizedCountry() {
		return authorizedCountry;
	}
	public void setAuthorizedCountry(String authorizedCountry) {
		this.authorizedCountry = authorizedCountry;
	}
	public String getPatentOwner() {
		return patentOwner;
	}
	public void setPatentOwner(String patentOwner) {
		this.patentOwner = patentOwner;
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
