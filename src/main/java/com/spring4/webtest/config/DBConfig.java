package com.spring4.webtest.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 数据源配置
 * H2 数据库使用参考：
 * http://www.cnblogs.com/xdp-gacl/p/4171024.html
 * http://www.cnblogs.com/love540376/p/5311907.html
 * http://www.cnblogs.com/jason0529/p/6529880.html
 * http://blog.csdn.net/zhangjq520/article/details/53931003
 * 
 */
@Configuration
@ComponentScan(basePackages = "com.spring4.webtest.dao")
public class DBConfig {

	@Bean
	public BasicDataSource dataSource(){
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("org.h2.Driver");
		ds.setUrl("jdbc:h2:tcp://localhost/~/webtest");
		ds.setUsername("sa");
		ds.setPassword("");
		ds.setInitialSize(5);
		ds.setMaxActive(10);
		return ds;
	} 

}
