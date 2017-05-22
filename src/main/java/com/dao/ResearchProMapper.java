package com.dao;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;



import com.model.ResearchProject;



@Repository
public interface ResearchProMapper extends BaseMapper<ResearchProject,String> {
	int insert(ResearchProject researchPro);
	ResearchProject load(String rpid);
	List<ResearchProject> findAllById(Map map);
	void update(String rpId);
	void delete(String rpId);
	List<ResearchProject> findAllInfosById(String id);
	
}
