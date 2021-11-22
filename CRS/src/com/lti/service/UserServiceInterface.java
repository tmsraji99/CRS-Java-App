package com.lti.service;

import com.lti.exception.InvalidOptionException;
import com.lti.exception.UserNotFoundException;
import com.lti.model.Admin;
import com.lti.model.Professor;
import com.lti.model.Student;
import com.lti.model.User;

public interface UserServiceInterface {

	public User validateUser(String username, String password) throws UserNotFoundException;

	public Student fetchStudent(Integer studentId);

	public Admin fetchAdmin(Integer adminId);

	public Professor fetchProfessor(Integer professorId);

	public void createUser(User user);

	public void createStudent(Student student);

	public void createProfessor(Professor professor);

	public void createAdmin(Admin admin);

	public void updateUser(Integer userId, User user);

	public void updateStudent(Integer sudentId, Student student);

	public void updateProfessor(Integer professsorId, Professor professor);

	public void updateAdmin(Integer adminId, Admin admin);

	public void deleteUser(Integer userId, String query) throws UserNotFoundException;

	public void displayStudents();

	public void displayProfessors();

	public void displayAdmins();
	void displayStudentsAdminApproval();

}
