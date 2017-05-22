package com.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.WorkHistoryMapper;
import com.model.WorkHistory;
import com.pageModel.Data;
import com.pageModel.Errcode;
import com.pageModel.WorkHistoryInfo;
import com.service.WorkHistoryService;



/**
 *
 * 
 * @author cfl
 * 
 */
@Service("workService")
public class WorkHistoryServiceImpl extends BaseServiceImpl implements WorkHistoryService{
	
	@Autowired
	private WorkHistoryMapper workMapper;
	
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	

	@Override
	public Data addWorkHistory(WorkHistoryInfo workInfo){		
		WorkHistory work = new WorkHistory(); 
		if(workInfo!=null){
			BeanUtils.copyProperties(workInfo, work);
			try {
				work.setStartDate(sdf.parse(workInfo.getStartDate()));
				work.setEndDate(sdf.parse(workInfo.getEndDate()));
			} catch (ParseException e) {
				
				return Data.build(Errcode.FAILURE.ordinal(), false, "时间格式转换错误");
			}
			work.setHistoryId(UUID.randomUUID().toString().replaceAll("-", ""));
			workMapper.insert(work);
			return Data.build(Errcode.SUCCESS.ordinal(), true, "添加成功");
		}else{
			return Data.build(Errcode.FAILURE.ordinal(), false, "添加失败");
		}
	}

	@Override
	public List<WorkHistoryInfo>  findAllById(String id) {
		List<WorkHistory> workList=workMapper.findAllById(id);
		List<WorkHistoryInfo> workInfoList = new ArrayList<WorkHistoryInfo>();
		if(workList!=null && !workList.isEmpty()){
			int count=workList.size();
			for(int i=0;i<count;i++){
				WorkHistoryInfo workInfo = new WorkHistoryInfo();
				WorkHistory work =workList.get(i);
				BeanUtils.copyProperties(work, workInfo);
				workInfo.setStartDate(sdf.format(work.getStartDate()));
				workInfo.setEndDate(sdf.format(work.getEndDate()));
				workInfoList.add(workInfo);
			}
			return workInfoList;
		}
		return null;
	}

	@Override
	public WorkHistoryInfo getWorkHistoryInfoById(String id) {
		WorkHistoryInfo workInfo = new WorkHistoryInfo();
		WorkHistory work = workMapper.load(id);
		BeanUtils.copyProperties(work, workInfo);
		workInfo.setStartDate(sdf.format(work.getStartDate()));
		workInfo.setEndDate(sdf.format(work.getEndDate()));
		return workInfo;
	}


	@Override
	public Data updateWorkHistory(WorkHistoryInfo workInfo) {
		WorkHistory work = new WorkHistory();
		if(workInfo!=null){
			BeanUtils.copyProperties(workInfo, work);
			try {
				work.setStartDate(sdf.parse(workInfo.getStartDate()));
				work.setEndDate(sdf.parse(workInfo.getEndDate()));
			} catch (ParseException e) {
				return Data.build(Errcode.FAILURE.ordinal(), false, "时间格式转换错误");
			}
			workMapper.update(work);
			return Data.build(Errcode.SUCCESS.ordinal(), true, "修改成功");
		}
		return Data.build(Errcode.FAILURE.ordinal(), false, "修改失败");
	}

	@Override
	public Data deleteWorkHistory(String id) {
		if(id!=null){
			workMapper.delete(id);
			return Data.build(Errcode.SUCCESS.ordinal(), true, "刪除成功");
		}
		return Data.build(Errcode.FAILURE.ordinal(), false, "删除失败");
	}
	
	

}
