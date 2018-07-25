package com.hing.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class IndexInterceptor implements HandlerInterceptor{
	/**
	 * 执行Controller之前
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String url = request.getRequestURI();
		if(url.indexOf("index")>=0 || url.indexOf("loginCheck") >= 0 || url.indexOf("Register") >= 0) {
			return true;
		}
		if(request.getSession().getAttribute("user_name") != null && request.getSession().getAttribute("user_id") != null) {
			return true;
		}
		response.sendRedirect("index");
		return false;
	}
	
	/**
	 * 业务处理器处理请求后，返回视图之前
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mav)
			throws Exception {
		if(request.getSession().getAttribute("user_name") == null || request.getSession().getAttribute("user_id") == null) {
			mav.setViewName("index");															
		}
	}
	 /** 
     * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等  
     *  
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion() 
     */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception arg3)
			throws Exception {
		
	}
	

	
}
