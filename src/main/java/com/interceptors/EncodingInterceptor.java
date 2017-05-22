package com.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 字符集拦截器
 * 
 * @author xyl1153
 * 
 */
public class EncodingInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception exception)
			throws Exception {

	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object object,
			ModelAndView modelAndView) throws Exception {
		// orient.httpModel.User sessionInfo = (orient.httpModel.User) request
		// .getSession().getAttribute("userInfo");
		// String ajaxTag = request.getHeader("Request-By");// Ext
		// if (sessionInfo == null) {
		// if (ajaxTag == null || !ajaxTag.trim().equalsIgnoreCase("Ext")) {
		// } else {
		// PrintWriter out = response.getWriter();
		// out.print("{sessionState:0}");
		// out.flush();
		// out.close();
		// }
		// }
	}

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object object) throws Exception {
		request.setCharacterEncoding("UTF-8");
		//request.getAttribute("deviceName")
		response.setCharacterEncoding("UTF-8");
		return true;
	}

}
