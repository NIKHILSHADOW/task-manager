package com.example.taskmanager.tasks.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0/tasks")
public class TaskController {

	@GetMapping("/")
	public String helloWorld() {
		return "tasks";
	}
}