package com.example.SpringBootDemo.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (username.equals("admin")) {
			return User.withUsername("admin").password("$2a$13$/jFVC5/4BMTnRNKDZFjny.zaDv/gPAqIIW8/168iQ2zPNslnkG6u2") // "password"
					.roles("ADMIN").build();
		}
		throw new UsernameNotFoundException("User not found");
	}
}
