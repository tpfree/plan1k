package com.dao;

import java.util.List;

import com.model.AbstractDO;

public interface BaseMapper<T extends AbstractDO, PK extends java.io.Serializable> {

	int insert(T model);

	void delete(PK modelPK);
	
	T load(PK modelPK);
	
	void update(T model);

	void updateSelective(T model);
	
	int countAll();
	
	List<T> findAll();
	
	List<PK> findAllIds();
	
}
