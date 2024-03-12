package com.example.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.taskmanager.users.models.Role;
import com.example.taskmanager.users.models.User;
import com.example.taskmanager.users.repositories.UserRepository;

@SpringBootApplication
public class TaskManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
	}
	
	@Bean
	public User createAdmin(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		User user = new User(1,"admin",passwordEncoder.encode("admin"),Role.ADMIN,null);
		User user2 = userRepository.save(user);
		
		return user2;
	}
	
	

}
