package com.cloudnative.java.chaper8.auth.accounts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long>{

	Optional<Account> findByUsername(String username);
}
