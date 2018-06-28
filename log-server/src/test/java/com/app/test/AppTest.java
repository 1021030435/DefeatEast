package com.app.test;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.start.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AppTest {
	@Value("${execution_expression}")
	private String a;

	@Test
	public void contextLoads() throws Exception {
		System.err.println(a);
	}

}
