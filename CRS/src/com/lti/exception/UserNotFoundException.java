package com.lti.exception;

// user not found exception
public class UserNotFoundException extends Exception {

	public UserNotFoundException() {

	}

	public UserNotFoundException(String mesg) {
		super(mesg);
	}

}
