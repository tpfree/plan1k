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

import com.dao.EducationMapper;
import com.model.EducationInfo;
import com.pageModel.Data;
import com.pageModel.Education;
import com.pageModel.Errcode;
import com.service.BaseServiceI;
import com.service.EducationService;



/**
 *
 * 
 * @author cfl
 * 
 */
@Service("eduService")
public class EducationServiceImpl extends BaseServiceImpl implements EducationService{
	
	@Autowired
	private EducationMapper eduMapper;
	
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	

	@Override
	public Data addEducation(Education education){
		
		EducationInfo eduInfo = new EducationInfo(); 
		if(education!=null){
			BeanUtils.copyProperties(education, eduInfo);
			try {
				eduInfo.setStartDate(sdf.parse(education.getStartDate()));
				eduInfo.setEndDate(sdf.parse(education.getEndDate()));
			} catch (ParseException e) {
				
				return Data.build(Errcode.FAILURE.ordinal(), false, "时间格式转换错误");
			}
			eduInfo.setEduId(UUID.randomUUID().toString().replaceAll("-", ""));
			eduInfo.setInsertDate(new Date());
			eduMapper.insert(eduInfo);
			return Data.build(Errcode.SUCCESS.ordinal(), true, "添加成功");
		}else{
			return Data.build(Errcode.FAILURE.ordinal(), false, "添加失败");
		}
	}

	@Override
	public List<Education>  findEducationById(String declareId) {
		List<EducationInfo> eduInfoList=eduMapper.findAllEductionById(declareId);
		List<Education> eduList = new ArrayList<Education>();
		if(eduInfoList!=null && !eduInfoList.isEmpty()){
			int count=eduInfoList.size();
			for(int i=0;i<count;i++){
				Education education = new Education();
				EducationInfo eduInfo =eduInfoList.get(i);
				BeanUtils.copyProperties(eduInfo, education);
				education.setStartDate(sdf.format(eduInfo.getStartDate()));
				education.setEndDate(sdf.format(eduInfo.getEndDate()));
				eduList.add(education);
			}
			return eduList;
		}
		return null;
	}

	@Override
	public Education getEducationById(String id) {
		EducationInfo eduInfo = eduMapper.load(id);
		Education education = new Education();
		BeanUtils.copyProperties(eduInfo, education);
		education.setStartDate(sdf.format(eduInfo.getStartDate()));
		education.setEndDate(sdf.format(eduInfo.getEndDate()));
		return education;
	}

	@Override
	public Data updateEducation(Education education) {
		EducationInfo eduInfo  = new EducationInfo();
		if(education!=null){
			BeanUtils.copyProperties(education, eduInfo);
			try {
				eduInfo.setStartDate(sdf.parse(education.getStartDate()));
				eduInfo.setEndDate(sdf.parse(education.getEndDate()));
			} catch (ParseException e) {
				return Data.build(Errcode.FAILURE.ordinal(), false, "时间格式转换错误");
			}
			eduMapper.update(eduInfo);
			return Data.build(Errcode.SUCCESS.ordinal(), true, "修改成功");
		}
		return Data.build(Errcode.FAILURE.ordinal(), false, "修改失败");
	}

	@Override
	public Data deleteEducation(String id) {
		if(id!=null){
			eduMapper.delete(id);
			return Data.build(Errcode.SUCCESS.ordinal(), true, "刪除成功");
		}
		return Data.build(Errcode.FAILURE.ordinal(), false, "删除失败");
	}
	
	

}
