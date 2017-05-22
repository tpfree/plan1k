package com.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class SysNavTree extends AbstractDO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2549770144649770858L;
	private String id;// 主键
	private String treeName;
	private String treeUrl;
	private Integer treeIndex;
	private String treeCode;
	private String parentCode;
	private Integer treeLevel;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getTreeIndex() {
		return treeIndex;
	}

	public void setTreeIndex(Integer treeIndex) {
		this.treeIndex = treeIndex;
	}

	public String getTreeName() {
		return treeName;
	}

	public void setTreeName(String treeName) {
		this.treeName = treeName;
	}

	public String getTreeUrl() {
		return treeUrl;
	}

	public void setTreeUrl(String treeUrl) {
		this.treeUrl = treeUrl;
	}

	public String getTreeCode() {
		return treeCode;
	}

	public void setTreeCode(String treeCode) {
		this.treeCode = treeCode;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public Integer getTreeLevel() {
		return treeLevel;
	}

	public void setTreeLevel(Integer treeLevel) {
		this.treeLevel = treeLevel;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("Id", getId())
				.append("NavTreeName", this.getTreeName())
				.append("navTreeUrl", this.getTreeUrl())
				.append("navTreeCode", this.getTreeCode()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof SysNavTree == false)
			return false;
		if (this == obj)
			return true;
		SysNavTree other = (SysNavTree) obj;
		return new EqualsBuilder().append(getId(), other.getId()).isEquals();
	}
}
