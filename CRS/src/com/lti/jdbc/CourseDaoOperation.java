package com.lti.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lti.exception.CourseNotFoundException;
import com.lti.model.Course;
import com.lti.model.Student;
import com.lti.utils.DBUtils;

public class CourseDaoOperation implements CourseDaoInterface{




	// provide list of courses available for a student to select
	// mapped with student's with branch and semester
	public List<Course> displayCourses(Student student) {

		//Establishing the connection
		Connection connection= DBUtils.getConnection();

		//Declaring prepared statement and executing query
		PreparedStatement stmt= null;
		try {
			int semester= student.getSemester();
			String branch= student.getBranch();
			stmt= connection.prepareStatement("");
			stmt.setInt(1, semester);
			stmt.setString(2,branch);

			ResultSet rs = stmt.executeQuery();

			List<Course> list= new ArrayList<Course>();

			//Creating ArrayList of Course
			while(rs.next())
			{
				
			}

			return list;
		}
		catch(SQLException ex) {
			System.out.print(ex.getMessage());
		}
		finally{
		closeConnection(connection,stmt);
		}
		
		return null;
		
	}


	// insert a new cousre in database against a course Id and catalog Id
	public void insertCourse(Course course)  {

		//Establishing the connection
		Connection connection = DBUtils.getConnection();
		//Establishing the connection
		PreparedStatement stmt = null;

		try {
			//Declaring prepared statement and executing query
			stmt = connection.prepareStatement("");
			stmt.executeUpdate();
			System.out.println("Course added!");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		

	}

	// delete a cousre from course database using course Id	
	public void deleteCourse(int courseId) throws CourseNotFoundException{

		//Establishing the connection
		Connection connection = DBUtils.getConnection();
		//Establishing the connection
		PreparedStatement stmt = null;
		try {

			stmt=connection.prepareStatement("");
			//Executing query
			int rs = stmt.executeUpdate();
			if(rs>0)
			{
				System.out.println("Course with courseId "+courseId+" deleted !");
				return;

			}
			throw new CourseNotFoundException();
		} catch (SQLException ex) {
			System.out.print(ex.getMessage());
		}
		
		
		

	}

	// provide list of courses available for professor to select to teach
	public List<Course> displayCoursesProfessor() {

		Connection connection= DBUtils.getConnection();

		//Declaring prepared statement and executing query
		PreparedStatement stmt= null;

		try {
			stmt= connection.prepareStatement("");
			ResultSet rs = stmt.executeQuery();

			List<Course> list= new ArrayList<Course>();

			//Creating ArrayList of courses
			while(rs.next())
			{
				
			}

			//returning list of courses
			return list;
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		finally{
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
