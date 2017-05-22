package com.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
import com.pageModel.Declare;
import com.pageModel.DeclareBase;
import com.pageModel.Education;
import com.pageModel.Unit;
import com.service.DeclareBaseInfoService;
import com.service.DeclareService;
import com.utils.JudgeString;

@Controller
@RequestMapping("baseInfoController")
public class DeclareBaseController extends BaseController {

	private DeclareBaseInfoService baseInfoService;
	private DeclareService  decService;

	public DeclareService getDecService() {
		return decService;
	}
	@Autowired
	public void setDecService(DeclareService decService) {
		this.decService = decService;
	}

	public DeclareBaseInfoService getBaseInfoService() {
		return baseInfoService;
	}

	@Autowired
	public void setBaseInfoService(DeclareBaseInfoService baseInfoService) {
		this.baseInfoService = baseInfoService;
	}
	
	private JudgeString jstr = new JudgeString();

	/**
	 * 个人资料录入
	 * @return
	 */
	@RequestMapping(params = "insert", method = RequestMethod.POST)
	public ModelAndView insertBaseInfo(DeclareBase infoBase,HttpSession session) throws Exception {

		if (infoBase != null) {
			String baseId=UUID.randomUUID().toString().replaceAll("-", "");
			infoBase.setBase_id(baseId);
			String declareId =(String)session.getAttribute("declareId");
			infoBase.setDeclare_id(declareId);
			Data data = baseInfoService.insert(infoBase);
			int  flag=infoBase.getFlag();
			if (data.isSuccess()) {
				
				if(flag==0){
					session.setAttribute("baseId", baseId);
					return ajaxDone(200, "个人资料录入成功,请继续填写个人教育经历", "eduInfoController.do?list");
				}else{
					if(flag==1){
						session.setAttribute("baseId", baseId);
					}
					return ajaxDone(200, "个人资料录入成功,请继续填写个人教育经历", "eduInfoController.do?teamList");
				}
			}else{
				return ajaxDone(300, "个人资料录入失败", "");
			}
		} else {
			return ajaxDone(300, "个人资料录入失败", "");
		}
	}
	
	/**
	 * 上传个人照片
	 * @param file
	 * @param request
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(params = "uploadFile", method = RequestMethod.POST)
	@ResponseBody
	public AjaxDone uploadFile(@RequestParam("file") CommonsMultipartFile file,
			HttpServletRequest request) throws Exception {
		AjaxDone ajaxDone = new AjaxDone();
		String fileName = UUID.randomUUID().toString();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(date);
		String tempPath = request.getSession().getServletContext()
				.getRealPath("/upload/" + dateStr);
		File file1 = new File(tempPath);
		if (!file1.isDirectory()) {
			file1.mkdirs();
		}

		String fileType = file.getOriginalFilename().contains(".") ? file
				.getOriginalFilename().substring(
						file.getOriginalFilename().lastIndexOf(".")) : "";
		String imgPath = tempPath + "/" + fileName + fileType;
		FileCopyUtils.copy(file.getBytes(), new File(imgPath));
	
		ajaxDone.setAttachmentPath(imgPath);
		ajaxDone.setAttachmentSize("1000");
		ajaxDone.setFileName(file.getOriginalFilename());
		ajaxDone.setId("1");

		return ajaxDone;
	}
	
	/**
	 * 更新重要学术兼职情况、成果转化、个人工作业绩简介信息入库
	 * @param infoBase
	 * @param session
	 * @return
	 */
	@RequestMapping(params = "toUpdateJy", method = RequestMethod.POST)
	public ModelAndView updateMemberYj(DeclareBase infoBase,HttpSession session,Model model) {
		String baseId =(String)session.getAttribute("baseId");
		if(!"".equals(baseId) && baseId!=null){
			infoBase.setBase_id(baseId);
			Data data =baseInfoService.updateSelective(infoBase);
			if(data.isSuccess()){
				return ajaxDoneSuccess((String)data.getResult(),"baseInfoController.do?baseList");
			}else {
				return ajaxDoneError((String)data.getResult());
			}
		}
			
		return ajaxDoneError("信息提交失败");
		
	}
	
