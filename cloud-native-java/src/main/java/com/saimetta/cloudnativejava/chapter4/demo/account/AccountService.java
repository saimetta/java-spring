package com.saimetta.cloudnativejava.chapter4.demo.account;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class AccountService {

	private final AccountRepository accountRepository;
	private final UserService userService;

	public AccountService(AccountRepository accountRepository,
						  UserService userService) {
		this.accountRepository = accountRepository;
		this.userService = userService;
	}
	
	public List<Account> getUserAccounts() {
		return Optional.ofNullable(userService.getAuthenticatedUser())
				.map( user -> accountRepository.findAccountByUsername(user.getUsername()))
				.orElse(Collections.emptyList());
	}
}
