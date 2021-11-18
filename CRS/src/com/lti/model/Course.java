package com.lti.model;

public class Course {
	private Integer courseId;
	private String courseTitle;
	private Integer credits;
	private Integer catalogId;
	private Integer semester;
	
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
	public Course(Integer courseId, String courseTitle, String courseDescription, Integer credits, Integer catalogId, Integer semester,
			String time_stamp, Integer studentsEnrolled, String grade) {
		super();
		this.courseId = courseId;
		this.courseTitle = courseTitle;
		this.credits = credits;
		this.catalogId = catalogId;
		this.semester = semester;
		this.time_stamp = time_stamp;
		this.studentsEnrolled = studentsEnrolled;
		this.grade = grade;
	}
	public Course() {
		super();
	}
	
	

}
