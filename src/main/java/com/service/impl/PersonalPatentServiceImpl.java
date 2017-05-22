package com.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





import com.dao.PersonalPatentMapper;
import com.model.PersonalPatent;
import com.pageModel.Data;
import com.pageModel.Errcode;
import com.pageModel.PersonalPatentInfo;
import com.service.PersonalPatentService;



/**
 *
 * 
 * @author cfl
 * 
 */
@Service("patentService")
public class PersonalPatentServiceImpl extends BaseServiceImpl implements PersonalPatentService{
	
	@Autowired
	private PersonalPatentMapper patentMapper;
	
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


	@Override
	public List<PersonalPatentInfo>  findAllById(String id) {
		List<PersonalPatent> patentList=patentMapper.findAllById(id);
		List<PersonalPatentInfo> patentInfoList = new ArrayList<PersonalPatentInfo>();
		if(patentList!=null && !patentList.isEmpty()){
			int count=patentList.size();
			for(int i=0;i<count;i++){
				PersonalPatentInfo patentInfo = new PersonalPatentInfo();
				PersonalPatent work =patentList.get(i);
				BeanUtils.copyProperties(work, patentInfo);
				patentInfoList.add(patentInfo);
			}
			return patentInfoList;
		}
		return null;
	}

	@Override
	public Data addPatentInfo(PersonalPatentInfo patentInfo) {
		PersonalPatent patent = new PersonalPatent(); 
		if(patentInfo!=null){
			BeanUtils.copyProperties(patentInfo, patent);
			patent.setPatentId(UUID.randomUUID().toString().replaceAll("-", ""));
			if(patentInfo.getAttachment()!=null && patentInfo.getAttachment().getAttachmentPath()!=null){
				patent.setCertificate(patentInfo.getAttachment().getAttachmentPath());
			}
			patentMapper.insert(patent);
			return Data.build(Errcode.SUCCESS.ordinal(), true, "添加成功");
		}else{
			return Data.build(Errcode.FAILURE.ordinal(), false, "添加失败");
		}
	}

	@Override
	public PersonalPatentInfo getPatentInfoById(String id) {
		PersonalPatentInfo patentInfo = new PersonalPatentInfo();
		PersonalPatent patent = patentMapper.load(id);
		BeanUtils.copyProperties(patent, patentInfo);
		return patentInfo;
	}

	@Override
	public Data updatePatentInfo(PersonalPatentInfo patentInfo) {
		PersonalPatent patent = new PersonalPatent();
		if(patentInfo!=null){
			BeanUtils.copyProperties(patentInfo, patent);
			if(patentInfo.getAttachment()!=null && patentInfo.getAttachment().getAttachmentPath()!=null){
				patent.setCertificate(patentInfo.getAttachment().getAttachmentPath());
			}
			patentMapper.update(patent);
			return Data.build(Errcode.SUCCESS.ordinal(), true, "修改成功");
		}
		return Data.build(Errcode.FAILURE.ordinal(), false, "修改失败");
	}

	@Override
	public Data deletePatentInfo(String id) {
		if(id!=null){
			patentMapper.delete(id);
			return Data.build(Errcode.SUCCESS.ordinal(), true, "刪除成功");
		}
		return Data.build(Errcode.FAILURE.ordinal(), false, "删除失败");
	}
	
	

}
