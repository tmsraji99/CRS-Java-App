package com.lti.service;

import com.lti.model.Professor;


public interface ProfessorServiceInterface {
	public void selectCourse(Integer courseId ,Professor professor);
	public void deselectCourse(Integer courseId, Professor professor);
	public void displaySelectedCoursesProfessor(Professor professor);

}
