package com.rhcloud.tothought.web.spring.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.rhcloud.tothought.web.spring.listeners.LookupLoaderApplicationListener;

public class LookupHandlerInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	LookupLoaderApplicationListener loader;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("skillCategories", loader.getCategories());
		return super.preHandle(request, response, handler);
	}
}
