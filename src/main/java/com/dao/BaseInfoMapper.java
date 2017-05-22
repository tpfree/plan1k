package com.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.model.DeclareBaseInfo;



@Repository
public interface BaseInfoMapper  extends BaseMapper<DeclareBaseInfo , String>{
	 int insert(DeclareBaseInfo baseInfo);
	 void updateSelective(DeclareBaseInfo baseInfo);
	 
	 List<DeclareBaseInfo>  findBaseInfoById(String declareId);
	 
	 void deleteBaseInfo(String baseId);
	 void insertBatch(List<DeclareBaseInfo> baseInfoList);
	 DeclareBaseInfo  getBaseInfoByObj(DeclareBaseInfo baseInfo);
	 
	 List<DeclareBaseInfo>  getTeamOtherMembersById(String declareId);
	 
	 DeclareBaseInfo getBaseInfoById(String declareId);
}
