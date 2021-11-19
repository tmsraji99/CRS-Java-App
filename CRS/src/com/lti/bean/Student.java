package com.lti.bean;

public class Student {

	private Integer StudentId;
	private String name;
	private String gender;
	private Long phoneNumber;
	private Integer semester;
	private String branch;
	private Boolean registrationStatus;
	private Integer scholarshipPercentage;
	public Integer getStudentId() {
		return StudentId;
	}
	public void setStudentId(Integer studentId) {
		StudentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Integer getSemester() {
		return semester;
	}
	public void setSemester(Integer semester) {
		this.semester = semester;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public Boolean getRegistrationStatus() {
		return registrationStatus;
	}
	public void setRegistrationStatus(Boolean registrationStatus) {
		this.registrationStatus = registrationStatus;
	}
	public Integer getScholarshipPercentage() {
		return scholarshipPercentage;
	}
	public void setScholarshipPercentage(Integer scholarshipPercentage) {
		this.scholarshipPercentage = scholarshipPercentage;
	}
	
	
	
}
