package com.usercenter.db.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

//import org.apache.ibatis.annotations.Update;
import com.usercenter.db.model.User;

public interface UserMapper {

	@Select("SELECT id,idcard,link,link_type,name,psw,salt,create_time FROM t_user WHERE link=#{link}")
	@Results({ @Result(column = "create_time", property = "createTime"),
			@Result(column = "link_type", property = "linkType") })
	User findByLink(@Param("link") String link);

	@Insert("INSERT INTO t_user(link,link_type,psw,salt) VALUES(#{user.link},#{user.linkType},#{user.psw},#{user.salt})")
	Integer signin(@Param("user") User user);

	 @Update("UPDATE t_user SET psw=#{user.psw}  , salt =#{user.salt} where id= #{user.id}  ")
	 Integer updateById(@Param("user") User user);
}
