package com.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





import com.dao.HonorTitleMapper;
import com.model.HonorTitle;
import com.pageModel.Data;
import com.pageModel.Errcode;
import com.pageModel.HonorTitleInfo;
import com.service.HonorTitleService;



/**
 *
 * 
 * @author cfl
 * 
 */
@Service("honorService")
public class HonorTitleServiceImpl extends BaseServiceImpl implements HonorTitleService{
	
	@Autowired
	private HonorTitleMapper honorMapper;
	
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	


	@Override
	public List<HonorTitleInfo>  findAllById(String id) {
		List<HonorTitle> honorList=honorMapper.findAllById(id);
		List<HonorTitleInfo> honorInfoList = new ArrayList<HonorTitleInfo>();
		if(honorList!=null && !honorList.isEmpty()){
			int count=honorList.size();
			for(int i=0;i<count;i++){
				HonorTitleInfo honorInfo = new HonorTitleInfo();
				HonorTitle honor =honorList.get(i);
				BeanUtils.copyProperties(honor, honorInfo);
				honorInfo.setHonorDate(sdf.format(honor.getHonorDate()));
				honorInfoList.add(honorInfo);
			}
			return honorInfoList;
		}
		return null;
	}





	@Override
	public Data addHonorInfo(HonorTitleInfo honorInfo) {
		HonorTitle honor = new HonorTitle(); 
		if(honorInfo!=null){
			BeanUtils.copyProperties(honorInfo, honor);
			try {
				honor.setHonorDate(sdf.parse(honorInfo.getHonorDate()));
			} catch (ParseException e) {
				
				return Data.build(Errcode.FAILURE.ordinal(), false, "时间格式转换错误");
			}
			honor.setHonorId(UUID.randomUUID().toString().replaceAll("-", ""));
			if(honorInfo.getAttachment()!=null && honorInfo.getAttachment().getAttachmentPath()!=null){
				honor.setCertificate(honorInfo.getAttachment().getAttachmentPath());
			}
			honorMapper.insert(honor);
			return Data.build(Errcode.SUCCESS.ordinal(), true, "添加成功");
		}else{
			return Data.build(Errcode.FAILURE.ordinal(), false, "添加失败");
		}
	}

	@Override
	public HonorTitleInfo getHonorInfoById(String id) {
		HonorTitleInfo honorInfo = new HonorTitleInfo();
		HonorTitle honor = honorMapper.load(id);
		BeanUtils.copyProperties(honor, honorInfo);
		honorInfo.setHonorDate(sdf.format(honor.getHonorDate()));
		return honorInfo;
	}

	@Override
	public Data updateHonorInfo(HonorTitleInfo honorInfo) {
		HonorTitle honor = new HonorTitle();
		if(honorInfo!=null){
			BeanUtils.copyProperties(honorInfo, honor);
			try {
				honor.setHonorDate(sdf.parse(honorInfo.getHonorDate()));
			} catch (ParseException e) {
				return Data.build(Errcode.FAILURE.ordinal(), false, "时间格式转换错误");
			}
			if(honorInfo.getAttachment()!=null && honorInfo.getAttachment().getAttachmentPath()!=null){
				honor.setCertificate(honorInfo.getAttachment().getAttachmentPath());
			}
			honorMapper.update(honor);
			return Data.build(Errcode.SUCCESS.ordinal(), true, "修改成功");
		}
		return Data.build(Errcode.FAILURE.ordinal(), false, "修改失败");
	}

	@Override
	public Data deleteHonorInfo(String id) {
		if(id!=null){
			honorMapper.delete(id);
			return Data.build(Errcode.SUCCESS.ordinal(), true, "刪除成功");
		}
		return Data.build(Errcode.FAILURE.ordinal(), false, "删除失败");
	}
	
	

}
