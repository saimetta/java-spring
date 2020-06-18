package com.saimetta.cloudnativejava.chapter4.demo.account;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AccountRepository {

	public List<Account> findAccountByUsername(String username) {
		//TODO: implement me :)
		return new ArrayList();
	}
}
