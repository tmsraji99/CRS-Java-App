package com.lti.constant;

public class SQlQueries {
	public static final String INSERT_USER = "INSERT INTO user VALUES (?,?,?,?)";

	public static final String INSERT_STUDENT = "INSERT INTO student(STUDENTID,NAME,PHNNUMBER,GENDER,SEMESTER,BRANCH,StudentRegistrationStatus,ScholarshipPercentage,AdminStatus) VALUES (?,?,?,?,?,?,?,?,?)";
	public static final String INSERT_PROFESSOR = "INSERT INTO professor VALUES (?,?,?,?,?)";
	public static final String INSERT_ADMIN = "INSERT INTO admin VALUES (?,?,?,?)";
	public static final String INSERT_COURSE="INSERT INTO course VALUES (?,?,?,?,?,?,?)";
	public static final String DELETE_COURSE="DELETE FROM course WHERE CourseID=?" ;
	
	public static final String SELECT_COURSE="INSERT INTO inventory(ProfessorId,CourseID) VALUES (?,?)";//UPDATE inventory SET ProfessorID = ? WHERE CourseID=? ";
	public static final String DESELECT_COURSE="UPDATE inventory SET ProfessorID=0 WHERE CourseID=?" ;
	public static final String DELETE_PROFESSOR_COURSE_ALLOTMENT="DELETE FROM inventory WHERE ProfessorID=?" ;
	public static final String COURSE_COUNT="select count";
	public static final String ADD_COURSE="INSERT INTO register VALUES (?,?,false,CURRENT_TIMESTAMP)";
	public static final String DROP_COURSE="DELETE FROM register WHERE StudentID=? AND CourseID=?" ;
	public static final String VIEW_ENROLLED_STUDENT_ID="SELECT StudentID FROM register WHERE CourseID=? AND CourseRegistrationStatus=1";
	public static final String DELETE_STUDENT_REGISTER_COURSE="DELETE FROM register WHERE StudentID=?" ;
	public static final String DISPLAY_STUDENTS_ADMIN="SELECT * FROM student where AdminStatus=false";
	public static final String SHOW_REGISTRATION_RECIEPT= "SELECT * FROM notification WHERE StudentID=?";
	public static final String DELETE_STUDENT_REGISTRATION="DELETE FROM notification WHERE StudentID=?" ;
	public static final String SUBMIT_REGISTRATION_DETAILS="INSERT INTO notification VALUES (?,?,?,?,CURRENT_TIMESTAMP)";

	public static final String DELETE_STUDENT_GRADE="DELETE grade WHERE StudentID=?" ;
	public static final String VIEW_GRADES="SELECT course.CourseID, course.title,  grade.Grade FROM course INNER JOIN grade  \r\n" + 
			"ON course.CourseID = grade.CourseID \r\n" + "WHERE grade.StudentID=?";
	public static final String UPLOAD_GRADES="INSERT INTO grade VALUES (?,?,?,CURRENT_TIMESTAMP)";
	public static final String UPDATE_USER="UPDATE user SET Username=?,Password=?, role_user_id=? WHERE UserID=?";
	public static final String UPDATE_STUDENT="UPDATE student SET Name=?,Gender=?, PHNNUMBER=?, Semester=?, Branch=?, StudentRegistrationStatus=?,ScholarshipPercentage=?, AdminStatus=? WHERE StudentID=?";
	public static final String UPDATE_PROFESSOR="UPDATE professor SET Name=?,Gender=?, PhoneNumber=?,Designation=? WHERE ProfessorID=?";
	public static final String UPDATE_ADMIN="UPDATE admin SET Name=?,Gender=?, PhoneNumber=? WHERE AdminID=?";
	
	public static final String DELETE_USER="DELETE FROM user WHERE UserID=?" ;
	public static final String DELETE_STUDENT="DELETE FROM student WHERE StudentID=?" ;
	public static final String DELETE_ADMIN="DELETE FROM admin WHERE AdminID=?" ;
	public static final String DELETE_PROFESSOR="DELETE FROM professor WHERE ProfessorID=?" ;
	
	public static final String DISPLAY_STUDENTS="SELECT * FROM student";
	public static final String DISPLAY_PROFESSORS="SELECT * FROM professor";
	public static final String DISPLAY_ADMINS="SELECT * FROM admin";
	public static final String DISPLAY_COURSES_PROFESSOR= "SELECT * FROM course" ;
	
	public static final String VALIDATE_USER="select userid, role_id from user u inner join  role r on r.ROLE_ID=role_user_id  where Username=? AND Password=?";
	
	public static final String GET_STUDENT="SELECT * FROM student WHERE StudentID=?";
	public static final String DISPLAY_COURSES= "SELECT * FROM course";// WHERE Semester= ? AND Branch =?";
	public static final String FETCH_STUDENT="SELECT * FROM student WHERE StudentID=?";
	public static final String FETCH_PROFESSOR="SELECT * FROM professor WHERE ProfessorID=?";
	public static final String FETCH_ADMIN="SELECT * FROM admin WHERE AdminID=?";
	
	public static final String VIEW_SELECTED_COURSES="SELECT course.CourseID, course.title, course.Credits,  register.Date_OF_REGISTRATION\r\n" + 
			"FROM course \r\n" + "INNER JOIN register \r\n" + "ON register.CourseID = course.CourseID\r\n" + "WHERE register.StudentID= ?";
	
	public static final String NUMBER_OF_COURSES_SELECTED="SELECT count(CourseID) FROM register WHERE StudentID=?";
	
	public static final String UPDATE_REGISTARTION_STATUS="UPDATE student SET StudentRegistrationStatus= true WHERE StudentID=?";
	
	public static final String REGISTRATION_OF_COURSES= "UPDATE register SET CourseRegistrationStatus=1 WHERE STUDENTID=?";
	
	public static final String DISPLAY_PROFESSOR_SELECTED_COURSES="SELECT course.CourseID, course.Title, inventory.NumberOfStudentsEnrolled FROM course INNER JOIN inventory ON course.CourseID=inventory.CourseID WHERE ProfessorID=? ";
	public static final String UPDATE_ENROLLED_STUDENTS_NUMBER="UPDATE inventory SET NumberOfStudentsEnrolled = "
			+ "NumberOfStudentsEnrolled +1 WHERE CourseID IN (SELECT CourseID FROM register WHERE StudentID=? AND CourseRegistrationStatus= true)";

	
	
}
