package com.spring4.webtest.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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
@EnableTransactionManagement
public class DBConfig {
	
/*	@Autowired
	private Environment environment;*/
	
	@Bean
	public JpaTransactionManager transactionManager(){
		JpaTransactionManager jtManager = new JpaTransactionManager(entityManagerFactoryBean().getObject());
		return jtManager;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPackagesToScan(new String [] {"com.spring4.webtest.domain"});
		entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		entityManagerFactoryBean.setJpaProperties(jpaProperties());
		return entityManagerFactoryBean; 
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setDatabase(Database.H2);
		hibernateJpaVendorAdapter.setShowSql(true);
		hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
		return hibernateJpaVendorAdapter;
	}
	
	private Properties jpaProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		return properties;
	}
	
	//@Profile("dev")
	@Bean
	public DataSource dataSource(){
/*		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("org.h2.Driver");
		ds.setUrl("jdbc:h2:tcp://localhost/~/webtest");
		ds.setUsername("sa");
		ds.setPassword("");
		ds.setInitialSize(5);
		ds.setMaxActive(10);
		return ds;*/
		
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript("classpath:schema.sql")
				.build();
	} 

}
