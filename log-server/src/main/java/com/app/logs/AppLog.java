package com.app.logs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AppLog {

	private Logger log = LoggerFactory.getLogger(getClass());

	public void info(String marker, String msg) {
		log.info(marker, msg);
	}

	public void info(String marker, Object msg) {
		log.info(marker, msg);
	}

	public void error(String marker, String msg) {
		log.error(marker, msg);
	}

	public void debug(String marker, String msg) {
		log.debug(marker, msg);
	}

	public void warn(String marker, String msg) {
		log.warn(marker, msg);
	}
}
