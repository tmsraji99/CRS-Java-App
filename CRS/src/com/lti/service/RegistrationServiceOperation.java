package com.lti.service;

import com.lti.model.Student;


public class RegistrationServiceOperation implements RegistrationServiceInterface {

	// checks if student has selected exactly  4 courses or not
	public boolean checkCourseSelectionStatus(Student student) {

	return false;
	}

	// submit registration for student
	public void submitRegistration (Student student) {
		
	}

	// generate student registration details and store them in database
	public void generateRegistrationReciept(Student student, double payableAmount, int payModeId){
		
	}

	// display studentID of students enrolled in a course
	public void displayRegisteredStudentsInCourse(int courseId){
		

	}

}
