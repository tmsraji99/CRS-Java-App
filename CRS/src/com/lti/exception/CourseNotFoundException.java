package com.lti.exception;

public class CourseNotFoundException extends Exception{
	public String getMessage() {
		String msg="No such course exists ! Verify course again ";
		return msg;
	}

}
