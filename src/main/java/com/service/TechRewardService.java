package com.service;


import java.util.List;

import com.pageModel.Data;
import com.pageModel.Education;
import com.pageModel.TechRewardInfo;


/**
 *  工作经历ervice
 * 
 * @author cfl
 * 
 */
public interface TechRewardService extends BaseServiceI {

	Data addReward(TechRewardInfo rewardInfo);
	List<TechRewardInfo> findAllById(String declareId);
	TechRewardInfo getRewardById(String id);
	Data updateReward(TechRewardInfo rewardInfo);
	Data deleteReward(String id);

}