	/**
	 * 更新重要学术兼职情况、成果转化、个人工作业绩简介信息入库
	 * @param infoBase
	 * @param session
	 * @return
	 */
	@RequestMapping(params = "intro", method = RequestMethod.POST)
	public ModelAndView updateQKJJ(DeclareBase infoBase,HttpSession session,Model model) {
		String baseId =(String)session.getAttribute("baseId");
		//String baseId ="d6fe77b00e7f44e094782480c9018b00";
		if(!"".equals(baseId) && baseId!=null){
			infoBase.setBase_id(baseId);
			Data data =baseInfoService.updateSelective(infoBase);
			if(data.isSuccess()){
				if(infoBase.getFlag()==0){
					return ajaxDoneSuccess((String)data.getResult(),"declarationInfo/othersInfo.jsp");
				}else{
					return ajaxDoneSuccess((String)data.getResult(),"declarationInfo/teamDeclare/teamothersInfo.jsp");
				}
				
			}else {
				return ajaxDoneError((String)data.getResult());
			}
		}
			
		return ajaxDoneError("信息提交失败");
		
	}
	/**
	 * 更新信息入库
	 * @param infoBase
	 * @param session
	 * @return
	 */
	@RequestMapping(params = "others", method = RequestMethod.POST)
	public ModelAndView updateOthersInfo(DeclareBase infoBase,HttpSession session,Model model) {
		String baseId =(String)session.getAttribute("baseId");
	//	String baseId ="d6fe77b00e7f44e094782480c9018b00";
		String declareId =(String)session.getAttribute("declareId");
		if(!"".equals(baseId) && baseId!=null){
			infoBase.setBase_id(baseId);
			Data data =baseInfoService.updateSelective(infoBase);
			if(data.isSuccess()){
				decService.updateIfValid(declareId);
				session.removeAttribute("baseId");
				session.removeAttribute("declareId");
				return ajaxDoneSuccess("申报信息已提交成功，等待待审核");
			}
		}
			
		return ajaxDoneError("信息提交失败");
		
	}
	/**
	 * 跳转至负责人信息页面
	 * @param model
	 * @return
	 */
	@RequestMapping(params ="addCharge")
	public String addCharge(Model model) {
		return "/declarationInfo/teamDeclare/chargePersonInfo";
	}
	/**
	 * 跳转至核心成员信息页面
	 * @param model
	 * @return
	 */
	@RequestMapping(params ="addCore")
	public String addCore(Model model) {
		return "/declarationInfo/teamDeclare/coreMemberInfo";
	}
	/**
	 * 跳转至团队成员基本信息列表页面
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(params ="baseList")
	public String baseList(Model model,HttpSession session) {
		String declareId =(String)session.getAttribute("declareId");
		if(declareId !=null){
			List<DeclareBase> baseList = baseInfoService.findBaseInfoById(declareId);
			model.addAttribute("baseInfoList", baseList);
		}
		return "/declarationInfo/teamDeclare/teamMemberList";
	}
	/**
	 * 删除团队成员信息
	 * @param baseId
	 * @param infoBase
	 * @param session
	 * @return
	 */
	@RequestMapping(params = "delete", method = RequestMethod.POST)
	public ModelAndView delete(String baseId,DeclareBase infoBase,HttpSession session) {
		Data data =baseInfoService.deleteBaseInfo(baseId);
		if(data.isSuccess()){
				return ajaxDoneSuccess((String)data.getResult(),"baseInfoController.do?baseList");
		}
		return ajaxDoneError((String)data.getResult());
	}
	/**
	 * 跳转至团队成员个人业绩简介页面
	 * @param model
	 * @return
	 */
	@RequestMapping(params ="toPersonal")
	public String toPersonal(Model model) {
		return "/declarationInfo/teamDeclare/personalInfo";
	}
	
	@RequestMapping(params = "getInfo")
	public String getDeclareInfo(Model model, HttpSession session) {
		String declareId = (String) session.getAttribute("declareId");
		String baseId = (String) session.getAttribute("baseId");
		String forward="";
		if(jstr.StringIsNull(declareId) && jstr.StringIsNull(baseId)){
			DeclareBase declareBase = new DeclareBase();
			declareBase.setDeclare_id(declareId);
			declareBase.setBase_id(baseId);
			DeclareBase baseInfo = baseInfoService.getBaseInfoById(declareBase);
			model.addAttribute("baseInfo",baseInfo);
			if(baseInfo!=null){
				model.addAttribute("type",baseInfo.getFlag());
			}
			forward="/declarationInfo/baseInfo";
		}
		
		return forward;
	}
}
