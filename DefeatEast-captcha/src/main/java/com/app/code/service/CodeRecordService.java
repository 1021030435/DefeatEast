package com.app.code.service;

public interface CodeRecordService {

	Integer insert(Integer type, String target, String code, Integer status) throws Exception;
}
