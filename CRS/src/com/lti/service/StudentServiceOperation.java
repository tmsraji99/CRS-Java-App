package com.lti.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.lti.model.Course;
import com.lti.model.Grades;
import com.lti.model.Student;

public class StudentServiceOperation implements StudentServiceInterface {

	private Map<Integer,Student> hashMap = new HashMap<>();
	private Map<Long, Set<Course>> registerCourse = new HashMap<>();

	
	public Map<Integer, Student> getHashMap() {
		return hashMap;
	}

	public void setHashMap(Map<Integer, Student> hashMap) {
		this.hashMap = hashMap;
	}

	public Map<Long, Set<Course>> getRegisterCourse() {
		return registerCourse;
	}

	public void setRegisterCourse(Map<Long, Set<Course>> registerCourse) {
		this.registerCourse = registerCourse;
	}

	@Override
	public void addCourse(Integer courseId, Student student) {

		// CourseDummy courseDummy = new CourseDummy();

		// Course orElse =
		// courseDummy.listOfCourse().stream().filter(course->course.getCourseId()==courseId).findAny().orElse(null);

		hashMap.put(courseId, student);

	}

	@Override
	public void dropCourse(Integer courseId, Student student) {
		// TODO Auto-generated method stub

		hashMap.remove(courseId);
	}

	

	@Override
	public double calculatPayment(Student student) {

		Integer standardPayment = 10000;
		Integer scholarshipPercentage = 5;
		double payableAmount = standardPayment * (100 - scholarshipPercentage);
		return payableAmount;

	}

	@Override
	public void registerCourse(Long studentId, Set<Course> courses) {
		// TODO Auto-generated method stub
         registerCourse.put(studentId, courses);
	}

	@Override
	public List<List<Grades>> viewGrades(String semester, Integer student_id, Integer year) {

		return null;
	}
}
