package com.springboot.jpa.h2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String Hello() {
		return "Hello - Welcome to my JAVA PP";
	}
}
