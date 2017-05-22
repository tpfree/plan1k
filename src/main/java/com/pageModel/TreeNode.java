/**
 * @FILE:FitnessActivity.java
 * @AUTHOR:xuhaibo
 * @DATE:2017-3-1 下午1:10:52
 **/
package com.pageModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TreeNode implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String text;
	private String url;
	private String code;
	private String icon;
	private String pCode;
	private List<TreeNode> children = new ArrayList<TreeNode>();
	private boolean leaf;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

	@Override
	public boolean equals(Object obj) {
		return this.code.equals(((TreeNode) obj).getCode());
	}
}
