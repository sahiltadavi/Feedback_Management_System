package com.project.Repository;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.project.Model.Admin;
import com.project.Model.Customer;
import com.project.Model.Feedback;
import com.project.Model.Product;
import com.project.Model.ProductFeedback;
import com.project.Model.*;

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

	


	@Override
	public List<Product> getTopFiveProduct() {
		// TODO Auto-generated method stub
		String sql = "select p.*, count(f.fid) as feedback_count, avg(f.rating) as average_rating from feedback f join product p on f.pid = p.pid group by p.pid order by count(f.fid) desc, avg(f.rating) desc limit 5;";
		List<Product> list = new ArrayList<Product>();
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				Product temp = new Product();
				temp.setPid(rs.getInt(1));
				temp.setProduct_name(rs.getString(2));
				temp.setProduct_price(rs.getDouble(3));
				
				list.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Product> getLowerFiveProduct() {
		// TODO Auto-generated method stub
		String sql = "select p.*, count(f.fid) as feedback_count, avg(f.rating) as average_rating from feedback f join product p on f.pid = p.pid group by p.pid order by count(f.fid) asc, avg(f.rating) asc limit 5;";
		List<Product> list = new ArrayList<Product>();
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				Product temp = new Product();
				temp.setPid(rs.getInt(1));
				temp.setProduct_name(rs.getString(2));
				temp.setProduct_price(rs.getDouble(3));
				
				list.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Services> getTopFiveServices() {
		List<Services> list = new ArrayList<>();
		String sql = "select s.sid, s.sname, sf.feedback, count(sf.fid) as feedback_count, avg(sf.rating) as average_rating from service_feedback sf join services s on sf.sid = s.sid group by s.sid, s.sname, sf.feedback order by feedback_count desc, average_rating desc limit 5;";
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next())
			{
//				System.out.println(rs.getInt(1) + rs.getString(2) + " " + rs.getString(3));
				Services service = new Services();
				service.setService_id(rs.getInt(1));
				service.setService_name(rs.getString(2));
				service.setService_feedback(rs.getString(3));
				
				list.add(service);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<Services> getLowerFiveServices() {
		List<Services> list = new ArrayList<>();
		String sql =  "select s.sid, s.sname, sf.feedback, count(sf.fid) as feedback_count, avg(sf.rating) as average_rating from service_feedback sf join services s on sf.sid = s.sid group by s.sid, s.sname, sf.feedback order by feedback_count asc, average_rating asc limit 5;";
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				Services service = new Services();
				service.setService_id(rs.getInt(1));
				service.setService_name(rs.getString(2));
				service.setService_feedback(rs.getString(3));
				
				list.add(service);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	@Override
	public boolean addService(Services service) {
//		System.out.println(service.getService_name());
		try {
			String sql  = "insert into services values(null,?);";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, service.getService_name());
			int val = stmt.executeUpdate();
			if(val > 0) return true;
			else return false;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Map<String, ProductFeedback> getProductFeedback(int id) {
		// TODO Auto-generated method stub
		Map<String, ProductFeedback> feedbackMap = new HashMap<>();
		
		 String sql = "SELECT " +
                 "p.pname AS \"Product Name\", " +
                 "c.cname AS \"Customer Name\", " +
                 "c.ccity AS \"Customer City\", " +
                 "f.feedback AS \"Customer Feedback\", " +
                 "f.rating AS \"Rating\", " +
                 "AVG(f.rating) OVER (PARTITION BY p.pname) AS \"Average Rating\" " +
                 "FROM customer c " +
                 "INNER JOIN feedback f ON c.cid = f.cid " +
                 "INNER JOIN product p ON f.pid = p.pid " +
                 "WHERE p.pid = ?";
		 
		 try {
			 
			 stmt  = con.prepareStatement(sql);
			 stmt.setInt(1, id);
			 
			 rs = stmt.executeQuery();
			 while(rs.next())
			 {
				    String productName = rs.getString("Product Name");
		            String customerName = rs.getString("Customer Name");
		            String customerCity = rs.getString("Customer City");
		            String feedbackMessage = rs.getString("Customer Feedback");
		            int rating = rs.getInt("Rating");
		            double averageRating = rs.getDouble("Average Rating");

		            // Create a Feedback object
		            Feedback feedback = new Feedback(customerName, customerCity, feedbackMessage, rating, averageRating);

		            // Add the feedback to the map (grouping feedback by product name)
		            feedbackMap.putIfAbsent(productName, new ProductFeedback(productName, averageRating));
		            feedbackMap.get(productName).addFeedback(feedback);
			 }
		} catch (Exception e) {
			// TODO: handle exception
		}
		 
		 return feedbackMap; 
	}

	@Override
	public Map<String, Integer> countOfFeedbacks(int pid) {
	    // Initialize the map to store counts
	    Map<String, Integer> mpp = new HashMap<>();
	    
	    // Define positive and negative words
	    String[] positiveWords = {
	        "excellent", "amazing", "awesome", "fantastic", "great", "outstanding", 
	        "perfect", "positive", "impressive", "wonderful", "satisfactory", 
	        "brilliant", "superb", "exceptional", "remarkable", "enjoyable", 
	        "helpful", "efficient", "appreciated", "commendable", "delightful", 
	        "friendly", "reliable", "valuable", "professional", "innovative", 
	        "easy-to-use", "top-notch", "trusted", "high-quality", "efficient"
	    };

	    String[] negativeWords = {
	        "poor", "bad", "terrible", "horrible", "awful", "unsatisfactory", 
	        "disappointing", "frustrating", "inefficient", "unreliable", 
	        "negative", "slow", "unhelpful", "confusing", "annoying", 
	        "mediocre", "incompetent", "difficult", "outdated", "expensive", 
	        "low-quality", "rude", "unacceptable", "subpar", "boring", 
	        "overrated", "problematic", "broken", "error-prone", "unprofessional", 
	        "time-consuming", "unresponsive"
	    };

	    // Convert positive and negative word arrays into sets for faster lookup
	    Set<String> positiveSet = new HashSet<>(Arrays.asList(positiveWords));
	    Set<String> negativeSet = new HashSet<>(Arrays.asList(negativeWords));

	    int positiveFeedbackCount = 0;
	    int negativeFeedbackCount = 0;

	    // SQL query to fetch feedbacks for the given product id (pid)
	    String sql = "SELECT feedback FROM feedback WHERE pid = ?";

	    try (PreparedStatement  stmt = con.prepareStatement(sql)) {
	        stmt.setInt(1, pid);
	        try (ResultSet rs = stmt.executeQuery()) {
	            // Iterate through each feedback
	            while (rs.next()) {
	                String feedback = rs.getString("feedback");

	                // Split feedback into words and convert to lowercase for case-insensitive comparison
	                String[] words = feedback.toLowerCase().split("\\s+");

	                // Count positive and negative words in the feedback
	                for (String word : words) {
	                    if (positiveSet.contains(word)) {
	                        positiveFeedbackCount++;
	                    }
	                    if (negativeSet.contains(word)) {
	                        negativeFeedbackCount++;
	                    }
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Handle database exceptions (e.g., SQL syntax issues, connection issues)
	    }

	    // Store the counts in the map
	    mpp.put("positiveFeedbacks", positiveFeedbackCount);
	    mpp.put("negativeFeedbacks", negativeFeedbackCount);

	    return mpp;
	}

	@Override
	public List<Product> getAllDeletedProduct() {
		// TODO Auto-generated method stub
		String sql = "select * from history";
		List<Product> list = new ArrayList<>();
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				Product p = new Product();
				p.setPid(rs.getInt(1));
				p.setProduct_name(rs.getString(2));
				p.setProduct_price(rs.getInt(3));
				p.setProduct_desc(rs.getString(4));
				p.setSid(rs.getInt(5));
				
				list.add(p);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}


}
