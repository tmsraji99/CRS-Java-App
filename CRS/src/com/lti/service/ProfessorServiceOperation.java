package com.lti.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.lti.model.Professor;

public class ProfessorServiceOperation implements ProfessorServiceInterface {
CourseServiceInterface courseServiceInterface;
	Map<Integer, Professor> profCourses = new HashMap<Integer, Professor>();

	public Map<Integer, Professor> getProfCourses() {
		return profCourses;
	}

	public void setProfCourses(Map<Integer, Professor> profCourses) {
		this.profCourses = profCourses;
	}

	// select course by professsor
	public void selectCourse(Integer courseId, Professor professor) {
		profCourses.put(courseId, professor);
	}

	// deselect course by professor
	public void deselectCourse(Integer courseId, Professor professor) {
		profCourses.remove(courseId, professor);
	}

	// display list of courses selected by professor
	public void displaySelectedCoursesProfessor(Professor professor) {
		
		System.out.println(" displaySelectedCoursesProfessor..............");
	System.out.println(	profCourses.entrySet().stream().filter(a->a.getValue().getProfessorId().
				equals(professor.getProfessorId())).map(Map.Entry::getValue).
			collect(Collectors.toList()));
			
	}

}
