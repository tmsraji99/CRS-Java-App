package com.lti.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lti.model.Course;
import com.lti.model.Professor;
import com.lti.utils.DBUtils;

public class ProfessorDaoOperation implements ProfessorDaoInterface{

	// select a course by professor to teach
	public void selectCourse(int courseId ,Professor professor)  {

		//Establishing the connection
		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt= null;

		try {
			//Declaring prepared statement and executing query
			stmt = connection.prepareStatement("");


			//Executing query
			stmt.executeUpdate();
			System.out.println("Course with courseId="+courseId+" selected to teach!");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}finally{
			closeConnection(connection,stmt);
		}
		
		

	}

	// deselect a selected course by professor gainst courseId
	public void deselectCourse(int courseId, Professor professor) {

		//Establishing the connection
		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt= null;
		try {

			stmt=connection.prepareStatement("");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}finally{
			closeConnection(connection,stmt);
		}
		
		System.out.println("Course not found !");

	}

	// display the list of courses selected by professor
	public List<Course> displaySelectedCoursesProfessor(Professor professor) {

		//Establishing the connection
		Connection connection= DBUtils.getConnection();
		PreparedStatement stmt= null;

		try {

			stmt= connection.prepareStatement("");
			stmt.setInt(1, professor.getProfessorId());

			ResultSet rs = stmt.executeQuery();

			List<Course> list= new ArrayList<Course>();

			//Creating ArrayList of course
			while(rs.next())
			{
				Course course = new Course();
				course.setCourseId(rs.getInt("CourseID"));
				course.setCourseTitle(rs.getString("CourseTitle"));
				course.setStudentsEnrolled(rs.getInt("NumberOfStudentsEnrolled"));

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
