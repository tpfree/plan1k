package com.service;

import com.pageModel.Data;
import com.pageModel.Dictionary;

/**
 * 用户Service
 * 
 * @author
 * 
 */
public interface DictServiceI extends BaseServiceI {

	/**
	 * 添加字典
	 * @param unitName
	 * @param level
	 * @return
	 */
	Data addDict(String typeCode, String name,String pCode);
	
	/**
	 * 获取字典列表
	 * @param unitName
	 * @param level
	 * @return
	 */
	Data getDictList(String typeCode);

}
