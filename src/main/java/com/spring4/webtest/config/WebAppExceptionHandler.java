package com.spring4.webtest.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * 处理web应用控制器通用异常
 * 用法参考：http://jinnianshilongnian.iteye.com/blog/1866350
 */
@ControllerAdvice
public class WebAppExceptionHandler {

	/**
	 * 全局处理Exception 错误的情况下返回500
	 * 
	 * @param ex
	 * @param req
	 * @return
	 */
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleOtherExceptions(final Exception ex, final WebRequest req) {
		return new ResponseEntity<Object>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
