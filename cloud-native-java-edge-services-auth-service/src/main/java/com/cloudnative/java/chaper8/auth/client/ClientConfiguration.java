package com.cloudnative.java.chaper8.auth.client;

import java.util.Collections;
import java.util.Optional;

import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

@Configuration
public class ClientConfiguration {

	private final LoadBalancerClient loadBalancerClient;
	
	public ClientConfiguration(LoadBalancerClient loadBalancerClient) {
		this.loadBalancerClient = loadBalancerClient;
	}
	
	@Bean
	public ClientDetailsService clientDetailsService(ClientRepository clientRepository) {
		return clientId -> clientRepository.findByClientId(clientId)
				.map(client -> {
							BaseClientDetails details = new BaseClientDetails(client.getClientId(), 
																			  null, 
																			  client.getScopes(), 
																			  client.getAuthorizedGrantTypes(), 
																			  client.getAuthorities());
							details.setClientSecret(client.getSecret());
							//If true, all the requested scopes will be conferred with the authentication
							//details.setAutoApproveScopes(Arrays.asList(client.getAutoApproveScopes().split(",")));
							
							String greetingsClientsRedirectUri = Optional.ofNullable(
									loadBalancerClient.choose("greetings-client")).map( service -> String.format("http://%s:%s/", service.getHost(), service.getPort()))
									.orElseThrow( () -> new ClientRegistrationException("Couldnt find and bind a greetings-client IP"));
							details.setRegisteredRedirectUri( Collections.singleton(greetingsClientsRedirectUri));
							return details;
						}
				).orElseThrow(() -> new ClientRegistrationException(String.format("No client %s registered",clientId)));
	}
}
