package com.lti.model;

public class Student extends User {

	private Integer StudentId;
	private String name;
	private String gender;
	private Integer phoneNumber;
	private Integer semester;
	private String branch;
	private Boolean registrationStatus;
	private Integer scholarshipPercentage;
	private Boolean adminStatus;

	public Boolean getRegistrationStatus() {
		return registrationStatus;
	}

	public void setRegistrationStatus(Boolean registrationStatus) {
		this.registrationStatus = registrationStatus;
	}

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

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer i) {
		this.phoneNumber = i;
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

	public Integer getScholarshipPercentage() {
		return scholarshipPercentage;
	}

	public void setScholarshipPercentage(Integer scholarshipPercentage) {
		this.scholarshipPercentage = scholarshipPercentage;
	}

	public Boolean getAdminStatus() {
		return adminStatus;
	}

	public void setAdminStatus(Boolean adminStatus) {
		this.adminStatus = adminStatus;
	}

}
