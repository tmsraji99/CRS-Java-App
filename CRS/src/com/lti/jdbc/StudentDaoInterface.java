package com.lti.jdbc;

import java.util.List;

import com.lti.model.Course;
import com.lti.model.Student;

public interface StudentDaoInterface {

	public void addCourse(int courseId ,Student student) ;
	public void dropCourse(int courseId, Student student);
	public List<Course> displaySelectedCourses(Student student);

}
