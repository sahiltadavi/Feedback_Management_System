package com.project.Repository;

import java.util.List;

import com.project.Model.Admin;
import com.project.Model.Product;

public interface AdminRepoIntef {
	boolean isValid(Admin admin);
	public boolean addProduct(Product product);
	public List<Product> getAllProduct();
	public boolean updateProduct(Product product);
	public boolean deleteProduct(int id);
}
