package com.nt.jai.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	//authentication
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			
		}
		
		//authorization
		@Override
		protected void configure(HttpSecurity http) throws Exception {
		
		}

}
