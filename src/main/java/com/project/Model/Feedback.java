package com.project.Model;



public class Feedback {
    private String customerName;
    public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public void setFeedbackMessage(String feedbackMessage) {
		this.feedbackMessage = feedbackMessage;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	private String customerCity;
    private String feedbackMessage;
    private int rating;
    private double averageRating; // To store the average rating for the product

    // Constructor
    public Feedback(String customerName, String customerCity, String feedbackMessage, int rating, double averageRating) {
        this.customerName = customerName;
        this.customerCity = customerCity;
        this.feedbackMessage = feedbackMessage;
        this.rating = rating;
        this.averageRating = averageRating;
    }

    // Getters
    public String getCustomerName() { return customerName; }
    public String getCustomerCity() { return customerCity; }
    public String getFeedbackMessage() { return feedbackMessage; }
    public int getRating() { return rating; }
    public double getAverageRating() { return averageRating; }

    @Override
    public String toString() {
        return "Customer: " + customerName + " | City: " + customerCity + " | Feedback: " + feedbackMessage + " | Rating: " + rating;
    }
}
