package com.lti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.lti.exception.UserNotFoundException;
import com.lti.model.Admin;
import com.lti.model.Professor;
import com.lti.model.Student;
import com.lti.model.User;
import com.lti.utils.DBUtils;

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
	  public List<Student> displayStudentsAdminApproval();
	  default public void deleteUser(int userId, String query) throws UserNotFoundException {

			//Establishing the connection
			Connection connection = DBUtils.getConnection();
			try {

				//Establishing the connection
				PreparedStatement stmt = null;

				stmt=connection.prepareStatement(query);
				stmt.setInt(1, userId);
				//Executing query
				int rs = stmt.executeUpdate();
				if(rs>0){
					return;
				}
//				else 
//				throw new UserNotFoundException();

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
			
		}



}
