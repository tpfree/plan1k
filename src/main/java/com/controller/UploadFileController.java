package com.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.pageModel.AjaxDone;

/**
 * 
 * 
 * @author 余军红
 * 
 */
@Controller
@RequestMapping("/uploadController")
public class UploadFileController extends BaseController {
	private static final Logger logger = Logger
			.getLogger(UploadFileController.class);

	/**
	 * 上传专利证书
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
