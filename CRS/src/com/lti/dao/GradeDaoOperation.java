package com.lti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lti.model.Course;
import com.lti.model.Student;
import com.lti.utils.DBUtils;


public class GradeDaoOperation implements GradeDaoInterface{
	
	// fetch grades of students against courseId and studentId
	public List<Course> displayGrades(Student student) {

		//Establishing the connection
		Connection connection= DBUtils.getConnection();
		PreparedStatement stmt= null;

		try {

			//Declaring prepared statement and executing query
			stmt= connection.prepareStatement(com.lti.constant.Student.VIEW_GRADES);
			stmt.setInt(1, student.getStudentId());

			ResultSet rs = stmt.executeQuery();
			List<Course> list= new ArrayList<Course>();

			//Creating ArrayList of course
			while(rs.next())
			{
				Course course = new Course();

				course.setCourseId(rs.getInt("CourseID"));
				course.setCourseTitle(rs.getString("CourseTitle"));
				course.setGrade(rs.getString("Grade"));

				list.add(course);
			}
			//returning list of courses
			return list;
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}finally{
			closeConnection(connection,stmt);
		}
		
		return null;
	}

	// upload grades against a studentId and courseId
	public void uploadGrades(int studentId, int courseId, String grade) {
		//Establishing the connection
		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt=null;

		try {
			//Declaring prepared statement and executing query
			 stmt = connection.prepareStatement("");

			//Executing query
			stmt.executeUpdate();
			System.out.println("Grade uploaded");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}finally{
			closeConnection(connection,stmt);
		}
		
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
		}	}


