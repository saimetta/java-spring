package com.cloudnative.java.chaper8.relay;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.client.RestTemplate;

import feign.RequestInterceptor;

@Configuration
@ConditionalOnWebApplication
@ConditionalOnClass(EnableResourceServer.class)
public class TokenRelayAutoConfiguration {

	public static final String SECURE_PROFILE = "secure";

	
	/**
	 * 
	 * Install a plain load balanced resttemplate in the non secure profile
	 */
	@Configuration
	//non secure (!)
	@Profile("!" + SECURE_PROFILE)
	public static class RestTemplateConfiguration {
		@Bean
		@LoadBalanced
		RestTemplate simpleRestTemplate() {
			return new RestTemplate();
		}
	}

	/**
	 * Install a secure load balanced resttemplate that if a oauth2 token is present it will propagate it
	 * for the secure profile
	 */
	@Configuration
	@Profile(SECURE_PROFILE)
	public static class SecureRestTemplateConfiguration {

		@Bean
		@Lazy
		@LoadBalanced
		OAuth2RestTemplate anOAuth2RestTemplate(UserInfoRestTemplateFactory factory) {
			return factory.getUserInfoRestTemplate();
		}
	}

	/**
	 * Will propage the access token for feign invocations
	 */
	@Configuration
	@Profile(SECURE_PROFILE)
	@ConditionalOnClass(RequestInterceptor.class)
	@ConditionalOnBean(OAuth2ClientContextFilter.class)
	public static class FeignAutoConfiguration {

		@Bean
		RequestInterceptor requestInterceptor(OAuth2ClientContext clientContext) {
			//sets the authorization header, like Authorization: Bearer <access_token_value>
			return requestTemplate -> requestTemplate.header(HttpHeaders.AUTHORIZATION,
					clientContext.getAccessToken().getTokenType() + ' ' + clientContext.getAccessToken().getValue());
		}
	}
}
