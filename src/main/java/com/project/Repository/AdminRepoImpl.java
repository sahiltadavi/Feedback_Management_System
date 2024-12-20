package com.project.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.Model.Admin;
import com.project.Model.Product;

public class AdminRepoImpl extends DbState implements AdminRepoIntef {

	public boolean isValid(Admin admin) {
		try {
			stmt = con.prepareStatement("select * from admin where aname = ? and apass=?");
			stmt.setString(1, admin.getAdmin_name());
			stmt.setString(2, admin.getAdmin_password());
			rs = stmt.executeQuery();
			if(rs.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean addProduct(Product product) {
		try {
			stmt = con.prepareStatement("insert into product values(null,?,?,?)");
			stmt.setString(1, product.getProduct_name());
			stmt.setDouble(2, product.getProduct_price());
			stmt.setString(3, product.getProduct_desc());
			int value = stmt.executeUpdate();
			if(value > 0)
			{
				return true;
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		try {
			String sql = "update product set pname=? , pprice = ? , description = ? where pid = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, product.getProduct_name());
			stmt.setDouble(2, product.getProduct_price());
			stmt.setString(3, product.getProduct_desc());
			stmt.setInt(4, product.getPid());
			
			int val = stmt.executeUpdate();
			if(val > 0)
			{
				return true;
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteProduct(int id) {
		try {
			String sql = "delete from product where pid = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			int val = stmt.executeUpdate();
			if(val >0)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> list = new ArrayList<>();
		try {
			String sql = "select * from product";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Product product = new Product();
				product.setPid(rs.getInt(1));
				product.setProduct_name(rs.getString(2));
				product.setProduct_price(rs.getDouble(3));
				product.setProduct_desc(rs.getString(4));
	
				list.add(product);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

}
