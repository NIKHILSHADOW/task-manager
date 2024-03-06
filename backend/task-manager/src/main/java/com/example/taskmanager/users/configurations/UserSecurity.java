package com.example.taskmanager.users.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class UserSecurity {
	
	@Autowired PasswordEncoder passwordEncoder;

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails userDetails = User
									.builder()
									.username("root")
									.password(passwordEncoder.encode("root"))
									.build();
		
		return new InMemoryUserDetailsManager(userDetails);
	}
}
