package com.lti.jdbc;

import java.util.List;

import com.lti.model.Notification;
import com.lti.model.Student;


public interface RegistrationDaoInterfacce {
	public boolean numberOfCoursesSelected (Student student);
	public void submitRegistration (Student student);
	public void generateRegistrationReciept(Student student, double payableAmount, int payModeId);
	public Notification showRegistrationReciept(Student student);
	public List<Integer> displayRegisteredStudentsInCourse(int courseId);

}
