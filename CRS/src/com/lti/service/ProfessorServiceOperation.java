package com.lti.service;

import java.util.List;

import com.lti.dao.ProfessorDaoInterface;
import com.lti.dao.ProfessorDaoOperation;
import com.lti.model.Course;
import com.lti.model.Professor;

public class ProfessorServiceOperation implements ProfessorServiceInterface {
	ProfessorDaoInterface professorDao= new ProfessorDaoOperation();

	// select course by professsor
	public void selectCourse(Integer courseId ,Professor professor){
		professorDao.selectCourse(courseId, professor);
	}

	// deselect course by professor
	public void deselectCourse(Integer courseId, Professor professor){
		professorDao.deselectCourse(courseId, professor);
	}

	//display list of courses selected by professor
	public void displaySelectedCoursesProfessor(Professor professor){
		System.out.println("********************************LIST OF SELECTED COURSES******************************");	
		System.out.println("COURSE ID      COURSE TITLE                         NUMBER OF STUDENTS ENROLLED");
		List<Course> courses = professorDao.displaySelectedCoursesProfessor(professor);
		courses.forEach(course -> System.out.println(course.getCourseId()+"               "+course.getCourseTitle()+"                               "+course.getStudentsEnrolled()));

		System.out.println("*****************************************************************************************");
	}

}
