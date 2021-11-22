package com.lti.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lti.constant.SQlQueries;
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
			stmt = connection.prepareStatement(SQlQueries.SELECT_COURSE);

			int professorId= professor.getProfessorId();

			stmt.setInt(1, professorId);
			stmt.setInt(2, courseId);

			stmt.executeUpdate();
			System.out.println("Course with courseId="+courseId+" selected to teach!");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}finally{
			//closeConnection(connection,stmt);
		}
		
		

	}

	// deselect a selected course by professor gainst courseId
	public void deselectCourse(int courseId, Professor professor) {

		//Establishing the connection
		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt= null;
		try {

			stmt=connection.prepareStatement(SQlQueries.DESELECT_COURSE);

			stmt.setInt(1, courseId);
			//Executing query
			int rs = stmt.executeUpdate();
			if(rs>0)
			{
				System.out.println("Course deselected !");
				return;

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}finally{
			//closeConnection(connection,stmt);
		}
		
		System.out.println("Course not found !");

	}

	// display the list of courses selected by professor
	public List<Course> displaySelectedCoursesProfessor(Professor professor) {

		//Establishing the connection
		Connection connection= DBUtils.getConnection();
		PreparedStatement stmt= null;

		try {

			stmt= connection.prepareStatement(SQlQueries.DISPLAY_PROFESSOR_SELECTED_COURSES);
			stmt.setInt(1, professor.getProfessorId());

			ResultSet rs = stmt.executeQuery();

			List<Course> list= new ArrayList<Course>();

			//Creating ArrayList of course
			while(rs.next())
			{
				Course course = new Course();
				course.setCourseId(rs.getInt("CourseID"));
				course.setCourseTitle(rs.getString("Title"));
				course.setStudentsEnrolled(rs.getInt("NumberOfStudentsEnrolled"));

				list.add(course);

			}

			//returning list of courses
			return list;
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}finally{
			//closeConnection(connection,stmt);
		}
		
		return null;
	}
	

}
