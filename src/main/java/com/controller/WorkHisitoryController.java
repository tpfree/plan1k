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
import com.pageModel.WorkHistoryInfo;
import com.service.WorkHistoryService;

/**
 * 工作经历信息业务处理
 * 
 * @author cfl
 * 
 */

@Controller
@RequestMapping("workController")
public class WorkHisitoryController extends BaseController {
	private static final Logger logger = Logger.getLogger(WorkHisitoryController.class);

	private WorkHistoryService workService;
	
	
	public WorkHistoryService getWorkService() {
		return workService;
	}


	@Autowired
	public void setWorkService(WorkHistoryService workService) {
		this.workService = workService;
	}


	@RequestMapping(params ="list")
	public String list(Integer flag,Model model,HttpSession session) {
		String declareId =(String)session.getAttribute("declareId");
		model.addAttribute("flag", flag);
		if(declareId !=null){
			List<WorkHistoryInfo> workList = workService.findAllById(declareId);
			model.addAttribute("workList", workList);
		}
		return "/declarationInfo/workHistory/workInfoList";
	}
	
	
	@RequestMapping(params = "insert", method = RequestMethod.POST)
	public ModelAndView insert(WorkHistoryInfo workInfo,HttpSession session) {
		String declareId =(String)session.getAttribute("declareId");
		if(declareId!=null && declareId!=""){
			String baseId =(String)session.getAttribute("baseId");
			workInfo.setDeclareId(declareId);
			workInfo.setBaseId(baseId);
			Data data =workService.addWorkHistory(workInfo);
			if(data.isSuccess()){
				return ajaxDoneSuccess((String)data.getResult(),"workController.do?list&flag="+workInfo.getFlag());
			
			}
		}
		return ajaxDoneError("添加失败");
	}
	
	@RequestMapping(params ="add")
	public String add(Integer flag,Model model) {
		model.addAttribute("flag", flag);
		return "/declarationInfo/workHistory/addWorkInfo";
	}
	
	@RequestMapping(params ="edit")
	public String edit(Integer flag,String workId, Model model) {
		WorkHistoryInfo workInfo = workService.getWorkHistoryInfoById(workId);
		model.addAttribute("workInfo", workInfo);
		model.addAttribute("flag", flag);
		return "/declarationInfo/workHistory/editWorkInfo";
	}
	
	@RequestMapping(params = "update", method = RequestMethod.POST)
	public ModelAndView update(WorkHistoryInfo workInfo) {
		Data data =workService.updateWorkHistory(workInfo);
		if(data.isSuccess()){
			return ajaxDoneSuccess((String)data.getResult(),"workController.do?list&flag="+workInfo.getFlag());
		}
		return ajaxDoneError((String)data.getResult());
	}
	
	@RequestMapping(params = "delete", method = RequestMethod.POST)
	public ModelAndView delete(Integer flag,String workId,Model model,HttpSession session) {
		Data data =workService.deleteWorkHistory(workId);
		if(data.isSuccess()){
			return ajaxDoneSuccess((String)data.getResult(),"workController.do?list&flag="+flag);
		}
		return ajaxDoneError((String)data.getResult());
	}
	
}
