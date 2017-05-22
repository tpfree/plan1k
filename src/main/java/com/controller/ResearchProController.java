package com.controller;




import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pageModel.Data;
import com.pageModel.ResearchProInfo;
import com.service.ResearchProjectService;



/**
 * 代表性研究项目业务处理
 * 
 * @author cfl
 * 
 */

@Controller
@RequestMapping("researchController")
public class ResearchProController extends BaseController {
	private static final Logger logger = Logger.getLogger(ResearchProController.class);

	private ResearchProjectService researchService;

	
	public ResearchProjectService getResearchService() {
		return researchService;
	}

	@Autowired
	public void setResearchService(ResearchProjectService researchService) {
		this.researchService = researchService;
	}



	@RequestMapping(params ="list")
	public String list(Integer flag,Integer type,Model model,HttpSession session) {
		String declareId =(String)session.getAttribute("declareId");
		model.addAttribute("flag", flag);
		model.addAttribute("type", type);
		if(declareId !=null){
			List<ResearchProInfo> researchList = researchService.findAllById(type,declareId);
			model.addAttribute("researchList", researchList);
		}
		return "/declarationInfo/researchProject/researchProInfoList";
	}
	
	
	@RequestMapping(params = "insert", method = RequestMethod.POST)
	public ModelAndView insert(ResearchProInfo researchInfo,HttpSession session) {
		String declareId =(String)session.getAttribute("declareId");
		if(declareId!=null && declareId!=""){
			String baseId =(String)session.getAttribute("baseId");
			researchInfo.setDeclareId(declareId);
			researchInfo.setBaseId(baseId);
			Data data = researchService.addResearchPro(researchInfo);
			if(data.isSuccess()){
				return ajaxDoneSuccess((String)data.getResult(),"researchController.do?list&flag="+researchInfo.getFlag()+"&type="+researchInfo.getType());
			}
			return ajaxDoneError((String)data.getResult());
		}
		return ajaxDoneError("添加失败");
	}
	
	@RequestMapping(params ="add")
	public String add(Integer flag,Integer type,Model model) {
		model.addAttribute("flag", flag);
		model.addAttribute("type", type);
		return "/declarationInfo/researchProject/addResearchProInfo";
	}
	
	@RequestMapping(params ="edit")
	public String edit(Integer flag,Integer type,String resId, Model model) {
		ResearchProInfo researchInfo = researchService.getResearchProById(resId);
		model.addAttribute("researchInfo", researchInfo);
		model.addAttribute("flag",flag);
		model.addAttribute("type", type);
		return "/declarationInfo/researchProject/editResearchProInfo";
	}
	
	@RequestMapping(params = "update", method = RequestMethod.POST)
	public ModelAndView update(ResearchProInfo researchInfo) {
		Data data =researchService.updateResearchPro(researchInfo);
		if(data.isSuccess()){
			return ajaxDoneSuccess((String)data.getResult(),"researchController.do?list&flag="+researchInfo.getFlag()+"&type="+researchInfo.getType());
		}
		return ajaxDoneSuccess((String)data.getResult());
	}
	
	@RequestMapping(params = "delete", method = RequestMethod.POST)
	public ModelAndView delete(Integer flag,Integer type,String resId,Model model,HttpSession session) {
		Data data =researchService.deleteResearchPro(resId);
		if(data.isSuccess()){
			return ajaxDoneSuccess((String)data.getResult(),"researchController.do?list&flag="+flag+"&type="+type);
		}
		return ajaxDoneSuccess((String)data.getResult());
	}
	
}
