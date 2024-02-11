package com.jac.library.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class securityConfig {


	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
		
		http
		.authorizeHttpRequests(configurer -> 
		configurer 
			.requestMatchers("/books/list").hasRole("USER")
			.requestMatchers("/books/editBook/**").hasRole("ADMIN")
			.requestMatchers("/books/searchBook/**").hasRole("USER")
				.requestMatchers("/images/**","/css/**").permitAll()
		    .anyRequest().authenticated()
				)

		.formLogin(form -> 
		form
		.loginPage("/showMyLoginPage")
		.loginProcessingUrl("/authenticateTheUser")
		.permitAll()
			)
		.logout(logout -> logout.permitAll())
		.exceptionHandling(configurer ->
		configurer
		.accessDeniedPage("/access-denied")
		);
		return http.build();
			
	}
}
