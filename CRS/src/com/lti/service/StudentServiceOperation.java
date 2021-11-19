package com.lti.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.lti.dao.StudentDaoInterface;
import com.lti.dao.StudentDaoOperation;
import com.lti.model.Course;
import com.lti.model.Grades;
import com.lti.model.Student;

public class StudentServiceOperation implements StudentServiceInterface {
  



	StudentDaoInterface studentDaoOperation = new StudentDaoOperation();
	@Override
	public void addCourse(Integer courseId, Student student) {
		studentDaoOperation.addCourse(courseId, student);
	}

	@Override
	public void dropCourse(Integer courseId, Student student) {
		// TODO Auto-generated method stub
		studentDaoOperation.dropCourse(courseId, student);

	}

	public void displaySelectedCourses(Student student) {
		System.out.println("***********************************LIST OF SELECTED COURSES******************************");	
		System.out.println("COURSE ID      COURSE TITLE               CREDITS           TIME STAMP             ");
		List<Course> courses = studentDaoOperation.displaySelectedCourses(student);
		courses.forEach(course -> System.out.println(course.getCourseId()+"               "+course.getCourseTitle()+"                    "+course.getCredits()+"              "+course.getTime_stamp()));
		boolean status= student.getRegistrationStatus();
		if(status)
			System.out.println("++++++++++++++++++++++++++++REGISTRATION STATUS: COMPLETED ++++++++++++++++++++++++++++");
		else
			System.out.println("++++++++++++++++++++++++++++REGISTRATION STATUS: PENDING ++++++++++++++++++++++++++++++");

	}


	@Override
	public List<List<Grades>> viewGrades(String semester, Integer student_id, Integer year) {

		return null;
	}
}
