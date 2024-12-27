package com.project.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.Model.Customer;
import com.project.Model.Feedback;
import com.project.Model.Product;
import com.project.Model.ProductFeedback;
import com.project.Model.Services;
import com.project.Service.UserRegistration;
import com.project.Repository.*;

public class UserRegistrationRepoImpl extends DbState implements UserRegistrationRepo{
	
	

	@Override
	public boolean user_register(Customer cust) {
		try {
			stmt = con.prepareStatement("insert into customer values(null,?,?,?,?)");
			stmt.setString(1, cust.getCustomer_name());
			stmt.setString(2, cust.getCustomer_city());
			stmt.setString(3, cust.getCustomer_userName());
			stmt.setString(4, cust.getCustomer_password());
			int val = stmt.executeUpdate();
			if(val > 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isUserValid(String username, String password) {
		try {
			stmt = con.prepareStatement("select * from customer where username = ? and password = ?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			if(rs.next())
			{
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}


	@Override
	public boolean addFeedback(Services service) {
		
		String sql = "insert into service_feedback values(null,?,?,?)";
		try {
		
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, service.getService_id());
			stmt.setString(2, service.getService_feedback());
			stmt.setInt(3, service.getService_rating());
			
			int val = stmt.executeUpdate();
			if(val > 0)
			{
				return true;
			}
			else return false;
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	
	@Override
	public boolean addProductFeedback(Customer cust, Product product) {
		
//		System.out.println(cust);
//		System.out.println(product);
		//find pid , cid  first
		String sql = " select cid from customer where username = ? and password = ?;";
		try {
			stmt = con.prepareStatement(sql);
			System.out.println("herer1");
			rs = stmt.executeQuery();
			if(rs.next())
			{
				int cid = rs.getInt(1);
				System.out.println(cid);
				sql = "insert into feedback values(null,?,?,?,?);";
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, cid);
				stmt.setInt(2, product.getPid());
				stmt.setString(3, product.getProduct_feedback());
				stmt.setInt(4, product.getProduct_rating());
				
				
				int val = stmt.executeUpdate();
				if(val > 0) return true;
				else return false;
				
			}
			else return false;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public List<Services> viewAllServices() {
		// TODO Auto-generated method stub
		List<Services> list = new ArrayList<>();
		String sql = "select * from services";
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				Services serv = new Services();
				
				serv.setService_id(rs.getInt(1));
				serv.setService_name(rs.getString(2));
				
				list.add(serv);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public boolean isValidService(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from services where sid = ?;";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
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
	public boolean isValidProduct(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from product where pid = ?;";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
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

	
}
