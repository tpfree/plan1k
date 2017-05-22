package com.service;


import java.util.List;

import com.pageModel.Data;
import com.pageModel.Education;
import com.pageModel.PersonalPatentInfo;


/**
 *  教育经历ervice
 * 
 * @author cfl
 * 
 */
public interface PersonalPatentService extends BaseServiceI {

	Data addPatentInfo(PersonalPatentInfo patentInfo);
	List<PersonalPatentInfo> findAllById(String declareId);
	PersonalPatentInfo getPatentInfoById(String id);
	Data updatePatentInfo(PersonalPatentInfo patentInfo);
	Data deletePatentInfo(String id);

}
