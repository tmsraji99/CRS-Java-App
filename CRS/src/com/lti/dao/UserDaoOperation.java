package com.lti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lti.constant.SQlQueries;
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
			stmt = connection.prepareStatement(SQlQueries.VALIDATE_USER);
			stmt.setString(1, username);
			stmt.setString(2, pass);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				User checkeduser = new User();
				checkeduser.setUserId(rs.getInt("userid"));
				checkeduser.setRoleId(rs.getInt("role_id"));

				return checkeduser;
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			// closeConnection(connection, stmt);
		}
//		
		return null;
	}

	// fetch student from student database against studentId
	public Student fetchStudent(Integer studentId) {

		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = connection.prepareStatement(SQlQueries.GET_STUDENT);
			stmt.setInt(1, studentId);
System.out.println(stmt);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Student student = new Student();
				student.setStudentId(studentId);
				student.setName(rs.getString("Name"));
				student.setPhoneNumber(rs.getInt("PHNNUMBER"));
				student.setGender(rs.getString("Gender"));
				student.setSemester(rs.getInt("Semester"));
				student.setBranch(rs.getString("Branch"));
				student.setRegistrationStatus(rs.getBoolean("StudentRegistrationStatus"));
				student.setScholarshipPercentage(rs.getInt("ScholarshipPercentage"));
				student.setAdminStatus(rs.getBoolean("AdminStatus"));
				return student;
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			// closeConnection(connection, stmt);
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
			stmt = connection.prepareStatement(SQlQueries.FETCH_ADMIN);
			stmt.setInt(1, adminId);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				System.out.println("SQlQueries.FETCH_ADMIN");
				Admin admin = new Admin();
				admin.setAdminId(adminId);
				admin.setName(rs.getString("Name"));
				admin.setPhoneNumber(rs.getInt("PhoneNumber"));
				admin.setGender(rs.getString("Gender"));

				return admin;
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			// closeConnection(connection, stmt);
		}
