package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.EducationInfo;
import com.model.HonorTitle;
import com.pageModel.Data;
import com.pageModel.Declare;
import com.pageModel.DeclareBase;
import com.pageModel.Education;
import com.pageModel.HonorTitleInfo;
import com.pageModel.PaperInfo;
import com.pageModel.PersonalPatentInfo;
import com.pageModel.RelyingOrgInfo;
import com.pageModel.ResearchProInfo;
import com.pageModel.SelectedProInfo;
import com.pageModel.TeamMemberInfo;
import com.pageModel.TechRewardInfo;
import com.pageModel.Unit;
import com.pageModel.WorkHistoryInfo;
import com.service.DeclareBaseInfoService;
import com.service.DeclareService;
import com.service.EducationService;
import com.service.HonorTitleService;
import com.service.PaperInfoService;
import com.service.PersonalPatentService;
import com.service.RelyingOrgervice;
import com.service.ResearchProjectService;
import com.service.SelectedProjectService;
import com.service.TechRewardService;
import com.service.UserServiceI;
import com.service.WorkHistoryService;
import com.utils.JudgeString;

/**
 * 申报信息
 * 
 * @author cfl
 * 
 */
@Controller
@RequestMapping(value = "declarationInfo")
public class DeclareController extends BaseController {
	private static final Logger logger = Logger
			.getLogger(DeclareController.class);

	private DeclareService decService;
	private UserServiceI userService;
	private DeclareBaseInfoService baseinfoService;
	private EducationService eduService;
	private HonorTitleService honorService;
	private PaperInfoService paperService;
	private PersonalPatentService patentService;
	private RelyingOrgervice orgService;
	private ResearchProjectService researchService;
	private SelectedProjectService selectedService;
	private TechRewardService rewardService;
	private WorkHistoryService workService;

	private JudgeString jstr = new JudgeString();

