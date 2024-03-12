package com.example.taskmanager.tasks.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
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

import com.example.taskmanager.tasks.dtos.TaskRequest;
import com.example.taskmanager.tasks.dtos.TaskResponse;
import com.example.taskmanager.tasks.services.TaskService;
import com.example.taskmanager.users.dtos.ErrorResponse;

@RestController
@RequestMapping("/api/v0/tasks")
public class TaskController {
	
	@Autowired TaskService taskService;

	@GetMapping("/")
	public List<TaskResponse> getAllTasks(Principal principal) {
		System.out.println(principal.getName());
		return taskService.getAllTasks(principal);///
	}
	
	@PostMapping("/")
	public TaskResponse addTask(@RequestBody TaskRequest taskRequest, Principal principal){
		// check who is adding the task to whom and verify
//		System.out.println(user);
		return taskService.addTask(taskRequest, principal);
	}
	
	@GetMapping("/{id}")
	public TaskResponse getTaskById(@PathVariable("id") Integer id){
		return taskService.getTaskById(id);
	}
	
	
	@PatchMapping("/{id}")
	public TaskResponse updateTask(@PathVariable("id") Integer id, @RequestBody TaskRequest taskRequest){
		return taskService.updateTask(id, taskRequest);
	}
	
	@DeleteMapping("/{id}")
	public String deleteTask(@PathVariable("id") Integer id){
		return taskService.deleteTask(id);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleError(Exception e){
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(new ErrorResponse(e.getMessage()));
	}
}
