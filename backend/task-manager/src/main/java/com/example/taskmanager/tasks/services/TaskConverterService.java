package com.example.taskmanager.tasks.services;

import org.springframework.stereotype.Service;

import com.example.taskmanager.tasks.dtos.TaskRequest;
import com.example.taskmanager.tasks.dtos.TaskResponse;
import com.example.taskmanager.tasks.models.Level;
import com.example.taskmanager.tasks.models.Task;



@Service
public class TaskConverterService {

	public TaskResponse toTaskResponse(Task task) {
		return TaskResponse
				.builder()
				.name(task.getName())
				.description(task.getDescription())
				.dueDate(task.getDueDate())
				.createdByUserWithId(task.getCreatedByUserWithId())
				.createdTime(task.getCreatedTime())
				.build();
	}
	
	public Task toTask(TaskRequest taskRequest, Integer createdBy, Level level) {
		
		
		return Task
				.builder()
				.name(taskRequest.getName())
				.description(taskRequest.getDescription())
				.dueDate(taskRequest.getDueDate())
				.level(level)
				.priority(taskRequest.getPriority())
				.createdByUserWithId(createdBy)
				.assignedToUserWithId(taskRequest.getAssignedToUserWithId())
				.build();
	}
}
