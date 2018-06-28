package com.app.code.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.app.code.Interceptor.ValidateInterceptor;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		WebMvcConfigurer.super.addInterceptors(registry);
		registry.addInterceptor(new ValidateInterceptor());
	}
}
