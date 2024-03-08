package com.example.taskmanager.tasks.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TaskResponse {

	private String name;
	
	private String description;
	
	private Date dueDate;
	
	private Date createdTime;
	//
	private Integer createdByUserWithId;
}
