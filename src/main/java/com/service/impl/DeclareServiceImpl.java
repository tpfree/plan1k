package com.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BaseInfoMapper;
import com.dao.DeclareMapper;
import com.dao.EducationMapper;
import com.dao.HonorTitleMapper;
import com.dao.PaperInfoMapper;
import com.dao.PersonalPatentMapper;
import com.dao.RelyingOrgMapper;
import com.dao.ResearchProMapper;
import com.dao.SelectedProMapper;
import com.dao.TeamMemberMapper;
import com.dao.TechRewardMapper;
import com.dao.WorkHistoryMapper;
import com.model.DeclareBaseInfo;
import com.model.DeclareInfo;
import com.model.EducationInfo;
import com.model.HonorTitle;
import com.model.PaperInfomation;
import com.model.PersonalPatent;
import com.model.ResearchProject;
import com.model.SelectedProject;
import com.model.TeamMember;
import com.model.TechnologyReward;
import com.model.WorkHistory;
import com.pageModel.Data;
import com.pageModel.Declare;
import com.pageModel.DeclareBase;
import com.pageModel.Errcode;
import com.pageModel.HonorTitleInfo;
import com.pageModel.TeamMemberInfo;
import com.pageModel.User;
import com.service.BaseServiceI;
import com.service.DeclareService;

/**
 *
 * 
 * @author cfl
 * 
 */
