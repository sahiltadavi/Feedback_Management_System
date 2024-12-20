package com.project.Service;



import java.sql.ResultSet;

import com.project.Model.Customer;

import com.project.Repository.*;

public class UserRegistrationImpl implements UserRegistration {

	UserRegistrationRepo repo = new UserRegistrationRepoImpl();
	
	@Override
	public boolean user_register(Customer cust) {
		// TODO Auto-generated method stub
		return repo.user_register(cust);
	}

	@Override
	public boolean isUserValid(String username, String password) {
		// TODO Auto-generated method stub
		return repo.isUserValid(username, password);
	}

	@Override
	public ResultSet generateReport() {
		// TODO Auto-generated method stub
		return null;
	}

}
