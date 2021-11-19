package com.lti.service;

import java.util.HashMap;
import java.util.Map;

import com.lti.dao.UserDaoInterface;
import com.lti.dao.UserDaoOperation;
import com.lti.exception.InvalidLoginException;
import com.lti.model.Admin;
import com.lti.model.Professor;
import com.lti.model.Student;
import com.lti.model.User;

public class UserServiceOperation implements UserServiceInterface {

	UserDaoInterface userDao = new UserDaoOperation();

	public User validateUser(String username, String password) throws InvalidLoginException {
		User user = userDao.validateUser(username, password);

		if (user == null)
			throw new InvalidLoginException();
		return user;

	}

	// fetching student details from student databse against studentId
	public Student fetchStudent(Integer studentId) {
		return userDao.fetchStudent(studentId);
	}

	// fetching admin details from admin databse against adminId
	public Admin fetchAdmin(Integer adminId) {
		return adminList.get(adminId);
	}

	// fetching professor details from professor databse against professortId
	public Professor fetchProfessor(Integer professorId) {
		return professorList.get(professorId);
	}

	// create new user
	public void createUser(User user) {

	}

	// create new student
	private Map<Integer, Student> studentList = new HashMap<Integer, Student>();

	public Map<Integer, Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(Map<Integer, Student> studentList) {
		this.studentList = studentList;
	}

	public void createStudent(Student student) {
		studentList.put(student.getStudentId(), student);

	}

	// create new professor

	private Map<Integer, Professor> professorList = new HashMap<Integer, Professor>();

	public Map<Integer, Professor> getProfessorList() {
		return professorList;
	}

	public void setProfessorList(Map<Integer, Professor> professorList) {
		this.professorList = professorList;
	}

	public void createProfessor(Professor professor) {
		professorList.put(professor.getProfessorId(), professor);
	}

	// create new admin
	private Map<Integer, Admin> adminList = new HashMap<Integer, Admin>();

	public Map<Integer, Admin> getAdminList() {
		return adminList;
	}

	public void setAdminList(Map<Integer, Admin> adminList) {
		this.adminList = adminList;
	}

	public void createAdmin(Admin admin) {

		adminList.put(admin.getAdminId(), admin);
	}

	// update user against userId
	public void updateUser(Integer userId, User user) {

	}

	// update student against studentId
	public void updateStudent(Integer studentId, Student student) {
		studentList.remove(studentId);
		studentList.put(studentId, student);

	}

	// update professor against professorId
	public void updateProfessor(Integer professorId, Professor professor) {
		professorList.remove(professorId);
		professorList.put(professorId, professor);
	}

	// update admin against adminId
	public void updateAdmin(Integer adminId, Admin admin) {
		adminList.remove(adminId);
		adminList.put(adminId, admin);
	}

	// delete user against userId
	public void deleteUser(Integer userId, String query) {

	}

	// display details of all students
	public void displayStudents() {
		System.out.println(" Llist of Students.......");
		studentList.entrySet().forEach(a -> System.out.println(a));
		System.out.println();
	}

	// display details of all professors
	public void displayProfessors() {

		System.out.println("List of Professors.....");
		professorList.entrySet().forEach(a -> System.out.println(a));
		System.out.println();
	}

	// display details of all admins
	public void displayAdmins() {

		System.out.println("List of Admins......");
		adminList.entrySet().forEach(a -> System.out.println(a));
		System.out.println();
	}

}
