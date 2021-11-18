package com.lti.model;

public class Grades {

	String title;
	String date;
	String type;
	Integer grade;
	String coursename;

	public Grades(String coursename, String title, String date, String type, Integer grade) {
		this.coursename = coursename;
		this.title = title;
		this.date = date;
		this.type = type;
		this.grade = grade;
	}

	public Grades() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	@Override
	public String toString() {
		return "Grades{" + "title='" + title + '\'' + ", date='" + date + '\'' + ", type='" + type + '\'' + ", grade="
				+ grade + ", coursename='" + coursename + '\'' + '}';
	}
}
