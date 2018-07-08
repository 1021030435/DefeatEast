package com.app.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.script.DefaultRedisScript;
//import org.springframework.scripting.support.ResourceScriptSource;

@Configuration
public class RedisConfig {

	@Bean
	public StringRedisTemplate stringTemplate(RedisConnectionFactory factory) {
		StringRedisTemplate template = new StringRedisTemplate(factory);
		return template;
	}

	@Bean
	public RedisTemplate<?, ?> template(RedisConnectionFactory factory) {
		RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
		template.setConnectionFactory(factory);
		return template;
	}

//	@Bean
//	public DefaultRedisScript<Boolean> redisScript() {
//		DefaultRedisScript<Boolean> redisScript = new DefaultRedisScript<Boolean>();
//		redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("get_next_seq.lua")));
//		redisScript.setResultType(Boolean.class);
//		return redisScript;
//	}
}

/**
 * RedisTemplate使用的是JdkSerializationRedisSerializer,redis中字节数组显示
 * StringRedisTemplate使用的是StringRedisSerializer,redis中是正常的可读的字符串
 */