@Service("decService")
public class DeclareServiceImpl extends BaseServiceImpl implements
		DeclareService {

	@Autowired
	private DeclareMapper declareMapper;
	@Autowired
	private BaseInfoMapper baseInfoMapper;
	@Autowired
	private TeamMemberMapper membersMapper;
	@Autowired
	private EducationMapper educationMapper;
	@Autowired
	private HonorTitleMapper honorMapper;
	@Autowired
	private PaperInfoMapper paperMapper;
	@Autowired
	private PersonalPatentMapper patentMapper;
	@Autowired
	private ResearchProMapper researchMapper;
	@Autowired
	private SelectedProMapper selectedMapper;
	@Autowired
	private TechRewardMapper rewardMapper;
	@Autowired
	private WorkHistoryMapper workMapper;
	@Autowired
	private RelyingOrgMapper orgMapper;
	
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public int insert(Declare declare) {
		DeclareInfo declareInfo = new DeclareInfo();
		if (declare != null) {
			BeanUtils.copyProperties(declare, declareInfo);
			declareInfo.setIfvalid(0);
			declareInfo.setAuditStatus(0);
			declareInfo.setDeclare_date(new Date());
			int flag = declareMapper.insert(declareInfo);
			return flag;
		} else {
			return 0;
		}
	}

	@Override
	public Data updateIfValid(String id) {
		if (id != null && !"".equals(id)) {
			try {
				declareMapper.updateIfValid(id);
				return Data.build(Errcode.SUCCESS.ordinal(), true, "数据状态更新成功");
			} catch (Exception e) {
				return Data.build(Errcode.FAILURE.ordinal(), true, "数据状态更新失败");
			}

		}
		return Data.build(Errcode.FAILURE.ordinal(), true, "参数不能为空");
	}

	@Override
	public Data deleteById(String id) {
		if (id != null && !"".equals(id)) {
			try {
				declareMapper.deleteDeclareInfoById(id);
				return Data.build(Errcode.SUCCESS.ordinal(), true, "数据删除成功");
			} catch (Exception e) {
				return Data.build(Errcode.FAILURE.ordinal(), true, "数据删除失败");
			}

		}
		return Data.build(Errcode.FAILURE.ordinal(), true, "参数不能为空");
	}

	@Override
	public Data deleteByIds(String[] ids) {
		if (ids != null && ids.length > 0) {
			try {
				int count = declareMapper.deleteDeclareInfoByIds(ids);
				return Data.build(Errcode.SUCCESS.ordinal(), true,
						"数据删除成功,共删除【" + count + " 】条记录");
			} catch (Exception e) {
				return Data.build(Errcode.FAILURE.ordinal(), true, "数据删除失败");
			}

		}
		return Data.build(Errcode.FAILURE.ordinal(), true, "参数不能为空");
	}

	@Override
	public List<Declare> findAllInfoList(String userName) {
		if (userName != null && !"".equals(userName)) {
			List<DeclareInfo> infoList = declareMapper
					.findAllDeclareInfos(userName);
			List<Declare> declareList = new ArrayList<Declare>();
			int size = infoList.size();
			if (infoList != null && size > 0) {
				for (int i = 0; i < size; i++) {
					DeclareInfo info = infoList.get(i);
					Declare declare = new Declare();
					BeanUtils.copyProperties(info, declare);
					declare.setDeclare_date(info.getDeclare_date());
					declare.setAuditDate(info.getAuditDate());
					declareList.add(declare);
				}
				return declareList;
			}
		}
		return null;
	}

	@Override
	public Data addOtherMembers(TeamMemberInfo memberInfo, Declare declare,
			String declareId) {
		TeamMember members = new TeamMember();
		if (memberInfo != null) {
			BeanUtils.copyProperties(memberInfo, members);
			members.setMemberId(UUID.randomUUID().toString()
					.replaceAll("-", ""));
			members.setDeclareId(declareId);
		}
		List<DeclareBaseInfo> baseList = new ArrayList<DeclareBaseInfo>();
		if (declare != null && declare.getBaseInfoList().size() > 0) {
			List<DeclareBase> infoList = declare.getBaseInfoList();
			if (!infoList.get(0).getName_zh().isEmpty()) {
				for (DeclareBase baseInfo : infoList) {
					DeclareBaseInfo infoBase = new DeclareBaseInfo();
					BeanUtils.copyProperties(baseInfo, infoBase);
					try {
						infoBase.setBirthday(sdf.parse(baseInfo.getBirthday()));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					infoBase.setBase_id(UUID.randomUUID().toString()
							.replaceAll("-", ""));
					infoBase.setDeclare_id(declareId);
					infoBase.setFlag(3);
					baseList.add(infoBase);
				}
			}
		}
		try {
			if (members != null) {
				membersMapper.insert(members);
			}
			if (baseList.size() > 0) {
				baseInfoMapper.insertBatch(baseList);
			}
			return Data.build(Errcode.SUCCESS.ordinal(), true, "数据提交成功");
		} catch (Exception e) {
			return Data.build(Errcode.FAILURE.ordinal(), true, "数据提交失败");
		}

	}

	@Override
	public Declare findDeclareInfos(String id) {
		if (id != null && !"".equals(id)) {
			DeclareInfo info = declareMapper.findDeclareInfos(id);
			Declare declare = new Declare();
			BeanUtils.copyProperties(info, declare);
			return declare;
		}
		return null;
	}

	@Override
	public List<DeclareBase> findMembersById(String id) {
		List<DeclareBaseInfo> basesList = baseInfoMapper
				.getTeamOtherMembersById(id);
		List<DeclareBase> infoList = new ArrayList<DeclareBase>();
		if (basesList != null) {
			for (DeclareBaseInfo baseInfo : basesList) {
				DeclareBase declareBase = new DeclareBase();
				BeanUtils.copyProperties(baseInfo, declareBase);
				if (baseInfo.getBirthday() != null) {
					declareBase.setBirthday(sdf.format(baseInfo.getBirthday()));
				}
				infoList.add(declareBase);
			}
		}
		return infoList;
	}

	@Override
	public TeamMemberInfo getMembersInfo(String id) {
		TeamMemberInfo memberInfo = new TeamMemberInfo();
		try {
			TeamMember members = membersMapper.load(id);
			BeanUtils.copyProperties(members, memberInfo);
		} catch (Exception e) {
		}
		return memberInfo;
	}

	@Override
	public Declare getAllDeclareInfos(String declareId,Integer flag) {
		Declare declareInfo = new Declare();
		if(flag==0){
			DeclareBaseInfo baseInfo = baseInfoMapper.getBaseInfoById(declareId);
			if(baseInfo!=null){
				DeclareBase declareBase = new DeclareBase();
				BeanUtils.copyProperties(baseInfo, declareBase);
				declareBase.setBirthday(sdf.format(baseInfo.getBirthday()));
				declareInfo.setBaseInfo(declareBase);
			}
		}
		if(flag==1){
			List<DeclareBaseInfo> baseInfoList = baseInfoMapper.findBaseInfoById(declareId);
			if(baseInfoList!=null && baseInfoList.size()>0){
				for(DeclareBaseInfo baseInfo:baseInfoList){
					
				}
			}
		}
		List<EducationInfo> eduList =educationMapper.findAllEductionById(declareId);
		List<HonorTitle> honorList = honorMapper.findAllById(declareId); 
		List<PaperInfomation> peperList = paperMapper.findAllById(declareId);
		List<PersonalPatent> patentList = patentMapper.findAllById(declareId);
		List<SelectedProject> selectedList = selectedMapper.findAllById(declareId);
		List<TechnologyReward> rewardList = rewardMapper.findAllById(declareId);
		List<WorkHistory> workList = workMapper.findAllById(declareId);
		
		List<ResearchProject> researchList = researchMapper.findAllInfosById(declareId);
		
		
		return null;
	}

}
