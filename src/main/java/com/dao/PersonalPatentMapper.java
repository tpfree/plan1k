package com.dao;


import java.util.List;

import org.springframework.stereotype.Repository;


import com.model.PersonalPatent;



@Repository
public interface PersonalPatentMapper extends BaseMapper<PersonalPatent,String> {
	int insert(PersonalPatent patent);
	PersonalPatent load(String patentId);
	List<PersonalPatent> findAllById(String id);
	void update(String patentId);
	void delete(String patentId);
	
}
