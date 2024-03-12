package com.example.taskmanager.tasks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.taskmanager.tasks.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

	@Query(value = "select * from tasks t1 where t1.id = (select u1.id from users u1 where u1.name = ?1)",nativeQuery = true)
	public List<Task> findAllByUserName(String username);

}
