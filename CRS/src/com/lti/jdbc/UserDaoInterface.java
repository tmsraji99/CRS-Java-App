package com.lti.jdbc;

import java.util.List;

import com.lti.model.Admin;
import com.lti.model.Professor;
import com.lti.model.Student;
import com.lti.model.User;

public interface UserDaoInterface {
	
	public User validateUser(String username, String pass);
	public Student fetchStudent(int studentId);
	 public Admin fetchAdmin(int adminId);
	 public Professor fetchProfessor(int professorId);
	 public void createUser(User user);
	 public void createStudent(Student student) ;
	 public void createProfessor(Professor professor);
	 public void createAdmin(Admin admin);
	  public void updateUser(int userId,User user);
	  public void updateStudent(int studentId,Student student);
	  public void updateProfessor(int professorId, Professor professor) ;
	  public void updateAdmin(int adminId,Admin admin) ;
	  public List<Student> displayStudents();
	  public List<Professor> displayProfessors();
	  public List<Admin> displayAdmins();


}
