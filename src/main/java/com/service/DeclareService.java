package com.service;


import java.util.List;
import java.util.Map;

import com.model.DeclareInfo;
import com.pageModel.Data;
import com.pageModel.Declare;
import com.pageModel.DeclareBase;
import com.pageModel.TeamMemberInfo;


/**
 *  申请信息Service
 * 
 * @author cfl
 * 
 */
public interface DeclareService extends BaseServiceI {

	public int insert(Declare declare);

	public Data updateIfValid(String id);
	
	public Data deleteById(String id);
	
	public Data deleteByIds(String[] ids);
	
	public List<Declare> findAllInfoList(String userName);
	
	public Data addOtherMembers(TeamMemberInfo memberInfo,Declare declare,String declareId);
	
	public Declare findDeclareInfos(String id);
	
	public List<DeclareBase> findMembersById(String id);
	
	public TeamMemberInfo getMembersInfo(String id);
	
	public Declare getAllDeclareInfos(String declareId,Integer flag);
}
