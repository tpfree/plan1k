package com.service;


import java.util.List;

import com.pageModel.Data;
import com.pageModel.DeclareBase;


/**
 *  申请人基本资料信息Service
 * 
 * @author cfl
 * 
 */
public interface DeclareBaseInfoService extends BaseServiceI {

	Data insert(DeclareBase baseInfo);
	
	Data updateSelective(DeclareBase base);
	
	List<DeclareBase>  findBaseInfoById(String declareId);
	
	Data deleteBaseInfo(String baseId);
	
	DeclareBase getBaseInfoById(DeclareBase baseInfo);
}