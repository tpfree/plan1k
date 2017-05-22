package com.pageModel;


/**
 * JSON模型
 * 
 * @author 余军红
 * 
 */
public enum Errcode {
	FAILURE("失败"), SUCCESS("成功");
	
	private final String value;

	Errcode(String value) {
		this.value = value;
	}

	public String getId() {
		return this.toString();
	}

	public String getName() {
		return value;
	}
}
