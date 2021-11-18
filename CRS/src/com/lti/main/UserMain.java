package com.lti.main;

import java.util.Scanner;

import com.lti.model.Admin;
import com.lti.model.Professor;
import com.lti.model.Student;
import com.lti.service.UserServiceInterface;
import com.lti.service.UserServiceOperation;

public class UserMain {

	
	public static void main(String[] args) {
		
		//initializing the scanner
		Scanner sc= new Scanner(System.in); 

		// initializing the instance courseOperation to carry out user operations 
		UserServiceInterface userOperation= new UserServiceOperation();

		//user login landing page
		while(true) {
			System.out.println("Enter your profile");

			
			Integer profile= Integer.parseInt(sc.next());
			
			System.out.println("Enter user id");
			
			Integer userId = Integer.parseInt(sc.nextLine());

				switch(profile) {
				// if user is a student
				case 1:
					
					Student student = userOperation.fetchStudent(userId);
					StudentMain studentClient= new StudentMain();
					// redirecting to student client landing page
					studentClient.studentClientPage(student);
					continue;


				//if user is a professor
				case 2:
					//fetching professor object from professor table
					Professor professor= userOperation.fetchProfessor(userId);
					ProfessorMain professorClient= new ProfessorMain();
					//redirecting to professor client landing page
					professorClient.professorClientPage(professor);
					continue;

				//if user is an admin
				case 3:
					// fetching admin object from admin table
					Admin admin= userOperation.fetchAdmin(userId);
					AdminMain adminClient= new AdminMain();
					// redirecting to admin client landing page
					adminClient.adminClientPage(admin);
					continue;
				}
	
			}
				
	}


}
