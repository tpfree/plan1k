package com.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class DeclareInfo extends AbstractDO{


	/**
	 * 
	 */
	private static final long serialVersionUID = 7715856169963191855L;
	
	
	private String declareId;    //申请资料编号
	private String applicant;     //申请人（中文名）
	private Integer declareType;  //申报类别 0  杰出人才 1 领军人才 2 拔尖人才
	private String declareUnit;    //申报单位
	private Integer declareFields;      //申报领域
	private String appPhone;           //申请人电话
	private String email;				//申请人电子信箱
	private String name_en;				//申请人英文名
	private Integer ifvalid;			//资料是否有效
	private Integer personType;			//人才类型
	private String contactPerson;		//联系人姓名
	private String contactPhone;		//联系人电话
	private String userName;             //数据录入人
	private Date declare_date;			//申报日期
	private String updateUser;			//数据修改人
	private Date updateDate;			//数据修改时间
	private Integer auditStatus;		//审核状态：0 未审核 1 审核中 2 审核通过 3 审核未通过
	private String auditUser;          //审核人
	private Date auditDate;			//审核时间
	
	private Integer flag;               // 0 个人申报  1 团队申报
	
	
	
	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getAuditUser() {
		return auditUser;
	}

	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}

	public Date getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("declareId",this.getDeclareId())
			.append("applicant",this.getApplicant())
			.append("declareType",this.getDeclareType())
			.append("declareUnit",this.getDeclareUnit())
			.append("declareFields",this.getDeclareFields())
			.append("appPhone",this.getAppPhone())
			.append("email",this.getEmail())
			.append("name_en",this.getName_en())
			.append("declare_date",this.getDeclare_date())
			.append("ifvalid",this.getIfvalid())
			.append("personType",this.getPersonType())
			.append("contactPerson",this.getContactPerson())
			.append("contactPhone",this.getContactPhone())
			.toString();
	}
	
	


	public String getDeclareId() {
		return declareId;
	}

	public void setDeclareId(String declareId) {
		this.declareId = declareId;
	}

	public String getApplicant() {
		return applicant;
	}



	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}



	public Integer getDeclareType() {
		return declareType;
	}



	public void setDeclareType(Integer declareType) {
		this.declareType = declareType;
	}


	public String getDeclareUnit() {
		return declareUnit;
	}

	public void setDeclareUnit(String declareUnit) {
		this.declareUnit = declareUnit;
	}

	public Integer getDeclareFields() {
		return declareFields;
	}

	public void setDeclareFields(Integer declareFields) {
		this.declareFields = declareFields;
	}

	public String getAppPhone() {
		return appPhone;
	}



	public void setAppPhone(String appPhone) {
		this.appPhone = appPhone;
	}



	


	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getName_en() {
		return name_en;
	}



	public void setName_en(String name_en) {
		this.name_en = name_en;
	}



	public Date getDeclare_date() {
		return declare_date;
	}



	public void setDeclare_date(Date declare_date) {
		this.declare_date = declare_date;
	}



	public Integer getIfvalid() {
		return ifvalid;
	}



	public void setIfvalid(Integer ifvalid) {
		this.ifvalid = ifvalid;
	}



	public Integer getPersonType() {
		return personType;
	}



	public void setPersonType(Integer personType) {
		this.personType = personType;
	}



	public String getContactPerson() {
		return contactPerson;
	}



	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}



	public String getContactPhone() {
		return contactPhone;
	}



	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}


	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SysUser == false) return false;
		if(this == obj) return true;
		SysUser other = (SysUser)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}

	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