//		
		return null;

	}

	// fetch professor from professor database against professorId
	public Professor fetchProfessor(Integer professorId) {

		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = null;
			stmt = connection.prepareStatement(SQlQueries.FETCH_PROFESSOR);
			stmt.setInt(1, professorId);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Professor professor = new Professor();
				professor.setProfessorId(professorId);
				professor.setName(rs.getString("Name"));
				professor.setPhoneNumber(rs.getInt("PhoneNumber"));
				professor.setGender(rs.getString("Gender"));
				professor.setDesignation(rs.getString("Designation"));

				return professor;
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			// closeConnection(connection, stmt);
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
			stmt = connection.prepareStatement(SQlQueries.INSERT_USER);
			int userId = user.getUserId();
			String username = user.getUserName();
			String password = user.getUserPassword();
			int roleId = user.getRoleId();

			stmt.setInt(1, userId);
			stmt.setString(2, username);
			stmt.setString(3, password);

			stmt.setInt(4, roleId);

			// Executing query
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
			stmt = connection.prepareStatement(SQlQueries.INSERT_STUDENT);
			int studentId = student.getStudentId();

			String name = student.getName();
			int phoneNo = student.getPhoneNumber();
			int semester = student.getSemester();
			String branch = student.getBranch();

			String gender = student.getGender();
			Boolean isRegistrationComplete = student.getRegistrationStatus();

			int ScholarshipAllowancePercentage = student.getScholarshipPercentage();

			stmt.setInt(1, studentId);
			stmt.setString(2, name);
			stmt.setString(4, gender);

			stmt.setInt(3, phoneNo);
			stmt.setInt(5, semester);
			stmt.setString(6, branch);

			stmt.setBoolean(7, isRegistrationComplete);

			stmt.setInt(8, ScholarshipAllowancePercentage);
			stmt.setBoolean(9, false);

			stmt.executeUpdate();
			System.out.println("Student" + " added!");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());

		} finally {
			// closeConnection(connection, stmt);
		}

	}

	// create a new professor
	public void createProfessor(Professor professor) {

		// Establishing the connection
		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = connection.prepareStatement(SQlQueries.INSERT_PROFESSOR);
			int professorId = professor.getProfessorId();

			String name = professor.getName();
			int phoneNo = professor.getPhoneNumber();
			String gender = professor.getGender();
			String designation = professor.getDesignation();

			stmt.setInt(1, professorId);
			stmt.setString(2, name);
			stmt.setString(4, gender);
			stmt.setInt(3, phoneNo);
			stmt.setString(5, designation);

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
			stmt = connection.prepareStatement(SQlQueries.INSERT_ADMIN);
			int adminId = admin.getAdminId();
			String name = admin.getName();
			int phoneNo = admin.getPhoneNumber();
			String gender = admin.getGender();

			stmt.setInt(1, adminId);
			stmt.setString(2, name);
			stmt.setString(4, gender);
			stmt.setInt(3, phoneNo);

			stmt.executeUpdate();

			System.out.println("Admin" + " added!");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			// closeConnection(connection, stmt);
		}

	}

	public void updateUser(Integer userID, User user) {

		// Establishing the connection
		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt = null;

		try {
			// Declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQlQueries.UPDATE_USER);
			int userId = user.getUserId();
			String username = user.getUserName();
			String password = user.getUserPassword();
			int roleId = user.getRoleId();

			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setInt(3, roleId);
			stmt.setInt(4, userId);

			// Executing query
			stmt.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

	}

	// update a student against studentId
	public void updateStudent(Integer studentID, Student student) {

		// Establishing the connection
		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt = null;

		try {
			// Declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQlQueries.UPDATE_STUDENT);
			int studentId = student.getStudentId();
			String name = student.getName();
			long phoneNo = student.getPhoneNumber();
			int semester = student.getSemester();
			String branch = student.getBranch();
			String gender = student.getGender();
			Boolean isRegistrationComplete = student.getRegistrationStatus();
			int ScholarshipAllowancePercentage = student.getScholarshipPercentage();

			stmt.setString(1, name);
			stmt.setString(2, gender);
			stmt.setLong(3, phoneNo);
			stmt.setInt(4, semester);
			stmt.setString(5, branch);
			stmt.setBoolean(6, isRegistrationComplete);
			stmt.setInt(7, ScholarshipAllowancePercentage);
			stmt.setInt(9, studentId);
			Boolean adminStatus = student.getAdminStatus();

			stmt.setBoolean(8, adminStatus); // Executing query
			stmt.executeUpdate();

			System.out.println("Student details updated !" +stmt);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

	}

	// update Professor against professorId
	public void updateProfessor(Integer professorID, Professor professor) {

		// Establishing the connection
		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt = null;

		try {
			// Declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQlQueries.UPDATE_PROFESSOR);
			int professorId = professor.getProfessorId();

			String name = professor.getName();
			long phoneNo = professor.getPhoneNumber();
			String gender = professor.getGender();
			String designation = professor.getDesignation();

			stmt.setString(1, name);
			stmt.setString(2, gender);
			stmt.setLong(3, phoneNo);
			stmt.setString(4, designation);
			stmt.setInt(5, professorId);

			// Executing query
			stmt.executeUpdate();
			System.out.println("Professor details updated !");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

	}

	// update admin against adminId
	public void updateAdmin(Integer adminID, Admin admin) {

		// Establishing the connection
		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt = null;

		try {
			// Declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQlQueries.UPDATE_ADMIN);
			int adminId = admin.getAdminId();
			String name = admin.getName();
			long phoneNo = admin.getPhoneNumber();
			String gender = admin.getGender();

			stmt.setString(1, name);
			stmt.setString(2, gender);
			stmt.setLong(3, phoneNo);
			stmt.setInt(4, adminId);

			// Executing query
			stmt.executeUpdate();
			System.out.println("Admin details updated !");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

	}

	public List<Student> displayStudents() {

		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt = null;
		try {

			stmt = connection.prepareStatement(SQlQueries.DISPLAY_STUDENTS);

			ResultSet rs = stmt.executeQuery();

			List<Student> list = new ArrayList<Student>();

			// Creating ArrayList of student
			while (rs.next()) {
				Student student = new Student();
				student.setStudentId(rs.getInt("StudentID"));
				student.setName(rs.getString("Name"));
				student.setPhoneNumber(rs.getInt("PhoneNumber"));
				student.setGender(rs.getString("Gender"));
				student.setBranch(rs.getString("Branch"));
				student.setSemester(rs.getInt("Semester"));
				student.setRegistrationStatus(rs.getBoolean("StudentRegistrationStatus"));
				student.setScholarshipPercentage(rs.getInt("ScholarshipPercentage"));

				list.add(student);

			}

			// returning list of student
			return list;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return null;
	}

	// provides details of all professors
	public List<Professor> displayProfessors() {

		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = connection.prepareStatement(SQlQueries.DISPLAY_PROFESSORS);

			ResultSet rs = stmt.executeQuery();

			List<Professor> list = new ArrayList<Professor>();

			// Creating ArrayList of professor
			while (rs.next()) {
				Professor professor = new Professor();
				professor.setProfessorId(rs.getInt("ProfessorID"));
				professor.setName(rs.getString("Name"));
				professor.setPhoneNumber(rs.getInt("PhoneNumber"));
				professor.setGender(rs.getString("Gender"));
				professor.setDesignation(rs.getString("Designation"));

				list.add(professor);

			}

			// returning list of professors
			return list;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return null;
	}

	// provide details of all admins
	public List<Admin> displayAdmins() {

		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = connection.prepareStatement(SQlQueries.DISPLAY_ADMINS);

			ResultSet rs = stmt.executeQuery();

			List<Admin> list = new ArrayList<Admin>();

			// Creating ArrayList of admin
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setAdminId(rs.getInt("AdminID"));
				admin.setName(rs.getString("Name"));
				admin.setPhoneNumber(rs.getInt("PhoneNumber"));
				admin.setGender(rs.getString("Gender"));

				list.add(admin);

			}

			return list;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return null;
	}

	@Override
	public List<Student> displayStudentsAdminApproval() {
		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt = null;
		try {

			stmt = connection.prepareStatement(SQlQueries.DISPLAY_STUDENTS_ADMIN);

			ResultSet rs = stmt.executeQuery();

			List<Student> list = new ArrayList<Student>();

			// Creating ArrayList of student
			while (rs.next()) {
				Student student = new Student();
				student.setStudentId(rs.getInt("StudentID"));
				student.setName(rs.getString("Name"));
				student.setPhoneNumber(rs.getInt("PHNNUMBER"));
				student.setGender(rs.getString("Gender"));
				student.setBranch(rs.getString("Branch"));
				student.setSemester(rs.getInt("Semester"));
				student.setRegistrationStatus(rs.getBoolean("StudentRegistrationStatus"));
				student.setScholarshipPercentage(rs.getInt("ScholarshipPercentage"));
				student.setAdminStatus(rs.getBoolean("AdminStatus"));

				list.add(student);

			}

			// returning list of student
			return list;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return null;
	}

//	private void closeConnection(Connection conn, PreparedStatement stmt) {
//		try {
//			if (stmt != null)
//				stmt.close();
//		} catch (SQLException se2) {
//		} // nothing we can do
//		try {
//			if (conn != null)
//				conn.close();
//		} catch (SQLException se) {
//			System.out.println(se.getMessage());
//		}
//	}

}