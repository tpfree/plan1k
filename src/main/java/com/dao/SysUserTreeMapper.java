package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.SysUserTree;

@Repository
public interface SysUserTreeMapper extends BaseMapper<SysUserTree, String> {
	
	List<SysUserTree> findByLevel(Integer level);
	
}
