package com.project.Model;


//import lombok.Data;



public class Customer {
	private String customer_name;
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_city() {
		return customer_city;
	}
	public void setCustomer_city(String customer_city) {
		this.customer_city = customer_city;
	}
	public String getCustomer_userName() {
		return customer_userName;
	}
	public void setCustomer_userName(String customer_userName) {
		this.customer_userName = customer_userName;
	}
	public String getCustomer_password() {
		return customer_password;
	}
	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}
	private String customer_city;
	private String customer_userName;
	private String customer_password;
	
}
