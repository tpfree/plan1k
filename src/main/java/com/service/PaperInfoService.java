package com.service;


import java.util.List;

import com.pageModel.Data;
import com.pageModel.Education;
import com.pageModel.PaperInfo;


/**
 *  代表性论著service
 * 
 * @author cfl
 * 
 */
public interface PaperInfoService extends BaseServiceI {

	Data addPaperInfo(PaperInfo paperInfo);
	List<PaperInfo> findAllById(String declareId);
	PaperInfo getPaperInfoById(String id);
	Data updatePaperInfo(PaperInfo paperInfo);
	Data deletePaperInfo(String id);

}
