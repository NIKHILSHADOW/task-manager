package com.example.taskmanager.users.customauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.taskmanager.users.models.User;
import com.example.taskmanager.users.repositories.UserRepository;

@Service
public class UserDbService implements UserDetailsService {
	
	@Autowired private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("userdbservice" + username);
		User user = userRepository.findByName(username).get();
		System.out.println(user.getName());
		return new UserDbUserDetails(user);
	}

}
