package com.app.controller.base;


public abstract class BaseController {

	//protected AppLog log;

	protected OperateResult result(Integer errno, String msg, Object data) {
		OperateResult result = new OperateResult();
		result.setErrno(errno);
		result.setMsg(msg);
		result.setData(data);
		return result;
	}

	protected OperateResult result(Integer errno, String msg) {
		OperateResult result = new OperateResult();
		result.setErrno(errno);
		result.setMsg(msg);
		return result;
	}

	protected OperateResult result(String msg, Object data) {
		OperateResult result = new OperateResult();
		result.setErrno(AppConfig.SUCCESS);
		result.setMsg(msg);
		result.setData(data);
		return result;
	}

	protected OperateResult result(Object data) {
		OperateResult result = new OperateResult();
		result.setErrno(AppConfig.SUCCESS);
		result.setMsg(AppConfig.SUCCESS_MSG);
		result.setData(data);
		return result;
	}
	
	protected OperateResult result() {
		OperateResult result = new OperateResult();
		result.setErrno(AppConfig.SUCCESS);
		result.setMsg(AppConfig.SUCCESS_MSG);
		return result;
	}
	
	protected OperateResult result(OperateResult result) {
		return result;
	}
}
