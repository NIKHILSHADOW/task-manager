package com.example.taskmanager.users.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskmanager.users.dtos.ErrorResponse;
import com.example.taskmanager.users.dtos.UserRequest;
import com.example.taskmanager.users.dtos.UserResponse;
import com.example.taskmanager.users.services.UserService;

@RestController
@RequestMapping("/api/v0/users")
public class UserController {
	
	@Autowired UserService userService;

	@GetMapping("/")
	public List<UserResponse> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public UserResponse getUserById(@PathVariable("id") Integer id) {
		return userService.getById(id);
	}
	
	@PostMapping("/")
	public UserResponse addUser(@RequestBody UserRequest userRequest) {
		return userService.addUser(userRequest);
	}
	
	@PatchMapping("/{id}")
	public UserResponse updateUser(@PathVariable("id") Integer id, @RequestBody UserRequest userRequest) {
		return userService.updateUser(id, userRequest);
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable("id") Integer id) {
		return userService.deleteUser(id);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleExceptions(Exception e) {
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(new ErrorResponse(e.getMessage()));
	}
}
