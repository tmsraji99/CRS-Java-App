package com.lti.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.lti.model.Course;
import com.lti.model.Student;
import com.lti.utils.DBUtils;

public class StudentDaoOperation implements StudentDaoInterface{
	
	
	public void addCourse(int courseId ,Student student)  {

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

	// drop a course by student against a courseID
	public void dropCourse(int courseId, Student student) {

		//Establishing the connection
		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt= null;
		try {

			//Establishing the connection
			stmt=connection.prepareStatement("");
			stmt.executeUpdate();
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}finally{
			closeConnection(connection,stmt);
		}
		
		System.out.println("Course not found !");

	}

	// display list of courses selected by student
	public List<Course> displaySelectedCourses(Student student) {

		Connection connection= DBUtils.getConnection();
		PreparedStatement stmt= null;

		try {

			stmt= connection.prepareStatement("");
			stmt.executeQuery();

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