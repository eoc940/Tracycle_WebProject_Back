package com.tracycle.recycle.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Autowired
	private HandlerInterceptor interceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("all request");
		registry.addInterceptor(interceptor)
					.addPathPatterns("/**")
					.excludePathPatterns("/user/login")
					.excludePathPatterns("/user/addUser");
		System.out.println("interceptor regist");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
}
