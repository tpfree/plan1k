package com.pageModel;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "researchPro")
public class ResearchProInfo implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String proId;
	private String proName;
	private String proSource;
	private String startDate;
	private String endDate;
	private double totalAmonut;
	private Integer peopleNumber;
	private String specificPosition;
	private String specificTask;
	private String proProgress;
	private String proNature;
	private String declareId;
	private String baseId;
	private Integer type;
	private Integer flag;
	
	
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
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
	public String getProSource() {
		return proSource;
	}
	public void setProSource(String proSource) {
		this.proSource = proSource;
	}
	
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Double getTotalAmonut() {
		return totalAmonut;
	}
	public void setTotalAmonut(Double totalAmonut) {
		this.totalAmonut = totalAmonut;
	}
	public Integer getPeopleNumber() {
		return peopleNumber;
	}
	public void setPeopleNumber(Integer peopleNumber) {
		this.peopleNumber = peopleNumber;
	}
	public String getSpecificPosition() {
		return specificPosition;
	}
	public void setSpecificPosition(String specificPosition) {
		this.specificPosition = specificPosition;
	}
	public String getSpecificTask() {
		return specificTask;
	}
	public void setSpecificTask(String specificTask) {
		this.specificTask = specificTask;
	}
	public String getProProgress() {
		return proProgress;
	}
	public void setProProgress(String proProgress) {
		this.proProgress = proProgress;
	}
	public String getProNature() {
		return proNature;
	}
	public void setProNature(String proNature) {
		this.proNature = proNature;
	}
	public String getDeclareId() {
		return declareId;
	}
	public void setDeclareId(String declareId) {
		this.declareId = declareId;
	}
	
	
	
	
}
