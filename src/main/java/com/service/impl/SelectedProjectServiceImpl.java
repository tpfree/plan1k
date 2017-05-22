package com.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.SelectedProMapper;
import com.model.SelectedProject;
import com.pageModel.Data;
import com.pageModel.Errcode;
import com.pageModel.SelectedProInfo;
import com.service.SelectedProjectService;



/**
 *
 * 
 * @author cfl
 * 
 */
@Service("selectedProService")
public class SelectedProjectServiceImpl extends BaseServiceImpl implements SelectedProjectService{
	
	@Autowired
	private SelectedProMapper selectedProMapper;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	

	@Override
	public List<SelectedProInfo>  findAllById(String id) {
		List<SelectedProject> proList=selectedProMapper.findAllById(id);
		List<SelectedProInfo> proInfoList = new ArrayList<SelectedProInfo>();
		if(proList!=null && !proList.isEmpty()){
			int count=proList.size();
			for(int i=0;i<count;i++){
				SelectedProInfo proInfo = new SelectedProInfo();
				SelectedProject selectPro =proList.get(i);
				BeanUtils.copyProperties(selectPro, proInfo);
				proInfo.setSelectedTime(sdf.format(selectPro.getSelectedTime()));
				proInfoList.add(proInfo);
			}
			return proInfoList;
		}
		return null;
	}



	@Override
	public Data addSelectedInfo(SelectedProInfo proInfo) {
		SelectedProject selectedPro = new SelectedProject(); 
		if(proInfo!=null){
			BeanUtils.copyProperties(proInfo, selectedPro);
			selectedPro.setProId(UUID.randomUUID().toString().replaceAll("-", ""));
			try {
				selectedPro.setSelectedTime(sdf.parse(proInfo.getSelectedTime()));
			} catch (ParseException e) {
				return Data.build(Errcode.SUCCESS.ordinal(), true, "时间格式转换错误");
			}
			selectedProMapper.insert(selectedPro);
			return Data.build(Errcode.SUCCESS.ordinal(), true, "添加成功");
		}else{
			return Data.build(Errcode.FAILURE.ordinal(), false, "添加失败");
		}
	}

	@Override
	public SelectedProInfo getSelectedInfoById(String id) {
		SelectedProInfo selectProInfo = new SelectedProInfo();
		if(!"".equals(id)&&id!=null){
			SelectedProject selectPro = selectedProMapper.load(id);
			BeanUtils.copyProperties(selectPro, selectProInfo);
			selectProInfo.setSelectedTime(sdf.format(selectPro.getSelectedTime()));
		}
		return selectProInfo;
	}

	@Override
	public Data updateSelectedInfo(SelectedProInfo proInfo) {
		SelectedProject selectPro = new SelectedProject();
		if(proInfo!=null){
			BeanUtils.copyProperties(proInfo, selectPro);
			try {
				selectPro.setSelectedTime(sdf.parse(proInfo.getSelectedTime()));
			} catch (ParseException e) {
				return Data.build(Errcode.SUCCESS.ordinal(), true, "时间格式转换错误");
			}
			selectedProMapper.update(selectPro);
			return Data.build(Errcode.SUCCESS.ordinal(), true, "修改成功");
		}
		return Data.build(Errcode.FAILURE.ordinal(), false, "修改失败");
	}

	@Override
	public Data deleteSelectedInfo(String id) {
		if(id!=null){
			selectedProMapper.delete(id);
			return Data.build(Errcode.SUCCESS.ordinal(), true, "刪除成功");
		}
		return Data.build(Errcode.FAILURE.ordinal(), false, "删除失败");
	}
	
	

}
