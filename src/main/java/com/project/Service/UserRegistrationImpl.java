package com.project.Service;



import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import com.project.Model.Customer;
import com.project.Model.Product;
import com.project.Model.ProductFeedback;
import com.project.Model.Services;
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
	public boolean addProductFeedback(Customer cust, Product product) {
		// TODO Auto-generated method stub
		return repo.addProductFeedback(cust, product);
	}
	
	@Override
	public boolean addFeedback(Services service) {
		// TODO Auto-generated method stub
		return  repo.addFeedback(service);
	}

	@Override
	public List<Services> viewAllServices() {
		// TODO Auto-generated method stub
		return repo.viewAllServices();
	}

	@Override
	public boolean isValidService(int id) {
		// TODO Auto-generated method stub
		return repo.isValidService(id);
	}

	@Override
	public boolean isValidProduct(int id) {
		// TODO Auto-generated method stub
		return repo.isValidProduct(id);
	}
}
