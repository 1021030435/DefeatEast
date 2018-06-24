package com.app.code.db.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import com.app.code.db.model.CodeRecode;

public interface CodeRecordMapper {

	@Insert("INSERT INTO code_record(phone,msg,send_time) VALUES(#{recode.phone},#{recode.msg},#{recode.sendTime})")
	Integer insert(@Param("recode") CodeRecode recode);
}
