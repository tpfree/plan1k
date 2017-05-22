package com.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class SysDictionary extends AbstractDO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2549770144649770858L;
	private String id;// 主键
	private String dictCode;// 数组字典代码
	private Integer dictIndex;// 索引
	private Integer dictLevel;// 级别
	private String dictName;// 字典名称
	private String parentCode;// 父级代码
	private String typeCode;// 类型代码
	private Integer valid;// 是否可用

	public String getDictCode() {
		return dictCode;
	}

	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}

	public Integer getDictIndex() {
		return dictIndex;
	}

	public void setDictIndex(Integer dictIndex) {
		this.dictIndex = dictIndex;
	}

	public Integer getDictLevel() {
		return dictLevel;
	}

	public void setDictLevel(Integer dictLevel) {
		this.dictLevel = dictLevel;
	}

	public String getDictName() {
		return dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public Integer getValid() {
		return valid;
	}

	public void setValid(Integer valid) {
		this.valid = valid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("Id", getId()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof SysDictionary == false)
			return false;
		if (this == obj)
			return true;
		SysDictionary other = (SysDictionary) obj;
		return new EqualsBuilder().append(getId(), other.getId()).isEquals();
	}
}
