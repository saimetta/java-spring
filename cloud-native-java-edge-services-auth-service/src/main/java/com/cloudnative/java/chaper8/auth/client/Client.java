package com.cloudnative.java.chaper8.auth.client;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.util.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {

	@Id
	@GeneratedValue
	private Long id;
	private String clientId;
	private String secret;
	
	private String scopes = StringUtils.arrayToCommaDelimitedString(new String[] {"openid"});
	private String authorizedGrantTypes = StringUtils.arrayToCommaDelimitedString(new String[] {"authorization_code", "refresh_token", "password"});
	private String authorities = StringUtils.arrayToCommaDelimitedString(new String[] {"ROLE_USER", "ROLE_ADMIN"});
	private String autoApproveScopes = StringUtils.arrayToCommaDelimitedString(new String[] {".*"});
	
	public Client(String clientId, String clientSecret) {
		this.clientId = clientId;
		this.secret = clientSecret;
	}
}
