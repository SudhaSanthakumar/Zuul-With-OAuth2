package com.example.zuul.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ZuulResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http
		.authorizeRequests()
		.antMatchers("/oauth/**").permitAll()
		.anyRequest()
		.authenticated();
		
		http.cors().disable();
		http.csrf().disable();
		
	}

	
}
