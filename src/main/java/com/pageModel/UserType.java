package com.pageModel;


/**
 * JSON模型
 * 
 * @author 余军红
 * 
 */
public enum UserType {
	SUPPERADMIN("一级管理员"), 
	SIMPLEADMIN("二级管理员"),
	SIMPLEUSER("一般用户");
	
	private final String value;

	UserType(String value) {
		this.value = value;
	}

	public String getId() {
		return this.toString();
	}

	public String getName() {
		return value;
	}
}
