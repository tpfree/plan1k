package com.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;







import com.dao.TechRewardMapper;
import com.model.TechnologyReward;
import com.pageModel.Data;
import com.pageModel.Errcode;
import com.pageModel.TechRewardInfo;
import com.service.TechRewardService;



/**
 *
 * 
 * @author cfl
 * 
 */
@Service("rewardService")
public class TechRewardServiceImpl extends BaseServiceImpl implements TechRewardService{
	
	@Autowired
	private TechRewardMapper rewardMapper;
	
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	


	

	@Override
	public Data addReward(TechRewardInfo rewardInfo) {
		TechnologyReward reward = new TechnologyReward(); 
		if(rewardInfo!=null){
			BeanUtils.copyProperties(rewardInfo, reward);
			try {
				reward.setRewardDate(sdf.parse(rewardInfo.getRewardDate()));
			} catch (ParseException e) {
				
				return Data.build(Errcode.FAILURE.ordinal(), false, "时间格式转换错误");
			}
			reward.setRewardId(UUID.randomUUID().toString().replaceAll("-", ""));
			reward.setCertificate(rewardInfo.getAttachment().getAttachmentPath());
			rewardMapper.insert(reward);
			return Data.build(Errcode.SUCCESS.ordinal(), true, "添加成功");
		}else{
			return Data.build(Errcode.FAILURE.ordinal(), false, "添加失败");
		}
	}

	@Override
	public TechRewardInfo getRewardById(String id) {
		TechRewardInfo rewardInfo = new TechRewardInfo();
		TechnologyReward reward = rewardMapper.load(id);
		BeanUtils.copyProperties(reward, rewardInfo);
		rewardInfo.setRewardDate(sdf.format(reward.getRewardDate()));
		return rewardInfo;
	}

	@Override
	public Data updateReward(TechRewardInfo rewardInfo) {
		TechnologyReward reward = new TechnologyReward();
		if(rewardInfo!=null){
			BeanUtils.copyProperties(rewardInfo, reward);
			try {
				reward.setRewardDate(sdf.parse(rewardInfo.getRewardDate()));
			} catch (ParseException e) {
				return Data.build(Errcode.FAILURE.ordinal(), false, "时间格式转换错误");
			}
			if(rewardInfo.getAttachment()!=null && rewardInfo.getAttachment().getAttachmentPath()!=null){
				reward.setCertificate(rewardInfo.getAttachment().getAttachmentPath());
			}
			
			rewardMapper.update(reward);
			return Data.build(Errcode.SUCCESS.ordinal(), true, "修改成功");
		}
		return Data.build(Errcode.FAILURE.ordinal(), false, "修改失败");	
	}

	@Override
	public Data deleteReward(String id) {
		if(id!=null){
			rewardMapper.delete(id);
			return Data.build(Errcode.SUCCESS.ordinal(), true, "刪除成功");
		}
		return Data.build(Errcode.FAILURE.ordinal(), false, "删除失败");
	}

	@Override
	public List<TechRewardInfo>  findAllById(String id) {
		List<TechnologyReward> rewardList=rewardMapper.findAllById(id);
		List<TechRewardInfo> rewardInfoList = new ArrayList<TechRewardInfo>();
		if(rewardList!=null && !rewardList.isEmpty()){
			int count=rewardList.size();
			for(int i=0;i<count;i++){
				TechRewardInfo rewardInfo = new TechRewardInfo();
				TechnologyReward reward =rewardList.get(i);
				BeanUtils.copyProperties(reward, rewardInfo);
				rewardInfo.setRewardDate(sdf.format(reward.getRewardDate()));
				rewardInfoList.add(rewardInfo);
			}
			return rewardInfoList;
		}
		return null;
	}

	

}
