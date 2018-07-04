package com.app.code.online;

public enum OnlineEnum {

	SMS(0), EMAIL(1);
	
	private Integer type;
	
	private OnlineEnum(Integer type) {
		this.setType(type);
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
}
