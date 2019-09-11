package com.woniuxy.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer{
	//自定义路径的视图解析
//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/").setViewName("login");
//		registry.addViewController("/index.html").setViewName("login");
//	}
	//匿名内部类
	@Bean
	public WebMvcConfigurer webMvcConfig() {
		WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				//System.out.println("2");
				registry.addViewController("/").setViewName("login");
				registry.addViewController("/index.html").setViewName("login");
			}
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				//System.out.println("1");
				registry.addInterceptor(new LoginHandlerInterceptor())
				.addPathPatterns("/**")
				.excludePathPatterns("/","/index.html","/user/login","/css/**");
			}
		};
		return webMvcConfigurer;
	}
}
