package com.lti.service;

import java.util.List;
import java.util.Set;

import com.lti.model.Course;
import com.lti.model.Grades;
import com.lti.model.Student;

public interface StudentServiceInterface {

	void addCourse(Integer courseId, Student student);

	void dropCourse(Integer courseId, Student student);

	double calculatPayment(Student student);

	void registerCourse(Long studentId, Set<Course> courses);

	List<List<Grades>> viewGrades(String semester, Integer student_id, Integer year);

}
