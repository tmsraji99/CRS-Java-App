package com.lti.model;

public class Student extends User{
	
	private Integer StudentId;
	private String name;
	private String gender;
	private Long phoneNumber;
	private Integer semester;
	private String branch;
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
	public void setPhoneNumber(long i) {
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
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Student(Integer studentId, String name, String gender, Long phoneNumber, Integer semester, String branch,
			Integer scholarshipPercentage) {
		super();
		StudentId = studentId;
		this.name = name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.semester = semester;
		this.branch = branch;
		this.scholarshipPercentage = scholarshipPercentage;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	

}
