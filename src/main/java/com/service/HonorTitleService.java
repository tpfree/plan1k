package com.service;


import java.util.List;

import com.pageModel.Data;
import com.pageModel.HonorTitleInfo;


/**
 *  教育经历ervice
 * 
 * @author cfl
 * 
 */
public interface HonorTitleService extends BaseServiceI {

	Data addHonorInfo(HonorTitleInfo honorInfo);
	List<HonorTitleInfo> findAllById(String declareId);
	HonorTitleInfo getHonorInfoById(String id);
	Data updateHonorInfo(HonorTitleInfo honorInfo);
	Data deleteHonorInfo(String id);

}
