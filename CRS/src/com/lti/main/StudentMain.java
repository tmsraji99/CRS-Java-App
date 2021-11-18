package com.lti.main;

import java.util.Date;
import java.util.Scanner;

import com.lti.model.Student;
import com.lti.service.CourseServiceInterface;
import com.lti.service.CourseServiceOperation;
import com.lti.service.StudentServiceInterface;
import com.lti.service.StudentServiceOperation;


public class StudentMain {



	//initializing the scanner
	Scanner sc= new Scanner(System.in); 

	// studentClient landing page
	public void studentClientPage(Student student) {

		// initializing the instance courseOperation to carry out course operations 
		CourseServiceInterface courseOperation= new CourseServiceOperation();
		// initializing the instance studentOperation to carry out student operations 
		StudentServiceInterface studentOperation= new StudentServiceOperation();

		// begin variable listing
		int choice;
		int courseId;
		Date currentDate= new Date();

		//student client landing page contents
		System.out.println("Succesfully logged in as STUDENT on "+ currentDate);
		while(true) {
			System.out.println("Welcome "+student.getName()+" !");

			// declaration of menu for student
			System.out.println("Choose an option");
			System.out.println("1. View All Courses");  
			System.out.println("2. Add a course");
			System.out.println("3. Drop a course");
			choice= sc.nextInt();

			switch(choice) {
			// display all available courses for a particular student
			case 1:
				courseOperation.displayCourses(student);
				continue;

			// add a course by student
			case 2:
			
					System.out.println("Enter CourseID of the Course to be added");
					courseId= sc.nextInt();
					studentOperation.addCourse(courseId, student);
				
					System.out.println("Registration already completed!");
				
				continue;

			// drop a course by student
			case 3:
				
					System.out.println("Enter CourseID of the Course to be dropped");
					courseId= sc.nextInt();
					studentOperation.dropCourse(courseId, student);
				
					System.out.println("Registration already completed!");
				}
			break;
			}
		}
	

}