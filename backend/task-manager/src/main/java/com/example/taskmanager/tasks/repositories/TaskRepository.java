package com.example.taskmanager.tasks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taskmanager.tasks.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
