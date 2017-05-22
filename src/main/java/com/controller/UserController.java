package com.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.pageModel.Data;
import com.pageModel.SessionInfo;
import com.pageModel.Unit;
import com.pageModel.User;
import com.service.UserServiceI;
import com.utils.ImageUtil;
import com.utils.ResourceUtil;

/**
 * 用户控制器
 * 
 * @author 余军红
 * 
 */
@Controller
@RequestMapping("/userController")
public class UserController extends BaseController {
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	private UserServiceI userService;

	public UserServiceI getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}
	
	
	@RequestMapping("add")
	public String add(Model model) {
		return "/user/add";
	}
	
	@RequestMapping("edit/{userId}")
	public String edit(@PathVariable("userId") int userId, Model model) {
//		User user = userService.getUser(userId);
//
//		model.addAttribute("vo", user);

		return "/user/edit";
	}
	@RequestMapping(params="toReg")
	public String toRegister(Model model) {
		List<Unit> unitList = userService.findAllUnit();
		model.addAttribute("unitList", unitList);
		return "/register";
	}
	/**
	 * 用户登录
	 *
	 * @param user
	 *            用户的信息
	 * @return json
	 */
	@RequestMapping(params="reg",method=RequestMethod.POST)
	public String register(User user, ModelMap modelMap) {
		if(user==null){
			modelMap.put("errorText", "未知异常");
			return "/register";
		}
		
		Data d= userService.register(user);
		if(d==null){
			modelMap.put("errorText", "未知异常");
			return "/register";
		}
		if(d.isSuccess()){
			return "/login";
		}else{
			modelMap.put("errorText", d.getResult());
			return "/register";
		}
	}
	
	/**
	 * 用户登录
	 *
	 * @param user
	 *            用户的信息
	 * @return json
	 */
	@RequestMapping(params ="login")
	public String login(User user, Model model,HttpSession session) {
		if (user == null) {
			model.addAttribute("errorText", "未知异常");
			return "/login";
		}

		if (user.getUsername() == null || user.getUsername().isEmpty()) {
			model.addAttribute("errorText", "用户名不能为空");
			return "/login";
		}

		if (user.getPassword() == null || user.getPassword().isEmpty()) {
			model.addAttribute("errorText", "密码不能为空");
			return "/login";
		}

		String srand = (String) session.getAttribute("srand");
		if (srand == null) {
			model.addAttribute("errorText", "验证码过期");
			return "/login";
		}
		
		if (!(srand.toLowerCase()).equals(user.getValidateCode().toLowerCase())) {
			model.addAttribute("errorText", "验证码错误");
			return "/login";
		}
		Data d= userService.login(user);
		
		if(d.isSuccess()){
			
			User u=(User) d.getResult();
		   	String unitCode =u.getUnitCode();
		   	if(StringUtils.isEmpty(unitCode)){
		   		model.addAttribute("errorText", "单位代码不能为空");
				return "/login";
		   	}
		   	Data treeData=userService.getNavTreeByUnitCode(unitCode);
		   	if(treeData.isSuccess()){
		   		logger.debug(JSONObject.toJSONString(treeData.getResult()));
		   		model.addAttribute("treeList",treeData.getResult());
		   		session.setAttribute("userName", user.getUsername());
		   		session.setAttribute("nowdate",  new Date());
				return "/index";
		   	}else{
		   		model.addAttribute("errorText", treeData.getResult());
				return "/login";
		   	}
		}else{
			model.addAttribute("errorText", d.getResult());
			return "/login";
		}
	}

	@RequestMapping(params = "validateCode", method = RequestMethod.GET)
	public void validateCode(HttpServletResponse response,
			HttpServletRequest request) {

		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		response.setContentType("image/jpeg");

		BufferedImage image = ImageUtil.generationImage(request, "srand", 4);
		// 输出图形验证码图片

		try {
			ServletOutputStream sos = response.getOutputStream();
			ImageIO.write(image, "jpeg", response.getOutputStream());
			sos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * 注销接口
	 *
	 * @param session
	 * @return
	 */
	@RequestMapping(params = "logout")
	public String logout(HttpSession session) {
		Data j = new Data();
		if (session != null) {
			SessionInfo sessionInfo = (SessionInfo) session
					.getAttribute(ResourceUtil.getSessionInfoName());

			if (sessionInfo == null || sessionInfo.getUser() == null) {
				session.invalidate();
		//		j.setSuccess(true);
				return "/login";
			}
			session.invalidate();
		}
	//	j.setSuccess(true);
		return "/login";
	}
	
}
