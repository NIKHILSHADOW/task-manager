package com.example.taskmanager.users.dtos;

import com.example.taskmanager.users.models.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {

	private String name;
	
	private String password;
	
	private String role;
}
