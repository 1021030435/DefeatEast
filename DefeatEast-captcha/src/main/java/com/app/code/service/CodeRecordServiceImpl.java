package com.app.code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.code.db.mapper.CodeRecordMapper;
import com.app.code.db.model.CodeRecord;

@Service
public class CodeRecordServiceImpl implements CodeRecordService {

	@Autowired
	private CodeRecordMapper recordMapper;

	private Integer insert(String phone, String email, String code, Integer status) throws Exception {
		CodeRecord record = new CodeRecord();
		record.setPhone(phone);
		record.setEmail(email);
		record.setCode(code);
		record.setStatus(status);
		return recordMapper.insert(record);
	}

	@Override
	public List<CodeRecord> getSendDate(Integer status) throws Exception {
		return recordMapper.getSendDate(status);
	}

	@Override
	public Integer insertPhone(String phone, String code, Integer status) throws Exception {
		return insert(phone, "", code, status);
	}

	@Override
	public Integer insertEmail(String email, String code, Integer status) throws Exception {
		return insert("", email, code, status);
	}

}
