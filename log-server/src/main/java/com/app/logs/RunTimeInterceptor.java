package com.app.logs;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.logs.AppLog;
import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class RunTimeInterceptor {

	@Autowired
	private AppLog log;
	
	@Pointcut("@annotation(com.app.logAnnotation.SaveLog)")
	public void cutPoint() {}
	
	@Around("cutPoint()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		long time = System.currentTimeMillis();
		log.info("执行方法【{}】", joinPoint.getSignature().getName());
		log.error("test","tt");
		Object result = null;
		try {
			result = joinPoint.proceed();
		} catch (Exception e) {
			log.info("执行失败，原因【{}】", e.getStackTrace()[0]);
			throw e;
		} finally {
			log.info("处理结果【{}】", new ObjectMapper().writeValueAsString(result));
			log.info("执行处理耗时【{}毫秒】", (System.currentTimeMillis() - time));
		}

		return result;
	}

}
