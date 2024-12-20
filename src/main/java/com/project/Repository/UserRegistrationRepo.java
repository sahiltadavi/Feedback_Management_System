package com.project.Repository;

import java.sql.ResultSet;

import com.project.Model.Customer;

public interface UserRegistrationRepo {
	boolean user_register(Customer cust);
	boolean isUserValid(String username , String password);
	ResultSet generateReport();
}
