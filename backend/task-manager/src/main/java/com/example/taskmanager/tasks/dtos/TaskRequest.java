package com.example.taskmanager.tasks.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskRequest {

	private String name;
	
	private String description;
	
	private Date dueDate;
	
	private String level;
	
	private Integer priority;
	
	private Integer assignedToUserWithId;
}
