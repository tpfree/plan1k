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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pageModel.AjaxDone;
import com.pageModel.Data;
import com.pageModel.Education;
import com.service.EducationService;

/**
 * 教育经历信息
 * 
 * @author cfl
 * 
 */

@Controller
@RequestMapping("eduInfoController")
public class EducationController extends BaseController {
	private static final Logger logger = Logger.getLogger(EducationController.class);

	private EducationService eduService;
	
	
	
	
	public EducationService getEduService() {
		return eduService;
	}

	@Autowired
	public void setEduService(EducationService eduService) {
		this.eduService = eduService;
	}



	@RequestMapping(params ="list")
	public String list(Education education,Model model,HttpSession session) {
		String declareId =(String)session.getAttribute("declareId");
		if(declareId !=null){
			List<Education> eduList = eduService.findEducationById(declareId);
			model.addAttribute("eduList", eduList);
		}
		return "/declarationInfo/eduInfoList";
	}
	@RequestMapping(params ="teamList")
	public String teamList(Education education,Model model,HttpSession session) {
		String declareId =(String)session.getAttribute("declareId");
		if(declareId !=null){
			List<Education> eduList = eduService.findEducationById(declareId);
			model.addAttribute("eduList", eduList);
		}
		return "/declarationInfo/teamDeclare/eduInfoList";
	}

	@RequestMapping(params = "insert", method = RequestMethod.POST)
	public ModelAndView insert(Education education,HttpSession session) {
		String declareId =(String)session.getAttribute("declareId");
		String baseId =(String)session.getAttribute("baseId");
		if(declareId!=null && declareId!=""){
			education.setDeclareId(declareId);
			education.setBaseId(baseId);
			Data data =eduService.addEducation(education);
			if(data.isSuccess()){
				if(education.getFlag()!=0 ){
					 return ajaxDoneSuccess((String)data.getResult(),"eduInfoController.do?teamList");
				}
				return ajaxDoneSuccess((String)data.getResult(),"eduInfoController.do?list");
			}
		}
		return ajaxDoneError("添加失败");
	}
	
	@RequestMapping(params ="add")
	public String add(Integer flag,Model model) {
		String forwardUrl="/declarationInfo/addEdu";
		if(flag!=0){
			forwardUrl="/declarationInfo/teamDeclare/addEdu";
		}
		return forwardUrl;
	}
	
	@RequestMapping(params ="edit")
	public String edit(Integer flag,String eduId, Model model) {
		Education education= eduService.getEducationById(eduId);
		model.addAttribute("edu", education);
		String forwardUrl="/declarationInfo/editEdu";
		if(flag!=0){
			forwardUrl="/declarationInfo/teamDeclare/editEdu";
		}
		return forwardUrl;
	}
	
	@RequestMapping(params = "update", method = RequestMethod.POST)
	public ModelAndView update(Education education) {
		Data data =eduService.updateEducation(education);
		if(data.isSuccess()){
			if(education.getFlag()!=0){
				return ajaxDoneSuccess((String)data.getResult(),"eduInfoController.do?teamList");
			}
			return ajaxDoneSuccess((String)data.getResult(),"eduInfoController.do?list");
		}
		return ajaxDoneError((String)data.getResult());
	}
	
	@RequestMapping(params = "delete", method = RequestMethod.POST)
	public ModelAndView delete(String eduId,Education education,Model model,HttpSession session) {
		Data data =eduService.deleteEducation(eduId);
		if(data.isSuccess()){
			if(education.getFlag()!=0){
				return ajaxDoneSuccess((String)data.getResult(),"eduInfoController.do?teamList");
			}
			return ajaxDoneSuccess((String)data.getResult(),"eduInfoController.do?list");
		}
		return ajaxDoneError((String)data.getResult());
	}
	
}
