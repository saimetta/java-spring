package com.cloudnative.java.chaper8.auth.accounts;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {

	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String password;
	private Boolean active;
	
	 public Account(String username, String password, boolean active) {
	  this.username = username;
	  this.password = password;
	  this.active = active;
	 }
}
