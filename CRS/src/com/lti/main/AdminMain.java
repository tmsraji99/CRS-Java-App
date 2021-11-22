package com.lti.main;

import java.util.Date;
import java.util.Scanner;

import com.lti.constant.SQlQueries;
import com.lti.exception.CourseNotFoundException;
import com.lti.exception.InvalidOptionException;
import com.lti.model.Admin;
import com.lti.model.Course;
import com.lti.model.Professor;
import com.lti.model.Student;
import com.lti.model.User;
import com.lti.service.CourseServiceInterface;
import com.lti.service.CourseServiceOperation;
import com.lti.service.UserServiceInterface;
import com.lti.service.UserServiceOperation;

public class AdminMain {

	// initializing the scanner
	Scanner sc = new Scanner(System.in);

	// admin client landing page
	public void adminClientPage(Admin admin) throws InvalidOptionException {

		// initializing the instance userOperation to carry out user operations
		UserServiceInterface userOperation = new UserServiceOperation();
		// initializing the instance courseOperation to carry out course operations
		CourseServiceInterface courseOperation = new CourseServiceOperation();

		// begin variable listing
		User user;
		int userId;
		int profileOption;

		Date currentDate = new Date();
		// display contents of admin client landing page
		System.out.println("Succesfully logged in as ADMIN on " + currentDate);
		while (true) {
			// diplay menu list for admin
			System.out.println("Welcome " + admin.getName() + " !");
			System.out.println("Choose an option");
			System.out.println("1. Create user");
			System.out.println("2. Update user");
			System.out.println("3. Delete user");
			System.out.println("4. Add a new Course");
			System.out.println("5. Delete Course");
			System.out.println("6. Display users");
			System.out.println("7. Approvals Of Student Registration");
			System.out.println("8. Logout");
			int min = 200;
			int max = 400;

			double d = Math.random() * (max - min + 1) + min;
			userId = (int) Math.nextDown(d);
			int choice = sc.nextInt();
			switch (choice) {
			// create a new user
			case 1:
				user = new User();
				// System.out.println("Enter UserId");
				// =(Dou)(Math.random());// sc.nextInt();
				user.setUserId(userId);
				System.out.println("Enter Username");
				user.setUserName(sc.next());
				System.out.println("Enter Password");
				user.setUserPassword(sc.next());

				System.out.println("Enter Profile ");
				System.out.println("1. Student");
				System.out.println("2. Professor");
				System.out.println("3. Admin");
				profileOption = sc.nextInt();
				switch (profileOption) {
				// if user is a student
				case 1:
					user.setRoleId(1);
					userOperation.createUser(user);
					Student student = new Student();
					student.setStudentId(userId);
					System.out.println("Enter Name");
					student.setName(sc.next());
					System.out.println("Enter gender");
					student.setGender(sc.next());
					System.out.println("Enter Phone Number");
					student.setPhoneNumber(sc.nextInt());
					System.out.println("Enter Semester");
					student.setSemester(sc.nextInt());
					System.out.println("Enter Branch");
					student.setBranch(sc.next());
					student.setRegistrationStatus(false);
					student.setAdminStatus(false);
					System.out.println("Enter Scholarship Allowance Percentage");
					student.setScholarshipPercentage(sc.nextInt());
					// create student
					userOperation.createStudent(student);
					break;

				// if user is a professor
				case 2:
					user.setRoleId(2);
					userOperation.createUser(user);
					Professor professor = new Professor();
					professor.setProfessorId(userId);
					System.out.println("Enter Name");
					professor.setName(sc.next());
					System.out.println("Enter gender");
					professor.setGender(sc.next());
					System.out.println("Enter Phone Number");
					professor.setPhoneNumber(Integer.parseInt(sc.next()));
					System.out.println("Enter Designation");
					professor.setDesignation(sc.next());
					// create professor
					userOperation.createProfessor(professor);
					break;

				// if user is an admin
				case 3:
					user.setRoleId(3);
					userOperation.createUser(user);
					Admin newAdmin = new Admin();
					newAdmin.setAdminId(userId);
					System.out.println("Enter Name");
					newAdmin.setName(sc.next());
					System.out.println("Enter gender");
					newAdmin.setGender(sc.next());
					System.out.println("Enter Phone Number");
					newAdmin.setPhoneNumber(Integer.parseInt(sc.next()));
					// create admin
					userOperation.createAdmin(newAdmin);
					break;
				}
				continue;

			// update an existing user
			case 2:
				user = new User();

				System.out.println("Enter UserId");
				userId = sc.nextInt();
				user.setUserId(userId);
				System.out.println("Enter Username");
				user.setUserName(sc.next());
				System.out.println("Enter Password");
				user.setUserPassword(sc.next());
				System.out.println("Enter Profile ");
				System.out.println("1. Student");
				System.out.println("2. Professor");
				System.out.println("3. Admin");
				profileOption = sc.nextInt();
				switch (profileOption) {
				// if user is student
				case 1:
					user.setRoleId(1);
					userOperation.updateUser(userId, user);
					Student student = new Student();
					student.setStudentId(userId);
					System.out.println("Enter Name");
					student.setName(sc.next());
					System.out.println("Enter gender");
					student.setGender(sc.next());
					System.out.println("Enter Phone Number");
					student.setPhoneNumber(sc.nextInt());
					System.out.println("Enter Semester");
					student.setSemester(sc.nextInt());
					System.out.println("Enter Branch");
					student.setBranch(sc.nextLine());
					student.setRegistrationStatus(false);
					student.setAdminStatus(false);
					System.out.println("Enter Scholarship Allowance Percentage");
					student.setScholarshipPercentage(sc.nextInt());

					// update user
					userOperation.updateStudent(userId, student);
					break;
				// if user is a professor
				case 2:
					user.setRoleId(2);
					userOperation.updateUser(userId, user);
					Professor professor = new Professor();
					professor.setProfessorId(userId);
					System.out.println("Enter Name");
					professor.setName(sc.next());
					System.out.println("Enter gender");
					professor.setGender(sc.next());
					System.out.println("Enter Phone Number");
					professor.setPhoneNumber(Integer.parseInt(sc.next()));
					System.out.println("Enter Designation");
					professor.setDesignation(sc.next());
					// update professor
					userOperation.updateProfessor(userId, professor);
					break;
				// if user is an admin
				case 3:
					user.setRoleId(3);
					userOperation.updateUser(userId, user);
					Admin newAdmin = new Admin();
					newAdmin.setAdminId(userId);
					System.out.println("Enter Name");
					newAdmin.setName(sc.next());
					System.out.println("Enter gender");
					newAdmin.setGender(sc.next());
					System.out.println("Enter Phone Number");
					newAdmin.setPhoneNumber(Integer.parseInt(sc.next()));
					// update admin
					userOperation.updateAdmin(userId, newAdmin);
					break;
				}
				continue;

			// delete the user
			case 3:
				try {
					System.out.println("Enter UserId of user to be deleted");
					userId = sc.nextInt();
					userOperation.deleteUser(userId, SQlQueries.DELETE_USER);
					System.out.println("Enter Profile ");
					System.out.println("1. Student");
					System.out.println("2. Professor");
					System.out.println("3. Admin");
					profileOption = sc.nextInt();
					switch (profileOption) {
					// if user is a student
					case 1:
						// delete student from student, registration and grade records
						userOperation.deleteUser(userId, SQlQueries.DELETE_STUDENT);
						userOperation.deleteUser(userId, SQlQueries.DELETE_STUDENT_REGISTER_COURSE);
						userOperation.deleteUser(userId, SQlQueries.DELETE_STUDENT_GRADE);
						userOperation.deleteUser(userId, SQlQueries.DELETE_STUDENT_REGISTRATION);
						System.out.println("Student with Id= " + userId + " deleted !");
						break;
					// if user is a professor
					case 2:
						// delete professor from professor and cousre allotment records
						userOperation.deleteUser(userId, SQlQueries.DELETE_PROFESSOR);
						userOperation.deleteUser(userId, SQlQueries.DELETE_PROFESSOR_COURSE_ALLOTMENT);
						System.out.println("Professor with Id= " + userId + " deleted !");
						break;
					// if user is admin
					case 3:
						// delete admin from admin records
						userOperation.deleteUser(userId, SQlQueries.DELETE_ADMIN);
						System.out.println("Admin with Id= " + userId + " deleted !");
						break;
					}
				} catch (com.lti.exception.UserNotFoundException e) {
					System.out.println(e.getMessage());
					continue;
				}
				continue;
			// insert a new course
			case 4:
				Course course = new Course();
				System.out.println("Enter catalogId");
				course.setCatalogId(sc.nextInt());
				// System.out.println("Enter CousreId");
				// int cId = (int) Math.random();
				course.setCourseId(userId);// sc.nextInt());
				System.out.println("Enter Course Title");
				course.setCourseTitle(sc.next());
				System.out.println("Enter Course Description ");

				course.setCourseDescription(sc.next());

				System.out.println("Enter Semester");
				course.setSemester(sc.nextInt());
				System.out.println("Enter Branch ");
				course.setBranch(sc.next());
				System.out.println("Enter credits");
				course.setCredits(sc.nextInt());
				// course added in the database
				courseOperation.insertCourse(course);
				continue;

			// delete an existing course
			case 5:
				System.out.println("Enter CourseId of course to be deleted");
				int courseId = sc.nextInt();
				// course deleted from database
				try {
					courseOperation.deleteCourse(courseId);
				} catch (CourseNotFoundException e) {
					System.out.println(e.getMessage());
				}
				continue;

			// view user details
			case 6:
				while (true) {
					System.out.println("1. View Student Details");
					System.out.println("2. View Professor Details");
					System.out.println("3. View Admin Details");
					System.out.println("4. Go Back to Main Menu");
					int display = sc.nextInt();
					switch (display) {
					// view studennt details
					case 1:
						userOperation.displayStudents();
						continue;

					// view professor details
					case 2:
						userOperation.displayProfessors();
						continue;

					// view admin details
					case 3:
						userOperation.displayAdmins();
						continue;

					// back to main menu
					case 4:
						break;
					}

					break;
				}
				continue;

			case 7:
				System.out.println("List of students need to Approve");
				userOperation.displayStudentsAdminApproval();
				while (true) {
					System.out.println("1. Please Enter  Student Id for Approval");
					System.out.println("2. Main Menu");
					int ch = sc.nextInt();
					switch (ch) {
					case 1:
						Integer studentId = sc.nextInt();
						Student fetchStudent = userOperation.fetchStudent(studentId);
						fetchStudent.setAdminStatus(true);
						userOperation.updateStudent(studentId, fetchStudent);
						continue;

					case 2:
						break;
					}
					break;
				}
				continue;
			// log out as admin
			case 8:
				System.out.println("Succesfully logged out as on " + currentDate);
				break;
			}
			break;
		}
	}

}
