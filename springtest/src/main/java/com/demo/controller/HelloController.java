package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.DemoService;

@RestController
public class HelloController {
	@Autowired
	private DemoService demoService;
	
	@RequestMapping("hello")	
	public String hello() {
		System.out.println("Hello SpringBoot1");
		return "Hello SpringBoot2";
		
	}
	@RequestMapping("demo")
	public String demo() {
		demoService.demo();
		return"demo ok";
	}
}
