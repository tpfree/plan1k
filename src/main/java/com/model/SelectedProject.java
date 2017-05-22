package com.model;

import java.io.Serializable;
import java.util.Date;

public class SelectedProject extends AbstractDO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6205014482302654342L;
	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return null;
	}

	private String proId;
	private String proName;
	private Date selectedTime;
	private String memo;
	private Integer proLevel;
	private String  declareId;
	private String baseId;
	
	
	
	
	
	public String getBaseId() {
		return baseId;
	}
	public void setBaseId(String baseId) {
		this.baseId = baseId;
	}
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public Date getSelectedTime() {
		return selectedTime;
	}
	public void setSelectedTime(Date selectedTime) {
		this.selectedTime = selectedTime;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Integer getProLevel() {
		return proLevel;
	}
	public void setProLevel(Integer proLevel) {
		this.proLevel = proLevel;
	}
	public String getDeclareId() {
		return declareId;
	}
	public void setDeclareId(String declareId) {
		this.declareId = declareId;
	}
	
	
	
	

}
