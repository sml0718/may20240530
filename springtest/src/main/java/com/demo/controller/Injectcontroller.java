package com.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Injectcontroller {
	
	@Value("${name}")
	public String name;
	
	@Value("${age}")
	public Integer age;
	
	@Value("${birthday}")
	public Date birthday;
	
	@Value("${gender}")
	public boolean gender;
	
	@RequestMapping("inject")
	public String inject() {
		System.out.println(name);
		System.out.println(age);
		System.out.println(birthday);
		System.out.println(gender);
		
		return "Injeck ok";
	}
	

}
