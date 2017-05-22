package com.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.dao.SysDictMapper;
import com.dao.SysUnitMapper;
import com.dao.SysUserMapper;
import com.dao.SysUserTreeMapper;
import com.model.SysDictionary;
import com.model.SysUnit;
import com.model.SysUser;
import com.model.SysUserTree;
import com.pageModel.Data;
import com.pageModel.Errcode;
import com.pageModel.TreeNode;
import com.pageModel.Unit;
import com.pageModel.User;
import com.service.UserServiceI;

/**
 * 用户service
 * 
 * @author xyl1153
 * 
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl implements UserServiceI {
	private static final Logger logger = Logger
			.getLogger(UserServiceImpl.class);
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private SysUserTreeMapper sysUserTreeMapper;
	
	@Autowired
	private SysDictMapper sysDictMapper;
	
	@Autowired
	private SysUnitMapper sysUnitMapper;
	
	
	@Override
	public Data login(User user) {
		if(user==null)
			return Data.build(Errcode.FAILURE.ordinal(), false, "参数解析错误");
		
		if(StringUtils.isEmpty(user.getUsername()))
			return Data.build(Errcode.FAILURE.ordinal(), false, "用户名不能为空");
		
		if(StringUtils.isEmpty(user.getPassword()))
			return Data.build(Errcode.FAILURE.ordinal(), false, "密码不能为空");
		SysUser sysUser=sysUserMapper.findByUsername(user.getUsername());
		
		if(sysUser==null)
			return Data.build(Errcode.FAILURE.ordinal(), false, "用户不存在");
		if(!sysUser.getPassword().equals(user.getPassword()))
			return Data.build(Errcode.FAILURE.ordinal(), false, "密码错误");
		User u=new User();
		BeanUtils.copyProperties(sysUser, u);
		return Data.build(Errcode.SUCCESS.ordinal(), true, u);
	}


	@Override
	@Transactional
	public Data register(User user) {
		if(user==null)
			return Data.build(Errcode.FAILURE.ordinal(), false, "参数解析错误");
		
		if(StringUtils.isEmpty(user.getUsername()))
			return Data.build(Errcode.FAILURE.ordinal(), false, "用户名不能为空");
		
		if(StringUtils.isEmpty(user.getPassword()))
			return Data.build(Errcode.FAILURE.ordinal(), false, "密码不能为空");
		SysUser sysUser=sysUserMapper.findByUsername(user.getUsername());
		
		if(sysUser!=null)
			return Data.build(Errcode.FAILURE.ordinal(), false, "用户已存在");
		sysUser=new SysUser();
		BeanUtils.copyProperties(user, sysUser);
		sysUser.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		sysUserMapper.insert(sysUser);
		return Data.build(Errcode.SUCCESS.ordinal(), true, "注册成功");
	}


	@Override
	public Data getNavTreeByUnitCode(String unitCode) {
		List<TreeNode> treeNodeList=new ArrayList();
		
		if(StringUtils.isEmpty(unitCode))
			return Data.build(Errcode.FAILURE.ordinal(), false, "单位代码不能为空") ;
		
		SysDictionary dict=sysDictMapper.findByDictCode(unitCode);
		
		if(dict==null){
			return Data.build(Errcode.FAILURE.ordinal(), false, "用户单位未找到");
		}
		
		List<SysUserTree> userTreeList=sysUserTreeMapper.findByLevel(dict.getDictLevel());
		
		if(userTreeList==null || userTreeList.isEmpty()){
			return Data.build(Errcode.FAILURE.ordinal(), false, "用户导航树未设置");
		}
		TreeNode parentNode=new TreeNode();
		TreeNode childNode=new TreeNode();
		TreeNode thridChildNode=new TreeNode();
		for(SysUserTree userTree:userTreeList){
			
			if(userTree.getTreeLevel()==0){
				parentNode.setCode(userTree.getTreeCode());
				if(treeNodeList.contains(parentNode)){
					parentNode=treeNodeList.get(treeNodeList.indexOf(parentNode));
				}else{
					parentNode.setpCode("");
					parentNode.setText(userTree.getTreeName());
					
					treeNodeList.add(parentNode);
				}
			}else if(userTree.getTreeLevel()==1){
				parentNode.setCode(userTree.getParentCode());
				if(treeNodeList.contains(parentNode)){
					parentNode=treeNodeList.get(treeNodeList.indexOf(parentNode));
				}else{
					continue;
				}
				childNode=new TreeNode();
				childNode.setCode(userTree.getTreeCode());
				if(!parentNode.getChildren().contains(childNode)){
					childNode.setText(userTree.getTreeName());
					childNode.setUrl(userTree.getTreeUrl());
					parentNode.getChildren().add(childNode);
				}else{
					childNode=parentNode.getChildren().get(parentNode.getChildren().indexOf(childNode));
				}
			}else if(userTree.getTreeLevel()==2){
//				parentNode.setCode(userTree.getParentCode());
//				if(childNode.getChildren().contains(parentNode)){
//					parentNode=childNode.getChildren().get(childNode.getChildren().indexOf(parentNode));
//				}else{
//					continue;
//				}
				thridChildNode=new TreeNode();
				thridChildNode.setCode(userTree.getTreeCode());
				if(!childNode.getChildren().contains(thridChildNode)){
					thridChildNode.setText(userTree.getTreeName());
					thridChildNode.setUrl(userTree.getTreeUrl());
					childNode.getChildren().add(thridChildNode);
				}
			}
		}
		return Data.build(Errcode.SUCCESS.ordinal(), true, treeNodeList,treeNodeList.size());
	}


	@Override
	public List<Unit> findAllUnit() {
		List<SysUnit> sysUnitList=sysUnitMapper.findAllUnits();
		List<Unit> unitList = new ArrayList<Unit>();
		if(sysUnitList.size()>0){
			int count=sysUnitList.size();
			for(SysUnit sysUnit:sysUnitList){
				Unit unitInfo = new Unit();
				BeanUtils.copyProperties(sysUnit, unitInfo);
				unitList.add(unitInfo);
			}
		}
		
		return unitList;
	}
	
}
