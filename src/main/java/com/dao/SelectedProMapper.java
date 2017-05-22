package com.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.SelectedProject;



@Repository
public interface SelectedProMapper extends BaseMapper<SelectedProject,String> {
	int insert(SelectedProject selectedPro);
	SelectedProject load(String proId);
	List<SelectedProject> findAllById(String id);
	void update(String proId);
	void delete(String proId);
	
}
