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

public class StudentDaoOperation implements StudentDaoInterface{
	
	
	public void addCourse(int courseId ,Student student)  {

		//Establishing the connection
		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt= null;

		try {
			//Declaring prepared statement and executing query
			stmt = connection.prepareStatement(com.lti.constant.Student.ADD_COURSE);			
			int studentId= student.getStudentId();

			stmt.setInt(1, studentId);
			stmt.setInt(2, courseId);

			//Executing query
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


			stmt=connection.prepareStatement(com.lti.constant.Student.DROP_COURSE);
			int studentId= student.getStudentId();

			stmt.setInt(1, studentId);
			stmt.setInt(2, courseId);
			//Executing query
			int rs = stmt.executeUpdate();
			if(rs>0)
				System.out.println("Drop course....");
			

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

			stmt= connection.prepareStatement(com.lti.constant.Student.VIEW_SELECTED_COURSES);
			stmt.setInt(1, student.getStudentId());


			ResultSet rs = stmt.executeQuery();

			List<Course> list= new ArrayList<Course>();

			//Creating ArrayList of courses
			while(rs.next())
			{
				Course course = new Course();
				course.setCourseId(rs.getInt("CourseID"));
				course.setCourseTitle(rs.getString("CourseTitle"));
				course.setCredits(rs.getInt("Credits"));
				course.setTime_stamp(rs.getString("TimeStamp"));
				list.add(course);
			}

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