package com.interceptors;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.pageModel.SessionInfo;
import com.utils.ResourceUtil;

public class SessionInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception exception)
			throws Exception {
		SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(ResourceUtil.getSessionInfoName());
		String requestUrl = request.getQueryString();

		List<String> uncheckUrls = new ArrayList<String>();
		uncheckUrls.add("login");
		uncheckUrls.add("logout");
		uncheckUrls.add("validateCode");
		if (!uncheckUrls.contains(requestUrl.contains("&")?requestUrl.substring(0,requestUrl.indexOf("&")):requestUrl)) {
			if(sessionInfo==null){
				if (request.getHeader("x-requested-with") != null
						&& request.getHeader("x-requested-with").equalsIgnoreCase(
								"XMLHttpRequest")) {
					response.sendRedirect(request.getContextPath()+"/login.jsp");
				} else {
					response.sendRedirect(request.getContextPath()+"/login.jsp");
				}
			}
		}else{
			if(sessionInfo!=null)
				response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object object,
			ModelAndView modelAndView) throws Exception {

	}

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object object) throws Exception {
		SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(ResourceUtil.getSessionInfoName());
		String requestUrl = request.getQueryString();
		List<String> uncheckUrls = new ArrayList<String>();
		uncheckUrls.add("login");
		uncheckUrls.add("logout");
		uncheckUrls.add("validateCode");
		if(requestUrl==null){
			return false;
		}
		if (!uncheckUrls.contains(requestUrl.contains("&")?requestUrl.substring(0,requestUrl.indexOf("&")):requestUrl)) {
			if(sessionInfo==null){
				if (request.getHeader("x-requested-with") != null
						&& request.getHeader("x-requested-with").equalsIgnoreCase(
								"XMLHttpRequest")) {
					response.addHeader("sessionstatus", "timeout");
				} else {
					response.sendRedirect(request.getContextPath()+"/login.jsp");
				}
			}
		}
		return true;
	}
}
