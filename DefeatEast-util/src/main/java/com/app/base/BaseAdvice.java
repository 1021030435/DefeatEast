package com.app.controller.base;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BaseAdvice extends BaseController {

	@ExceptionHandler(value = Exception.class)
	public OperateResult test(Exception ex) {
		ex.printStackTrace();
		return result(AppConfig.SYSTEM_ERROR, "系统错误");
	}
}
