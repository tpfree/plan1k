package com.controller;




import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.pageModel.AjaxDone;
import com.pageModel.Data;
import com.pageModel.TechRewardInfo;
import com.service.TechRewardService;

/**
 * 获得科技奖励信息业务处理
 * 
 * @author cfl
 * 
 */

@Controller
@RequestMapping("rewardController")
public class TechRewardController extends BaseController {
	private static final Logger logger = Logger.getLogger(TechRewardController.class);

	private TechRewardService rewardService;
	
	


	public TechRewardService getRewardService() {
		return rewardService;
	}

	@Autowired
	public void setRewardService(TechRewardService rewardService) {
		this.rewardService = rewardService;
	}



	@RequestMapping(params ="list")
	public String list(Integer flag,Model model,HttpSession session) {
		String declareId =(String)session.getAttribute("declareId");
		model.addAttribute("flag", flag);
		if(declareId !=null){
			List<TechRewardInfo> rewardList = rewardService.findAllById(declareId);
			model.addAttribute("rewardList", rewardList);
		}
		return "/declarationInfo/technologyReward/rewardInfoList";
	}

	@RequestMapping(params = "insert", method = RequestMethod.POST)
	public ModelAndView insert(TechRewardInfo rewardInfo,HttpSession session) {
		String declareId =(String)session.getAttribute("declareId");
		if(declareId!=null && declareId!=""){
			String baseId =(String)session.getAttribute("baseId");
			rewardInfo.setDeclareId(declareId);
			rewardInfo.setBaseId(baseId);
			Data data =rewardService.addReward(rewardInfo);
			if(data.isSuccess()){
				return ajaxDoneSuccess((String)data.getResult(),"rewardController.do?list&flag="+rewardInfo.getFlag());
			}
			return ajaxDoneError((String)data.getResult());
		}
		return ajaxDoneError("添加失败");
	}
	
	@RequestMapping(params ="add")
	public String add(Integer flag,Model model) {
		model.addAttribute("flag",flag);
		return "/declarationInfo/technologyReward/addRewardInfo";
	}
	
	@RequestMapping(params ="edit")
	public String edit(Integer flag,String rewardId, Model model) {
		TechRewardInfo rewardInfo = rewardService.getRewardById(rewardId);
		model.addAttribute("rewardInfo", rewardInfo);
		model.addAttribute("flag",flag);
		return "/declarationInfo/technologyReward/editRewardInfo";
	}
	
	@RequestMapping(params = "update", method = RequestMethod.POST)
	public ModelAndView update(TechRewardInfo rewardInfo) {
		Data data =rewardService.updateReward(rewardInfo);
		if(data.isSuccess()){
			return ajaxDoneSuccess((String)data.getResult(),"rewardController.do?list&flag="+rewardInfo.getFlag());
		}
		return ajaxDoneError((String)data.getResult());
	}
	
	@RequestMapping(params = "delete", method = RequestMethod.POST)
	public ModelAndView delete(Integer flag,String rewardId,TechRewardInfo rewardInfo,Model model,HttpSession session) {
		Data data =rewardService.deleteReward(rewardId);
		if(data.isSuccess()){
			return ajaxDoneSuccess((String)data.getResult(),"rewardController.do?list&flag="+flag);
		}
		return ajaxDoneError((String)data.getResult());
	}
	
}
