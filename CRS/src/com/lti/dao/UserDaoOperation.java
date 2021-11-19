package com.lti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.lti.model.Admin;
import com.lti.model.Professor;
import com.lti.model.Student;
import com.lti.model.User;
import com.lti.utils.DBUtils;

public class UserDaoOperation implements UserDaoInterface {

	public User validateUser(String username, String pass) {
		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt = null;

		try {

			// Declaring prepared statement
			stmt = connection.prepareStatement(com.lti.constant.User.VALIDATE_USER);
			stmt.setString(1, username);
			stmt.setString(2,pass);
			ResultSet rs = stmt.executeQuery();

			if(rs.next() )
			{
				User checkeduser = new User();
				checkeduser.setUserId( rs.getInt(" u.user_id") );
				checkeduser.setRoleId(rs.getInt("r.role_profile"));

				return checkeduser;
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			closeConnection(connection, stmt);
		}
//		
		return null;
	}

	// fetch student from student database against studentId
	public Student fetchStudent(Integer studentId) {

		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = connection.prepareStatement(com.lti.constant.Student.GET_STUDENT);
			stmt.setInt(1, studentId);

			ResultSet rs = stmt.executeQuery();

			if(rs.next() )
			{
				Student student= new Student();
				student.setStudentId(studentId);
				student.setName(rs.getString("Name"));
				student.setPhoneNumber(rs.getLong("PhoneNumber"));
				student.setGender(rs.getString("Gender"));
				student.setSemester(rs.getInt("Semester"));
				student.setBranch(rs.getString("Branch"));
				student.setRegistrationStatus(rs.getBoolean("StudentRegistrationStatus"));
				student.setScholarshipPercentage(rs.getInt("ScholarshipPercentage"));
				return student;
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			closeConnection(connection, stmt);
		}
//		
		return null;

	}

	// fetch admin from admin database against admin Id
	public Admin fetchAdmin(Integer adminId) {

		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt = null;

		try {
			// Declaring prepared statement
			stmt = null;
			stmt = connection.prepareStatement("");
			stmt.executeQuery();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			closeConnection(connection, stmt);
		}
//		
		return null;

	}

	// fetch professor from professor database against professorId
	public Professor fetchProfessor(Integer professorId) {

		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt = null;

		try {
			// Declaring prepared statement
			stmt = null;
			stmt = connection.prepareStatement("");
			stmt.executeQuery();
			return null;

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			closeConnection(connection, stmt);
		}
//		
		return null;

	}

	// create a new user
	public void createUser(User user) {

		// Establishing the connection
		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt = null;

		try {
			// Declaring prepared statement and executing query
			stmt = connection.prepareStatement("");
			stmt.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

	}

	// create a new student
	public void createStudent(Student student) {

		// Establishing the connection
		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt = null;

		try {
			// Declaring prepared statement and executing query
			stmt = connection.prepareStatement("");
			stmt.executeUpdate();
			System.out.println("Student" + " added!");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());

		} finally {
			closeConnection(connection, stmt);
		}

	}

	// create a new professor
	public void createProfessor(Professor professor) {

		// Establishing the connection
		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt = null;

		try {
			// Declaring prepared statement and executing query
			stmt = connection.prepareStatement("");
			stmt.executeUpdate();
			System.out.println("Professor" + " added!");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

	}

	// create a new admin
	public void createAdmin(Admin admin) {

		// Establishing the connection
		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt = null;

		try {
			// Declaring prepared statement and executing query
			stmt = connection.prepareStatement("");
			stmt.executeUpdate();
			System.out.println("Admin" + " added!");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			closeConnection(connection, stmt);
		}

	}

	// update an user
	public void updateUser(Integer userID, User user) {

		// Establishing the connection
		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt = null;

		try {
			// Declaring prepared statement and executing query
			stmt = connection.prepareStatement("");
			stmt.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			closeConnection(connection, stmt);
		}

	}

	// update a student against studentId
	public void updateStudent(Integer studentID, Student student) {

		// Establishing the connection
		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt = null;

		try {
			// Declaring prepared statement and executing query
			stmt = connection.prepareStatement("");
			stmt.executeUpdate();
			System.out.println("Student details updated !");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			closeConnection(connection, stmt);
		}

	}

	// update Professor against professorId
	public void updateProfessor(Integer professorID, Professor professor) {

		// Establishing the connection
		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt = null;

		try {
			// Declaring prepared statement and executing query
			stmt = connection.prepareStatement("");
			stmt.executeUpdate();
			System.out.println("Professor details updated !");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			closeConnection(connection, stmt);
		}

	}

	// update admin against adminId
	public void updateAdmin(Integer adminID, Admin admin) {

		// Establishing the connection
		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt = null;

		try {
			// Declaring prepared statement and executing query
			stmt = connection.prepareStatement("");
			stmt.executeUpdate();
			System.out.println("Admin details updated !");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			closeConnection(connection, stmt);
		}

	}

	// provides details of all students
	public List<Student> displayStudents() {

		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt = null;
		try {

			stmt = connection.prepareStatement("");
			stmt.executeQuery();
			return null;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			closeConnection(connection, stmt);
		}

		return null;
	}

	// provides details of all professors
	public List<Professor> displayProfessors() {

		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = connection.prepareStatement("");
			stmt.executeQuery();

			return null;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			closeConnection(connection, stmt);
		}

		return null;
	}

	// provide details of all admins
	public List<Admin> displayAdmins() {

		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = connection.prepareStatement("");
			stmt.executeQuery();
			return null;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			closeConnection(connection, stmt);
		}

		return null;
	}

	private void closeConnection(Connection conn, PreparedStatement stmt) {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException se2) {
		} // nothing we can do
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}

}
