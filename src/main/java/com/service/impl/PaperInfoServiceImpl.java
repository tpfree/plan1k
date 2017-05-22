package com.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PaperInfoMapper;
import com.model.PaperInfomation;
import com.pageModel.Data;
import com.pageModel.Errcode;
import com.pageModel.PaperInfo;
import com.service.PaperInfoService;



/**
 *
 * 
 * @author cfl
 * 
 */
@Service("paperService")
public class PaperInfoServiceImpl extends BaseServiceImpl implements PaperInfoService{
	
	@Autowired
	private PaperInfoMapper paperMapper;
	
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	


	@Override
	public List<PaperInfo>  findAllById(String id) {
		List<PaperInfomation> paperList=paperMapper.findAllById(id);
		List<PaperInfo> paperInfoList = new ArrayList<PaperInfo>();
		if(paperList!=null && !paperList.isEmpty()){
			int count=paperList.size();
			for(int i=0;i<count;i++){
				PaperInfo paperInfo = new PaperInfo();
				PaperInfomation info =paperList.get(i);
				BeanUtils.copyProperties(info, paperInfo);
				paperInfo.setPublishedDate(sdf.format(info.getPublishedDate()));
				paperInfoList.add(paperInfo);	
			}
			return paperInfoList;
		}
		return null;
	}


	@Override
	public Data addPaperInfo(PaperInfo paperInfo) {
		PaperInfomation info = new PaperInfomation(); 
		if(paperInfo!=null){
			BeanUtils.copyProperties(paperInfo, info);
			try {
				info.setPublishedDate(sdf.parse(paperInfo.getPublishedDate()));
			} catch (ParseException e) {
				
				return Data.build(Errcode.FAILURE.ordinal(), false, "时间格式转换错误");
			}
			info.setPaperId(UUID.randomUUID().toString().replaceAll("-", ""));
			paperMapper.insert(info);
			return Data.build(Errcode.SUCCESS.ordinal(), true, "添加成功");
		}else{
			return Data.build(Errcode.FAILURE.ordinal(), false, "添加失败");
		}
	}

	@Override
	public PaperInfo getPaperInfoById(String id) {
		PaperInfo paperInfo = new PaperInfo();
		PaperInfomation info =  paperMapper.load(id);
		BeanUtils.copyProperties(info, paperInfo);
		paperInfo.setPublishedDate(sdf.format(info.getPublishedDate()));
		return paperInfo;
	}

	@Override
	public Data updatePaperInfo(PaperInfo paperInfo) {
		PaperInfomation info = new PaperInfomation();
		if(paperInfo!=null){
			BeanUtils.copyProperties(paperInfo, info);
			try {
				info.setPublishedDate(sdf.parse(paperInfo.getPublishedDate()));
			} catch (ParseException e) {
				return Data.build(Errcode.FAILURE.ordinal(), false, "时间格式转换错误");
			}
			paperMapper.update(info);
			return Data.build(Errcode.SUCCESS.ordinal(), true, "修改成功");
		}
		return Data.build(Errcode.FAILURE.ordinal(), false, "修改失败");
	}

	@Override
	public Data deletePaperInfo(String id) {
		if(id!=null){
			paperMapper.delete(id);
			return Data.build(Errcode.SUCCESS.ordinal(), true, "刪除成功");
		}
		return Data.build(Errcode.FAILURE.ordinal(), false, "删除失败");
	}
	
	

}
