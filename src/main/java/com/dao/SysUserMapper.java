package com.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.model.SysUser;



@Repository
public interface SysUserMapper extends BaseMapper<SysUser, String> {

	SysUser findByUsername(String username);
	
	SysUser findByVerifyCode(String verifyCode);
	
	Integer isUniqueUsername(@Param("id") Integer id, @Param("username") String username);

	void updateStatus(@Param("id") int id, @Param("status") String userStatus,
			@Param("updateDate") Date updateDate);
}
