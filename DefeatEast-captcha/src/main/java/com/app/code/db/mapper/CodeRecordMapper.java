package com.app.code.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.app.code.db.model.CodeRecord;

public interface CodeRecordMapper {

	@Insert("INSERT INTO code_record(phone,email,code,status,send_time) VALUES(#{code.phone},#{code.email},#{code.code},#{code.status}, NOW())")
	Integer insert(@Param("code") CodeRecord record);
	
	@Select("SELECT phone,email,code FROM code_record WHERE status=#{status}")
	List<CodeRecord> getSendDate(@Param("status") Integer status);
	
	
}
