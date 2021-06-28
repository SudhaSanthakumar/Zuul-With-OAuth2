package com.example.ZuulClient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity()
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable().authorizeRequests()
		.antMatchers("/utilities/**").hasAnyRole("ADMIN","MANAGER","USER")
		.antMatchers("/**").permitAll()
	
		.and()		
		
		.logout().logoutSuccessUrl("/").permitAll();
		
		http.cors().disable();
		http.headers().frameOptions().disable();
		

			
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.eraseCredentials(false).inMemoryAuthentication()
		.withUser("Sam").password(encoder().encode("aaaa")).roles("ADMIN")
		.and()
		.withUser("Gaby").password(encoder().encode("bbbb")).roles("USER");
	}

	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
	
	 @Bean
	   public PasswordEncoder encoder() {
	      return NoOpPasswordEncoder.getInstance();
	   }
	 
	
	
	
	
	
	
	
	
	
}
