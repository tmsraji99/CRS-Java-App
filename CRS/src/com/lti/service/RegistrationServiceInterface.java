package com.lti.service;

import com.lti.model.Student;

public interface RegistrationServiceInterface {
	public boolean checkCourseSelectionStatus(Student student);

	public void submitRegistration(Student student);

	public void generateRegistrationReciept(Student student, Double payableAmount, Integer payModeId);

	public void displayRegisteredStudentsInCourse(Integer courseId);

}
