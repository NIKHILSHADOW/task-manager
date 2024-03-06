package com.example.taskmanager.users.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.taskmanager.users.dtos.UserRequest;
import com.example.taskmanager.users.dtos.UserResponse;
import com.example.taskmanager.users.models.User;
import com.example.taskmanager.users.repositories.UserRepository;

import lombok.Data;

@Service
@Data
public class UserService {

	private final UserRepository userRepository;
	private final UserConverterService userConverterService;
	
	public List<UserResponse> getAllUsers() {
		return userRepository
				.findAll()
				.stream()
				.map(user -> userConverterService.toUserResponse(user))
				.toList();
	}

	public UserResponse addUser(UserRequest userRequest) {
		// TODO Auto-generated method stub
		
		User user = userRepository.save(userConverterService.toUser(userRequest));
		
		return userConverterService
				.toUserResponse(user);
	}

	public UserResponse getById(Integer id) {
		// TODO Auto-generated method stub
		return userConverterService
				.toUserResponse(userRepository.findById(id).get());
	}

	public UserResponse updateUser(Integer id, UserRequest userRequest) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(id).get();
		user.setName(userRequest.getName() != null?userRequest.getName():user.getName());
		userRepository.save(user);
		return userConverterService.toUserResponse(user);
	}

	public String deleteUser(Integer id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		return "deleted";
	}
}
