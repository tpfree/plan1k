package com.service;


import java.util.List;

import com.pageModel.Data;
import com.pageModel.WorkHistoryInfo;


/**
 *  工作经历ervice
 * 
 * @author cfl
 * 
 */
public interface WorkHistoryService extends BaseServiceI {

	Data addWorkHistory(WorkHistoryInfo workInfo);
	List<WorkHistoryInfo> findAllById(String declareId);
	WorkHistoryInfo getWorkHistoryInfoById(String id);
	Data updateWorkHistory(WorkHistoryInfo workInfo);
	Data deleteWorkHistory(String id);

}
