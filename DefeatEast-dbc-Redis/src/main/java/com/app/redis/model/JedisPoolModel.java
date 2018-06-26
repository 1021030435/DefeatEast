package com.app.redis.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="jedispool")
public class JedisPoolModel {

	private Integer maxWaitMillis=-1;
	private Integer maxIdle=50000;
	private Integer minIdle=0;
	private Integer maxTotal=50000;

	public Integer getMaxWaitMillis() {
		return maxWaitMillis;
	}

	public void setMaxWaitMillis(Integer maxWaitMillis) {
		this.maxWaitMillis = maxWaitMillis;
	}

	public Integer getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(Integer maxIdle) {
		this.maxIdle = maxIdle;
	}

	public Integer getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(Integer minIdle) {
		this.minIdle = minIdle;
	}

	public Integer getMaxTotal() {
		return maxTotal;
	}

	public void setMaxTotal(Integer maxTotal) {
		this.maxTotal = maxTotal;
	}

}
