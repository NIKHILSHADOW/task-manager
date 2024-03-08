package com.example.taskmanager.tasks.models;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "tasks")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String description;
	
	private Date dueDate;
	
	private Level level;
	
	private Integer priority;
	
	@CreationTimestamp
	private Date createdTime;
	
	@UpdateTimestamp
	private Date updatedTime;
	
	private Integer createdByUserWithId;
	
	
	private Integer assignedToUserWithId;
}
