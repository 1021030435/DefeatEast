package com.app.code.db.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import com.app.code.db.model.CodeRecord;

public interface CodeRecordMapper {

	@Insert("INSERT INTO code_record(send_type,send_target,code,status,send_time) VALUES(#{code.sendType},#{code.sendTarget},#{code.code},#{code.status}, NOW())")
	Integer insert(@Param("code") CodeRecord record);
	
}
