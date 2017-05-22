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
import com.pageModel.SelectedProInfo;
import com.service.SelectedProjectService;

/**
 * 入选计划或工程信息业务处理
 * 
 * @author cfl
 * 
 */

@Controller
@RequestMapping("selectedController")
public class SelectedProController extends BaseController {
	private static final Logger logger = Logger
			.getLogger(SelectedProController.class);

	private SelectedProjectService selectedProService;

	public SelectedProjectService getSelectedProService() {
		return selectedProService;
	}

	@Autowired
	public void setSelectedProService(SelectedProjectService selectedProService) {
		this.selectedProService = selectedProService;
	}

	@RequestMapping(params = "list")
	public String list(Integer flag, Model model, HttpSession session) {
		String declareId = (String) session.getAttribute("declareId");

		if (declareId != null) {
			List<SelectedProInfo> selectedProList = selectedProService
					.findAllById(declareId);
			model.addAttribute("selectedProList", selectedProList);
		}
		model.addAttribute("flag", flag);
		return "/declarationInfo/selectedProject/selectedProInfoList";
	}

	@RequestMapping(params = "insert", method = RequestMethod.POST)
	public ModelAndView insert(SelectedProInfo selectPro, HttpSession session) {
		String declareId = (String) session.getAttribute("declareId");
		if (declareId != null && declareId != "") {
			String baseId = (String) session.getAttribute("baseId");
			if (baseId != null) {
				selectPro.setDeclareId(declareId);
				selectPro.setBaseId(baseId);
				Data data = selectedProService.addSelectedInfo(selectPro);
				if (data.isSuccess()) {
					return ajaxDoneSuccess(
							(String) data.getResult(),
							"selectedController.do?list&flag="
									+ selectPro.getFlag());
				}

				return ajaxDoneError((String) data.getResult());
			}
		}
		return ajaxDoneError("添加失败");
	}

	@RequestMapping(params = "add")
	public String add(Integer flag, Model model) {
		model.addAttribute("flag", flag);
		return "/declarationInfo/selectedProject/addProjectInfo";
	}

	@RequestMapping(params = "edit")
	public String edit(Integer flag, String proId, Model model) {
		SelectedProInfo selectPro = selectedProService
				.getSelectedInfoById(proId);
		model.addAttribute("selectPro", selectPro);
		model.addAttribute("flag", flag);
		return "/declarationInfo/selectedProject/editProjectInfo";
	}

	@RequestMapping(params = "update", method = RequestMethod.POST)
	public ModelAndView update(SelectedProInfo selectPro) {
		Data data = selectedProService.updateSelectedInfo(selectPro);
		if (data.isSuccess()) {
			return ajaxDoneSuccess((String) data.getResult(),
					"selectedController.do?list&flag=" + selectPro.getFlag());
		}
		return ajaxDoneSuccess((String) data.getResult());
	}

	@RequestMapping(params = "delete", method = RequestMethod.POST)
	public ModelAndView delete(Integer flag, String proId, Model model,
			HttpSession session) {
		Data data = selectedProService.deleteSelectedInfo(proId);
		if (data.isSuccess()) {
			return ajaxDoneSuccess((String) data.getResult(),
					"selectedController.do?list&flag=" + flag);
		}
		return ajaxDoneSuccess((String) data.getResult());
	}

}
