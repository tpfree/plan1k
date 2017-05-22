package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.SysDictionary;



@Repository
public interface SysDictMapper extends BaseMapper<SysDictionary, String> {

	SysDictionary findByDictCode(String dictCode);
	
	SysDictionary findByDictName(String dictName,String typeCode);
	
	List<SysDictionary> findByTypeCode(String typeCode);
}
