package com.project.Service;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import com.project.Model.Customer;
import com.project.Model.Product;
import com.project.Model.ProductFeedback;
import com.project.Model.Services;

public interface UserRegistration {
		boolean user_register(Customer cust);
		boolean isUserValid(String username , String password);
		public boolean addFeedback(Services service);
		public boolean addProductFeedback(Customer cust , Product product);
		public List<Services> viewAllServices();
		public boolean isValidService(int id);
		public boolean isValidProduct(int id);
}
