package com.spring4.webtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class HomeController {

	@RequestMapping(value = {"/","/home","/index"}, method = GET)
	public String home() {
		return "home";
	}

}
