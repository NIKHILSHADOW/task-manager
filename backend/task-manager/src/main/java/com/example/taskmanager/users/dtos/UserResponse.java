package com.example.taskmanager.users.dtos;

import org.springframework.stereotype.Component;

import com.example.taskmanager.users.models.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

	private Integer id;
	
	private String name;
	
	private Role role;
}
