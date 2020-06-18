package com.saimetta.cloudnativejava.chapter3.demo.account;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.saimetta.cloudnativejava.chapter4.demo.account.Account;
import com.saimetta.cloudnativejava.chapter4.demo.account.AccountNumber;
import com.saimetta.cloudnativejava.chapter4.demo.account.AccountRepository;
import com.saimetta.cloudnativejava.chapter4.demo.account.AccountService;
import com.saimetta.cloudnativejava.chapter4.demo.account.Application;
import com.saimetta.cloudnativejava.chapter4.demo.account.User;
import com.saimetta.cloudnativejava.chapter4.demo.account.UserService;

@SpringBootTest(classes = Application.class)
@ContextConfiguration
@RunWith(SpringRunner.class)
class AccountServiceTests {
	
	@Autowired
	@MockBean
	private UserService userService;
	@Autowired
	@MockBean
	private AccountRepository accountRepository;
	
	private AccountService accountService;

	@BeforeEach
	void setUp() throws Exception {
		accountService = new AccountService(accountRepository, userService);
	}

	@Test
	void getUserAccountsReturnsSingleAccount() {
		
		
		List<Account> accountList = Collections.singletonList(new Account("tino", new AccountNumber("123456")));
		User user = new User("tino","Santiago","Aime","tino@bla.com");

		
		Mockito.when(accountRepository.findAccountByUsername("tino"))
			   .thenReturn(accountList);
		
		Mockito.when(userService.getAuthenticatedUser())
		.thenReturn(user);
		
		List<Account> actual = accountService.getUserAccounts();
		
		assertEquals(1, actual.size());
	}

}
