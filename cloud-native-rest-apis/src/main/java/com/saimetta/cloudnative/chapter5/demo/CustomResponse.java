package com.saimetta.cloudnative.chapter5.demo;

public class CustomResponse {

	private String message;
	private Integer httpCode;
	private Object result;
	
	public CustomResponse() {
	}
	
	
	public CustomResponse(String message, Integer httpCode, Object result) {
		super();
		this.message = message;
		this.httpCode = httpCode;
		this.result = result;
	}


	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getHttpCode() {
		return httpCode;
	}
	public void setHttpCode(Integer httpCode) {
		this.httpCode = httpCode;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	
	
}
