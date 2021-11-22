package com.lti.service;

import java.util.List;

import com.lti.dao.UserDaoInterface;
import com.lti.dao.UserDaoOperation;
import com.lti.exception.InvalidOptionException;
import com.lti.exception.UserNotFoundException;
import com.lti.model.Admin;
import com.lti.model.Professor;
import com.lti.model.Student;
import com.lti.model.User;

public class UserServiceOperation implements UserServiceInterface {

	UserDaoInterface userDao = new UserDaoOperation();

	public User validateUser(String username, String password) throws UserNotFoundException {
		User user = userDao.validateUser(username, password);
		
			if (user == null) {

				throw new UserNotFoundException("User not found");
			}
		 		return user;

	}

	// fetching student details from student databse against studentId
	public Student fetchStudent(Integer studentId) {
		//System.out.println(int);
		return userDao.fetchStudent(studentId);
	}

	// fetching admin details from admin databse against adminId
	public Admin fetchAdmin(Integer adminId) {
		return userDao.fetchAdmin(adminId);
	}

	// fetching professor details from professor databse against professortId
	public Professor fetchProfessor(Integer professorId) {
		return userDao.fetchProfessor(professorId);
	}

	// create new user
	public void createUser(User user) {
		userDao.createUser(user);
	}

	public void createStudent(Student student) {

		userDao.createStudent(student);
	}

	public void createProfessor(Professor professor) {
		userDao.createProfessor(professor);
	}

	public void createAdmin(Admin admin) {

		userDao.createAdmin(admin);
	}

	// update user against userId
	public void updateUser(Integer userId, User user) {
		
		userDao.updateUser(userId, user);
	}

	// update student against studentId
	public void updateStudent(Integer studentId, Student student) {
		userDao.updateStudent(studentId, student);
	}

	// update professor against professorId
	public void updateProfessor(Integer professorId, Professor professor) {
		userDao.updateProfessor(professorId, professor);
	}

	// update admin against adminId
	public void updateAdmin(Integer adminId, Admin admin) {
		userDao.updateAdmin(adminId, admin);
	}

	// delete user against userId
	public void deleteUser(Integer userId, String query) throws com.lti.exception.UserNotFoundException {
		userDao.deleteUser(userId, query);
	}

	public void displayStudents() {
		System.out.println(
				"*********************************************LIST OF STUDENTS**********************************************");

		List<Student> students = userDao.displayStudents();

		students.stream().forEach(student -> {
			if (student.getGender().equals("female"))
				student.setName("Ms " + student.getName());
			else
				student.setName("Mr " + student.getName());
		});
		System.out.println(
				"STUDENT ID      NAME         PHONE NUMBER    BRANCH    SEMESTER    REGISTRATION STATUS      SCHOLARSHIP PERCENTAGE");
		for (Student student : students) {
			System.out.println(student.getStudentId() + "         " + student.getName() + "          "
					+ student.getPhoneNumber() + "        " + student.getBranch() + "        " + student.getSemester()
					+ "                " + student.getRegistrationStatus() + "                      "
					+ student.getScholarshipPercentage());
		}
		System.out.println(
				"*************************************************************************************************************");
	}

	// display details of all professors
	public void displayProfessors() {
		System.out.println("****************************LIST OF PROFESSORS************************************");

		List<Professor> professors = userDao.displayProfessors();

		professors.stream().forEach(professor -> {
			if (professor.getGender().equals("female"))
				professor.setName("Ms " + professor.getName());
			else
				professor.setName("Mr " + professor.getName());
		});

		System.out.println("PROFESSOR ID      NAME            PHONE NUMBER      DESIGNATION   ");
		for (Professor professor : professors) {
			System.out.println(professor.getProfessorId() + "         " + professor.getName() + "          "
					+ professor.getPhoneNumber() + "        " + professor.getDesignation());

		}
		System.out
				.println("*******************************************************************************************");
	}

	// display details of all admins
	public void displayAdmins() {
		System.out.println("**************LIST OF ADMINS****************");

		List<Admin> admins = userDao.displayAdmins();

		admins.stream().forEach(user -> {
			if (user.getGender().equals("female"))
				user.setName("Ms " + user.getName());
			else
				user.setName("Mr " + user.getName());
		});
		System.out.println("USER ID      NAME           PHONE NUMBER      ");
		for (Admin admin : admins) {
			System.out.println(
					admin.getAdminId() + "         " + admin.getName() + "          " + admin.getPhoneNumber());

		}
		System.out.println("***********************************************");

	}

	@Override
	public void displayStudentsAdminApproval() {

		System.out.println(
				"*********************************************LIST OF STUDENTS**********************************************");

		List<Student> students = userDao.displayStudentsAdminApproval();

		students.stream().forEach(student -> {
			if (student.getGender().equals("female"))
				student.setName("Ms " + student.getName());
			else
				student.setName("Mr " + student.getName());
		});
		System.out.println(
				"STUDENT ID      NAME         PHONE NUMBER    BRANCH    SEMESTER    REGISTRATION STATUS      SCHOLARSHIP PERCENTAGE");
		for (Student student : students) {
			System.out.println(student.getStudentId() + "         " + student.getName() + "          "
					+ student.getPhoneNumber() + "        " + student.getBranch() + "        " + student.getSemester()
					+ "                " + student.getRegistrationStatus() + "                      "
					+ student.getScholarshipPercentage());
		}
		System.out.println(
				"*************************************************************************************************************");
	}

	}


