package com.saimetta.cloudnativejava.chapter2;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

 private Long id;

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