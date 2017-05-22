package com.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.pageModel.AjaxDone;
import com.utils.CustomDateEditor;

/**
 * 基础控制器，其他控制器需extends此控制器获得initBinder自动转换的功能
 * 
 * @author 余军红
 * 
 */
public class BaseController {

	private static final Logger logger = Logger.getLogger(BaseController.class);

	/**
	 * 将前台传递过来的日期格式的字符串，自动转化为Date类型
	 * 
	 * @param binder
	 * 
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		// binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
	}
	
	protected ModelAndView ajaxDone(int statusCode, String message, String forwardUrl) {
		ModelAndView mav = new ModelAndView("ajaxDone");
		mav.addObject("statusCode", statusCode);
		mav.addObject("message", message);
		mav.addObject("forwardUrl", forwardUrl);
	//	mav.addObject("rel", "jyjl");
		return mav;
	}
	
	protected ModelAndView ajaxDoneSuccess(String message, String forwardUrl) {
		return ajaxDone(200, message, forwardUrl);
	}
	protected ModelAndView ajaxDoneSuccess(String message) {
		return ajaxDone(200, message, "");
	}

	protected ModelAndView ajaxDoneError(String message, String forwardUrl) {
		return ajaxDone(300, message, forwardUrl);
	}
	protected ModelAndView ajaxDoneError(String message) {
		return ajaxDone(300, message, "");
	}
	
	/**
	 * 上传奖励证书
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
		String sqlpath="/upload/" + dateStr+ "/" + fileName + fileType;
		
		
		ajaxDone.setAttachmentPath(sqlpath);
		ajaxDone.setAttachmentSize("1000");
		ajaxDone.setFileName(file.getOriginalFilename());
		ajaxDone.setId("1");

		return ajaxDone;
	}
}
