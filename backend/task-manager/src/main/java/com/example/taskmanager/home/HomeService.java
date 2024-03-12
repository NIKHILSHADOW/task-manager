package com.example.taskmanager.home;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.example.taskmanager.users.jwt.JwtService;

@Service
public class HomeService {
	
	@Autowired JwtService jwtService;

	public String getMyProfile(Principal principal) {
		// TODO Auto-generated method stub
		return principal.getName();
	}

	public String generateToken(String username) {
		// TODO Auto-generated method stub
		return jwtService.generateToken(username);
	}

}
