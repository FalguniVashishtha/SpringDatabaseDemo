package com.example.demo.exception;

public class UserException extends Exception {

	private static final long serialVersionUID = 1L;

	String message;

	public UserException() {
		super();
	}

	public UserException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
}
