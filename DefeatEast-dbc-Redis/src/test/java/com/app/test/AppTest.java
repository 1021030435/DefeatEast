package com.app.test;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.redis.model.JedisPoolModel;
import com.app.start.Application;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AppTest {

	@Autowired
	private JedisPoolModel jedisPoolModel;

	@Test
	public void contextLoads() throws Exception {
		System.err.println(jedisPoolModel.getMaxIdle());
		System.err.println(jedisPoolModel.getMaxWaitMillis());
		System.err.println(jedisPoolModel.getMinIdle());

	}

}