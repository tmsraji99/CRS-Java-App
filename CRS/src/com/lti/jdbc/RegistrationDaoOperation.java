package com.lti.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.lti.model.Notification;
import com.lti.model.Student;
import com.lti.utils.DBUtils;


public class RegistrationDaoOperation implements RegistrationDaoInterfacce {

	
	// gives the count of courses selected by student
	public boolean numberOfCoursesSelected (Student student) {

		//Establishing the connection
		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt= null;

		try {
			//Declaring prepared statement and executing query
			stmt = connection.prepareStatement("");

			int studentId= student.getStudentId();
			stmt.setInt(1, studentId);

			//Executing query
			ResultSet rs= stmt.executeQuery();
			if(rs.next()) {
				int number= rs.getInt("count(CourseID)");
				if(number==4)
					return true;
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}finally{
			closeConnection(connection,stmt);
		}
		
		return false;


	}

	// submit registration by student
	public void submitRegistration (Student student) {
		//set registartion status as successful
		

		//Establishing the connection
		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt= null;

		try {

			// update registration status of student in student database
			// declaring prepared statement and executing query
			stmt = connection.prepareStatement("");
			stmt.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}finally{
			closeConnection(connection,stmt);
		}
		

	}

	// updating registration database and generating registration details
	public void generateRegistrationReciept(Student student, double payableAmount, int payModeId)  {

		//Establishing the connection
		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt= null;

		try {
			//Declaring prepared statement and executing query
			stmt = connection.prepareStatement("");

			stmt.executeUpdate();


		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}finally{
			closeConnection(connection,stmt);
		}
		

	}

	// fetch registration details of student in notification instance
	public Notification showRegistrationReciept(Student student) {

		Connection connection= DBUtils.getConnection();
		PreparedStatement stmt= null;

		try {

			stmt= connection.prepareStatement("");
			stmt.setInt(1,student.getStudentId());

			 stmt.executeQuery();

					}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}finally{
			closeConnection(connection,stmt);
		}
		
		return null;
	}

	// generate list of students enrolled in a course
	public List<Integer> displayRegisteredStudentsInCourse(int courseId) {

		Connection connection= DBUtils.getConnection();
		PreparedStatement stmt= null;

		try {
			
			stmt= connection.prepareStatement("");
			stmt.execute();
			return null;
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}finally{
			closeConnection(connection,stmt);
		}
		
		return null;
	} 
	private void closeConnection(Connection conn, PreparedStatement stmt) {
		try{
			if(stmt!=null)
				stmt.close();
		}catch(SQLException se2){
		}// nothing we can do
		try{
			if(conn!=null)
				conn.close();
		}catch(SQLException se){
			System.out.println(se.getMessage());
		}
	}

}
