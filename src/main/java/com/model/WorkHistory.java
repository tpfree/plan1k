package com.model;

import java.io.Serializable;
import java.util.Date;

public class WorkHistory extends AbstractDO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String historyId;
	private Date startDate;
	private Date endDate;
	private String workUnit;
	private String position;
	private String country;
	private String declareId;
	private String baseId;
	
	
	
	
	
	public String getBaseId() {
		return baseId;
	}





	public void setBaseId(String baseId) {
		this.baseId = baseId;
	}





	public String getHistoryId() {
		return historyId;
	}





	public void setHistoryId(String historyId) {
		this.historyId = historyId;
	}





	public Date getStartDate() {
		return startDate;
	}





	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}





	public Date getEndDate() {
		return endDate;
	}





	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}





	public String getWorkUnit() {
		return workUnit;
	}





	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}





	public String getPosition() {
		return position;
	}





	public void setPosition(String position) {
		this.position = position;
	}





	public String getCountry() {
		return country;
	}





	public void setCountry(String country) {
		this.country = country;
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
