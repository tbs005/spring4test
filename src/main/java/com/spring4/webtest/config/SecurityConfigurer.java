package com.spring4.webtest.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("user").password("123").roles("USER")
		.and()
		.withUser("admin").password("admin").roles("USER","ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/","/index","/home").permitAll()
		.anyRequest().authenticated();
	}
}