	public UserServiceI getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}

	public DeclareService getDecService() {
		return decService;
	}

	@Autowired
	public void setDecService(DeclareService decService) {
		this.decService = decService;
	}

	@RequestMapping(params = "toPy")
	public String toDeclarePy(Model model) {
		List<Unit> unitList = userService.findAllUnit();
		model.addAttribute("unitList", unitList);
		return "/declarationInfo/startDeclarePy";
	}

	@RequestMapping(params = "toYj")
	public String toDeclareYj(Model model) {
		List<Unit> unitList = userService.findAllUnit();
		model.addAttribute("unitList", unitList);
		return "/declarationInfo/startDeclareYj";
	}

	@RequestMapping(params = "toTeam")
	public String toTeamDeclare(Model model) {
		List<Unit> unitList = userService.findAllUnit();
		model.addAttribute("unitList", unitList);
		return "/declarationInfo/teamDeclare";
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(params = "delcare", method = RequestMethod.POST)
	public ModelAndView delcare(Declare declare, Model model,
			HttpSession session) throws Exception {
		if (declare != null) {
			if (!jstr.StringIsNull(declare.getDeclareId())) {
				decService.deleteById(declare.getDeclareId());
			}
			String declareId = UUID.randomUUID().toString().replaceAll("-", "");
			declare.setDeclareId(declareId);
			declare.setUserName((String) session.getAttribute("userName"));
			try {
				decService.insert(declare);
				session.setAttribute("declareId", declareId);
				if (declare.getFlag() == 0) {
					model.addAttribute("type", declare.getPersonType());
					return ajaxDoneSuccess("数据录入成功，请继续进行个人资料填写",
							"declarationInfo/baseInfo.jsp");
				} else {
					return ajaxDoneSuccess("数据录入成功，请继续进行团队资料填写",
							"baseInfoController.do?baseList&flag=0");
				}

			} catch (Exception e) {
				return ajaxDoneError("数据录入失败", "");
			}
		} else {
			return ajaxDoneError("数据录入失败");
		}
	}

	/**
	 * 查询所有申报资料
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(params = "list")
	public String ListInfos(Model model, HttpSession session) {
		String userName = (String) session.getAttribute("userName");
		if (userName != null && !"".equals(userName)) {
			List<Declare> declareList = decService.findAllInfoList(userName);
			List<Unit> unitList = userService.findAllUnit();
			model.addAttribute("unitList", unitList);
			model.addAttribute("declareList", declareList);
		}
		return "/declarationInfo/declareList";
	}

	/**
	 * 根据id 批量删除申报资料
	 * 
	 * @param ids
	 * @param infoBase
	 * @param session
	 * @return
	 */
	@RequestMapping(params = "deleteIds", method = RequestMethod.POST)
	public ModelAndView deleteIds(String[] ids, DeclareBase infoBase,
			HttpSession session) {
		Data data = decService.deleteByIds(ids);
		if (data.isSuccess()) {
			return ajaxDoneSuccess((String) data.getResult(),
					"declarationInfo.do?list");
		}
		return ajaxDoneError((String) data.getResult());
	}

	/**
	 * 根据id 单条删除申报资料
	 * 
	 * @param id
	 * @param infoBase
	 * @param session
	 * @return
	 */
	@RequestMapping(params = "delete", method = RequestMethod.POST)
	public ModelAndView delete(String id, DeclareBase infoBase,
			HttpSession session) {
		Data data = decService.deleteById(id);
		if (data.isSuccess()) {
			return ajaxDoneSuccess((String) data.getResult(),
					"declarationInfo.do?list");
		}
		return ajaxDoneError((String) data.getResult());
	}

	@RequestMapping(params = "addmembers", method = RequestMethod.POST)
	public ModelAndView addmembers(TeamMemberInfo memberInfo, Declare declare,
			HttpSession session) {
		String declareId = (String) session.getAttribute("declareId");
		// String declareId = "111test";
		if (declareId != null) {
			Data data = decService.addOtherMembers(memberInfo, declare,
					declareId);
			if (data.isSuccess()) {
				return ajaxDoneSuccess((String) data.getResult(),
						"selectedController.do?list&flag=1");
			}
			return ajaxDoneError((String) data.getResult());
		}
		return ajaxDoneError("数据提交失败");
	}

	@RequestMapping(params = "getInfo")
	public String getDeclareInfo(Model model, HttpSession session) {
		String declareId = (String) session.getAttribute("declareId");
		String forward = "/declarationInfo/startDeclarePy";
		if (declareId != null) {
			Declare declare = decService.findDeclareInfos(declareId);
			List<Unit> unitList = userService.findAllUnit();
			model.addAttribute("unitList", unitList);
			model.addAttribute("declare", declare);
			if (declare.getFlag() == 1) {
				forward = "/declarationInfo/teamDeclare";
			} else if (declare.getPersonType() != 0) {
				forward = "/declarationInfo/startDeclareYj";
			}
		}
		return forward;
	}

	@RequestMapping(params = "getmembers")
	public String getMembers(HttpSession session, Model model) {
		String declareId = (String) session.getAttribute("declareId");
		if (declareId != null) {
			TeamMemberInfo membersInfo = decService.getMembersInfo(declareId);
			List<DeclareBase> listInfo = decService.findMembersById(declareId);
			model.addAttribute("membersInfo", membersInfo);
			model.addAttribute("listInfo", listInfo);
		}
		return "/declarationInfo/teamDeclare/memberInfos";
	}

	public String findAlldeclareInfos(String declareId, Integer flag, Model model) {
		String forwardUrl="";
		if (jstr.StringIsNull(declareId)) {
			List<DeclareBase> baseList = baseinfoService.findBaseInfoById(declareId);
			List<Education> eduList = eduService.findEducationById(declareId);
			List<WorkHistoryInfo> workList = workService.findAllById(declareId);
			List<ResearchProInfo> researchList = researchService.findAllById(2, declareId);
			List<HonorTitleInfo> honorList = honorService.findAllById(declareId);
			List<PaperInfo> paperList = paperService.findAllById(declareId);
			List<PersonalPatentInfo> patentList = patentService.findAllById(declareId);
			List<SelectedProInfo> selectedList = selectedService.findAllById(declareId);
			List<TechRewardInfo> rewardList = rewardService.findAllById(declareId);
			
			model.addAttribute("researchList", researchList);
			model.addAttribute("honorList", honorList);
			model.addAttribute("paperList", paperList);
			model.addAttribute("patentList", patentList);
			model.addAttribute("selectedList", selectedList);
			model.addAttribute("rewardList", rewardList);
			if (flag == 0) {
				DeclareBase baseInfo = baseList.get(0);
				model.addAttribute("baseInfo", baseInfo);
				model.addAttribute("eduList", eduList);
				model.addAttribute("workList", workList);
				forwardUrl="/declarationInfo/detailsAndPreview";
			} else {
				List<ResearchProInfo> kyxmList =researchService.findAllById(1, declareId);
				List<RelyingOrgInfo> orgList = orgService.findAllById(declareId);
				model.addAttribute("kyxmList", kyxmList);
				model.addAttribute("orgList", orgList);
				/**
				 * 团队人员基本信息
				 */
				DeclareBase chargePersonInfo = new DeclareBase();
				List<DeclareBase> coreMemberList = new ArrayList<DeclareBase>();
				List<DeclareBase> otherMemberList = new ArrayList<DeclareBase>();
				/**
				 * 团队人员教育经历
				 */
				List<Education> chargeEduList = new ArrayList<Education>();
				List<Education> coreEduList = new ArrayList<Education>();
				/**
				 * 团队人员工作经历
				 */
				List<WorkHistoryInfo> chargeWorkList = new ArrayList<WorkHistoryInfo>();
				List<WorkHistoryInfo> coreWorkList = new ArrayList<WorkHistoryInfo>();
				
				for (DeclareBase db : baseList) {
					if (db.getFlag() == 3) {
						otherMemberList.add(db);
					} else {
						if (db.getFlag() == 2) {
							coreMemberList.add(db);
						}
						if (db.getFlag() == 1) {
							chargePersonInfo = db;
						}
						for (Education education : eduList) {
							if (db.getBase_id() == education.getBaseId()) {
								chargeEduList.add(education);
							}else{
								coreEduList.add(education);
							}
						}
						for (WorkHistoryInfo workInfo : workList) {
							if (db.getBase_id() == workInfo.getBaseId()) {
								chargeWorkList.add(workInfo);
							}else{
								coreWorkList.add(workInfo);
							}
						}
					}
				}
				/**
				 * 团队负责人基本信息及教育工作经历
				 */
				model.addAttribute("chargePersonInfo", chargePersonInfo);
				model.addAttribute("chargeEduList", chargeEduList);
				model.addAttribute("chargeWorkList", chargeWorkList);
				/**
				 * 团队核心人员基本信息及教育工作经历
				 */
				model.addAttribute("coreMemberList", coreMemberList);
				model.addAttribute("coreWorkList", chargeEduList);
				model.addAttribute("coreEduList", chargeWorkList);
				/**
				 * 团队其他成员
				 */
				model.addAttribute("otherMemberList", otherMemberList);
				forwardUrl="/declarationInfo/teamDeclare/DetailsAndPreview";
			}

		}
		return forwardUrl;
	}
}
