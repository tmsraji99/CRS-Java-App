package com.lti.dao;

import java.util.List;

import com.lti.model.Admin;
import com.lti.model.Professor;
import com.lti.model.Student;
import com.lti.model.User;

public interface UserDaoInterface {
	
	public User validateUser(String username, String pass);
	public Student fetchStudent(Integer studentId);
	 public Admin fetchAdmin(Integer adminId);
	 public Professor fetchProfessor(Integer professorId);
	 public void createUser(User user);
	 public void createStudent(Student student) ;
	 public void createProfessor(Professor professor);
	 public void createAdmin(Admin admin);
	  public void updateUser(Integer userId,User user);
	  public void updateStudent(Integer studentId,Student student);
	  public void updateProfessor(Integer professorId, Professor professor) ;
	  public void updateAdmin(Integer adminId,Admin admin) ;
	  public List<Student> displayStudents();
	  public List<Professor> displayProfessors();
	  public List<Admin> displayAdmins();


}
