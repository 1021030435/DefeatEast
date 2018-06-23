package com.app.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.base.AppConfig;
import com.app.base.BaseController;
import com.app.base.OperateResult;
import com.app.exception.KeyException;
import com.app.exception.ParamException;

@RestControllerAdvice
public class ShowAdvice extends BaseController {

	@ExceptionHandler(value = KeyException.class)
	public OperateResult test(KeyException ex) {
		ex.printStackTrace();
		return result(AppConfig.KEY_ERROR, "手机号邮箱错误");
	}

	@ExceptionHandler(value = ParamException.class)
	public OperateResult test(ParamException ex) {
		ex.printStackTrace();
		return result(AppConfig.Param_ERROR, "密码用户名错误");
	}
}
