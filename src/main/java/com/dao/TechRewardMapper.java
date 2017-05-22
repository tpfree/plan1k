package com.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.TechnologyReward;



@Repository
public interface TechRewardMapper extends BaseMapper<TechnologyReward,String> {
	int insert(TechnologyReward reward);
	TechnologyReward load(String rewardId);
	List<TechnologyReward> findAllById(String id);
	void update(String rewardId);
	void delete(String rewardId);
	
}
