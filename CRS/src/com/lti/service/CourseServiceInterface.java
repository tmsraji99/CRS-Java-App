package com.lti.service;

import com.lti.exception.CourseNotFoundException;
import com.lti.model.Course;
import com.lti.model.Student;

public interface CourseServiceInterface {

	public void displayCoursesStudent(Student student);

	public void insertCourse(Course course);

	public void deleteCourse(Integer courseId) throws CourseNotFoundException;

	public void displayCoursesProfessor();
}
