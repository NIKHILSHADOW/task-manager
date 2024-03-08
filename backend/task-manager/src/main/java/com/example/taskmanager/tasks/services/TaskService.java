package com.example.taskmanager.tasks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taskmanager.tasks.dtos.TaskRequest;
import com.example.taskmanager.tasks.dtos.TaskResponse;
import com.example.taskmanager.tasks.models.Level;
import com.example.taskmanager.tasks.models.Task;
import com.example.taskmanager.tasks.repositories.TaskRepository;

@Service
public class TaskService {
	
	@Autowired TaskRepository taskRepository;
	@Autowired TaskConverterService taskConverterService;

	public List<TaskResponse> getAllTasks() {
		
		return taskRepository
				.findAll()
				.stream()
				.map(task -> taskConverterService.toTaskResponse(task))
				.toList();
	}

	public TaskResponse addTask(TaskRequest taskRequest) {
		
		Level level = Level.EASY;
		
		if(taskRequest.getLevel().equals("medium")) {
			level = Level.MEDIUM;
		}else if(taskRequest.getLevel().equals("hard")) {
			level = Level.HARD;
		}
		
		//add principal
		Task task = taskConverterService
						.toTask(taskRequest, null, level);
		
		Task task2 = taskRepository.save(task);
		
		return taskConverterService
				.toTaskResponse(task2);
	}

	public TaskResponse getTaskById(Integer id) {
		// TODO Auto-generated method stub
		return taskConverterService
				.toTaskResponse(
						taskRepository
						.findById(id)
						.get()
				);
	}

	public TaskResponse updateTask(Integer id, TaskRequest taskRequest) {
		
		Task task = taskRepository.findById(id).get();
		
		updateTask(task, taskRequest);
		
		taskRepository.save(task);
		
		
		return taskConverterService.toTaskResponse(task);
	}

	private void updateTask(Task task, TaskRequest taskRequest) {
		
		if(taskRequest.getName() != null) {
			task.setName(taskRequest.getName());
		}
		
		if(taskRequest.getDescription() != null) {
			task.setDescription(taskRequest.getDescription());
		}
		
		if(taskRequest.getDueDate() != null) {
			task.setDueDate(taskRequest.getDueDate());
		}
		
		if(taskRequest.getAssignedToUserWithId() != null) {
			task.setAssignedToUserWithId(taskRequest.getAssignedToUserWithId());
		}
		
		if(taskRequest.getLevel() != null) {
			if(taskRequest.getLevel().equals("medium")) {
				task.setLevel(Level.MEDIUM);
			}else if(taskRequest.getLevel().equals("hard")) {
				task.setLevel(Level.HARD);
			}else {
				task.setLevel(Level.EASY);
			}
		}
	}

	public String deleteTask(Integer id) {
		// TODO Auto-generated method stub
		
		taskRepository.deleteById(id);
		
		return "deleted";
	}

}
