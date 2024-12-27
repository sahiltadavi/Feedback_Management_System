package com.project.Service;

import java.util.List;
import java.util.Map;

import com.project.Model.Admin;
import com.project.Model.Customer;
import com.project.Model.Product;
import com.project.Model.ProductFeedback;
import com.project.Model.Services;

public interface AdminIntef {
	public boolean isValid(Admin admin);
	public boolean addProduct(Product product);
	public List<Product> getAllProduct();
	public boolean updateProduct(Product product);
	public boolean deleteProduct(int id);
	public List<Product> getTopFiveProduct();
	public List<Product> getLowerFiveProduct();
	public List<Services> getTopFiveServices();
	public List<Services> getLowerFiveServices();
	public boolean addService(Services service);
	public Map<String, ProductFeedback> getProductFeedback(int id);
	public Map<String,Integer> countOfFeedbacks(int pid);
	public List<Product> getAllDeletedProduct();
}
