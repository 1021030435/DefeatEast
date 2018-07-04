package com.app.code.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.code.db.mapper.CodeRecordMapper;
import com.app.code.db.model.CodeRecord;

@Service
public class CodeRecordServiceImpl implements CodeRecordService {

	@Autowired
	private CodeRecordMapper recordMapper;

	public Integer insert(Integer type, String target, String code, Integer status) throws Exception {
		CodeRecord record = new CodeRecord();
		record.setCode(code);
		record.setStatus(status);
		record.setSendType(type);
		return recordMapper.insert(record);
	}
	
}
