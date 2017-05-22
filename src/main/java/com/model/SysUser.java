package com.model;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class SysUser extends AbstractDO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2549770144649770858L;
	private String id;// 主键
	private String gender;// 性别 0 男 1 女
	private String username;// 用户名
	private String password;// 密码
	private String nickname;// 别名
	private String email;// 邮箱
	private String phone;// 电话
	private Date birthDate;// 出生日期
	private String unitCode;// 单位代码
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public SysUser() {
	}

	public SysUser(String id) {
		this.id = id;
	}

	public void setId(String value) {
		this.id = value;
	}

	public String getId() {
		return this.id;
	}

	public void setGender(String value) {
		this.gender = value;
	}

	public String getGender() {
		return this.gender;
	}

	public void setUsername(String value) {
		this.username = value;
	}

	public String getUsername() {
		return this.username;
	}

	public void setPassword(String value) {
		this.password = value;
	}

	public String getPassword() {
		return this.password;
	}

	public void setNickname(String value) {
		this.nickname = value;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setEmail(String value) {
		this.email = value;
	}

	public String getEmail() {
		return this.email;
	}

	public void setPhone(String value) {
		this.phone = value;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setBirthDate(java.util.Date value) {
		this.birthDate = value;
	}

	public java.util.Date getBirthDate() {
		return this.birthDate;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("Id", getId()).append("Gender", getGender())
				.append("Username", getUsername())
				.append("Password", getPassword())
				.append("Nickname", getNickname()).append("Email", getEmail())
				.append("Phone", getPhone())
				.append("BirthDate", getBirthDate()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof SysUser == false)
			return false;
		if (this == obj)
			return true;
		SysUser other = (SysUser) obj;
		return new EqualsBuilder().append(getId(), other.getId()).isEquals();
	}
}
