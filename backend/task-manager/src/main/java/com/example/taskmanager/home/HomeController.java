package com.example.taskmanager.home;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class HomeController {
	
	@Autowired HomeService homeService;

	@RequestMapping("/")
	public String welcome(HttpServletRequest httpServletRequest) {
		
		return httpServletRequest.getSession().getId();
	}
	
	@GetMapping("/profile")
	public String getMyProfile(Principal principal) {
		return homeService.getMyProfile(principal);
	}
	
	@GetMapping("/login1")
	public String getToken(Principal principal) {
		return homeService.generateToken(principal.getName());
	}
	
	
	@RequestMapping("/**")
	public String error() {
		return "Not Found";
	}
}
