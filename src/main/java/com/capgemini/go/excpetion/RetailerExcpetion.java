package com.capgemini.go.excpetion;

public class RetailerExcpetion extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RetailerExcpetion() {
		super();
	}

	public RetailerExcpetion(String message, Throwable cause) {
		super(message, cause);
	}

	public RetailerExcpetion(String message) {
		super(message);
	}
}
