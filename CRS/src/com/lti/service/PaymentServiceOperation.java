package com.lti.service;

import com.lti.model.Student;


public class PaymentServiceOperation implements PaymentServiceInterface{

	public double calculatPayment(Student student) {
		int standardPayment= 10000;
		int scholarshipPercentage=student.getScholarshipPercentage();
		double payableAmount= standardPayment*(0.01*(100-scholarshipPercentage));
		return payableAmount;

	}



}
