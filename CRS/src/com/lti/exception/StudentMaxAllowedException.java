package com.lti.exception;

public class StudentMaxAllowedException  extends Exception{

	public String getMessage() {
		String msg=" Student  Enrolled  Max Course ";
		return msg;
	}
}
