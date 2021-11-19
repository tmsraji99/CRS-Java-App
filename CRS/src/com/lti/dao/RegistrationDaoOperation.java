package com.lti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
			stmt = connection.prepareStatement(com.lti.constant.Student.NUMBER_OF_COURSES_SELECTED);

			int studentId= student.getStudentId();
			stmt.setInt(1, studentId);

			//Executing query
			ResultSet rs= stmt.executeQuery();
			if(rs.next()) {
				int number= rs.getInt("count(CourseID)");
				if(number>=10 && number<4)
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
		student.setRegistrationStatus(true);

		//Establishing the connection
		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt= null;

		try {

			// update registration status of student in student database
			// declaring prepared statement and executing query
			stmt = connection.prepareStatement(com.lti.constant.Student.UPDATE_REGISTARTION_STATUS);
			int studentId= student.getStudentId();
			stmt.setInt(1,studentId);

			// Executing query
			stmt.executeUpdate();
			
			// update course registration status
			stmt = connection.prepareStatement(com.lti.constant.Student. REGISTRATION_OF_COURSES);

			stmt.setInt(1, studentId);
			stmt.executeUpdate();

			// update the number of students enrolled in that course by +1
			stmt = connection.prepareStatement(com.lti.constant.Student. UPDATE_ENROLLED_STUDENTS_NUMBER);

			stmt.setInt(1, studentId);
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

			stmt = connection.prepareStatement(com.lti.constant.Student.SUBMIT_REGISTRATION_DETAILS);
			int studentId= student.getStudentId();
			String regId=2020+""+studentId;
			int registrationId=Integer.parseInt(regId);

			stmt.setInt(1, registrationId);
			stmt.setInt(2, studentId);
			stmt.setDouble(3, payableAmount);
			stmt.setInt(4, payModeId);

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
			
			stmt= connection.prepareStatement(com.lti.constant.Student.VIEW_ENROLLED_STUDENT_ID);
			stmt.setInt(1, courseId);
			ResultSet rs = stmt.executeQuery();
			List<Integer> list= new ArrayList<Integer>();
			while(rs.next())
			{
				int studentId= rs.getInt("StudentID");
				list.add(studentId);
			}

			//returning list of studentId
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
