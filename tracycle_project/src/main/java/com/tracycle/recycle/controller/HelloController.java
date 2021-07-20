package com.tracycle.recycle.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	// TEST 중입니다!!!! 
	
	@GetMapping("/hello")
	public String hello(HttpServletRequest req) {
		req.setAttribute("data", "ssafy");
		return "result";
	}

}
