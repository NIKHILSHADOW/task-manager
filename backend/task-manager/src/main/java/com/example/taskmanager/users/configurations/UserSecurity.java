package com.example.taskmanager.users.configurations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.example.taskmanager.users.customauth.UserDbService;

@EnableWebSecurity
@Configuration
public class UserSecurity {
	
	
//	private UserDetailsService userDetailsService = null;
//	private PasswordEncoder passwordEncoder = null;

	@Bean
	public UserDetailsService userDetailsService() {
//		UserDetails userDetails = User
//									.builder()
//									.username("root")
//									.password(passwordEncoder.encode("root"))
//									.build();
		
		return new UserDbService();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, CorsFilter corsFilter) throws Exception {
		
		httpSecurity
			.csrf(csrf -> csrf.disable())
			.cors(cors -> cors.disable())
			.authorizeHttpRequests(auth ->auth.anyRequest().authenticated())
			.addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
			.authenticationProvider(authenticationProvider())
			.formLogin(
					formLogin 
					-> 
					formLogin
			.permitAll()
			);
			
		
		
		return httpSecurity.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
//		if(authenticationProvider != null) return authenticationProvider;
		
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		
		return authenticationProvider;
	}
	
	
//	
//	@Bean
//	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//		return config.getAuthenticationManager();
//	}
	
	
//	 @Override
//	  public void addCorsMappings(CorsRegistry registry) {
//	    registry.addMapping("/**").allowedOrigins("http://localhost:3000").allowCredentials(true);
//	  }
	 
//	@Bean
//	  public CorsConfigurationSource corsConfigurationSource() {
//	    CorsConfiguration configuration = new CorsConfiguration();
//	    configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000/login"));
//	    configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
//	    configuration.setAllowedHeaders(Arrays.asList("*"));
//	    configuration.setAllowCredentials(true);
//
//	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	    source.registerCorsConfiguration("/**", configuration);
//	    return source;
//	  }
//
//	  @Override
//	  public void addCorsMappings(CorsRegistry registry) {
//	    registry.addMapping("/**").allowedOrigins("http://localhost:3000/login");
//	  }
	
}
