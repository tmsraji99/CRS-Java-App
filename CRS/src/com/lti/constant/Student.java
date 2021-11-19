package com.lti.constant;

public class Student {

	
	public static final String GET_STUDENT="SELECT * FROM student WHERE Student_ID=?";
	public static final String DISPLAY_COURSES= "SELECT * FROM course WHERE Semester= ? AND Branch =?";
	public static final String INSERT_COURSE="INSERT INTO course VALUES (?,?,?,?,?,?,?)";
	public static final String ADD_COURSE="INSERT INTO registration VALUES (?,?,CURRENT_TIMESTAMP)";
	public static final String DROP_COURSE="DELETE FROM registration WHERE StudentID=? AND CourseID=?" ;
	public static final String VIEW_SELECTED_COURSES="SELECT course.Course_ID, course.Course_NAME, course.Credits,  registration.TimeStamp\r\n" + 
			"FROM course \r\n" + "INNER JOIN registration \r\n" + "ON registration.Course_ID = course.Course_ID\r\n" + "WHERE registration.Student_ID= ?";
	public static final String NUMBER_OF_COURSES_SELECTED="SELECT count(CourseID) FROM register_course WHERE StudentID=?";
	public static final String UPDATE_REGISTARTION_STATUS="UPDATE student SET StudentRegistrationStatus= true WHERE StudentID=?";
	public static final String REGISTRATION_OF_COURSES= "UPDATE registration SET CourseRegistrationStatus=1 WHERE STUDENTID=?";
	public static final String SUBMIT_REGISTRATION_DETAILS="INSERT INTO notification VALUES (?,?,?,?,CURRENT_TIMESTAMP)";
	public static final String UPDATE_ENROLLED_STUDENTS_NUMBER="UPDATE course_inventory SET NumberOfStudentsEnrolled = "
			+ "NumberOfStudentsEnrolled +1 WHERE CourseID IN (SELECT CourseID FROM register_course WHERE StudentID=? AND CourseRegistrationStatus= true)";
	public static final String SHOW_REGISTRATION_RECIEPT= "SELECT * FROM notification WHERE StudentID=?";
	public static final String VIEW_ENROLLED_STUDENT_ID="SELECT StudentID FROM registration WHERE Course_ID=? AND Course_Registration_Status=1";
	public static final String VIEW_GRADES="SELECT course.Course_ID, course.Course_Name,  grade.Grade \r\n" + "FROM course  \r\n" + "INNER JOIN grade  \r\n" + 
			"ON course.CourseID = grade.CourseID \r\n" + "WHERE grade.StudentID=?";
}
