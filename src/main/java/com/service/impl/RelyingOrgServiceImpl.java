package com.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





import com.dao.RelyingOrgMapper;
import com.model.RelyingOrg;
import com.pageModel.Data;
import com.pageModel.Errcode;
import com.pageModel.RelyingOrgInfo;
import com.service.RelyingOrgervice;



/**
 *
 * 
 * @author cfl
 * 
 */
@Service("orgService")
public class RelyingOrgServiceImpl extends BaseServiceImpl implements RelyingOrgervice{
	
	@Autowired
	private RelyingOrgMapper orgMapper;
	
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	


	@Override
	public List<RelyingOrgInfo>  findAllById(String id) {
		List<RelyingOrg> orgList=orgMapper.findAllById(id);
		List<RelyingOrgInfo> orgInfoList = new ArrayList<RelyingOrgInfo>();
		if(orgList!=null && !orgList.isEmpty()){
			int count=orgList.size();
			for(int i=0;i<count;i++){
				RelyingOrgInfo orgInfo = new RelyingOrgInfo();
				RelyingOrg relyOrg =orgList.get(i);
				BeanUtils.copyProperties(relyOrg, orgInfo);
				orgInfo.setRatifyDate(sdf.format(relyOrg.getRatifyDate()));
				orgInfoList.add(orgInfo);
			}
			return orgInfoList;
		}
		return null;
	}



	@Override
	public Data addRelyingOrg(RelyingOrgInfo orgInfo) {
		RelyingOrg info = new RelyingOrg(); 
		if(orgInfo!=null){
			BeanUtils.copyProperties(orgInfo, info);
			try {
				info.setRatifyDate(sdf.parse(orgInfo.getRatifyDate()));
			} catch (ParseException e) {
				
				return Data.build(Errcode.FAILURE.ordinal(), false, "时间格式转换错误");
			}
			info.setOrgId(UUID.randomUUID().toString().replaceAll("-", ""));
			orgMapper.insert(info);
			return Data.build(Errcode.SUCCESS.ordinal(), true, "添加成功");
		}else{
			return Data.build(Errcode.FAILURE.ordinal(), false, "添加失败");
		}
	}



	@Override
	public RelyingOrgInfo getRelyingOrgById(String id) {
		RelyingOrgInfo orgInfo = new RelyingOrgInfo();
		RelyingOrg info =  orgMapper.load(id);
		BeanUtils.copyProperties(info, orgInfo);
		orgInfo.setRatifyDate(sdf.format(info.getRatifyDate()));
		return orgInfo;
	}


	@Override
	public Data updateRelyingOrg(RelyingOrgInfo orgInfo) {
		RelyingOrg info = new RelyingOrg();
		if(orgInfo!=null){
			BeanUtils.copyProperties(orgInfo, info);
			try {
				info.setRatifyDate(sdf.parse(orgInfo.getRatifyDate()));
			} catch (ParseException e) {
				return Data.build(Errcode.FAILURE.ordinal(), false, "时间格式转换错误");
			}
			orgMapper.update(info);
			return Data.build(Errcode.SUCCESS.ordinal(), true, "修改成功");
		}
		return Data.build(Errcode.FAILURE.ordinal(), false, "修改失败");
	}



	@Override
	public Data deleteRelyingOrg(String id) {
		if(id!=null){
			orgMapper.delete(id);
			return Data.build(Errcode.SUCCESS.ordinal(), true, "刪除成功");
		}
		return Data.build(Errcode.FAILURE.ordinal(), false, "删除失败");
	}





	

}
