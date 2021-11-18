package com.lti.main;

import java.util.Date;
import java.util.Scanner;

import com.lti.model.Professor;
import com.lti.service.CourseServiceInterface;
import com.lti.service.CourseServiceOperation;
import com.lti.service.ProfessorServiceInterface;
import com.lti.service.ProfessorServiceOperation;

public class ProfessorMain {

	// initializing the scanner
	Scanner sc = new Scanner(System.in);

	// professor client landing page
	public void professorClientPage(Professor professor) {

		int courseId;

		// initializing the instance courseOperation to carry out course operations
		CourseServiceInterface courseOperation = new CourseServiceOperation();
		// initializing the instance professorOperation to carry out professor
		// operations
		ProfessorServiceInterface professorOperation = new ProfessorServiceOperation();

		Date currentDate = new Date();
		// professor client page contents
		System.out.println("Succesfully logged in as PROFESSOR on " + currentDate);
		while (true) {
			System.out.println("Welcome " + professor.getName() + " !");

			// display menu list for professor
			System.out.println("Choose an option");
			System.out.println("1. View Courses to teach");
			System.out.println("2. Select a course");
			System.out.println("3. Deselect a course");
			System.out.println("4. View Selected Courses");
			System.out.println("5. Upload Grades");
			System.out.println("6. Logout");

			int choice= sc.nextInt();

			switch(choice) {
			// display all the courses available for professor to teach
			case 1:
				courseOperation.displayCoursesProfessor();
				continue;

			// select a course to teach
			case 2:
				System.out.println("Enter CourseID of the Course to be selected");
				courseId= sc.nextInt();
				professorOperation.selectCourse(courseId, professor);
				continue;

			// deselect a course
			case 3:
				System.out.println("Enter CourseID of the Course to be deselected");
				courseId= sc.nextInt();
				professorOperation.deselectCourse(courseId, professor);
				continue;

			// display list of courses selected by professor to teach
			case 4:
				professorOperation.displaySelectedCoursesProfessor(professor);
				continue;

			// upload grades 
			case 5:
				continue;

			// log out as a professor
			case 6:
				currentDate = new Date();
				System.out.println("Succesfully logged out as on "+ currentDate);
				break;

			}
			break;

		}
	}

}
