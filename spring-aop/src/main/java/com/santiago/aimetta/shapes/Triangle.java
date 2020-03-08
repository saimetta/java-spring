package com.santiago.aimetta.shapes;

import org.springframework.stereotype.Component;

import com.santiago.aimetta.shapes.aspect.Loggable;

@Component
public class Triangle {

	private String name;

	@Loggable
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public String setNameAndReturn(String name) {
		setName(name);
		return "New name:"+name;
	}
	
	public void throwRuntime() {
		throw new RuntimeException("It failed :)");
	}
}
