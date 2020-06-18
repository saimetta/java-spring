package com.saimetta.cloudnativejava.chapter5.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;

 private String email;
 
 public Customer() {
	 
 }
 
 public Customer(String email) {
	 this.email = email;
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
 
 public void setEmail(String email) {
	 this.email = email;
 }
}