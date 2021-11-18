package com.lti.model;

import java.time.LocalDateTime;

public class SemesterRegistration {

	private Integer studentId;
	private Integer semester;
	LocalDateTime dateOfregistration;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getSemester() {
		return semester;
	}

	public void setSemester(Integer semester) {
		this.semester = semester;
	}

	public LocalDateTime getDateOfregistration() {
		return dateOfregistration;
	}

	public void setDateOfregistration(LocalDateTime dateOfregistration) {
		this.dateOfregistration = dateOfregistration;
	}

	public SemesterRegistration(Integer studentId, Integer semester, LocalDateTime dateOfregistration) {
		super();
		this.studentId = studentId;
		this.semester = semester;
		this.dateOfregistration = dateOfregistration;
	}

	public SemesterRegistration() {

	}

}
