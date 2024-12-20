package com.project.Service;

import java.util.List;

import com.project.Model.Admin;
import com.project.Model.Product;
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
	
	

}
