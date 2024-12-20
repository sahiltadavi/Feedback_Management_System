package com.project.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.Model.Customer;
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
	public ResultSet generateReport() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
