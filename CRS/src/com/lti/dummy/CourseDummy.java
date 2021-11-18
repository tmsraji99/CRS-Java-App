package com.lti.dummy;

import java.util.HashSet;
import java.util.Set;

import com.lti.model.Course;

public class CourseDummy {

	public final Set<Course> listOfCourse() {

		Set<Course> coursesList = new HashSet<Course>();
		coursesList.add(new Course(1, "DB", "DatatBase", 8, 1, 1, null, 0, null));
		coursesList.add(new Course(2, "Os", "DatatBase", 8, 2, 1, null, 0, null));
		coursesList.add(new Course(3, "DS", "DatatBase", 8, 3, 2, null, 0, null));
		coursesList.add(new Course(4, "CD", "DatatBase", 8, 4, 2, null, 0, null));
		coursesList.add(new Course(5, "Java", "DatatBase", 8, 5, 3, null, 0, null));
		coursesList.add(new Course(6, "Python", "DatatBase", 8, 6, 3, null, 0, null));
		coursesList.add(new Course(7, "Proj1", "DatatBase", 8, 7, 4, null, 0, null));
		coursesList.add(new Course(8, "Proj2", "DatatBase", 8, 9, 4, null, 0, null));

		return coursesList;
	}

}
