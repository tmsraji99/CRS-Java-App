package com.lti.dao;

import java.util.List;

import com.lti.model.Course;
import com.lti.model.Student;

public interface StudentDaoInterface {

	public void addCourse(Integer courseId ,Student student) ;
	public void dropCourse(Integer courseId, Student student);
	public List<Course> displaySelectedCourses(Student student);
	

}
