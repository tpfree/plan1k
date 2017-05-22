package com.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.HonorTitle;
import com.model.RelyingOrg;
import com.model.SysUser;



@Repository
public interface RelyingOrgMapper extends BaseMapper<RelyingOrg, String> {

	int insert(RelyingOrg orgInfo);
	RelyingOrg load(String orgId);
	List<RelyingOrg> findAllById(String id);
	void update(String orgId);
	void delete(String orgId);
}
