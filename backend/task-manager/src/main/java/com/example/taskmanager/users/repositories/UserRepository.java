package com.example.taskmanager.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taskmanager.users.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
