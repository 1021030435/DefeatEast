package com.app.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.base.AppConfig;
import com.app.base.BaseController;
import com.app.base.OperateResult;
import com.app.exception.PswException;
import com.app.exception.UserNotFoundException;

@RestControllerAdvice
public class UserCenterAdvice extends BaseController{

	@ExceptionHandler(value = PswException.class)
	public OperateResult test(PswException ex) {
		ex.printStackTrace();
		return result(AppConfig.PSW_ERROR, "密码错误");
	}
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public OperateResult test(UserNotFoundException ex) {
		ex.printStackTrace();
		return result(AppConfig.USER_ERROR, "无此用户");
	}
}
