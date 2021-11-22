package com.lti.service;

import com.lti.dao.NotificationDaoOperation;
import com.lti.model.Notification;
import com.lti.model.Student;
public class NotificationServiceOperation implements NotificationServiceInterface{

	NotificationDaoOperation dao=new NotificationDaoOperation();
	public void showRegistrationReciept(Student student){
		Notification notification=dao.showRegistrationReciept(student);
		System.out.println("***************************REGISTRATION RECIEPT***********************");
		System.out.println("Registration ID : "+notification.getRegistrationId());
		System.out.println("Student ID : "+notification.getStudentId());
		System.out.println("Name : "+student.getName());
		System.out.println("PaymentAmount : "+notification.getPayableAmount());
		
		if(notification.getPayModeId()==1)
			System.out.println("PaymentMode : 1, DEBIT_CARD");
		else if(notification.getPayModeId()==2)
			System.out.println("PaymentMode : 2, E-WALLET");
		else if(notification.getPayModeId()==3)
			System.out.println("PaymentMode : 3, NETBANKING");
		System.out.println("Registration Date : "+notification.getTimeStamp());
		System.out.println("Message : Successfully Completed");
		System.out.println("***********************************************************************");


	}

}
