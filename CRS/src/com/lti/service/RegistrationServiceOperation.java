package com.lti.service;

import java.util.List;

import com.lti.dao.RegistrationDaoInterfacce;
import com.lti.dao.RegistrationDaoOperation;
import com.lti.model.Student;


public class RegistrationServiceOperation implements RegistrationServiceInterface {

	RegistrationDaoInterfacce registrationDaoOperation = new RegistrationDaoOperation();
	// checks if student has selected exactly  4 courses or not
	public boolean checkCourseSelectionStatus(Student student) {
	return	registrationDaoOperation.numberOfCoursesSelected(student);
	
	}

	// submit registration for student
	public void submitRegistration (Student student) {
		registrationDaoOperation.submitRegistration(student);
	}

	// generate student registration details and store them in database
	public void generateRegistrationReciept(Student student, Double payableAmount, Integer payModeId){
		registrationDaoOperation.generateRegistrationReciept(student, payableAmount, payModeId);
	}

	// display studentID of students enrolled in a course
	public void displayRegisteredStudentsInCourse(Integer courseId){
		System.out.println("*********************STUDENTS ENROLLED******************************");	
		System.out.println("STUDENT ID");
		List<Integer> students = registrationDaoOperation.displayRegisteredStudentsInCourse(courseId);
		students.forEach(student -> System.out.println(student));


	}

}
