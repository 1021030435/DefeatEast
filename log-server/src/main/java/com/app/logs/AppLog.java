package com.app.logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class AppLog {

	//private Logger log = LoggerFactory.getLogger(getClass());
	private  final Logger log = LogManager.getLogger(getClass());

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
