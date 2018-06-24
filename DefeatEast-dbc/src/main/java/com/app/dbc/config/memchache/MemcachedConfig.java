package com.app.dbc.config.memchache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

@Configuration
public class MemcachedConfig {

	@Autowired
	private MemcachedModel model;

	@Bean
	public SockIOPool init() {
		String[] servers = { model.getServers() };
		SockIOPool pool = SockIOPool.getInstance();
		pool.setServers(servers);
		pool.setFailover(model.getFailover());
		pool.setInitConn(model.getInitConn());
		pool.setMinConn(model.getMinConn());
		pool.setMaxConn(model.getMaxConn());
		pool.setMaintSleep(model.getMaintSleep());
		pool.setNagle(model.getNagle());
		pool.setSocketTO(model.getSocketTO());
		pool.setAliveCheck(model.getAliveCheck());
		pool.initialize();
		System.out.println(pool.toString());
		return pool;
	}

	@Bean
	public MemCachedClient client() {
		return new MemCachedClient();
	}
}
// memcached.exe -p 11211 -m 512 -d start