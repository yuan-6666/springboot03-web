package com.woniuxy.springboot.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginHandlerInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object user = request.getSession().getAttribute("user");
		System.out.println(user+"用户");
		if(user!=null) {
			return true;
		}else {
			//转发，重定向，模板引擎不起作用
			System.out.println("aaaaaasdddd");
			request.getRequestDispatcher("/index.html").forward(request, response);
			return false;
		}
	}
}
