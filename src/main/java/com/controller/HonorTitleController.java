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
import com.service.HonorTitleService;


/**
 * 获得荣誉信息业务处理
 * 
 * @author cfl
 * 
 */

@Controller
@RequestMapping("honorController")
public class HonorTitleController extends BaseController {
	private static final Logger logger = Logger.getLogger(HonorTitleController.class);

	private HonorTitleService honorService;
	


	public HonorTitleService getHonorService() {
		return honorService;
	}

	@Autowired
	public void setHonorService(HonorTitleService honorService) {
		this.honorService = honorService;
	}



	@RequestMapping(params ="list")
	public String list(Integer flag,Model model,HttpSession session) {
		String declareId =(String)session.getAttribute("declareId");
		model.addAttribute("flag", flag);
		if(declareId !=null){
			List<HonorTitleInfo> honorList = honorService.findAllById(declareId);
			model.addAttribute("honorList", honorList);
		}
		return "/declarationInfo/honorTitle/honorInfoList";
	}
	
	
	@RequestMapping(params = "insert", method = RequestMethod.POST)
	public ModelAndView insert(HonorTitleInfo honorInfo,HttpSession session) {
		String declareId =(String)session.getAttribute("declareId");
		if(declareId!=null && declareId!=""){
			String baseId =(String)session.getAttribute("baseId");
			honorInfo.setDeclareId(declareId);
			honorInfo.setBaseId(baseId);
			Data data = honorService.addHonorInfo(honorInfo);
			if(data.isSuccess()){
				return ajaxDoneSuccess((String)data.getResult(),"honorController.do?list&flag="+honorInfo.getFlag());
			}
			return ajaxDoneError((String)data.getResult());
		}
		return ajaxDoneError("添加失败");
	}
	
	@RequestMapping(params ="add")
	public String add(Integer flag,Model model) {
		model.addAttribute("flag", flag);
		return "/declarationInfo/honorTitle/addHonorInfo";
	}
	
	@RequestMapping(params ="edit")
	public String edit(Integer flag,String honorId, Model model) {
		HonorTitleInfo honorInfo = honorService.getHonorInfoById(honorId);
		model.addAttribute("honorInfo", honorInfo);
		model.addAttribute("flag", flag);
		return "/declarationInfo/honorTitle/editHonorInfo";
	}
	
	@RequestMapping(params = "update", method = RequestMethod.POST)
	public ModelAndView update(HonorTitleInfo honorInfo) {
		Data data =honorService.updateHonorInfo(honorInfo);
		if(data.isSuccess()){
			return ajaxDoneSuccess((String)data.getResult(),"honorController.do?list&flag="+honorInfo.getFlag());
		}
		return ajaxDoneSuccess((String)data.getResult());
	}
	
	@RequestMapping(params = "delete", method = RequestMethod.POST)
	public ModelAndView delete(Integer flag,String honorId,HonorTitleInfo honorInfo,Model model,HttpSession session) {
		Data data =honorService.deleteHonorInfo(honorId);
		if(data.isSuccess()){
			return ajaxDoneSuccess((String)data.getResult(),"honorController.do?list&flag="+flag);
		}
		return ajaxDoneSuccess((String)data.getResult());
	}
	
}
