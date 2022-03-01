package com.example.demo.exception;

public class SourceNotFoundException extends RuntimeException {

	
	
	private static final long serialVersionUID = 1L;

	public SourceNotFoundException(String message) {
		super(message);
	}
}
