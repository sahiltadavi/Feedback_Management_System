package com.project.Model;


import lombok.Data;


@Data
public class Product {
	private int pid;
	private String product_name;
	private double product_price;
	private String product_desc;
	private int product_rating;
	private String product_feedback;
	private String service_name;
	private int sid;
}
