package com.service;


import java.util.List;

import com.pageModel.Data;
import com.pageModel.HonorTitleInfo;
import com.pageModel.RelyingOrgInfo;


/**
 *  依托机构ervice
 * 
 * @author cfl
 * 
 */
public interface RelyingOrgervice extends BaseServiceI {

	Data addRelyingOrg(RelyingOrgInfo orgInfo);
	List<RelyingOrgInfo> findAllById(String declareId);
	RelyingOrgInfo getRelyingOrgById(String id);
	Data updateRelyingOrg(RelyingOrgInfo orgInfo);
	Data deleteRelyingOrg(String id);

}
