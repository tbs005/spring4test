package com.spring4.webtest.config;

import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Web 安全权限相关配置
 * 参考官方文档：http://docs.spring.io/spring-security/site/docs/4.2.3.RELEASE/guides/html5/
 * 其他参考：http://hanqunfeng.iteye.com/blog/2114980
 */
//@Configuration @EnableWebSecurity已经继承了Configuration
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/", "/index", "/home");
		web.ignoring().antMatchers("/", "/index");
	}
}
