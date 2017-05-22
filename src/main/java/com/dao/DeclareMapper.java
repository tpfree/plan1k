package com.dao;



import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.DeclareInfo;




@Repository
public interface DeclareMapper extends BaseMapper<DeclareInfo, String> {

	public int insert(DeclareInfo declare);
	public int updateIfValid(String id);
	public int deleteDeclareInfoById(String id);
	public int  deleteDeclareInfoByIds(String[] ids);
	public List<DeclareInfo> findAllDeclareInfos(String userName);
	public DeclareInfo findDeclareInfos(String id);
}
