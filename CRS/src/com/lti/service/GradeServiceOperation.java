package com.lti.service;

import com.lti.dao.GradeDaoInterface;
import com.lti.dao.GradeDaoOperation;
import com.lti.model.Student;

public class GradeServiceOperation implements GradeServiceInterface {

	GradeDaoInterface gradeDao = new GradeDaoOperation();
	// display grades for a student against courseId
	public void displayGrades(Student student) {

		System.out.println("***********************************REPORT CARD******************************");
		System.out.println("COURSE ID      COURSE TITLE                     GRADE");

		gradeDao.displayGrades(student).forEach(course -> System.out.println(course.getCourseId() + "               "
				+ course.getCourseTitle() + "                       " + course.getGrade()));

		System.out.println("*****************************************************************************");
	}

	public void uploadGrades(Integer studentId, Integer courseId, String grade) {
		gradeDao.uploadGrades(studentId, courseId, grade);

	}

}
