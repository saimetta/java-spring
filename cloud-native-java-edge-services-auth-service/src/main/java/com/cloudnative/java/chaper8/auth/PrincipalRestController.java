package com.cloudnative.java.chaper8.auth;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrincipalRestController {

	@RequestMapping("/user")
	/**
	 * java.security.Principal is the class provided by spring security that will be exchanged
	 * by an access token, it is the data representation of the token owner (person or entity). It will be converted to JSON
	 * 
	 */
	public Principal principal(Principal p) {
		return p;
	}
}
