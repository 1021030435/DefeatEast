package com.app.code.model;

public class SMSResultModel {

	private Integer err_code;

	private String model;

	private String msg;

	private Boolean success;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getErr_code() {
		return err_code;
	}

	public void setErr_code(Integer err_code) {
		this.err_code = err_code;
	}
}
