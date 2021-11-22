package com.lti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lti.constant.SQlQueries;
import com.lti.model.Course;
import com.lti.model.Student;
import com.lti.utils.DBUtils;

public class StudentDaoOperation implements StudentDaoInterface{
	
	
	public void addCourse(Integer courseId ,Student student)  {

		//Establishing the connection
		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt= null;

		try {
			//Declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQlQueries.ADD_COURSE);			
			int studentId= student.getStudentId();

			stmt.setInt(1, studentId);
			stmt.setInt(2, courseId);

			//Executing query
			stmt.executeUpdate();
			System.out.println("Course with courseId="+courseId+" added!");
			
			

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}finally{
			//closeConnection(connection,stmt);
		}
		

	}

	// drop a course by student against a courseID
	public void dropCourse(Integer courseId, Student student) {

		//Establishing the connection
		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt= null;
		try {


			stmt=connection.prepareStatement(SQlQueries.DROP_COURSE);
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
			//closeConnection(connection,stmt);
		}
		
		System.out.println("Course not found !");

	}

	// display list of courses selected by student
	public List<Course> displaySelectedCourses(Student student) {

		Connection connection= DBUtils.getConnection();
		PreparedStatement stmt= null;

		List<Course> list= new ArrayList<Course>();
		try {

			stmt= connection.prepareStatement(SQlQueries.VIEW_SELECTED_COURSES);
			stmt.setInt(1, student.getStudentId());


			ResultSet rs = stmt.executeQuery();


			//Creating ArrayList of courses
			while(rs.next())
			{
				Course course = new Course();
				course.setCourseId(rs.getInt("CourseID"));
				course.setCourseTitle(rs.getString("Title"));
				course.setCredits(rs.getInt("Credits"));
				course.setTime_stamp(rs.getString("Date_OF_REGISTRATION"));
				list.add(course);
			}
			System.out.println(list.size());

		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}finally{
			//closeConnection(connection,stmt);
		}
return list;	
	}


	
}