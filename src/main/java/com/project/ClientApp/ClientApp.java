package com.project.ClientApp;

import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

import com.project.Model.*;
import com.project.Service.*;

public class ClientApp {

	public static void main(String[] args) {	
		int choice = -1 , product_id;
		Product product;
		UserRegistration service = new UserRegistrationImpl();
		AdminIntef adminService = new AdminImpl();
		String customer_name , customer_city , customer_username , customer_password;
		String product_name, product_feedback, product_desc;
		double product_price;
		int product_rating;
		Scanner sc = new Scanner(System.in);
		Admin a = new Admin();
		do
		{
			String username , password;
			System.out.println("-------------Welcome To FeedBack System------------");
			System.out.println("0.Exit");
			System.out.println("1.Customer");
			System.out.println("2.Admin");
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice)
			{
				case 0 :
					System.exit(0);
					break;
				case 1 :
					do
					{
						System.out.println("0.Exit");
						System.out.println("1.User Login");
						System.out.println("2.Registeration");
						choice = sc.nextInt();
						sc.nextLine();
						switch(choice)
						{
						case 0:
							System.exit(0);
							break;
						case 1 : 
							System.out.println("Enter UserName : ");
							username = sc.nextLine();
							System.out.println("Enter PassWord : ");
							password = sc.nextLine();
							if(service.isUserValid(username, password))
							{
								System.out.println("Welcome , " + username);
								System.out.println("1.Give FeedBack to Products");
								System.out.println("2.Give FeedBack to Services");
								choice = sc.nextInt();
								sc.nextLine();
								switch(choice)
								{
									case 1 :
											System.out.println("Enter Product Name : ");
											product_name = sc.nextLine();
											System.out.println("Enter Product Feedback : ");
											product_feedback = sc.nextLine();
											
											
											break;
									case 2 : 
											break;
									case 3 : 
											
											break;
									default : 
											System.out.println("Invalid Choice.....Try Again");
											break;
								}
							}
							else
							{
								System.out.println("Login Failed..... Try Again!");
							}
							break;
						case 2 : 
							System.out.println("Registration......");
							Customer c = new Customer();
							System.out.println("Enter Your Name : ");
							customer_name = sc.nextLine();
							System.out.println("Enter Your City : ");
							customer_city = sc.nextLine();
							System.out.println("Enter Your UserName : ");
							customer_username = sc.nextLine();
							System.out.println("Enter Your Pasword : ");
							customer_password = sc.nextLine();
							
							
							c.setCustomer_name(customer_name);
							c.setCustomer_city(customer_city);
							c.setCustomer_userName(customer_username);
							c.setCustomer_password(customer_password);
							
							if(service.user_register(c))
							{
								System.out.println("Registration Sucess.....");
							}
							else
							{
								System.out.println("Registration Failed.... Try Again....");
							}
							break;
						default:
							break;
						}
					}while(choice != 0);
					break;
				case 2 :
					
					
					System.out.println("Enter UserName : ");
					username = sc.nextLine();
					System.out.println("Enter PassWord : ");
					password = sc.nextLine();
					
					Admin admin = new Admin();
					admin.setAdmin_name(username);
					admin.setAdmin_password(password);
					if(adminService.isValid(admin))
					{
						
						do
						{
						System.out.println("Welcome...." +admin.getAdmin_name());
						System.out.println("0.Exit");
						System.out.println("1.Add New Product");
						System.out.println("2.View All Product");
						System.out.println("3.Update Product");
						System.out.println("4.Delete Product");
						System.out.println("5.Report");
						System.out.println("6.Overall Product Feedback");
						System.out.println("Enter Your Choice");
						choice = sc.nextInt();
						sc.nextLine();
						switch(choice)
						{
							case 0:
								System.exit(0);
								break;
							case 1 :
								System.out.println("Enter Name of Product To Add : ");
								product_name = sc.nextLine();
								System.out.println("Enter Name of Price To Add : ");
								product_price = sc.nextDouble();
								sc.nextLine();
								System.out.println("Enter Name of Description To Add : ");
								product_desc = sc.nextLine();
								
								product = new Product();
								product.setProduct_name(product_name);
								product.setProduct_price(product_price);
								product.setProduct_desc(product_desc);
								
								if(adminService.addProduct(product))
								{
									System.out.println("Product Added Successfully....");
								}
								else
								{
									System.out.println("Failed To Add Product....");
								}
								break;
							case 2 : 
								System.out.println("All Proudcts");
								List<Product> list = adminService.getAllProduct();
								System.out.println("ID"+"  "+"NAME"+"  "+"PRICE"+"  "+"DESCRIPTION");
								for(Product itr : list)
								{
									System.out.println(itr.getPid() + "  " + itr.getProduct_name() + "  " + itr.getProduct_price()
									+"  " + itr.getProduct_desc());
								}
								
								break;
							case 3 :
								System.out.println("Update Product");
								System.out.println("Enter Product ID : ");
								product_id = sc.nextInt();
								sc.nextLine();
								System.out.println("Enter Product Name to Update");
								product_name = sc.nextLine();
								System.out.println("Enter Product Price to Update");
								product_price = sc.nextDouble();
								sc.nextLine();
								System.out.println("Enter Product Description to Update");
								product_desc = sc.nextLine();
								
								product = new Product();
								product.setPid(product_id);
								product.setProduct_name(product_name);
								product.setProduct_price(product_price);
								product.setProduct_desc(product_desc);
								
								if(adminService.updateProduct(product))
								{
									System.out.println("Proudct Updated Sucessfully....");
								}
								else
								{
									System.out.println("Some Thing Went Wrong...Try Again...");
								}
								
								break;
							case 4 : 
								System.out.println("Delete Proudct");
								System.out.println("Enter Product ID TO Delete Product: ");
								product_id = sc.nextInt();
								if(adminService.deleteProduct(product_id))
								{
									System.out.println("Product Deleted Successfully...");
								}
								else
								{
									System.out.println("Some Thing Went Wrong...Try Again...");
								}
								break;
							case 5 :
								System.out.println("Product Report this is sahil tadavi work");
								break;
							case 6 : 
								System.out.println("OverAll Product Report");
								break;
						}
					}while(choice != 0);
						
					}
					else
					{
						System.out.println("Login Failed...Try Again");
					}
					break;
			}
		}while(choice != 0);

	}

}
