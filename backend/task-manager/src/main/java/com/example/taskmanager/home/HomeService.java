package com.example.taskmanager.home;

import java.security.Principal;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

	public String getMyProfile(Principal principal) {
		// TODO Auto-generated method stub
		return principal.getName();
	}

}
