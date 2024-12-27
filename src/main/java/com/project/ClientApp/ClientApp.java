package com.project.ClientApp;

import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

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
		String service_name , service_feedback;
		int service_id;
		int service_rating;
		double product_price;
		int product_rating;
		Scanner sc = new Scanner(System.in);
		Admin a = new Admin();
		do
		{
			String username , password;
			System.out.println("-------------Welcome To FeedBack System------------");
			System.out.println("1.Customer");
			System.out.println("2.Admin");
			System.out.println("3.Exit");
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice)
			{
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
							System.out.println("");
							break;
						case 1 : 
							System.out.println("Enter UserName : ");
							username = sc.nextLine();
							System.out.println("Enter PassWord : ");
							password = sc.nextLine();
							if(service.isUserValid(username, password))
							{
								System.out.println("Welcome , " + username);
								do
								{
									
								
								System.out.println("1.Give FeedBack to Products");
								System.out.println("2.Give FeedBack to Services");
								System.out.println("3.Exit");
								choice = sc.nextInt();
								sc.nextLine();
								switch(choice)
								{
									case 1 :
										
											List<Product> list = adminService.getAllProduct();
											
											System.out.println("All Available Products");
											System.out.println("ID" + " " + "NAME" + " " + "PRICE");
											for(Product temp : list)
											{
												System.out.println(temp.getPid() + " " + temp.getProduct_name() + " " + temp.getProduct_price());
											}
											System.out.println("\n\n");
											System.out.println("Enter Product ID : ");
											product_id = sc.nextInt();
											sc.nextLine();
											if(!service.isValidProduct(product_id))
											{
												System.out.println("You Enter Invalid ID Try Again...");
												break;
											}
											System.out.println("Enter Product Feedback : ");
											product_feedback = sc.nextLine();
											System.out.println("Enter Product Rating : ");
											product_rating = sc.nextInt();
											
											
											Product p = new Product();
											p.setPid(product_id);
											p.setProduct_feedback(product_feedback);
											p.setProduct_rating(product_rating);
											
											Customer cust = new Customer();
											cust.setCustomer_userName(username);
											cust.setCustomer_password(password);
								
											if(service.addProductFeedback(cust, p))
											{
												System.out.println("Thank You For The FeedBack");
											}
											else
											{
												System.out.println("Some Thing Went Wrong...");
											}
											System.out.println("\n\n");
											break;
									case 2 : 
										
										List<Services> allServices = service.viewAllServices();
										if(allServices.size() != 0)
										{
											System.out.println("Available Services");
											System.out.println("ID" + " " + "Name");
											for(Services temp : allServices)
											{
												System.out.println(temp.getService_id() + " " + temp.getService_name());
											}
											
											System.out.println("Enter Service ID : ");
											service_id = sc.nextInt();
											sc.nextLine();
											if(!service.isValidService(service_id))
											{
												System.out.println("You Enter Invalid ID Try Again...");
												break;
											}
											System.out.println("Enter Service Feedback : ");
											service_feedback = sc.nextLine();
											System.out.println("Enter Service Rating : ");
											service_rating = sc.nextInt();
											
											Services s = new Services();
											
											s.setService_id(service_id);
											s.setService_feedback(service_feedback);
											s.setService_rating(service_rating);
											
											
											if(service.addFeedback(s))
											{
												System.out.println("Thank You For The Feedback....");
											}
											else
											{
												System.out.println("Some Error Occured....");
											}	
										}
										else
										{
											System.out.println("Some Error Occurred...");
										}
											
											break;
									case 3 : 
											
											break;
									default : 
											System.out.println("Invalid Choice.....Try Again");
											break;
								}
								}while(choice != 3);
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
								System.out.println("Registration Success.....");
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
						System.out.println("5.Product Report");
						System.out.println("6.Top Five Products");
						System.out.println("7.Top Five Services");
						System.out.println("8.Lower Five Products");
						System.out.println("9.Lower Five Services");
						System.out.println("10.Add Services");
						System.out.println("11.Product History");
						System.out.println("Enter Your Choice");
						choice = sc.nextInt();
						sc.nextLine();
						switch(choice)
						{
							case 0:
								System.out.println("Admin Log Out...");
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
								System.out.println("Product Report");
								System.out.println("All Proudcts");
								list = adminService.getAllProduct();
								System.out.println("ID"+"  "+"NAME"+"  "+"PRICE"+"  "+"DESCRIPTION");
								for(Product itr : list)
								{
									System.out.println(itr.getPid() + "  " + itr.getProduct_name() + "  " + itr.getProduct_price()
									+"  " + itr.getProduct_desc());
								}
								
								System.out.println("Enter Product ID TO Generate Report : ");
								int pid = sc.nextInt();
								
								if(!service.isValidProduct(pid))
								{
									System.out.println("Invalid Product ID Try Again...");
								}
								
								 Map<String, ProductFeedback> feedbacks = adminService.getProductFeedback(pid);
								
								 for (Map.Entry<String, ProductFeedback> entry : feedbacks.entrySet()) {
						                String productName = entry.getKey();
						                ProductFeedback productFeedback = entry.getValue();
						                System.out.println("Product: " + productName + " | Average Rating: " + productFeedback.getAverageRating() + "  Out Of 5");
						                for (Feedback feedback : productFeedback.getFeedbackList()) {
						                    System.out.println(feedback);
						                }
						                System.out.println("------------------------------------------------");
						            }
								 
								 Map<String,Integer> feedback = adminService.countOfFeedbacks(pid);
								 int posCount = feedback.get("positiveFeedbacks");
								 int negCount = feedback.get("negativeFeedbacks");
								 
								 if(posCount > negCount)
								 {
									System.out.println("OverAll Feedback For This Product is Positive "); 
								 }
								 else if(posCount < negCount)
								 {
									 System.out.println("OverAll Feedback For This Product is Negative "); 
								 }
								 else
								 {
									 System.out.println("OverAll Feedack For This Product is Neutral");
								 }
								 
								
								break;
							case 6 : 
								System.out.println("Top Five Products");
								List<Product> topFiveProduct = adminService.getTopFiveProduct();
								if(topFiveProduct != null)
								{
									for(Product p : topFiveProduct)
									{
										System.out.println(p.getPid() + " " + p.getProduct_name() + " " + p.getProduct_price());
									}
								}
								else
								{
									System.out.println("No Data Found...");
								}
								break;
							case 7 : 
								System.out.println("Top Five Services");
								List<Services> topFiveServices = adminService.getTopFiveServices();
								if(topFiveServices.size() != 0)
								{
									for (Services services : topFiveServices) {
										System.out.println(services.getService_id() + " " +services.getService_name() + " " + services.getService_feedback());
									} 
								}
								else
								{
									System.out.println("No Data Found...");
								}
								break;
							case 8 : 
								System.out.println("Lower Five Products");
								List<Product> topLowerProduct = adminService.getLowerFiveProduct();
								if(topLowerProduct != null)
								{
									for(Product p : topLowerProduct)
									{
										System.out.println(p.getPid() + " " + p.getProduct_name() + " " + p.getProduct_price());
									}
								}
								else
								{
									System.out.println("No Data Found...");
								}
								break;
							case 9 : 
								System.out.println("Lower Five Services");
								List<Services> lowerFiveServices = adminService.getLowerFiveServices();
								if(lowerFiveServices != null)
								{
									for(Services s : lowerFiveServices)
									{
										System.out.println(s.getService_id() + " " + s.getService_name() + " "+ s.getService_feedback());
									}
								}
								else
								{
									System.out.println("No Data Found...");
								}
								break;
							case 10 : 
								System.out.println("Add Services");
								System.out.println("Enter Service Name : ");
								service_name = sc.nextLine();
								
								Services s = new Services();
								s.setService_name(service_name);
								
								if(adminService.addService(s))
								{
									System.out.println("Service Added Successfully...");
								}
								else
								{
									System.out.println("Some Error Occured....");
								}
								break;
							case 11 : 
								System.out.println("\n\n");
								System.out.println("All Deleted Product History");
								List<Product> deletedProduct = adminService.getAllDeletedProduct();
								System.out.println("ID"+"  "+"NAME"+"  "+"PRICE"+"  "+"DESCRIPTION" + " " + "SERVICE ID");
								if(deletedProduct.size() != 0)
								{
									for(Product p : deletedProduct)
									{
										System.out.println(p.getPid() + " " + p.getProduct_name() + " " + p.getProduct_price() + " " + p.getProduct_desc() + " " + p.getSid());
									} 
								}
								else
								{
									System.out.println("Empty....");
								}
								System.out.println("\n\n");
								break;
						}
					}while(choice != 0);
						
					}
					else
					{
						System.out.println("Login Failed...Try Again");
					}
					break;
				case 3 :
					System.out.println("Exited");
					System.exit(0);
					break;	
			}
		}while(choice != -1);

	}

}


