package com.example.taskmanager.users.jwt;

import java.security.Key;
import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SigningKeyResolver;

@Service
public class JwtService {
	
	public String generateToken(String username) {
		
		return Jwts
				.builder()
				.subject(username)
				.expiration(new Date(System.currentTimeMillis() + 5*60*1000))
				.signWith(SignatureAlgorithm.HS256, signInKey())
				.compact();
	}

	private String signInKey() {
		// TODO Auto-generated method stub
		return "MYSIGNINKEYPRIVATEKEY288u2u02023993ijenjnfufjeAFFDV45";
	}
	

	public String extractUsername(String token) {
		// TODO Auto-generated method stub
		return Jwts
				.parser()
				.setSigningKey(signInKey())
				.build()
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
				
	}

	public boolean validateToken(String token, UserDetails userDetails) {
		// TODO Auto-generated method stub
		System.out.println(extractUsername(token));
		System.out.println(userDetails.getUsername());
		return extractUsername(token).equals(userDetails.getUsername()) && isTokenNotExprired(token);
	}

	private boolean isTokenNotExprired(String token) {
		// TODO Auto-generated method stub
		return Jwts
				.parser()
				.setSigningKey(signInKey())
				.build()
				.parseClaimsJws(token)
				.getBody()
				.getExpiration().after(new Date(System.currentTimeMillis()));
	}

}
