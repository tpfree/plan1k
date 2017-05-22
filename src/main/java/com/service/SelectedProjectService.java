package com.service;


import java.util.List;

import com.pageModel.Data;
import com.pageModel.Education;
import com.pageModel.SelectedProInfo;


/**
 *  教育经历ervice
 * 
 * @author cfl
 * 
 */
public interface SelectedProjectService extends BaseServiceI {

	Data addSelectedInfo(SelectedProInfo proInfo);
	List<SelectedProInfo> findAllById(String declareId);
	SelectedProInfo getSelectedInfoById(String id);
	Data updateSelectedInfo(SelectedProInfo proInfo);
	Data deleteSelectedInfo(String id);

}
