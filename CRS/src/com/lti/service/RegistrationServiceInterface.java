package com.lti.service;

import com.lti.model.Student;

public interface RegistrationServiceInterface {
	public boolean checkCourseSelectionStatus(Student student);

	public void submitRegistration(Student student);

	public void generateRegistrationReciept(Student student, double payableAmount, int payModeId);

	public void displayRegisteredStudentsInCourse(int courseId);

}
