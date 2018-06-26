package com.app.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;

import redis.clients.jedis.JedisPoolConfig;


@Configuration
public class RedisConfig {
	
//	@Bean
//	public JedisPoolConfig pool() {
//		JedisPoolConfig pool = new JedisPoolConfig();
//		pool.setMaxWaitMillis(-1);
//		pool.setMaxIdle(50000);// 最大空闲
//		pool.setMinIdle(0);
//		pool.setMaxTotal(50000);// 最大连接
//		return pool;
//	}
//	@Bean
//	public RedisConnectionFactory connection() {
//		JedisConnectionFactory factory = new JedisConnectionFactory();
//		factory.setHostName("127.0.0.1");
//		factory.setPort(6379);
//		factory.setTimeout(-1);
//		return factory;
//	}

	@Bean
	  public RedisConnectionFactory redisConnectionFactory() {

	    RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("127.0.0.1", 6379);
	    JedisConnectionFactory jedis=	    new JedisConnectionFactory(config);
	    JedisPoolConfig pool = new JedisPoolConfig();
		pool.setMaxWaitMillis(-1);
		pool.setMaxIdle(50000);// 最大空闲
		pool.setMinIdle(0);
		pool.setMaxTotal(50000);// 最大连接
		jedis.setPoolConfig(pool);		
	    return  jedis;
	  }
	
	

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

	@Bean
	public DefaultRedisScript<Boolean> redisScript() {
		DefaultRedisScript<Boolean> redisScript = new DefaultRedisScript<Boolean>();
		redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("get_next_seq.lua")));
		redisScript.setResultType(Boolean.class);
		return redisScript;
	}
}
