package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.SysUnit;

@Repository
public interface SysUnitMapper extends BaseMapper<SysUnit, String>{
	List<SysUnit> findAllUnits();
}
