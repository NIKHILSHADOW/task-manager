package com.example.taskmanager.users.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.taskmanager.users.customauth.UserDbService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {
	
	@Autowired JwtService jwtService;
	@Autowired UserDbService userDbService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String bearerToken = request.getHeader("Authorization");
		
		System.out.println(bearerToken);
		
		if(bearerToken != null && bearerToken.startsWith("Bearer ")) {
			String token = bearerToken.substring(7);
			
			System.out.println(token);
			
			String username = jwtService.extractUsername(token);
			
			System.out.println(username);
			
			if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = userDbService.loadUserByUsername(username);
				
				if(jwtService.validateToken(token, userDetails)) {
					System.out.println("validated");
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken 
								= new UsernamePasswordAuthenticationToken(userDetails,null,null);
					usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetails(request));
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				}
			}
			
		}
		
		
		filterChain.doFilter(request, response);
		
	}

}
