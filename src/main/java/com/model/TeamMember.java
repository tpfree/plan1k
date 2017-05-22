package com.model;

import java.io.Serializable;

public class TeamMember extends AbstractDO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String memberId;
	private Integer seniorTitleNum;
	private Integer viceSeniorTitleNum;
	private Integer intermediateTitlNum;
	private Integer belowIntermediateNum;
	private Integer doctorMum;
	private Integer masterNum;
	private Integer bacheloNum;
	private Integer titleSubtotal;
	private Integer juniorCollegeNun;
	private Integer eudSubtotal;
	private String declareId;
	
	
	
	
	




	public String getMemberId() {
		return memberId;
	}





	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}





	public Integer getSeniorTitleNum() {
		return seniorTitleNum;
	}





	public void setSeniorTitleNum(Integer seniorTitleNum) {
		this.seniorTitleNum = seniorTitleNum;
	}





	public Integer getViceSeniorTitleNum() {
		return viceSeniorTitleNum;
	}





	public void setViceSeniorTitleNum(Integer viceSeniorTitleNum) {
		this.viceSeniorTitleNum = viceSeniorTitleNum;
	}





	public Integer getIntermediateTitlNum() {
		return intermediateTitlNum;
	}





	public void setIntermediateTitlNum(Integer intermediateTitlNum) {
		this.intermediateTitlNum = intermediateTitlNum;
	}





	public Integer getBelowIntermediateNum() {
		return belowIntermediateNum;
	}





	public void setBelowIntermediateNum(Integer belowIntermediateNum) {
		this.belowIntermediateNum = belowIntermediateNum;
	}





	public Integer getDoctorMum() {
		return doctorMum;
	}





	public void setDoctorMum(Integer doctorMum) {
		this.doctorMum = doctorMum;
	}





	public Integer getMasterNum() {
		return masterNum;
	}





	public void setMasterNum(Integer masterNum) {
		this.masterNum = masterNum;
	}





	public Integer getBacheloNum() {
		return bacheloNum;
	}





	public void setBacheloNum(Integer bacheloNum) {
		this.bacheloNum = bacheloNum;
	}





	public Integer getTitleSubtotal() {
		return titleSubtotal;
	}





	public void setTitleSubtotal(Integer titleSubtotal) {
		this.titleSubtotal = titleSubtotal;
	}





	public Integer getJuniorCollegeNun() {
		return juniorCollegeNun;
	}





	public void setJuniorCollegeNun(Integer juniorCollegeNun) {
		this.juniorCollegeNun = juniorCollegeNun;
	}





	public Integer getEudSubtotal() {
		return eudSubtotal;
	}





	public void setEudSubtotal(Integer eudSubtotal) {
		this.eudSubtotal = eudSubtotal;
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
