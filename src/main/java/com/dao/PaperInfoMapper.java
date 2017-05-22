package com.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.PaperInfomation;



@Repository
public interface PaperInfoMapper extends BaseMapper<PaperInfomation,String> {
	int insert(PaperInfomation paper);
	PaperInfomation load(String paperId);
	List<PaperInfomation> findAllById(String id);
	void update(String paperId);
	void delete(String paperId);
	
}
