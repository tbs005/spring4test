package com.spring4.webtest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.spring4.webtest.config.WebAppInitializer;
import com.spring4.webtest.controller.HomeController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebAppInitializer.class})
@WebAppConfiguration
public class HomeControllerTest {
	
/*	@Resource
	private HomeController home;*/
	
	@Test
	public void testHome() throws Exception{
		HomeController home = new HomeController();
		MockMvc mockMvc = standaloneSetup(home).build();
		mockMvc.perform(get("/")).andExpect(view().name("home"));
	}
}
