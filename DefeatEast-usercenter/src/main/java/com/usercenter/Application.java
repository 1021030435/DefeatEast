package com.usercenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import com.usercenter.filter.UserFilter;

@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = { "com.usercenter.db.mapper" })
public class Application {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}
	
	@Bean
	public FilterRegistrationBean<UserFilter> filter() {
		FilterRegistrationBean<UserFilter> bean = new FilterRegistrationBean<UserFilter>();
		bean.setFilter(new UserFilter());
		//bean.addUrlPatterns("");
		return bean;
	}
}
