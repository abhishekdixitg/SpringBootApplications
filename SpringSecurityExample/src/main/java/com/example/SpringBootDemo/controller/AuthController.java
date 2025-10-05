package com.example.SpringBootDemo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootDemo.service.JwtService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;

	public AuthController(JwtService jwtService, AuthenticationManager authenticationManager) {
		this.jwtService = jwtService;
		this.authenticationManager = authenticationManager;
	}

	@PostMapping("/login")
	public Map<String, String> authenticate(@RequestParam String username, @RequestParam String password) {
		Authentication auth = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		String token = jwtService.generateToken(auth.getName());

		Map<String, String> response = new HashMap<>();
		response.put("token", token);
		return response;
	}
}
