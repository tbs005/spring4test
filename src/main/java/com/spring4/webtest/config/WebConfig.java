package com.spring4.webtest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * web 项目配置文件
 * @author weihua.wang (tbs005@qq.com)
 *
 */

@Configuration
@EnableWebMvc
@ComponentScan("com.spring4.webtest")
public class WebConfig {
}
