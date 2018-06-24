//package com.app.code;
//
//import java.io.IOException;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.app.code.service.CacheService;
//import com.app.code.service.CacheServiceImpl;
//import com.app.code.util.SMSUtil;
//import com.fasterxml.jackson.core.JsonParseException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.taobao.api.ApiException;
//import com.whalin.MemCached.MemCachedClient;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
//public class CodeTests {
//	
//	//@Autowired
//	//private SMSUtil a;
//	//private CacheService serv;
//	
//	@Autowired
//	private MemCachedClient memCachedClient;
//
//	@Test
//	public void contextLoads() {
////		//serv.tt();
//		 //MemCachedClient memCachedClient = new MemCachedClient();
//	        for (int i = 0; i < 10; i++) {
//	            /* 将对象加入到memcached缓存 */
//	            boolean success = memCachedClient.set("" + i, "Hellow!");
//	            /* 从memcached缓存中按key值取对象 */
//	            String result = (String) memCachedClient.get("" + i);
//	            System.out.println(String.format("set( %d ): %s", i, success));
//	            System.out.println(String.format("get( %d ): %s", i, result));
//	        }
//		
//		
//	}
//
//}
