package com.saimetta.cloudnativejava.chapter2.boot;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

 @Id
 private Long id;

 public void setId(Long id) {
	this.id = id;
}

public void setEmail(String email) {
	this.email = email;
}

private String email;
 
 public Customer() {
	 
 }

 public Customer(Long id, String email) {
	 this.id = id;
	 this.email = email;
 }

 @Override
 public String toString() {
	 return "Customer{" + "id=" + id + ", email='" + email + '\'' + '}';
 }

 public Long getId() {
	 return id;
 }

 public String getEmail() {
	 return email;
 }
}