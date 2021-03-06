package com.app.code.task;

import java.util.Date;

import com.app.code.online.OnlineEnum;

public class SendModel {

	private String key;

	private String code;

	private Date sendTime;
	
	private OnlineEnum onlineEnum; 

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public OnlineEnum getOnlineEnum() {
		return onlineEnum;
	}

	public void setOnlineEnum(OnlineEnum onlineEnum) {
		this.onlineEnum = onlineEnum;
	}
}
