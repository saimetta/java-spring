package com.cloudnative.java.chaper8.auth.client;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long>{
	
	public Optional<Client> findByClientId(String clientId);
}
