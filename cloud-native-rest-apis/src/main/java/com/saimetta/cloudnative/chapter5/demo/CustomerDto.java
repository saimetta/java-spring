package com.saimetta.cloudnative.chapter5.demo;

import org.springframework.hateoas.RepresentationModel;

public class CustomerDto extends RepresentationModel<CustomerDto> {
	 private Long id;

	 private String email;
	 
	 public CustomerDto() {
		 
	 }
	 
	 public CustomerDto(String email) {
		 this.email = email;
	 }

	 public CustomerDto(Long id, String email) {
		 this.id = id;
		 this.email = email;
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
