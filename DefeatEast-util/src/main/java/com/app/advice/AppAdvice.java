package com.app.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.base.BaseController;
import com.app.base.OperateResult;

@RestControllerAdvice
public class AppAdvice extends BaseController {

	@ExceptionHandler(value = Exception.class)
	public OperateResult<Object> test(Exception ex) {
		ex.printStackTrace();
		return result();
	}
}
