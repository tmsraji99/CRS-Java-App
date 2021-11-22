package com.lti.service;

import com.lti.model.Student;

public interface StudentServiceInterface {

	void addCourse(Integer courseId, Student student);

	void dropCourse(Integer courseId, Student student);
	public void displaySelectedCourses(Student student);

}
