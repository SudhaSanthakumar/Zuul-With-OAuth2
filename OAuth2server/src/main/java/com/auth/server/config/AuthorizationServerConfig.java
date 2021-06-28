package com.auth.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import com.auth.server.service.MyClientDetailsService;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	
	@Autowired
	private MyClientDetailsService clientDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	
	
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		

		security.checkTokenAccess("isAuthenticated()").tokenKeyAccess("permitAll()").allowFormAuthenticationForClients();

		
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		clients.withClientDetails(clientDetailsService);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		
	endpoints.authenticationManager(authenticationManager).userDetailsService(userDetailsService);
		
	}
	
	
	


}
