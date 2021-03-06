package com.lti.service;

import java.util.List;

import com.lti.dao.CourseDaoInterface;
import com.lti.dao.CourseDaoOperation;
import com.lti.exception.CourseNotFoundException;
import com.lti.model.Course;
import com.lti.model.Student;

public class CourseServiceOperation implements CourseServiceInterface {

	CourseDaoInterface courseDao = new CourseDaoOperation();

	public void displayCoursesStudent(Student student) {
		System.out.println(
				"****************************************LIST OF AVAILABLE COURSES*****************************************1****");
		System.out.println(
				"COURSE ID      COURSE TITLE                          COUSRE DESCRIPTION                         CREDITS         ");
		List<Course> courses = courseDao.displayCourses(student);
		for (Course course : courses) {
			//if (course.getStudentsEnrolled() < 10) {
				System.out
						.println(course.getCourseId() + "               " + course.getCourseTitle() + "               "
								+ course.getCourseDescription() + "                  " + course.getCredits());
			//}
		}
		System.out.println(
				"*************************************************************************************************************");
	}

	// insert a new course in database
	public void insertCourse(Course course) {
		courseDao.insertCourse(course);
	}

	// delete an existing course
	public void deleteCourse(Integer courseId) throws CourseNotFoundException {
		courseDao.deleteCourse(courseId);
	}

	// display available courses for professor to select
	public void displayCoursesProfessor() {
		System.out.println("****************************LIST OF AVAILABLE COURSES************************************");
		System.out.println("COURSE ID      COURSE TITLE                          COUSRE DESCRIPTION             ");
		List<Course> courses = courseDao.displayCoursesProfessor();
		courses.forEach(course ->System.out.println(course.getCourseId()+"               "+course.getCourseTitle()+"               "+course.getCourseDescription()));

		System.out.println("******************************************************************************************");

	}

}
