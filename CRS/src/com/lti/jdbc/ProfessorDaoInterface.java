package com.lti.jdbc;

import java.util.List;

import com.lti.model.Course;
import com.lti.model.Professor;


public interface ProfessorDaoInterface {

	public void selectCourse(int courseId ,Professor professor);
	public void deselectCourse(int courseId, Professor professor);
	public List<Course> displaySelectedCoursesProfessor(Professor professor);

}
