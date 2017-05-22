package com.pageModel;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "reward")
public class TechRewardInfo implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9152867883445323969L;
	private String rewardId;
	private String rewardNumber;
	private String rewardName;
	private String department;
	private  Integer rewardLevel;
	private  Integer rewardRanking;
	private  Integer totalNumber;
	private String rewardDate;
	private String certificate;
	private String declareId;
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
	public String getRewardId() {
		return rewardId;
	}
	public void setRewardId(String rewardId) {
		this.rewardId = rewardId;
	}
	public String getRewardNumber() {
		return rewardNumber;
	}
	public void setRewardNumber(String rewardNumber) {
		this.rewardNumber = rewardNumber;
	}
	public String getRewardName() {
		return rewardName;
	}
	public void setRewardName(String rewardName) {
		this.rewardName = rewardName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Integer getRewardLevel() {
		return rewardLevel;
	}
	public void setRewardLevel(Integer rewardLevel) {
		this.rewardLevel = rewardLevel;
	}
	public Integer getRewardRanking() {
		return rewardRanking;
	}
	public void setRewardRanking(Integer rewardRanking) {
		this.rewardRanking = rewardRanking;
	}
	public Integer getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
	}
	
	public String getRewardDate() {
		return rewardDate;
	}
	public void setRewardDate(String rewardDate) {
		this.rewardDate = rewardDate;
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
