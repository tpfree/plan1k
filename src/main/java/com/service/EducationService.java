package com.service;


import java.util.List;

import com.pageModel.Data;
import com.pageModel.Education;


/**
 *  教育经历ervice
 * 
 * @author cfl
 * 
 */
public interface EducationService extends BaseServiceI {

	Data addEducation(Education eduInfo);
	List<Education> findEducationById(String declareId);
	Education getEducationById(String id);
	Data updateEducation(Education education);
	Data deleteEducation(String id);

}
