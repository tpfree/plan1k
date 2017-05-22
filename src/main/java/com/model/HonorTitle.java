package com.model;

import java.io.Serializable;
import java.util.Date;

public class HonorTitle extends AbstractDO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return null;
	}

	private String honorId;
	private String honorName;
	private Date honorDate;
	private String department;
	private String certificate;
	private String declareId;
	private int honorlevel;
	private String baseId;
	
	
	
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
	public Date getHonorDate() {
		return honorDate;
	}
	public void setHonorDate(Date honorDate) {
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
