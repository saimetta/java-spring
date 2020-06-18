package com.cloudnative.java.chaper8.greetings;

public class GreetDto {

	private String name;

	public GreetDto() {
	}
	
	public GreetDto(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
