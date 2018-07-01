package com.app.code.online;

public class OnlineSend {

	private Online online;

	public OnlineSend(Online online) {
		this.setOnline(online);
	}
	
	public Integer send(String key, String code) throws Exception {
		return online.send(key, code);
	}

	public Online getOnline() {
		return online;
	}

	public void setOnline(Online online) {
		this.online = online;
	}
}
