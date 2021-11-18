package com.lti.exception;

// invalid login exception
public class InvalidLoginException extends Exception {
	
	public String getMessage() {
		String msg="Username/ password incorrect! Please try again.. ";
		return msg;
	}

}
