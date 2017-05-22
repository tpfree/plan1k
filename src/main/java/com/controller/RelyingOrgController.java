package com.controller;




import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pageModel.Data;
import com.pageModel.HonorTitleInfo;
import com.pageModel.RelyingOrgInfo;
import com.service.HonorTitleService;
import com.service.RelyingOrgervice;


/**
 * 团队依托的机构信息业务处理
 * 
 * @author cfl
 * 
 */

@Controller
@RequestMapping("orgController")
public class RelyingOrgController extends BaseController {
	private static final Logger logger = Logger.getLogger(RelyingOrgController.class);

	private RelyingOrgervice orgService;
	


	public RelyingOrgervice getOrgService() {
		return orgService;
	}


	@Autowired
	public void setOrgService(RelyingOrgervice orgService) {
		this.orgService = orgService;
	}




	@RequestMapping(params ="list")
	public String list(Model model,HttpSession session) {
		String declareId =(String)session.getAttribute("declareId");
		if(declareId !=null){
			List<RelyingOrgInfo> orgList = orgService.findAllById(declareId);
			model.addAttribute("orgList", orgList);
		}
		return "/declarationInfo/teamRelyingOrg/orgList";
	}
	
	
	@RequestMapping(params = "insert", method = RequestMethod.POST)
	public ModelAndView insert(RelyingOrgInfo orgInfo,HttpSession session) {
		String declareId =(String)session.getAttribute("declareId");
		if(declareId!=null && declareId!=""){
			orgInfo.setDeclareId(declareId);
			Data data = orgService.addRelyingOrg(orgInfo);
			if(data.isSuccess()){
				return ajaxDoneSuccess((String)data.getResult(),"orgController.do?list");
			}
			return ajaxDoneError((String)data.getResult());
		}
		return ajaxDoneError("添加失败");
	}
	
	@RequestMapping(params ="add")
	public String add(Model model) {
		return "/declarationInfo/teamRelyingOrg/addOrgInfo";
	}
	
	@RequestMapping(params ="edit")
	public String edit(String orgId, Model model) {
		RelyingOrgInfo orgInfo = orgService.getRelyingOrgById(orgId);
		model.addAttribute("orgInfo", orgInfo);
		return "/declarationInfo/teamRelyingOrg/editOrgInfo";
	}
	
	@RequestMapping(params = "update", method = RequestMethod.POST)
	public ModelAndView update(RelyingOrgInfo orgInfo) {
		Data data =orgService.updateRelyingOrg(orgInfo);
		if(data.isSuccess()){
			return ajaxDoneSuccess((String)data.getResult(),"orgController.do?list");
		}
		return ajaxDoneSuccess((String)data.getResult());
	}
	
	@RequestMapping(params = "delete", method = RequestMethod.POST)
	public ModelAndView delete(String orgId,Model model,HttpSession session) {
		Data data =orgService.deleteRelyingOrg(orgId);
		if(data.isSuccess()){
			return ajaxDoneSuccess((String)data.getResult(),"orgController.do?list");
		}
		return ajaxDoneSuccess((String)data.getResult());
	}
	
}
