package com.lti.service;

import com.lti.model.Student;


public interface GradeServiceInterface {
	
	public void displayGrades(Student student);
	public void uploadGrades(Integer studentId, Integer courseId, String grade);

}
