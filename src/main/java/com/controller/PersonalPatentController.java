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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.pageModel.AjaxDone;
import com.pageModel.Data;
import com.pageModel.PersonalPatentInfo;
import com.service.PersonalPatentService;


/**
 * 个人专利信息业务处理
 * 
 * @author cfl
 * 
 */

@Controller
@RequestMapping("patentController")
public class PersonalPatentController extends BaseController {
	private static final Logger logger = Logger.getLogger(PersonalPatentController.class);

	private PersonalPatentService patentService;
	
	public PersonalPatentService getPatentService() {
		return patentService;
	}
	@Autowired
	public void setPatentService(PersonalPatentService patentService) {
		this.patentService = patentService;
	}


	@RequestMapping(params ="list")
	public String list(Integer flag,Model model,HttpSession session) {
		String declareId =(String)session.getAttribute("declareId");
		model.addAttribute("flag", flag);
		if(declareId !=null){
			List<PersonalPatentInfo> patentList = patentService.findAllById(declareId);
			model.addAttribute("patentList", patentList);
		}
		return "/declarationInfo/personalPatent/patentInfoList";
	}
	
	
	@RequestMapping(params = "insert", method = RequestMethod.POST)
	public ModelAndView insert(PersonalPatentInfo patentInfo,HttpSession session) {
		String declareId =(String)session.getAttribute("declareId");
		if(declareId!=null && declareId!=""){
			String baseId =(String)session.getAttribute("baseId");
			patentInfo.setDeclareId(declareId);
			patentInfo.setBaseId(baseId);
			Data data = patentService.addPatentInfo(patentInfo);
			if(data.isSuccess()){
				return ajaxDoneSuccess((String)data.getResult(),"patentController.do?list&flag="+patentInfo.getFlag());
			}
			return ajaxDoneError((String)data.getResult());
		}
		return ajaxDoneError("添加失败");
	}
	
	
	@RequestMapping(params ="add")
	public String add(Integer flag,Model model) {
		model.addAttribute("flag", flag);
		return "/declarationInfo/personalPatent/addPatentInfo";
	}
	
	@RequestMapping(params ="edit")
	public String edit(Integer flag,String patentId, Model model) {
		PersonalPatentInfo patentInfo =patentService.getPatentInfoById(patentId);
		model.addAttribute("patentInfo", patentInfo);
		model.addAttribute("flag", flag);
		return "/declarationInfo/personalPatent/editPatentInfo";
	}
	
	@RequestMapping(params = "update", method = RequestMethod.POST)
	public ModelAndView update(PersonalPatentInfo patentInfo) {
		Data data =patentService.updatePatentInfo(patentInfo);
		if(data.isSuccess()){
			return ajaxDoneSuccess((String)data.getResult(),"patentController.do?list&flag="+patentInfo.getFlag());
		}
		return ajaxDoneSuccess((String)data.getResult());
	}
	
	@RequestMapping(params = "delete", method = RequestMethod.POST)
	public ModelAndView delete(Integer flag,String patentId,PersonalPatentInfo patentInfo,Model model,HttpSession session) {
		Data data =patentService.deletePatentInfo(patentId);
		if(data.isSuccess()){
			return ajaxDoneSuccess((String)data.getResult(),"patentController.do?list&flag="+flag);
		}
		return ajaxDoneSuccess((String)data.getResult());
	}
	
}
