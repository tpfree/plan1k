package com.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.model.EducationInfo;



@Repository
public interface EducationMapper extends BaseMapper<EducationInfo,String> {
	int insert(EducationInfo eduInfo);
	EducationInfo load(String eduId);
	List<EducationInfo> findAllEductionById(String declareId);
	void update(String eduId);
	void delete(String eduId);
	
}
