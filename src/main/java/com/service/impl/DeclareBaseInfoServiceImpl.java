package com.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BaseInfoMapper;
import com.dao.DeclareMapper;
import com.model.DeclareBaseInfo;
import com.model.DeclareInfo;
import com.pageModel.Data;
import com.pageModel.Declare;
import com.pageModel.DeclareBase;
import com.pageModel.Errcode;
import com.pageModel.User;
import com.service.BaseServiceI;
import com.service.DeclareBaseInfoService;
import com.service.DeclareService;



/**
 *
 * 
 * @author cfl
 * 
 */
@Service("baseInfoService")
public class DeclareBaseInfoServiceImpl extends BaseServiceImpl implements DeclareBaseInfoService{
	
	@Autowired
	private BaseInfoMapper baseInfoMapper;
	@Autowired
	private DeclareMapper declareMapper;
	
	private SimpleDateFormat  sdf = new SimpleDateFormat ("yyyy-MM-dd");

	@Override
	public Data insert(DeclareBase baseInfo) {
		
		if(baseInfo !=null){
			DeclareBaseInfo info = new DeclareBaseInfo();
			BeanUtils.copyProperties(baseInfo, info);
			info.setIfvalid(0);
			try {
				info.setBirthday(sdf.parse(baseInfo.getBirthday()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			baseInfoMapper.insert(info);
			return Data.build(Errcode.SUCCESS.ordinal(), true, "基本信息添加成功");
		}else{
			return Data.build(Errcode.FAILURE.ordinal(), false, "参数解析错误");
		}
	}

	@Override
	public Data updateSelective(DeclareBase base) {
		if(base!=null){
			String job=base.getPersonal_job_profile();
			String plan =base.getPersonal_work_plan();
			if(job!=null&&job.toCharArray().length>2000){
				return Data.build(Errcode.FAILURE.ordinal(), false, "工作业绩不能超过1000个字");
			}
			if(plan!=null&&plan.toCharArray().length>2000){
				return Data.build(Errcode.FAILURE.ordinal(), false, "工作计划不能超过1000个字");
			}
			DeclareBaseInfo info = new DeclareBaseInfo();
			BeanUtils.copyProperties(base, info);
			baseInfoMapper.updateSelective(info);
			return Data.build(Errcode.SUCCESS.ordinal(), true, "操作成功");
		}
		return Data.build(Errcode.FAILURE.ordinal(), false, "操作失败");
	}

	@Override
	public List<DeclareBase> findBaseInfoById(String declareId) {
		if(declareId!=null && !"".equals(declareId)){
			List<DeclareBaseInfo> infoList = baseInfoMapper.findBaseInfoById(declareId);
			List<DeclareBase> declareList = new ArrayList<DeclareBase>();
			int size =infoList.size();
			if(infoList!=null && size>0){
				for(int i=0;i<size;i++){
					DeclareBaseInfo info = infoList.get(i);
					DeclareBase declare = new DeclareBase();
					BeanUtils.copyProperties(info, declare);
					declareList.add(declare);
				}
				return declareList;
			}
		}
		return null;
	}

	@Override
	public Data deleteBaseInfo(String baseId) {
		if(baseId!=null && !"".equals(baseId)){
		  	try {
		  		baseInfoMapper.deleteBaseInfo(baseId);
				return Data.build(Errcode.SUCCESS.ordinal(), true, "数据删除成功");
			} catch (Exception e) {
				return Data.build(Errcode.FAILURE.ordinal(), true, "数据删除失败");
			}
			
		}
		return Data.build(Errcode.FAILURE.ordinal(), true, "数据删除失败");
	}

	@Override
	public DeclareBase getBaseInfoById(DeclareBase infoBase) {
		DeclareBase baseInfo = new DeclareBase();
		DeclareBaseInfo declareBaseInfo = new DeclareBaseInfo();
		try {
			BeanUtils.copyProperties(infoBase, declareBaseInfo);
			declareBaseInfo = baseInfoMapper.getBaseInfoByObj(declareBaseInfo);
			BeanUtils.copyProperties(declareBaseInfo, baseInfo);
			baseInfo.setBirthday(sdf.format(declareBaseInfo.getBirthday()));
		} catch (Exception e) {
			return null;
		}
		return baseInfo;
	}

	
	
}
