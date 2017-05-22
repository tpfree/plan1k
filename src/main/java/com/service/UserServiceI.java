package com.service;

import java.util.List;

import com.pageModel.Data;
import com.pageModel.Unit;
import com.pageModel.User;



/**
 * 用户Service
 * 
 * @author
 * 
 */
public interface UserServiceI extends BaseServiceI {

	Data login(User user);

	Data register(User user);
	
	Data getNavTreeByUnitCode(String unitCode);
	
	List<Unit> findAllUnit();

}
