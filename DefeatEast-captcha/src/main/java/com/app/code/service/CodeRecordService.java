package com.app.code.service;

import java.util.List;

import com.app.code.db.model.CodeRecord;

public interface CodeRecordService {

	Integer insertPhone(String phone, String code, Integer status) throws Exception;
	
	Integer insertEmail(String email, String code, Integer status) throws Exception;
	
	List<CodeRecord> getSendDate(Integer status) throws Exception;
}
