package com.example.taskmanager.users.services;

import org.springframework.stereotype.Service;

import com.example.taskmanager.users.dtos.UserRequest;
import com.example.taskmanager.users.dtos.UserResponse;
import com.example.taskmanager.users.models.Role;
import com.example.taskmanager.users.models.User;

@Service
public class UserConverterService {

	
	public User toUser(UserRequest userRequest) {
		
		Role role = Role.STUDENT;
		
		if(userRequest.getRole().equals("teacher")) {
			role = Role.TEACHER;
		}else if(userRequest.getRole().equals("admin")) {
			role = Role.ADMIN;
		}
		return 
				new User(
						null,
						userRequest.getName(),
						userRequest.getPassword(),
						role
						);
	}
	
	public UserResponse toUserResponse(User user) {
		return UserResponse
				.builder()
				.id(user.getId())
				.name(user.getName())
				.build();
	}
}
