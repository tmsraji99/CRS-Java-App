package com.lti.model;

public class Course {
	private Integer courseId;
	private String courseTitle;
	private Integer credits;
	private Integer catalogId;
	private Integer semester;
	private String CourseDescription;
	private String branch;
	
	
	
	public String getCourseDescription() {
		return CourseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		CourseDescription = courseDescription;
	}
	public Integer getSemester() {
		return semester;
	}
	public void setSemester(Integer semester) {
		this.semester = semester;
	}
	public String getTime_stamp() {
		return time_stamp;
	}
	public void setTime_stamp(String time_stamp) {
		this.time_stamp = time_stamp;
	}

	private String time_stamp;
	private Integer studentsEnrolled;

	public Integer getStudentsEnrolled() {
		return studentsEnrolled;
	}
	public void setStudentsEnrolled(Integer studentsEnrolled) {
		this.studentsEnrolled = studentsEnrolled;
	}
	private String grade;
	
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	
	public Integer getCredits() {
		return credits;
	}
	public void setCredits(Integer credits) {
		this.credits = credits;
	}
	
	public Integer getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(Integer catalogId) {
		this.catalogId = catalogId;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}

}
