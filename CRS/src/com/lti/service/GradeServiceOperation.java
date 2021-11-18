package com.lti.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.lti.model.Course;
import com.lti.model.Student;

public class GradeServiceOperation implements GradeServiceInterface {

	// display grades for a student against courseId
	public void displayGrades(Student student) {

		System.out.println("***********************************REPORT CARD******************************");
		System.out.println("COURSE ID      COURSE TITLE                     GRADE");
		List<Course> courses = new CourseServiceOperation().getCourseList().entrySet().stream().map(Map.Entry::getValue)
				.collect(Collectors.toList());

		courses.forEach(course -> System.out.println(course.getCourseId() + "               " + course.getCourseTitle()
				+ "                       " + course.getGrade()));

		System.out.println("*****************************************************************************");
	}

	Map<Integer, HashMap<Integer, String>> hashMap = new HashMap<Integer, HashMap<Integer, String>>();

	// upload grades against a studentId and courseId by professor
	public void uploadGrades(Integer studentId, Integer courseId, String grade) {
		HashMap<Integer, String> hashMap2 = new HashMap<Integer, String>();
		hashMap2.put(courseId, grade);
		hashMap.put(studentId, hashMap2);
	}

}
