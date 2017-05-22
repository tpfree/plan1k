package com.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 
 * @author 余军红
 * 
 */
@Controller
@RequestMapping("/indexController")
public class IndexController extends BaseController {
	private static final Logger logger = Logger
			.getLogger(IndexController.class);

	@RequestMapping(params="index")
	public String index() {
		return "/index";
	}
	
	@RequestMapping(params="login")
	public String login() {
		return "/login";
	}

	@RequestMapping(params="register")
	public String register() {
		return "/register";
	}
}
