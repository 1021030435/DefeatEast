package com.app.base;

public enum AdviceEnum {

	SUCCESS(10000, "操作成功"),
	SYSTEM_ERROR(10002, "系统错误"),
	VALIDATE_ERROR(10003, "验证码错误"),
	CODE_EXIST_ERROR(10004, "验证码不存在"),
	PHONE_ERROR(10005, "手机号错误"),
	EMAIL_ERROR(10006, "邮箱错误"),
	CACHE_ERROR(10007, "缓存失败"),
	FREQUENCY_ERROR(10008, "获取验证码频繁"),
	SIGNIN_ERROR(10009, "注册错误"),
	USER_ERROR(10010, "用户错误"),
	PSW_ERROR(10011, "密码错误"),
	KEY_ERROR(10012, "账号错误"),
	PARAM_ERROR(10013, "参数错误");

	private Integer errno;

	private String msg;

	private AdviceEnum(Integer errno, String msg) {
		this.setErrno(errno);
		this.setMsg(msg);
	}

	public Integer getErrno() {
		return errno;
	}

	public void setErrno(Integer errno) {
		this.errno = errno;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
