package com.cloudnative.java.chaper8.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

	private final AuthenticationManager authenticationManager;
	private final ClientDetailsService clientDetailsService;
	
	public AuthorizationServerConfiguration(AuthenticationManager authenticationManager,
			ClientDetailsService clientDetailsService
			) {
		this.authenticationManager = authenticationManager;
		this.clientDetailsService = clientDetailsService; 
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		//configure the oauth clients
		clients.withClientDetails(clientDetailsService);
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		//Connect Spring security oauth with spring security by the AuthenticationManager instance
		endpoints.authenticationManager(authenticationManager);
	}
}
