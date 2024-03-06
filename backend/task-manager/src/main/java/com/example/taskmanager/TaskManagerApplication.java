package com.example.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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
	public User createAdmin(UserRepository userRepository) {
		User user = new User(1,"admin","admin",Role.ADMIN);
		User user2 = userRepository.save(user);
		
		return user2;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
