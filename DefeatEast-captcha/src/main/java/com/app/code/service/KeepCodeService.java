package com.app.code.service;

public interface KeepCodeService {

	Boolean put(String key, String code) throws Exception;

	String getCode(String key) throws Exception;
}
