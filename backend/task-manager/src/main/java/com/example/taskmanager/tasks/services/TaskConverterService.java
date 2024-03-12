package com.example.taskmanager.tasks.services;

import org.springframework.stereotype.Service;

import com.example.taskmanager.tasks.dtos.TaskRequest;
import com.example.taskmanager.tasks.dtos.TaskResponse;
import com.example.taskmanager.tasks.models.Level;
import com.example.taskmanager.tasks.models.Task;
import com.example.taskmanager.users.models.User;



@Service
public class TaskConverterService {

	public TaskResponse toTaskResponse(Task task) {
		return TaskResponse
				.builder()
				.id(task.getId())
				.name(task.getName())
				.description(task.getDescription())
				.dueDate(task.getDueDate())
				.createdByUserWithId(task.getCreatedByUser().getId())
				.createdTime(task.getCreatedTime())
				.build();
	}
	
	public Task toTask(TaskRequest taskRequest, User user, Level level) {
		
		
		return Task
				.builder()
				.name(taskRequest.getName())
				.description(taskRequest.getDescription())
				.dueDate(taskRequest.getDueDate())
				.level(level)
				.priority(taskRequest.getPriority())
				.createdByUser(user)
				.assignedToUserWithId(taskRequest.getAssignedToUserWithId())
				.build();
	}
}
