package com.project.Service;

import java.sql.ResultSet;

import com.project.Model.Customer;

public interface UserRegistration {
		boolean user_register(Customer cust);
		boolean isUserValid(String username , String password);
		ResultSet generateReport();
}
