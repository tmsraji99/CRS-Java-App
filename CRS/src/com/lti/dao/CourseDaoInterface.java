package com.lti.dao;

import java.util.List;

import com.lti.exception.CourseNotFoundException;
import com.lti.model.Course;
import com.lti.model.Student;


public interface CourseDaoInterface {
	public List<Course> displayCourses(Student student);
	public void insertCourse(Course course) ;
	public void deleteCourse(Integer courseId) throws CourseNotFoundException;
	public List<Course> displayCoursesProfessor();

}
