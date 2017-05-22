package com.service;


import java.util.List;

import com.pageModel.Data;
import com.pageModel.Education;
import com.pageModel.ResearchProInfo;


/**
 *  教育经历ervice
 * 
 * @author cfl
 * 
 */
public interface ResearchProjectService extends BaseServiceI {

	Data addResearchPro(ResearchProInfo researchInfo);
	List<ResearchProInfo> findAllById(Integer type,String declareId);
	ResearchProInfo getResearchProById(String id);
	Data updateResearchPro(ResearchProInfo researchInfo);
	Data deleteResearchPro(String id);

}
