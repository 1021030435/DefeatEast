package com.app.base;

import static com.app.base.AdviceEnum.*;

public abstract class BaseController {

	protected <T> OperateResult<T> result(AdviceEnum adviceEnum, T data) {
		OperateResult<T> result = new OperateResult<T>(adviceEnum);
		result.setData(data);
		return result;
	}

	protected <T> OperateResult<T> result(AdviceEnum adviceEnum) {
		OperateResult<T> result = new OperateResult<T>(adviceEnum);
		return result;
	}

	protected <T> OperateResult<T> result() {
		OperateResult<T> result = new OperateResult<T>();
		result.setErrno(SYSTEM_ERROR.getErrno());
		result.setMsg(SYSTEM_ERROR.getMsg());
		return result;
	}

	protected <T> OperateResult<T> result(T data) {
		OperateResult<T> result = new OperateResult<T>();
		result.setErrno(SUCCESS.getErrno());
		result.setMsg(SUCCESS.getMsg());
		result.setData(data);
		return result;
	}
}
