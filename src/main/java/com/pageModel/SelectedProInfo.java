package com.pageModel;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "selectedPro")
public class SelectedProInfo implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String proId;
	private String proName;
	private String selectedTime;
	private String memo;
	private Integer proLevel;
	private String  declareId;
	private String baseId;
	private Integer flag;
	
	
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
	
	public String getSelectedTime() {
		return selectedTime;
	}
	public void setSelectedTime(String selectedTime) {
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
