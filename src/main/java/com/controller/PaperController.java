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

import com.model.WorkHistory;
import com.pageModel.Data;
import com.pageModel.PaperInfo;
import com.pageModel.WorkHistoryInfo;
import com.service.PaperInfoService;
import com.service.WorkHistoryService;

/**
 * 代表性论著信息业务处理
 * 
 * @author cfl
 * 
 */

@Controller
@RequestMapping("paperController")
public class PaperController extends BaseController {
	private static final Logger logger = Logger.getLogger(PaperController.class);

	private PaperInfoService paperService;
	
	
	public PaperInfoService getPaperService() {
		return paperService;
	}

	@Autowired
	public void setPaperService(PaperInfoService paperService) {
		this.paperService = paperService;
	}



	@RequestMapping(params ="list")
	public String list(Integer flag,Model model,HttpSession session) {
		String declareId =(String)session.getAttribute("declareId");
		model.addAttribute("flag", flag);
		if(declareId !=null){
			List<PaperInfo> paperList = paperService.findAllById(declareId);
			model.addAttribute("paperList", paperList);
		}
		return "/declarationInfo/paperInfo/peperInfoList";
	}
	
	
	@RequestMapping(params = "insert", method = RequestMethod.POST)
	public ModelAndView insert(PaperInfo paperInfo,HttpSession session) {
		String declareId =(String)session.getAttribute("declareId");
		if(declareId!=null && declareId!=""){
			String baseId =(String)session.getAttribute("baseId");
			paperInfo.setDeclareId(declareId);
			paperInfo.setBaseId(baseId);
			Data data = paperService.addPaperInfo(paperInfo);
			if(data.isSuccess()){
				return ajaxDoneSuccess((String)data.getResult(),"paperController.do?list&flag="+paperInfo.getFlag());
			}
			return ajaxDoneError((String)data.getResult());
		}
		return ajaxDoneError("添加失败");
	}
	
	@RequestMapping(params ="add")
	public String add(Integer flag,Model model) {
		model.addAttribute("flag", flag);
		return "/declarationInfo/paperInfo/addPeperInfo";
	}
	
	@RequestMapping(params ="edit")
	public String edit(Integer flag,String paperId, Model model) {
		PaperInfo paperInfo = paperService.getPaperInfoById(paperId);
		model.addAttribute("paperInfo", paperInfo);
		model.addAttribute("flag", flag);
		return "/declarationInfo/paperInfo/editPeperInfo";
	}
	
	@RequestMapping(params = "update", method = RequestMethod.POST)
	public ModelAndView update(PaperInfo paperInfo) {
		Data data =paperService.updatePaperInfo(paperInfo);
		if(data.isSuccess()){
			return ajaxDoneSuccess((String)data.getResult(),"paperController.do?list&flag="+paperInfo.getFlag());
		}
		return ajaxDoneSuccess((String)data.getResult());
	}
	
	@RequestMapping(params = "delete", method = RequestMethod.POST)
	public ModelAndView delete(Integer flag,String paperId,PaperInfo paperInfo,Model model,HttpSession session) {
		Data data =paperService.deletePaperInfo(paperId);
		if(data.isSuccess()){
			return ajaxDoneSuccess((String)data.getResult(),"paperController.do?list&flag="+flag);
		}
		return ajaxDoneSuccess((String)data.getResult());
	}
	
}
