package com.app.MemcacheModel;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "memcached")
public class MemcachedModel {

	private String servers="127.0.0.1:11210";

	private Boolean failover=true;

	private Integer initConn=10;

	private Integer minConn=5;

	private Integer maxConn=250;

	private Integer maintSleep=30;

	private Boolean nagle=false;

	private Integer socketTO=3000;

	private Boolean aliveCheck=true;

	public Boolean getFailover() {
		return failover;
	}

	public void setFailover(Boolean failover) {
		this.failover = failover;
	}

	public Integer getInitConn() {
		return initConn;
	}

	public void setInitConn(Integer initConn) {
		this.initConn = initConn;
	}

	public Integer getMinConn() {
		return minConn;
	}

	public void setMinConn(Integer minConn) {
		this.minConn = minConn;
	}

	public Integer getMaxConn() {
		return maxConn;
	}

	public void setMaxConn(Integer maxConn) {
		this.maxConn = maxConn;
	}

	public Integer getMaintSleep() {
		return maintSleep;
	}

	public void setMaintSleep(Integer maintSleep) {
		this.maintSleep = maintSleep;
	}

	public Boolean getNagle() {
		return nagle;
	}

	public void setNagle(Boolean nagle) {
		this.nagle = nagle;
	}

	public Integer getSocketTO() {
		return socketTO;
	}

	public void setSocketTO(Integer socketTO) {
		this.socketTO = socketTO;
	}

	public Boolean getAliveCheck() {
		return aliveCheck;
	}

	public void setAliveCheck(Boolean aliveCheck) {
		this.aliveCheck = aliveCheck;
	}

	public String getServers() {
		return servers;
	}

	public void setServers(String servers) {
		this.servers = servers;
	}
}
