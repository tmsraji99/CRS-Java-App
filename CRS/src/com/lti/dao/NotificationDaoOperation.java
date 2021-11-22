package com.lti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lti.constant.SQlQueries;
import com.lti.model.Notification;
import com.lti.model.Student;
import com.lti.utils.DBUtils;

public class NotificationDaoOperation implements NotificationDaoInterfac{

	@Override
	public Notification showRegistrationReciept(Student student) {
		Connection connection= DBUtils.getConnection();
		PreparedStatement stmt= null;

		try {

			stmt= connection.prepareStatement(SQlQueries.SHOW_REGISTRATION_RECIEPT);
			stmt.setInt(1,student.getStudentId());

			ResultSet rs = stmt.executeQuery();

			if(rs.next())
			{
				Notification notification= new Notification();
				notification.setRegistrationId(rs.getInt("RegistrationID"));
				notification.setStudentId(rs.getInt("StudentID"));
				notification.setPayableAmount(rs.getDouble("Payableamount"));
				notification.setPayModeId(rs.getInt("Paymodeid"));
				notification.setTimeStamp(rs.getString("Date_Of_Pay"));

				return notification;

			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return null;
	}

		
	}


