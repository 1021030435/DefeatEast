package com.usercenter.filter.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.usercenter.filter.UserFilter;

@Configuration
public class FilterConfig {
	
	@Bean
	public FilterRegistrationBean<UserFilter> filter() {
		FilterRegistrationBean<UserFilter> bean = new FilterRegistrationBean<UserFilter>();
		bean.setFilter(new UserFilter());
		//bean.addUrlPatterns("");
		return bean;
	}

}
