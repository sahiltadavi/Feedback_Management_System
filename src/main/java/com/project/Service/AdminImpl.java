package com.project.Service;

import java.util.List;
import java.util.Map;

import com.project.Model.Admin;
import com.project.Model.Customer;
import com.project.Model.Product;
import com.project.Model.ProductFeedback;
import com.project.Model.Services;
import com.project.Repository.AdminRepoImpl;
import com.project.Repository.AdminRepoIntef;

public class AdminImpl implements AdminIntef {

	AdminRepoIntef repo = new AdminRepoImpl();
	
	@Override
	public boolean isValid(Admin admin) {
		
		return repo.isValid(admin);
	}

	@Override
	public boolean addProduct(Product product) {
		return repo.addProduct(product);
	}

	@Override
	public boolean updateProduct(Product product) {
		return repo.updateProduct(product);
	}

	@Override
	public boolean deleteProduct(int id) {
		return repo.deleteProduct(id);
	}

	@Override
	public List<Product> getAllProduct() {		
		return repo.getAllProduct();
	}


	@Override
	public List<Product> getTopFiveProduct() {
		// TODO Auto-generated method stub
		return repo.getTopFiveProduct();
	}

	@Override
	public List<Product> getLowerFiveProduct() {
		// TODO Auto-generated method stub
		return repo.getLowerFiveProduct();
	}

	@Override
	public List<Services> getTopFiveServices() {
		// TODO Auto-generated method stub
		return repo.getTopFiveServices();
	}

	@Override
	public List<Services> getLowerFiveServices() {
		// TODO Auto-generated method stub
		return repo.getLowerFiveServices();
	}

	@Override
	public boolean addService(Services service) {
		// TODO Auto-generated method stub
		return repo.addService(service);
	}

	@Override
	public Map<String, ProductFeedback> getProductFeedback(int id) {
		// TODO Auto-generated method stub
		return repo.getProductFeedback(id);
	}

	@Override
	public Map<String,Integer> countOfFeedbacks(int pid) {
		// TODO Auto-generated method stub
		return repo.countOfFeedbacks(pid);
	}

	@Override
	public List<Product> getAllDeletedProduct() {
		// TODO Auto-generated method stub
		return repo.getAllDeletedProduct();
	}
	

}
