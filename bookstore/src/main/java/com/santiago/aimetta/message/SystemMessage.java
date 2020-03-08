package com.santiago.aimetta.message;

import javax.persistence.Entity;

@Entity
public class SystemMessage extends Message {


	public SystemMessage() {
		super();
	}

	public SystemMessage(String text) {
		super(text);
	}

	@Override
	protected String getMessageName() {
		return "System message";
	}
}
