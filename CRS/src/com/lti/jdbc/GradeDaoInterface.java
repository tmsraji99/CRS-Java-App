package com.lti.jdbc;

import java.util.List;

import com.lti.model.Course;
import com.lti.model.Student;


public interface GradeDaoInterface {

	public List<Course> displayGrades(Student student);
	public void uploadGrades(int studentId, int courseId, String grade);
}
