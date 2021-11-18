package com.lti.model;

import java.util.List;

public class GradeCard {

private Integer studentid;
private Integer semester;
private float cpi;
private List<RegisteredCourse> registeredCourse=null;
public Integer getStudentid() {
	return studentid;
}
public void setStudentid(Integer studentid) {
	this.studentid = studentid;
}
public Integer getSemester() {
	return semester;
}
public void setSemester(Integer semester) {
	this.semester = semester;
}
public float getCpi() {
	return cpi;
}
public void setCpi(float cpi) {
	this.cpi = cpi;
}
public List<RegisteredCourse> getRegisteredCourse() {
	return registeredCourse;
}
public void setRegisteredCourse(List<RegisteredCourse> registeredCourse) {
	this.registeredCourse = registeredCourse;
}

}
