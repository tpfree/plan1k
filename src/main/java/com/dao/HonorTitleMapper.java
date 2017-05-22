package com.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.EducationInfo;
import com.model.HonorTitle;



@Repository
public interface HonorTitleMapper extends BaseMapper<HonorTitle,String> {
	int insert(HonorTitle honor);
	HonorTitle load(String honorId);
	List<HonorTitle> findAllById(String id);
	void update(String honorId);
	void delete(String honorId);
	
}
