package com.zhiling.webmagic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("/test")
	public String testController(){
		System.out.println("===================");
		return "true";
	}
}
