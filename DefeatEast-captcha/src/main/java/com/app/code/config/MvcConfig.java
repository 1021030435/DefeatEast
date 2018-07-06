package com.app.code.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.app.code.interceptor.ValidateInterceptor;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	
	@Autowired
	private ApplicationContext context;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		WebMvcConfigurer.super.addInterceptors(registry);
		registry.addInterceptor(context.getBean(ValidateInterceptor.class));
	}
}
