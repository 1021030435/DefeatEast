package com.app.base;

public class OperateResult<T> {

	public OperateResult() {
		
	}

	public OperateResult(AdviceEnum adviceEnum) {
		this.msg = adviceEnum.getMsg();
		this.errno = adviceEnum.getErrno();
	}

	private Integer errno;

	private String msg;

	private T data;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getErrno() {
		return errno;
	}

	public void setErrno(Integer errno) {
		this.errno = errno;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
