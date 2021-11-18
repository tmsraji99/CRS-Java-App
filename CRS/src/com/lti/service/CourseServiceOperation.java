package com.lti.service;

import java.util.HashMap;

import com.lti.dummy.CourseDummy;
import com.lti.exception.CourseNotFoundException;
import com.lti.model.Course;
import com.lti.model.Student;

public class CourseServiceOperation implements CourseServiceInterface{

	HashMap<Integer, Course> courseList = new HashMap<Integer, Course>();

	public HashMap<Integer, Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(HashMap<Integer, Course> courseList) {
		this.courseList = courseList;
	}
	
	// display list of available courses for student 
	public void displayCourses(Student student) {
		
			}
	// insert a new course in database
	public void insertCourse(Course course) {
	
		courseList.put(course.getCourseId(), course);
	}

	//delete an existing course
	public void deleteCourse(Integer courseId)throws CourseNotFoundException{
		courseList.remove(courseId);
	}

	//display available courses for professor to select
	public void displayCoursesProfessor() {
		System.out.println(" List of courses....");
		courseList.entrySet().forEach(a->System.out.println(a));
	}



}
