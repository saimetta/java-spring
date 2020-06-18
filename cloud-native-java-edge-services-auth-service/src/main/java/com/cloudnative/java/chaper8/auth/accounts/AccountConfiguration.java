package com.cloudnative.java.chaper8.auth.accounts;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class AccountConfiguration {

	
	@Bean
	public UserDetailsService userDetailsService(AccountRepository accountRepository) {
		return username -> accountRepository.findByUsername(username)
				.map( account -> {
					boolean active = account.getActive();
					return new User(account.getUsername(), account.getPassword(), active, active, active, active, AuthorityUtils.createAuthorityList("ROLE_ADMIN","ROLE_USER"));
				}).orElseThrow(
						() -> new UsernameNotFoundException(
								String.format("Username %s not found!", username)
						));
	}
}
