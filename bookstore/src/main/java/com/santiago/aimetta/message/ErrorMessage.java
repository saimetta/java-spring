package com.santiago.aimetta.message;

public class ErrorMessage extends Message {

	
	public ErrorMessage() {
		super();
	}

	public ErrorMessage(String text) {
		super(text);
	}
	
	@Override
	protected String getMessageName() {
		return "Error message";
	}
}
