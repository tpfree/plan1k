package com.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;









import com.dao.ResearchProMapper;
import com.model.ResearchProject;
import com.pageModel.Data;
import com.pageModel.Errcode;
import com.pageModel.ResearchProInfo;
import com.service.ResearchProjectService;



/**
 *
 * 
 * @author cfl
 * 
 */
@Service("researchService")
public class ResearchProjectServiceImpl extends BaseServiceImpl implements ResearchProjectService{
	
	@Autowired
	private ResearchProMapper researchMapper;
	
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	

	@Override
	public List<ResearchProInfo>  findAllById(Integer type,String id) {
		Map map = new HashMap();
		map.put("type", type);
		map.put("declareId", id);
		List<ResearchProject> reseachList=researchMapper.findAllById(map);
		List<ResearchProInfo> reseachInfoList = new ArrayList<ResearchProInfo>();
		if(reseachList!=null && !reseachList.isEmpty()){
			int count=reseachList.size();
			for(int i=0;i<count;i++){
				ResearchProInfo reseachInfo = new ResearchProInfo();
				ResearchProject reseach =reseachList.get(i);
				BeanUtils.copyProperties(reseach, reseachInfo);
				reseachInfo.setStartDate(sdf.format(reseach.getStartDate()));
				reseachInfo.setEndDate(sdf.format(reseach.getEndDate()));
				reseachInfoList.add(reseachInfo);
			}
			return reseachInfoList;
		}
		return null;
	}


	@Override
	public Data addResearchPro(ResearchProInfo researchInfo) {
		ResearchProject reseach = new ResearchProject(); 
		if(researchInfo!=null){
			BeanUtils.copyProperties(researchInfo, reseach);
			try {
				reseach.setStartDate(sdf.parse(researchInfo.getStartDate()));
				reseach.setEndDate(sdf.parse(researchInfo.getEndDate()));
			} catch (ParseException e) {
				
				return Data.build(Errcode.FAILURE.ordinal(), false, "时间格式转换错误");
			}
			reseach.setProId(UUID.randomUUID().toString().replaceAll("-", ""));
			researchMapper.insert(reseach);
			return Data.build(Errcode.SUCCESS.ordinal(), true, "添加成功");
		}else{
			return Data.build(Errcode.FAILURE.ordinal(), false, "添加失败");
		}
	}

	@Override
	public ResearchProInfo getResearchProById(String id) {
		ResearchProInfo researchInfo = new ResearchProInfo();
		ResearchProject reseach = researchMapper.load(id);
		BeanUtils.copyProperties(reseach, researchInfo);
		researchInfo.setStartDate(sdf.format(reseach.getStartDate()));
		researchInfo.setEndDate(sdf.format(reseach.getEndDate()));
		return researchInfo;
	}

	@Override
	public Data updateResearchPro(ResearchProInfo researchInfo) {
		ResearchProject researchPro = new ResearchProject();
		if(researchInfo!=null){
			BeanUtils.copyProperties(researchInfo, researchPro);
			try {
				researchPro.setStartDate(sdf.parse(researchInfo.getStartDate()));
				researchPro.setEndDate(sdf.parse(researchInfo.getEndDate()));
			} catch (ParseException e) {
				return Data.build(Errcode.FAILURE.ordinal(), false, "时间格式转换错误");
			}
			researchMapper.update(researchPro);
			return Data.build(Errcode.SUCCESS.ordinal(), true, "修改成功");
		}
		return Data.build(Errcode.FAILURE.ordinal(), false, "修改失败");
	}

	@Override
	public Data deleteResearchPro(String id) {
		if(id!=null){
			researchMapper.delete(id);
			return Data.build(Errcode.SUCCESS.ordinal(), true, "刪除成功");
		}
		return Data.build(Errcode.FAILURE.ordinal(), false, "删除失败");
	}
	
	

}
