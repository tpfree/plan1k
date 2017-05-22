package com.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.WorkHistory;



@Repository
public interface WorkHistoryMapper extends BaseMapper<WorkHistory,String> {
	int insert(WorkHistory history);
	WorkHistory load(String historyId);
	List<WorkHistory> findAllById(String id);
	void update(String historyId);
	void delete(String historyId);
	
}
