package com.example.SpringBootDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

	@GetMapping("/home")
	public String home() {
		return "Welcome to the Shopping Service. We are secured!";
	}

	@GetMapping("/api/test/hello")
	public String sayHello() {
		return "Hello, you are authorized!";
	}
}
