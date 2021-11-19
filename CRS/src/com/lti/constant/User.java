package com.lti.constant;

public class User {

	public static final String VALIDATE_USER="select u.user_id, r.role_profile from user u inner join role r on r.role_id=u.role_id WHERE Username=? AND Password=?";
}
