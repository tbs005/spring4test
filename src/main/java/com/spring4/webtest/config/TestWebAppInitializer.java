package com.spring4.webtest.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class TestWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * 其他spring配置
	 * web.xml ContextLoaderListener 配置相关
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfig.class };
	}

	/**
	 * WebMvc相关配置 
	 * web.xml DispatcherServlet 配置相关
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String [] {"/"};
	}

}
