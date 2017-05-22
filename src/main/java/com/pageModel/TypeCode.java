/**
 * @FILE:FitnessActivity.java
 * @AUTHOR:xuhaibo
 * @DATE:2017-3-1 下午1:10:52
 **/
package com.pageModel;


/*******************************************
 * @COMPANY:陕西之路网络技术有限公司
 * @CLASS:TypeCode
 * @DESCRIPTION:健身活动
 * @AUTHOR:yujunhong
 * @VERSION:v1.0
 * @DATE:2017-3-1 下午1:10:52
 *******************************************/
public class TypeCode {
	public static final String UNIT_TYPE_CODE="A0000001";//单位类型代码
	
	public static String getPrefix(String typeCode){
		return typeCode.replaceAll("[\\d]", "");
	}
}
